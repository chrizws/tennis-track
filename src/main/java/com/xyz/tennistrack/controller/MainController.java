package com.xyz.tennistrack.controller;

import com.xyz.tennistrack.config.UserAgents;
import com.xyz.tennistrack.dto.HolabirdDTO;
import com.xyz.tennistrack.model.enums.ProductType;
import com.xyz.tennistrack.service.impl.HolabirdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class MainController {

    private HolabirdServiceImpl holabirdService;

    public MainController(HolabirdServiceImpl holabirdService) {
        this.holabirdService = holabirdService;
    }

    @GetMapping("/")
    public String home() {
        return "hi";
    }

    @GetMapping("/holabird")
    public ResponseEntity<?> getAllHolabirdProducts() {

        return ResponseEntity.ok(holabirdService.getAllRacquets());

    }

    @GetMapping("/{retailer}/{type}")
    public ResponseEntity<?> getProductsByTypeAndRetailer(@PathVariable String retailer, @PathVariable String type) {

        return ResponseEntity.ok(holabirdService.getProductsByTypeAndRetailer(type, retailer));
    }




}
