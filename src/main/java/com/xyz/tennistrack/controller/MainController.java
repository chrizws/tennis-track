package com.xyz.tennistrack.controller;

import com.xyz.tennistrack.config.UserAgents;
import com.xyz.tennistrack.dto.HolabirdDTO;
import com.xyz.tennistrack.service.impl.HolabirdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public HolabirdDTO getHolabird() {

        //return holabirdService.getHolaBirdDTO();
        return null;
    }




}
