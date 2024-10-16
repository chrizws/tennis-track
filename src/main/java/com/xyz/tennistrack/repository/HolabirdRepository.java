package com.xyz.tennistrack.repository;

import com.xyz.tennistrack.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolabirdRepository extends JpaRepository<Product, String> {
}
