package com.xyz.tennistrack.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.xyz.tennistrack.TestJson;
import com.xyz.tennistrack.customSerializer.EmptyStringAsDoubleDeserializer;
import com.xyz.tennistrack.customSerializer.EmptyStringAsIntegerDeserializer;
import com.xyz.tennistrack.dto.retailerDto.HolabirdDTO;
import com.xyz.tennistrack.model.Entity.Product;
import com.xyz.tennistrack.model.enums.Brand;
import com.xyz.tennistrack.model.enums.ProductType;
import com.xyz.tennistrack.model.enums.Retailer;
import com.xyz.tennistrack.model.Entity.Racquets;
import com.xyz.tennistrack.repository.ProductRepository;
import com.xyz.tennistrack.repository.RacquetRepository;
import com.xyz.tennistrack.service.impl.HolabirdServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
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

    @Mock
    private RacquetRepository racquetRepositoryMock;

    @InjectMocks
    private HolabirdServiceImpl holabirdServiceImpl;

    private static HolabirdDTO dto;
    private static List<Product> products;

    @BeforeAll
    public static void initProducts() {

        //create the products
        products = new ArrayList<>();

        Racquets p = new Racquets();
        //p.setId("1323317330014");
        p.setMsrp(Double.parseDouble("325.0000"));
        p.setTitle("HEAD Ti. S6");
        p.setProductType(ProductType.RACQUETS);
        p.setRetailer(Retailer.HOLABIRD);
        p.setPrice(Double.parseDouble("99.0000"));
        p.setDiscount(Double.parseDouble("70"));
        p.setBrand(Brand.getBrandByName("Head"));

        Racquets p2 = new Racquets();
        //p2.setId("1323317330015");
        p2.setMsrp(Double.parseDouble("199.9900"));
        p2.setTitle("Wilson Hyper Hammer 5.3 Stretch Oversize");
        p2.setProductType(ProductType.RACQUETS);
        p2.setRetailer(Retailer.HOLABIRD);
        p2.setPrice(Double.parseDouble("199.0000"));
        p2.setDiscount(Double.parseDouble("40"));
        p2.setBrand(Brand.getBrandByName("Wilson"));


        p.setId("12221276815454");
        p.setList_price(Double.parseDouble("325.0000"));
        p.setQuantity_total(Double.parseDouble("5"));
        p.setOptions(Racquets.Options.builder()
                .size("2L - 4 3\\/8\\")
                .build());

        p2.setId("12221276848222");
        p2.setList_price(Double.parseDouble("199.9900"));
        p2.setQuantity_total(Double.parseDouble("6"));
        p2.setOptions(Racquets.Options.builder()
                .size("3L - 4 3\\/8\\")
                .build());

        products.add(p);
        products.add(p2);

    }
    @BeforeAll
    public static void initDto() throws JsonProcessingException {
        SimpleModule mod = new SimpleModule();
        mod.addDeserializer(Integer.class, new EmptyStringAsIntegerDeserializer());
        mod.addDeserializer(Double.class, new EmptyStringAsDoubleDeserializer());

        dto = new ObjectMapper()
                .registerModule(mod)
                .readerFor(HolabirdDTO.class)
                .readValue(TestJson.json);
    }

    @Test
    public void testHolabirdServiceImpl_getAllProducts() {

       when(rtMock.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.any(HttpEntity.class), Mockito.eq(HolabirdDTO.class)))
                .thenReturn(ResponseEntity.ok(dto));

       when(productRepositoryMock.saveAll(Mockito.anyList())).thenReturn(products);

       int productsSaved = holabirdServiceImpl.getAllProducts();

        Assertions.assertThat(productsSaved).isEqualTo(2);

    }

//    @Test
//    public void testHolabirdServiceImpl_toProductEntityFromHolabirdDto() {
//
//        List<Product> products = holabirdServiceImpl.toProductEntityFromHolabirdDto(dto);
//        Assertions.assertThat(products).isNotNull();
//        Assertions.assertThat(products.size()).isEqualTo(4);
//    }

//    @Test
//    public void testHolabirdServiceImpl_createEntityFromDto() {
//
//        dto.setType(ProductType.RACQUETS);
//
//        List<Product> products = holabirdServiceImpl.toProductEntityFromHolabirdDto(dto);
//        Assertions.assertThat(products).isNotNull();
//        Assertions.assertThat(products.size()).isEqualTo(2);
//
//        //Assertions.assertThat(products.get(0).getRacquets().size()).isEqualTo(2);
//
//    }



}
