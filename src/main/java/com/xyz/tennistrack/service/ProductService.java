package com.xyz.tennistrack.service;

import com.xyz.tennistrack.dto.productDto.ProductDto;
import com.xyz.tennistrack.dto.retailerDto.RetailerDTO;
import com.xyz.tennistrack.model.enums.Brand;
import com.xyz.tennistrack.model.enums.ProductType;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {


    <T> ResponseEntity<ProductDto> getProductsByType(String type);

    <T> ResponseEntity<ProductDto> getProductsByBrand(String brand);

    <T> ResponseEntity<ProductDto> getProductsByRetailer(String retailer);

}
