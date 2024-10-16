package com.xyz.tennistrack.service.impl;

import com.xyz.tennistrack.config.UserAgents;
import com.xyz.tennistrack.dto.HolabirdDTO;
import com.xyz.tennistrack.model.enums.ProductType;
import com.xyz.tennistrack.repository.ProductRepository;
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

    @Value("${holabird.url}")
    private String url;
    private Map<ProductType, String> productTypes;

    @Autowired
    public HolabirdServiceImpl(RestTemplate rt, ProductRepository productRepository) {
        this.rt = rt;
        this.productRepository = productRepository;

        //create a map of product types with associated categories
        productTypes = initProductTypes();
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

    //create request headers
    private HttpEntity<String> getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        //headers.set("authority", "searchserverapi.com");
        headers.set("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
        headers.set("accept-Language", "en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7");
        headers.set("referer", "https://www.holabirdsports.com/");
        headers.set("user-agent", UserAgents.getAgent());

        return new HttpEntity<>(headers);
    }

    //create request parameters
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

    //consume API to retrieve DTO
//    public <T> HolabirdDTO getHolaBirdDTO() {
//
//        for (ProductType type : productTypes.keySet()) {
//
//            //build the custom url with the query parameters
//            Map<String, String> params = getRequestParams(type, 0);
//            for (String param : params.keySet()) {
//                url += "&" + param + "=" + params.get(param);
//            }
//
//            //ResponseEntity<String> response = rt.exchange(url, HttpMethod.GET, getHeaders(), String.class);
//            //ParameterizedTypeReference<HolabirdDTO<Racquets>> responseType = new ParameterizedTypeReference<>() {};
//            //ResponseEntity<HolabirdDTO<Racquets>> response = rt.exchange(url, HttpMethod.GET, getHeaders(), responseType);
//            HolabirdDTO holabirdDTO = rt.exchange(url, HttpMethod.GET, getHeaders(), HolabirdDTO.class).getBody();
//            holabirdDTO.setType(type);
//
//            List<Product<T>> products = createProductEntity(holabirdDTO);
//            saveAllProducts(products);
//
//            return holabirdDTO;
//        }
//
//        return null;
//
//    }

    //save all products
//    private <T> void saveAllProducts(List<Product<T>> products) {
//        holabirdRepository.saveAll(products);
//    }

    //get response

//    public <T> List<Product<T>> createProductEntity(HolabirdDTO holabirdDTO) {
//        List<Product<T>> products = new ArrayList<>();
//
//        holabirdDTO.getItems().stream()
//                .forEach(e -> {
//
//                    Product<T> product = createProductEntity(e, holabirdDTO.getType());
//                    //product.setQuantity_total(e.getQuantity_total());
//
//                        //case PICKLEBALL -> product = new Pickleball();
//                        //case SHOES -> product = new Shoes();
//                        //case BAGS -> product = new Bags();
//                        //case ACCESSORIES -> product = new Accessories();
//                        //case STRINGS -> product = new Strings();
//                        //case EQUIPMENT -> product = new Equipment();
//                    products.add(product);
//                });
//
//        return products;
//    }
//
//    private <T> Product<T> createProductEntity(HolabirdDTO.Items items, ProductType productType) {

//        Product<Racquets> product = new Racquets.RacquetBuilder()
//                .retailer(Retailer.HOLABIRD)
//                .title(items.getTitle())
//                .price(items.getPrice())
//                .list_price(items.getList_price())
//                .productType(productType)
//                .discount(items.getDiscount())
//                .brand(Brand.getBrandName(items.getVendor()))
//                .build();

//        Product<T> product = new Product.Builder<T>()
//                .retailer(Retailer.HOLABIRD)
//                .title(items.getTitle())
//                .price(items.getPrice())
//                .msrp(items.getList_price())
//                .productType(productType)
//                .discount(items.getDiscount())
//                .brand(Brand.getBrandName(items.getVendor()))
//                .productUrl(items.getLink())
//                .imageUrl(items.getImage_link())
//                .build();


//        List<T> variants = createVariantEntity(items.getVariants(), productType);
//        product.setVariants((List<Racquets>) variants);
//
//        return (Product<T>) product;
//
//        return null;
//    }



    private <T> List<T> createVariantEntity(List<HolabirdDTO.Variants> variants, ProductType type) {

//        List<T> variantsEntity = new ArrayList<>();
//
//        variants.stream()
//                .forEach(e -> {
//                    switch (type) {
//                        case RACQUETS -> {
//                            Racquets racquet = new Racquets.RacquetBuilder()
//                                    .racquet_id(e.getVariant_id())
//                                    .price(e.getPrice())
//                                    .list_price(e.getList_price())
//                                    .quantity_total(e.getQuantity_total())
//                                    .link(e.getLink())
//                                    .build();
//
//                            Racquets.Options options = new Racquets.Options();
//                            options.setSize(e.getOptions().getSize());
//
//                            racquet.setOptions(options);
//
//                            variantsEntity.add((T) racquet);
//                        }
//
//                    }
//
//
//                });
//        return variantsEntity;

        return null;
    }
}
