package com.xyz.tennistrack.controller;

import com.xyz.tennistrack.service.impl.HolabirdServiceImpl;
import com.xyz.tennistrack.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final HolabirdServiceImpl holabirdService;
    private final ProductServiceImpl productService;

    @Autowired
    public MainController(HolabirdServiceImpl holabirdService, ProductServiceImpl productService) {
        this.holabirdService = holabirdService;
        this.productService = productService;
    }

//    @GetMapping("/test")
//    public ResponseEntity<?> getProducts() {
//        return holabirdService.getProducts();
//    }

    @GetMapping("/fetch")
    public ResponseEntity<String> getAllProducts() {
        int itemsSaved = productService.getAllProducts();
        if (itemsSaved > 0)
            return ResponseEntity.ok(itemsSaved + " items saved");

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Failed to Save");
    }


    @GetMapping("/{retailer}")
    public ResponseEntity<?> getProductsByRetailer(@PathVariable String retailer) {

        return (ResponseEntity<?>) productService.getProductsByRetailer(retailer);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<?> getProductsByType(@PathVariable String type) {

        return productService.getProductsByType(type);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getProductById(@PathVariable int id) {
//
//        return productService.getProductById(id);
//    }
    @GetMapping("/{retailer}/{type}")
    public ResponseEntity<?> getProductsByTypeAndRetailer(@PathVariable String retailer, @PathVariable String type) {

        return productService.getProductsByTypeAndRetailer(type, retailer);
    }




}
