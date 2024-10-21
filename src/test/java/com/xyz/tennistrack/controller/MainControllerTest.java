package com.xyz.tennistrack.controller;

import com.xyz.tennistrack.model.Entity.Product;
import com.xyz.tennistrack.model.enums.ProductType;
import com.xyz.tennistrack.model.enums.Retailer;
import com.xyz.tennistrack.repository.ProductRepository;
import com.xyz.tennistrack.service.impl.HolabirdServiceImpl;
import com.xyz.tennistrack.service.impl.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.mockito.Mockito.when;

@DataJpaTest
public class MainControllerTest {

    @Mock
    private HolabirdServiceImpl holabirdServiceMock;

    @Mock
    private ProductServiceImpl productServiceMock;

    @Mock
    private ProductRepository productRepositoryMock;

    @InjectMocks
    private MainController mainController;

    @Test
    public void testMainController_CallProducts() {

        when(productServiceMock.getAllProducts()).thenReturn(2);

        Assertions.assertThat(mainController.getAllProducts()).isEqualTo(2);

    }

//    @Test
//    public void testMainController_GetProductByRetailer() {
//
//        when(productRepositoryMock.findProductsByProductType(Mockito.any(ProductType.class)))
//                .thenReturn(new ArrayList<>());
//
//        List<Product> products = productRepositoryMock.findProductsByRetailer(Retailer.HOLABIRD);
//        products.add(new Product());
//
//        when(productServiceMock.getProductsByRetailer("list"))
//                .thenReturn(null);
//
//        ResponseEntity<?> response = mainController.getProductsByRetailer("list");
//
//        Assertions.assertThat(response).isNotNull();
//        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//        Assertions.assertThat(((List<Product>)response.getBody()).size()).isEqualTo(1);
//
//        when(productServiceMock.getProductsByRetailer("null"))
//                .thenReturn(ResponseEntity.status(HttpStatus.ACCEPTED).body(null));
//
//        response = mainController.getProductsByRetailer("null");
//        Assertions.assertThat(response).isNotNull();
//        Assertions.assertThat(response.getBody()).isNull();
//        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
//
//    }

//    @Test
//    public void testMainController_getProductsByTypeAndRetailer() {
//
//        when(productRepositoryMock.findProductsByProductTypeAndRetailer(ProductType.RACQUETS, Retailer.HOLABIRD))
//                .thenReturn(new ArrayList<>());
//
//        List<Product> products = productRepositoryMock.findProductsByProductTypeAndRetailer(ProductType.RACQUETS, Retailer.HOLABIRD);
//        products.add(new Product());
//
//        when(productServiceMock.getProductsByTypeAndRetailer("Racquets", "Holabird"))
//                .thenReturn(ResponseEntity.status(HttpStatus.OK).body(products));
//
//        ResponseEntity<?> response = mainController.getProductsByTypeAndRetailer("Holabird", "Racquets");
//
//        Assertions.assertThat(response).isNotNull();
//        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//        Assertions.assertThat(((List<Product>)response.getBody()).size()).isEqualTo(1);
//
//
//    }
}
