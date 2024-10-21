package com.xyz.tennistrack.dto.productDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.xyz.tennistrack.model.enums.Brand;
import com.xyz.tennistrack.model.enums.ProductType;
import com.xyz.tennistrack.model.enums.Retailer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductDto {

    //private int totalProducts;
    private int currentItems;
    private int totalItems;
    private List<Product> product;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class Product {

        private Retailer retailer;
        private ProductType productType;
        private Brand brand;
        private String title;
        private String price;
        private String msrp;
        private String discount;
        //private List<T> variants;

    }
}
