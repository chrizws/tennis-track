package com.xyz.tennistrack.service;

import com.xyz.tennistrack.dto.HolabirdDTO;
import com.xyz.tennistrack.model.Product;
import com.xyz.tennistrack.model.enums.Brand;
import com.xyz.tennistrack.model.enums.ProductType;
import com.xyz.tennistrack.model.enums.Retailer;
import com.xyz.tennistrack.model.tennisProducts.Racquets;
import com.xyz.tennistrack.repository.ProductRepository;
import com.xyz.tennistrack.service.impl.HolabirdServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HolabirdServiceImplTest {

    @Mock
    private ProductRepository productRepositoryMock;

    @Mock
    private RestTemplate rtMock;

    @InjectMocks
    private HolabirdServiceImpl holabirdServiceImpl;

    private static HolabirdDTO dto;
    private static List<Product> products;

    @BeforeAll
    public static void initProducts() {

        //create the products
        products = new ArrayList<>();

        Product p = new Product();
        p.setId("1323317330014");
        p.setMsrp("325.0000");
        p.setTitle("HEAD Ti. S6");
        p.setProductType(ProductType.RACQUETS);
        p.setRetailer(Retailer.HOLABIRD);
        p.setPrice("99.0000");
        p.setDiscount("70");
        p.setBrand(Brand.getBrandName("Head"));
        products.add(p);

        Product p2 = new Product();
        p2.setId("1323317330015");
        p2.setMsrp("199.9900");
        p2.setTitle("Wilson Hyper Hammer 5.3 Stretch Oversize");
        p2.setProductType(ProductType.RACQUETS);
        p2.setRetailer(Retailer.HOLABIRD);
        p2.setPrice("199.0000");
        p2.setDiscount("40");
        p2.setBrand(Brand.getBrandName("Wilson"));
        products.add(p2);

        List<Racquets> variants1 = new ArrayList<>();
        List<Racquets> variants2 = new ArrayList<>();
        p.setRacquets(variants1);
        p2.setRacquets(variants2);

        //create the variants
        Racquets racquet1 = Racquets.builder()
                .racquet_id("12221276815454")
                .sku("100096   2L")
                .barcode("726423947943")
                .price("99.0000")
                .list_price("325.0000")
                .quantity_total("5")
                .link("\\/products\\/head-ti-s6?variant=12221276815454")
                .options(Racquets.Options.builder()
                        .size("2L - 4 3\\/8\\")
                        .build())
                .build();

        Racquets racquet2 = Racquets.builder()
                .racquet_id("12221276848222")
                .sku("100096   3L")
                .barcode("726423947950")
                .price("99.0000")
                .list_price("325.0000")
                .quantity_total("6")
                .link("\\/products\\/head-ti-s6?variant=12221276848222")
                .options(Racquets.Options.builder()
                        .size("3L - 4 3\\/8\\")
                        .build())
                .build();

        variants1.add(racquet1);
        variants1.add(racquet2);

        Racquets racquet3 = Racquets.builder()
                .racquet_id("12221276815333")
                .sku("100096   2L")
                .barcode("726423947943")
                .price("99.0000")
                .list_price("199.0000")
                .quantity_total("1")
                .link("\\/products\\/wilson?variant=122212768214122")
                .options(Racquets.Options.builder()
                        .size("2L - 4 3\\/8\\")
                        .build())
                .build();

        Racquets racquet4 = Racquets.builder()
                .racquet_id("12221276848444")
                .sku("100096   3L")
                .barcode("726423947950")
                .price("99.0000")
                .list_price("199.0000")
                .quantity_total("1")
                .link("\\/products\\/wilson?variant=122212768482342")
                .options(Racquets.Options.builder()
                        .size("3L - 4 3\\/8\\")
                        .build())
                .build();

        variants2.add(racquet3);
        variants2.add(racquet4);

    }
    @BeforeAll
    public static void initDto() {
        //create the dto
        dto = new HolabirdDTO();

        dto.setTotalItems(360);
        dto.setStartIndex(0);
        dto.setItemsPerPage(250);
        dto.setCurrentItemCount(250);

        List<HolabirdDTO.Items> items = new ArrayList<>();

        dto.setItems(items);

        HolabirdDTO.Items item1 = new HolabirdDTO.Items();
        HolabirdDTO.Items item2 = new HolabirdDTO.Items();

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
        variant3.setLink("\\/products\\/head-ti-s6?variant=12221276815454");

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
        variant4.setLink("\\/products\\/head-ti-s6?variant=12221276848222");

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
    public void testHolabirdServiceImpl_CallAllProducts() {

       when(rtMock.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.any(HttpEntity.class), Mockito.eq(HolabirdDTO.class)))
                .thenReturn(ResponseEntity.ok(dto));

        List<Product> products = holabirdServiceImpl.callAllProducts();

        Assertions.assertThat(products).isNotNull();
        Assertions.assertThat(products.size()).isEqualTo(2);

    }

    @Test
    public void testHolabirdServiceImpl_GetAllRacquets() {

        //test find all racquets given the mocked product repository
        when(productRepositoryMock.findProductsByProductType(ProductType.RACQUETS)).thenReturn(products);

        ResponseEntity<?> response = holabirdServiceImpl.getAllRacquets();

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode().value()).isEqualTo(200);

        //test when no racquets are found and a message is returned
        when(productRepositoryMock.findProductsByProductType(ProductType.RACQUETS)).thenReturn(null);
        response = holabirdServiceImpl.getAllRacquets();

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
        Assertions.assertThat(response.getBody()).isEqualTo("No Products Found");
    }


    @Test
    public void testHolabirdServiceImpl_GetProductsByTypeAndRetailer() {
        //test to find products given a retailer and product type
        when(productRepositoryMock.
                findProductsByProductTypeAndRetailer(ProductType.RACQUETS, Retailer.HOLABIRD))
                .thenReturn(products);
        ResponseEntity<?> response = holabirdServiceImpl.getProductsByTypeAndRetailer("Racquets", "Holabird");

        List<Product> foundProducts = (List<Product>) response.getBody();

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(foundProducts.size()).isEqualTo(2);

        //test when no retailer or product type is found
        when(productRepositoryMock.findProductsByProductTypeAndRetailer(ProductType.RACQUETS, Retailer.HOLABIRD))
                .thenReturn(null);
        response = holabirdServiceImpl.getProductsByTypeAndRetailer("Racquets", "Holabird");

        Assertions.assertThat(response.getBody()).isEqualTo("Holabird Racquets not found");
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);


    }


}
