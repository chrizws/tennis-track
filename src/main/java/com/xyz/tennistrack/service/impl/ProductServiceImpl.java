package com.xyz.tennistrack.service.impl;

import com.xyz.tennistrack.dto.productDto.ProductDto;
import com.xyz.tennistrack.factory.DtoMapper;
import com.xyz.tennistrack.model.Entity.Product;
import com.xyz.tennistrack.model.Entity.Racquets;
import com.xyz.tennistrack.model.enums.ProductType;
import com.xyz.tennistrack.model.enums.Retailer;
import com.xyz.tennistrack.repository.ProductRepository;
import com.xyz.tennistrack.repository.RacquetRepository;
import com.xyz.tennistrack.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final RestTemplate rt;
    private final ProductRepository<Product> productRepository;
    private final RacquetRepository racquetRepository;
    private final HolabirdServiceImpl holabirdService;


    @Autowired
    public ProductServiceImpl(RestTemplate rt, ProductRepository productRepository, RacquetRepository racquetRepository, HolabirdServiceImpl holabirdService) {
        this.rt = rt;
        this.productRepository = productRepository;
        this.racquetRepository = racquetRepository;
        this.holabirdService = holabirdService;
    }

    public int getAllProducts() {
        return holabirdService.getAllProducts();
    }

    @Override
    public <T> ResponseEntity<ProductDto> getProductsByType(String type) {

        ProductType productType = ProductType.getProductTypeByName(type);

        int totalItems = racquetRepository.getAllRacquetsCount();
        Pageable page = PageRequest.of(0, 50);
        Page<Racquets> products = racquetRepository.findAll(page);

        List<Racquets> racquets = products.toList();

        ProductDto productDto = DtoMapper.toProductDto(racquets, totalItems);

        return ResponseEntity.ok(productDto);

    }

    @Override
    public <T> ResponseEntity<ProductDto> getProductsByBrand(String brand) {
        return null;
    }

    @Override
    public <T> ResponseEntity<ProductDto> getProductsByRetailer(String retailName) {

        Retailer retailer = Retailer.getRetailerByName(retailName);
        //temporarily use racquets in place of all products
        //List<Product> products = productRepository.findProductsByRetailer(retailer);

        //if (products != null)
            //return convertEntityToDto(products, retailer);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

    public ResponseEntity<List<Product>> getProductsByTypeAndRetailer(String type, String name) {

        ProductType productType = ProductType.getProductTypeByName(type);
        Retailer retailer = Retailer.getRetailerByName(name);
        //List<Product> products = productRepository.findProductsByProductTypeAndRetailer(productType, retailer);

        //if (products != null)
        //    return ResponseEntity.status(HttpStatus.OK).body(products);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

}
