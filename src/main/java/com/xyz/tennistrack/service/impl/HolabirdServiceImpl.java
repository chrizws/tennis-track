package com.xyz.tennistrack.service.impl;

import com.xyz.tennistrack.config.UserAgents;
import com.xyz.tennistrack.dto.HolabirdDTO;
import com.xyz.tennistrack.model.Product;
import com.xyz.tennistrack.model.enums.Brand;
import com.xyz.tennistrack.model.enums.ProductType;
import com.xyz.tennistrack.model.enums.Retailer;
import com.xyz.tennistrack.model.tennisProducts.Racquets;
import com.xyz.tennistrack.repository.ProductRepository;
import com.xyz.tennistrack.repository.RacquetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class HolabirdServiceImpl {

    private final RestTemplate rt;
    private final ProductRepository productRepository;
    private final RacquetRepository racquetRepository;
    private List<Product> products;

    @Value("${holabird.url}")
    private String url;
    private Map<ProductType, String> productTypes;

    @Autowired
    public HolabirdServiceImpl(RestTemplate rt, ProductRepository productRepository, RacquetRepository racquetRepository) {
        this.rt = rt;
        this.productRepository = productRepository;
        this.racquetRepository = racquetRepository;
    }

    //initialize the product types into a map
    private Map<ProductType, String> initProductTypes() {
        if (productTypes == null) {
            productTypes = new HashMap<>();

            for (ProductType type : ProductType.values()) {
                switch (type) {
                    case RACQUETS -> productTypes.putIfAbsent(type, "Tennis Racquets");
//                    case PICKLEBALL -> productTypes.get(type).add("Pickleball Paddles");
//                    case SHOES -> productTypes.get(type).add("Shoe Deals");
//                    case BAGS -> productTypes.get(type).add("Tennis Bags");
//                    case ACCESSORIES -> productTypes.get(type).add("Tennis Accessories");
//                    case STRINGS -> productTypes.get(type).add("Tennis Strings");
//                    case EQUIPMENT -> productTypes.get(type).add("Stringing Machines");
                }
            }
        }

        return productTypes;
    }

    private HttpEntity<String> getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        //headers.set("authority", "searchserverapi.com");
        headers.set("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
        headers.set("accept-Language", "en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7");
        headers.set("referer", "https://www.holabirdsports.com/");
        headers.set("user-agent", UserAgents.getAgent());

        return new HttpEntity<>(headers);
    }

    private Map<String, String> getRequestParams(ProductType type, int index) {

        Map<String, String> params = new LinkedHashMap<>();
        params.put("facets", "true");
        params.put("maxResults", "250");
        params.put("queryBy[collections]", productTypes.get(type));
        params.put("q", "ALLDEALS");
        params.put("restrictBy[discount]", "5,100");
        params.put("startIndex", index + "");

        return params;

    }

    private String createUrlWithParams(Map<String, String> params) {

        String createParamUrl = url;

        //build the custom url with the query parameters
        for (String param : params.keySet()) {
            createParamUrl += "&" + param + "=" + params.get(param);
        }

        return createParamUrl;
    }



    public List<Product> callAllProducts() {
        //initialize productTypes with all the types of products
        productTypes = initProductTypes();

        products = new ArrayList<>();

        for (ProductType type : productTypes.keySet()) {

            //build the custom url with the query parameters
            String completeUrl = createUrlWithParams(getRequestParams(type, 0));

            //ParameterizedTypeReference<HolabirdDTO<Racquets>> responseType = new ParameterizedTypeReference<>() {};
            //ResponseEntity<HolabirdDTO<Racquets>> response = rt.exchange(url, HttpMethod.GET, getHeaders(), responseType);
            HolabirdDTO holabirdDTO = rt.exchange(completeUrl, HttpMethod.GET, getHeaders(), HolabirdDTO.class).getBody();
            holabirdDTO.setType(type);

            //create entities from dto for persistence
            List<Product> productEntities = createEntityFromDto(holabirdDTO);

            products.addAll(productEntities);
        }

        return products;
    }


    public ResponseEntity<?> getProductsByTypeAndRetailer(String type, String name) {

        ProductType productType = ProductType.getProductType(type);
        Retailer retailer = Retailer.getRetailer(name);
        List<Product> products = productRepository.findProductsByProductTypeAndRetailer(productType, retailer);

        if (products != null)
            return ResponseEntity.status(HttpStatus.OK).body(products);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(name + " " + type + " not found");
    }

    public ResponseEntity<?> getAllRacquets() {

        //temporarily use racquets in place of all products
        List<Product> products = productRepository.findProductsByProductType(ProductType.RACQUETS);

        //List<Racquets> products = productRepository.findAll();
        if (products != null)
            return ResponseEntity.status(HttpStatus.OK).body(products);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("No Products Found");
    }

    private boolean saveAllProducts(List<Product> products) {
        return productRepository.saveAll(products).size() == products.size();
    }


    private <T> List<Product> createEntityFromDto(HolabirdDTO holabirdDTO) {
        List<Product> products = new ArrayList<>();

        holabirdDTO.getItems()
                .forEach(e -> {

                    Product product = createProductEntity(e, holabirdDTO.getType());
                    products.add(product);

                    List<T> variants = new ArrayList<>();

                    e.getVariants().forEach(variant -> {

                        variants.add(createVariantEntity(variant, holabirdDTO.getType()));

                        switch (holabirdDTO.getType()) {
                            case RACQUETS -> product.setRacquets((List<Racquets>) variants);
                        }
                    });
                });
        return products;
    }

    private <T> Product createProductEntity(HolabirdDTO.Items item, ProductType productType) {

        Product product = Product.builder()
                .id(item.getProduct_id())
                .retailer(Retailer.HOLABIRD)
                .title(item.getTitle())
                .price(item.getPrice())
                .msrp(item.getList_price())
                .discount(item.getDiscount())
                .productType(productType)
                .brand(Brand.getBrandName(item.getVendor()))
                .build();

        return product;

    }


    private <T> T createVariantEntity(HolabirdDTO.Variants e, ProductType type) {

        switch (type) {
            case RACQUETS -> {
                Racquets racquet = Racquets.builder()
                        .racquet_id(e.getVariant_id())
                        .price(e.getPrice())
                        .link(e.getLink())
                        .list_price(e.getList_price())
                        .quantity_total(e.getQuantity_total())
                        .build();

                Racquets.Options options = new Racquets.Options();
                options.setSize(e.getOptions().getSize());

                racquet.setOptions(options);

                return (T) racquet;
            }
        };
        return null;
    }
}
