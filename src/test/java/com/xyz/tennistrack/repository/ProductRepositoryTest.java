//package com.xyz.tennistrack.repository;
//
//import com.xyz.tennistrack.dto.retailerDto.HolabirdDTO;
//import com.xyz.tennistrack.model.Entity.Product;
//import com.xyz.tennistrack.model.enums.Brand;
//import com.xyz.tennistrack.model.enums.ProductType;
//import com.xyz.tennistrack.model.enums.Retailer;
//import com.xyz.tennistrack.model.Entity.Racquets;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
//public class ProductRepositoryTest {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private RacquetRepository racquetsRepository;
//
//    private static HolabirdDTO dto;
//
//    @BeforeAll
//    public static void setup() {
//        //create the dto
//        dto = new HolabirdDTO();
//
//        dto.setType(ProductType.RACQUETS);
//        dto.setTotalItems(360);
//        dto.setStartIndex(0);
//        dto.setItemsPerPage(250);
//        dto.setCurrentItemCount(250);
//
//        List<HolabirdDTO.Items> items = new ArrayList<>();
//        dto.setItems(items);
//
//        HolabirdDTO.Items item1 = new HolabirdDTO.Items();
//        HolabirdDTO.Items item2 = new HolabirdDTO.Items();
//
//        //item 1
//        item1.setProduct_id("1323317330014");
//        item1.setTitle("HEAD Ti. S6");
//        item1.setDescription("");
//        item1.setLink("\\/products\\/head-ti-s6");
//        item1.setPrice("99.0000");
//        item1.setList_price("325.0000");
//        item1.setQuantity("1");
//        item1.setProduct_code("100096   2L");
//        item1.setImage_link("https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/2006\\/8755\\/products\\/100096_1_large.jpg?v=1596473380");
//        item1.setVendor("Head");
//        item1.setDiscount("70");
//        item1.setAdd_to_cart_id("12221276815454");
//        item1.setTotal_reviews("30");
//        item1.setReviews_average_score("4.6");
//
//        List<HolabirdDTO.Items.Variants> racq = new ArrayList<>();
//
//        //variant 1
//        HolabirdDTO.Items.Variants variant1 = new HolabirdDTO.Items.Variants();
//        variant1.setVariant_id("12221276815111");
//        variant1.setSku("100096   2L");
//        variant1.setBarcode("726423947943");
//        variant1.setPrice("99.0000");
//        variant1.setList_price("325.0000");
//        variant1.setTaxable("1");
//        variant1.setAvailable("1");
//        variant1.setQuantity_total("5");
//        variant1.setLink("\\/products\\/head-ti-s6?variant=12221276815454");
//
//        HolabirdDTO.Items.Variants.Options options = new HolabirdDTO.Items.Variants.Options();
//        options.setSize("2L - 4 1\\/4\\");
//        variant1.setOptions(options);
//
//        //variant 2
//        HolabirdDTO.Items.Variants variant2 = new HolabirdDTO.Items.Variants();
//        variant2.setVariant_id("12221276848222");
//        variant2.setSku("100096   3L");
//        variant2.setBarcode("726423947950");
//        variant2.setPrice("99.0000");
//        variant2.setList_price("325.0000");
//        variant2.setTaxable("1");
//        variant2.setAvailable("1");
//        variant2.setQuantity_total("6");
//        variant2.setLink("\\/products\\/head-ti-s6?variant=12221276848222");
//
//        HolabirdDTO.Items.Variants.Options options2 = new HolabirdDTO.Items.Variants.Options();
//        options2.setSize("3L - 4 3\\/8\\");
//        variant2.setOptions(options);
//
//        racq.add(variant1);
//        racq.add(variant2);
//
//
//        //item 2
//        item2.setProduct_id("1323318116446");
//        item2.setTitle("Wilson Hyper Hammer 5.3 Stretch Oversize");
//        item2.setDescription("");
//        item2.setLink("\\/products\\/wilson-hyper-hammer-5-3-stretch-over");
//        item2.setPrice("199.0000");
//        item2.setList_price("199.9900");
//        item2.setQuantity("1");
//        item2.setProduct_code("100241   1L");
//        item2.setImage_link("\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/2006\\/8755\\/products\\/100241_1_large.jpg?v=1596733522");
//        item2.setVendor("Wilson");
//        item2.setDiscount("40");
//        item2.setAdd_to_cart_id("15391879463006");
//        item2.setTotal_reviews("28");
//        item2.setReviews_average_score("4.3");
//
//        List<HolabirdDTO.Items.Variants> racquets = new ArrayList<>();
//
//        HolabirdDTO.Items.Variants variant3 = new HolabirdDTO.Items.Variants();
//        variant3.setVariant_id("12221276815333");
//        variant3.setSku("100096   2L");
//        variant3.setBarcode("726423947943");
//        variant3.setPrice("99.0000");
//        variant3.setList_price("199.0000");
//        variant3.setTaxable("1");
//        variant3.setAvailable("1");
//        variant3.setQuantity_total("5");
//        variant3.setLink("\\/products\\/wilson?variant=122212768214122");
//
//        HolabirdDTO.Items.Variants.Options options3 = new HolabirdDTO.Items.Variants.Options();
//        options3.setSize("2L - 4 1\\/4\\");
//        variant3.setOptions(options3);
//
//
//        HolabirdDTO.Items.Variants variant4 = new HolabirdDTO.Items.Variants();
//        variant4.setVariant_id("12221276848444");
//        variant4.setSku("100096   3L");
//        variant4.setBarcode("726423947950");
//        variant4.setPrice("99.0000");
//        variant4.setList_price("325.0000");
//        variant4.setTaxable("1");
//        variant4.setAvailable("1");
//        variant4.setQuantity_total("6");
//        variant4.setLink("\\/products\\/wilson?variant=122212768482342");
//
//        HolabirdDTO.Items.Variants.Options options4 = new HolabirdDTO.Items.Variants.Options();
//        options4.setSize("3L - 4 3\\/8\\");
//        variant4.setOptions(options4);
//
//        //add list of variant options to the variants array
//        racquets.add(variant3);
//        racquets.add(variant4);
//
//        //add the variants array to the item dto
//        item1.setVariants(racq);
//        item2.setVariants(racquets);
//
//        //add the item dto to the list of items
//        items.add(item1);
//        items.add(item2);
//
//    }
//
//    @Test
//    public void testProductRepository_SaveProducts() {
//
//        List<Product> products = new ArrayList<>();
//
//        dto.getItems().forEach(e -> {
//            Product product = new Product();
//            products.add(product);
//
//            switch (dto.getType()) {
//                case RACQUETS -> {
//                    product.setId(e.getProduct_id());
//                    product.setMsrp(e.getList_price());
//                    product.setTitle(e.getTitle());
//                    product.setProductType(dto.getType());
//                    product.setRetailer(Retailer.HOLABIRD);
//                    product.setPrice(e.getPrice());
//                    product.setDiscount(e.getDiscount());
//                    product.setBrand(Brand.getBrandByName(e.getVendor()));
//                }
//            }
//        });
//
//        productRepository.saveAll(products);
//        List<Product> list = productRepository.findAll();
//
//        Assertions.assertThat(list).isNotNull();
//        Assertions.assertThat(list.size()).isEqualTo(2);
//
//    }
//
//    @Test
//    public <T> void testProductRepository_SaveProductUsingAggregatePattern() {
//
//        //Aggregate pattern is saving with ONE repository using relationship annotations
//        List<Product> products = new ArrayList<>();
//
//        dto.getItems().forEach(e -> {
//
//            Product product = new Product();
//            List<T> variants = new ArrayList<>();
//            products.add(product);
//
//            switch (dto.getType()) {
//                case RACQUETS -> {
//
//                    product.setRacquets((List<Racquets>) variants);
//                    product.setId(e.getProduct_id());
//                    product.setMsrp(e.getList_price());
//                    product.setTitle(e.getTitle());
//                    product.setProductType(dto.getType());
//                    product.setRetailer(Retailer.HOLABIRD);
//                    product.setPrice(e.getPrice());
//                    product.setDiscount(e.getDiscount());
//                    product.setBrand(Brand.getBrandByName(e.getVendor()));
//
//                    e.getVariants()
//                            .forEach(f -> {
//
//                                Racquets racquet = Racquets.builder()
//                                        .racquet_id(f.getVariant_id())
//                                        .price(f.getPrice())
//                                        .list_price(f.getList_price())
//                                        .link(f.getLink())
//                                        .quantity_total(f.getQuantity_total())
//                                        .build();
//
//                                //racquet.setProduct(product);
//
//                                Racquets.Options options = new Racquets.Options();
//                                options.setSize(f.getOptions().getSize());
//                                racquet.setOptions(options);
//
//                                variants.add((T) racquet);
//                            });
//                }
//            }
//        });
//
//        //AGGREGATE PATTERN
//        productRepository.saveAll(products);
//
//        List<Product> list = productRepository.findAll();
//
//        List<Racquets> racquetsList = list.stream()
//                        .flatMap(p -> p.getRacquets().stream())
//                .collect(Collectors.toList());
//
//        Assertions.assertThat(list).isNotNull();
//        Assertions.assertThat(list.size()).isEqualTo(2);
//        Assertions.assertThat(racquetsList).isNotNull();
//        Assertions.assertThat(racquetsList.size()).isEqualTo(4);
//    }
//
//
//    @Test
//    public <T> void testProductRacquetRepository_SaveUsingRepositoryPattern() {
//        //Repository pattern is used to manage each object individually
//
//        List<Product> products = new ArrayList<>();
//        List<T> variants = new ArrayList<>();
//
//        dto.getItems()
//                .forEach(e -> {
//
//            Product product = new Product();
//            products.add(product);
//
//            switch (dto.getType()) {
//                case RACQUETS -> {
//
//                    product.setRacquets((List<Racquets>) variants);
//                    product.setId(e.getProduct_id());
//                    product.setMsrp(e.getList_price());
//                    product.setTitle(e.getTitle());
//                    product.setProductType(dto.getType());
//                    product.setRetailer(Retailer.HOLABIRD);
//                    product.setPrice(e.getPrice());
//                    product.setDiscount(e.getDiscount());
//                    product.setBrand(Brand.getBrandByName(e.getVendor()));
//
//                    e.getVariants()
//                            .forEach(f -> {
//
//                                Racquets racquet = Racquets.builder()
//                                        .racquet_id(f.getVariant_id())
//                                        .price(f.getPrice())
//                                        .list_price(f.getList_price())
//                                        .link(f.getLink())
//                                        .quantity_total(f.getQuantity_total())
//                                        .build();
//
//                                //racquet.setProduct(product);
//
//                                Racquets.Options options = new Racquets.Options();
//                                options.setSize(f.getOptions().getSize());
//                                racquet.setOptions(options);
//
//                                variants.add((T) racquet);
//                                //racquetsRepository.save(racquet);
//                            });
//                }
//            }
//        });
//
//        productRepository.saveAll(products);
//        racquetsRepository.saveAll((List<Racquets>)variants);
//
//        List<Product> productList = productRepository.findAll();
//        List<Racquets> racquetList = racquetsRepository.findAll();
//
//        Assertions.assertThat(productList).isNotNull();
//        Assertions.assertThat(productList.size()).isEqualTo(2);
//
//        Assertions.assertThat(racquetList).isNotNull();
//        Assertions.assertThat(racquetList.size()).isEqualTo(4);
//
//    }
//
//    @Test
//    public void testProductRepository_FindById() {
//        List<Product> products = new ArrayList<>();
//
//        dto.getItems().forEach(e -> {
//
//            Product product = new Product();
//            products.add(product);
//
//            switch (dto.getType()) {
//                case RACQUETS -> {
//
//                    product.setId(e.getProduct_id());
//                    product.setMsrp(e.getList_price());
//                    product.setTitle(e.getTitle());
//                    product.setProductType(dto.getType());
//                    product.setRetailer(Retailer.HOLABIRD);
//                    product.setPrice(e.getPrice());
//                    product.setDiscount(e.getDiscount());
//                    product.setBrand(Brand.getBrandByName(e.getVendor()));
//                }
//            }
//        });
//
//        productRepository.saveAll(products);
//
//        Product p = productRepository.findById(dto.getItems().get(0).getProduct_id()).get();
//
//        Assertions.assertThat(p).isNotNull();
//        Assertions.assertThat(p.getId()).isEqualToIgnoringCase(dto.getItems().get(0).getProduct_id());
//        Assertions.assertThat(p.getProductType()).isEqualTo(dto.getType());
//    }
//
//    @Test
//    public void testProductRepository_Update() {
//        List<Product> products = new ArrayList<>();
//
//        dto.getItems().forEach(e -> {
//
//            Product product = new Product();
//            products.add(product);
//
//            switch (dto.getType()) {
//                case RACQUETS -> {
//
//                    product.setId(e.getProduct_id());
//                    product.setMsrp(e.getList_price());
//                    product.setTitle(e.getTitle());
//                    product.setProductType(dto.getType());
//                    product.setRetailer(Retailer.HOLABIRD);
//                    product.setPrice(e.getPrice());
//                    product.setDiscount(e.getDiscount());
//                    product.setBrand(Brand.getBrandByName(e.getVendor()));
//                }
//            }
//        });
//
//        productRepository.saveAll(products);
//
//        Product p = productRepository.findById(dto.getItems().get(0).getProduct_id()).get();
//        p.setRetailer(Retailer.TENNIS_POINT);
//        p.setProductType(ProductType.BAGS);
//        p.setPrice("999");
//
//        Product savedProduct = productRepository.save(p);
//
//        Assertions.assertThat(savedProduct).isNotNull();
//        Assertions.assertThat(savedProduct.getRetailer()).isEqualTo(Retailer.TENNIS_POINT);
//        Assertions.assertThat(savedProduct.getProductType()).isEqualTo(ProductType.BAGS);
//        Assertions.assertThat(savedProduct.getPrice()).isEqualToIgnoringCase("999");
//
//    }
//
//    @Test
//    public void testProductRepository_Delete() {
//        List<Product> products = new ArrayList<>();
//
//        dto.getItems().forEach(e -> {
//
//            Product product = new Product();
//            products.add(product);
//
//            switch (dto.getType()) {
//                case RACQUETS -> {
//
//                    product.setId(e.getProduct_id());
//                    product.setMsrp(e.getList_price());
//                    product.setTitle(e.getTitle());
//                    product.setProductType(dto.getType());
//                    product.setRetailer(Retailer.HOLABIRD);
//                    product.setPrice(e.getPrice());
//                    product.setDiscount(e.getDiscount());
//                    product.setBrand(Brand.getBrandByName(e.getVendor()));
//                }
//            }
//        });
//
//        productRepository.saveAll(products);
//        productRepository.deleteById(dto.getItems().get(0).getProduct_id());
//
//        Optional<Product> p = productRepository.findById(dto.getItems().get(0).getProduct_id());
//
//        Assertions.assertThat(p).isEmpty();
//
//    }
//}
