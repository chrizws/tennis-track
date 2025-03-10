package com.xyz.tennistrack.repository;

import com.xyz.tennistrack.model.Entity.Product;
import com.xyz.tennistrack.model.enums.ProductType;
import com.xyz.tennistrack.model.enums.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository<T extends Product> extends JpaRepository<T, String> {

    //List<Product> findProductsByProductTypeAndRetailer(ProductType productType, Retailer retailer);

    //List<Product> findProductsByProductType(ProductType productType);

    //List<Product> findProductsByRetailer(Retailer retailer);

    //List<T> saveAll(List<T> products);

}
