package com.xyz.tennistrack.model.Entity;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Racquets extends Product {

//    @Id
//    private String racquet_id;

    @Id
    private String id;

    private double price;
    private double list_price;
    private double quantity_total;
//    private String link;
//    private String sku;
//    private String barcode;

    @Embedded
    private Options options;

//    @ManyToOne (cascade = {CascadeType.ALL})
//    @JoinColumn(name = "product_id")
//    private Product product;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class Options {
        private String size;
        private String color;
    }

}
