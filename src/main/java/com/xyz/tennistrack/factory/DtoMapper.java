package com.xyz.tennistrack.factory;

import com.xyz.tennistrack.dto.productDto.ProductDto;
import com.xyz.tennistrack.dto.productDto.RacquetsDto;
import com.xyz.tennistrack.model.Entity.Product;
import com.xyz.tennistrack.model.Entity.Racquets;

import java.util.*;
import java.util.stream.Collectors;

public class DtoMapper {

    public static <T extends Product> ProductDto toProductDto(List<T> products, int totalItems) {

        ProductDto productDto = new ProductDto();

//        int totalItems = products.stream()
//                .map(e -> 0)
//                .mapToInt(f -> f)
//                .sum();
        productDto.setCurrentItems(products.size());
        productDto.setTotalItems(totalItems);
        productDto.setProduct(toProduct(products));

        return productDto;

    }

    private static <T extends Product> List<ProductDto.Product> toProduct(List<T> products) {

        List<ProductDto.Product> productDtoList = products.stream()
                .map(e -> ProductDto.Product.builder()
                        .productType(e.getProductType())
                        .brand(e.getBrand())
                        .title(e.getTitle())
                        .price(String.valueOf(e.getPrice()))
                        .msrp(String.valueOf(e.getMsrp()))
                        .discount(String.valueOf(e.getDiscount()))
                        .retailer(e.getRetailer())

                        .build())
                .toList();

        return productDtoList;
    }
//    private static List<ProductDto.Product<RacquetsDto>> toProductList(List<Product> product) {
//            product.setVariants(toRacquetsDto(product.getVariants()));
//
//
//    }

    private static List<RacquetsDto> toRacquetsDto(List<Racquets> racquets) {

        List<RacquetsDto> racquetsDto = racquets.stream()
                .map(r -> RacquetsDto.builder()
                        .price(String.valueOf(r.getPrice()))
                        .list_price(String.valueOf(r.getList_price()))
                        .quantity_total(String.valueOf(r.getQuantity_total()))
                        .options(RacquetsDto.OptionsDto.builder()
                                .size(r.getOptions().getSize())
                                .color(r.getOptions().getColor())
                                .build())
                        .build())
                .toList();

        return racquetsDto;

    }

}
