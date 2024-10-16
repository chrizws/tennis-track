package com.xyz.tennistrack.service;

import com.xyz.tennistrack.dto.RetailerDTO;
import com.xyz.tennistrack.model.Product;
import com.xyz.tennistrack.model.enums.Brand;
import com.xyz.tennistrack.model.enums.ProductType;

import java.util.List;

public interface ProductService<T extends RetailerDTO> {

    List<T> getAllProducts();

    List<T> getProductsByType(ProductType type);

    List<T> getProductsByBrand(Brand brand);

    RetailerDTO addProduct(RetailerDTO product);

}
