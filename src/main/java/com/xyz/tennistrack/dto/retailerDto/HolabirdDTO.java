package com.xyz.tennistrack.dto.retailerDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.xyz.tennistrack.customSerializer.EmptyStringAsDoubleDeserializer;
import com.xyz.tennistrack.model.enums.ProductType;
import com.xyz.tennistrack.model.enums.Retailer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HolabirdDTO {

    private int totalItems;
    private int startIndex;
    private int itemsPerPage;
    private int currentItemCount;
    private List<Items> items;
    private ProductType type;
    private Retailer retailer;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Items {

        private String product_id;
        private String title;
        private String description;
        private String link;
        private String price;
        private String list_price;
        private String quantity;
        private String product_code;
        private String image_link;
        private String vendor;
        private String discount;
        private String add_to_cart_id;
        private String total_reviews;
        private String reviews_average_score;

        @JsonProperty("shopify_variants")
        private List<Variants> variants;
        private String quantity_total;


        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Variants {
            private String variant_id;
            private String sku;
            private String barcode;
            private String price;
            private String list_price;
            private String taxable;
            private String available;
            private String image_link;
            private String quantity_total;
            private String link;
            private Options options;

            @Data
            @NoArgsConstructor
            @AllArgsConstructor
            @Builder
            @JsonInclude(JsonInclude.Include.NON_EMPTY)
            @JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Options {
                private String size;
                private String width;
                private String color;

            }
        }
    }
}
