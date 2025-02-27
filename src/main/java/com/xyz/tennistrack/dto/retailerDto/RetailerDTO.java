package com.xyz.tennistrack.dto.retailerDto;

import com.xyz.tennistrack.model.enums.Retailer;

import java.util.*;

public abstract class RetailerDTO<T extends Retailer> {

    private T retailer;
    private List<T> products;

    public List<T> getProducts() {
        return products;
    }

    public void setProducts(List<T> products) {
        this.products = products;
    }

    public T getRetailer() {
        return retailer;
    }

    public void setRetailer(T retailer) {
        this.retailer = retailer;
    }

}
