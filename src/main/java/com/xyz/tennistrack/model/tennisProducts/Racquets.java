package com.xyz.tennistrack.model.tennisProducts;

import com.xyz.tennistrack.dto.HolabirdDTO;
import com.xyz.tennistrack.model.Product;
import com.xyz.tennistrack.model.enums.Brand;
import com.xyz.tennistrack.model.enums.ProductType;
import com.xyz.tennistrack.model.enums.Retailer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Racquets {

    @Id
    private String racquet_id;
    private String price;
    private String list_price;
    private String quantity_total;
    private String link;
    private String sku;
    private String barcode;

    @Embedded
    private Options options;

//    @ManyToOne (cascade = {CascadeType.ALL})
//    @JoinColumn(name = "product_id")
//    private Product product;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Options {
        private String size;
    }

}
