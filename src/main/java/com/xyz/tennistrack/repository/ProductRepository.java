package com.xyz.tennistrack.repository;

import com.xyz.tennistrack.model.Product;
import com.xyz.tennistrack.model.enums.ProductType;
import com.xyz.tennistrack.model.enums.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findProductsByProductTypeAndRetailer(ProductType productType, Retailer retailer);

    List<Product> findProductsByProductType(ProductType productType);
}
