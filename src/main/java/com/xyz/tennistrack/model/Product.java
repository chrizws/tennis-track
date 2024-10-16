package com.xyz.tennistrack.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xyz.tennistrack.model.enums.Brand;
import com.xyz.tennistrack.model.enums.ProductType;
import com.xyz.tennistrack.model.enums.Retailer;
import com.xyz.tennistrack.model.tennisProducts.Racquets;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//@MappedSuperclass
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    @Id
    private String id;

    private Retailer retailer;
    private String title;
    private String price;
    private String msrp;
    private String discount;
    private ProductType productType;
    private Brand brand;
//    private String productUrl;
//    private String imageUrl;
//    private String quantity_total;
//    private String highest_price;
//    private String lowest_price;
//    private String lowest_price_date;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<Racquets> racquets;

//    @OneToMany(mappedBy="product", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//    private List<Racquets> racquets;

}
