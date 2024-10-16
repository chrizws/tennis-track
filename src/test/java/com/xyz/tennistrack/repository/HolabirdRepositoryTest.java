package com.xyz.tennistrack.repository;

import com.xyz.tennistrack.dto.HolabirdDTO;
import com.xyz.tennistrack.model.Product;
import com.xyz.tennistrack.model.enums.Brand;
import com.xyz.tennistrack.model.enums.ProductType;
import com.xyz.tennistrack.model.enums.Retailer;
import com.xyz.tennistrack.model.tennisProducts.Racquets;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class HolabirdRepositoryTest {

    @Autowired
    private HolabirdRepository holabirdRepository;

    private static HolabirdDTO dto;

    @BeforeAll
    public static void setUp() {
        //create the dto
        dto = new HolabirdDTO();

        dto.setType(ProductType.RACQUETS);
        dto.setTotalItems(360);
        dto.setStartIndex(0);
        dto.setItemsPerPage(250);
        dto.setCurrentItemCount(250);

        List<HolabirdDTO.Items> items = new ArrayList<>();
        dto.setItems(items);

        HolabirdDTO.Items item1 = new HolabirdDTO.Items();
        HolabirdDTO.Items item2 = new HolabirdDTO.Items();
        HolabirdDTO.Items item3 = new HolabirdDTO.Items();

        //item 1
        item1.setProduct_id("1323317330014");
        item1.setTitle("HEAD Ti. S6");
        item1.setDescription("");
        item1.setLink("\\/products\\/head-ti-s6");
        item1.setPrice("99.0000");
        item1.setList_price("325.0000");
        item1.setQuantity("1");
        item1.setProduct_code("100096   2L");
        item1.setImage_link("https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/2006\\/8755\\/products\\/100096_1_large.jpg?v=1596473380");
        item1.setVendor("Head");
        item1.setDiscount("70");
        item1.setAdd_to_cart_id("12221276815454");
        item1.setTotal_reviews("30");
        item1.setReviews_average_score("4.6");

        List<HolabirdDTO.Variants> variants = new ArrayList<>();

        //variant 1
        HolabirdDTO.Variants variant1 = new HolabirdDTO.Variants();
        variant1.setVariant_id("12221276815454");
        variant1.setSku("100096   2L");
        variant1.setBarcode("726423947943");
        variant1.setPrice("99.0000");
        variant1.setList_price("325.0000");
        variant1.setTaxable("1");
        variant1.setAvailable("1");
        variant1.setQuantity_total("5");
        variant1.setLink("\\/products\\/head-ti-s6?variant=12221276815454");

        HolabirdDTO.Variants.Options options = new HolabirdDTO.Variants.Options();
        options.setSize("2L - 4 1\\/4\\");
        variant1.setOptions(options);

        //variant 2
        HolabirdDTO.Variants variant2 = new HolabirdDTO.Variants();
        variant2.setVariant_id("12221276848222");
        variant2.setSku("100096   3L");
        variant2.setBarcode("726423947950");
        variant2.setPrice("99.0000");
        variant2.setList_price("325.0000");
        variant2.setTaxable("1");
        variant2.setAvailable("1");
        variant2.setQuantity_total("6");
        variant2.setLink("\\/products\\/head-ti-s6?variant=12221276848222");

        HolabirdDTO.Variants.Options options2 = new HolabirdDTO.Variants.Options();
        options2.setSize("3L - 4 3\\/8\\");
        variant2.setOptions(options);

        variants.add(variant1);
        variants.add(variant2);


        //item 2
        item2.setProduct_id("1323318116446");
        item2.setTitle("Wilson Hyper Hammer 5.3 Stretch Oversize");
        item2.setDescription("");
        item2.setLink("\\/products\\/wilson-hyper-hammer-5-3-stretch-over");
        item2.setPrice("199.0000");
        item2.setList_price("199.9900");
        item2.setQuantity("1");
        item2.setProduct_code("100241   1L");
        item2.setImage_link("\"https:\\/\\/cdn.shopify.com\\/s\\/files\\/1\\/2006\\/8755\\/products\\/100241_1_large.jpg?v=1596733522");
        item2.setVendor("Wilson");
        item2.setDiscount("40");
        item2.setAdd_to_cart_id("15391879463006");
        item2.setTotal_reviews("28");
        item2.setReviews_average_score("4.3");

        List<HolabirdDTO.Variants> variants2 = new ArrayList<>();

        HolabirdDTO.Variants variant3 = new HolabirdDTO.Variants();
        variant3.setVariant_id("12221276815454");
        variant3.setSku("100096   2L");
        variant3.setBarcode("726423947943");
        variant3.setPrice("99.0000");
        variant3.setList_price("325.0000");
        variant3.setTaxable("1");
        variant3.setAvailable("1");
        variant3.setQuantity_total("5");
        variant3.setLink("\\/products\\/wilson?variant=122212768214122");

        HolabirdDTO.Variants.Options options3 = new HolabirdDTO.Variants.Options();
        options3.setSize("2L - 4 1\\/4\\");
        variant3.setOptions(options3);


        HolabirdDTO.Variants variant4 = new HolabirdDTO.Variants();
        variant4.setVariant_id("12221276848222");
        variant4.setSku("100096   3L");
        variant4.setBarcode("726423947950");
        variant4.setPrice("99.0000");
        variant4.setList_price("325.0000");
        variant4.setTaxable("1");
        variant4.setAvailable("1");
        variant4.setQuantity_total("6");
        variant4.setLink("\\/products\\/wilson?variant=122212768482342");

        HolabirdDTO.Variants.Options options4 = new HolabirdDTO.Variants.Options();
        options4.setSize("3L - 4 3\\/8\\");
        variant4.setOptions(options4);

        //add list of variant options to the variants array
        variants2.add(variant3);
        variants2.add(variant4);

        //add the variants array to the item dto
        item1.setVariants(variants);
        item2.setVariants(variants2);

        //add the item dto to the list of items
        items.add(item1);
        items.add(item2);


    }

    @Test
    public void testHolabirdRepository_Save() {

        List<Product<Racquets>> products = new ArrayList<>();

        dto.getItems().stream().forEach(e -> {

            switch (dto.getType()) {
                case RACQUETS -> {
                    List<Racquets> variants = new ArrayList<>();

                    Product<Racquets> product = new Racquets.RacquetBuilder()
                            .retailer(Retailer.HOLABIRD)
                            .title(e.getTitle())
                            .price(e.getPrice())
                            .list_price(e.getList_price())
                            .productType(dto.getType())
                            .discount(e.getDiscount())
                            .brand(Brand.getBrandName(e.getVendor()))
                            .build();

                    product.setVariants(variants);
                    product.setId(e.getProduct_id());
                    product.setMsrp(e.getList_price());

                    e.getVariants().stream()
                            .forEach(f -> {
                                Racquets racquets = new Racquets.RacquetBuilder()
                                        .racquet_id(f.getVariant_id())
                                        .price(f.getPrice())
                                        .list_price(f.getList_price())
                                        .quantity_total(f.getQuantity_total())
                                        .link(f.getLink())
                                        .build();

                                Racquets.Options options = new Racquets.Options();
                                options.setSize(f.getOptions().getSize());
                                racquets.setOptions(options);

                                variants.add(racquets);
                            });

                    products.add(product);

                }
            }
        });

        holabirdRepository.saveAll(products);

        List<Product> list = holabirdRepository.findAll();

        Assertions.assertThat(list).isNotNull();
        Assertions.assertThat(list.size()).isGreaterThan(0);

    }

    @Test
    public void testHolabirdRepository_FindById() {

    }

    @Test
    public void testHolabirdRepository_Update() {

    }

    @Test
    public void testHolabirdRepository_Delete() {

    }
}
