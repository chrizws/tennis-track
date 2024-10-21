package com.xyz.tennistrack.model.Entity;

import com.xyz.tennistrack.model.enums.Brand;
import com.xyz.tennistrack.model.enums.ProductType;
import com.xyz.tennistrack.model.enums.Retailer;
import com.xyz.tennistrack.model.Entity.Racquets;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@MappedSuperclass
public class Product {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name="retailer")
    private Retailer retailer;
    private String title;
    private double price;
    private double msrp;
    private double discount;

    @Enumerated(EnumType.STRING)
    @Column(name="product_type")
    private ProductType productType;

    @Enumerated(EnumType.STRING)
    @Column(name="brand")
    private Brand brand;
//    private String productUrl;
//    private String imageUrl;
//    private String quantity_total;
//    private String highest_price;
//    private String lowest_price;
//    private String lowest_price_date;

//    @OneToMany (cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id")
//    private List<Racquets> racquets;

//    @OneToMany(mappedBy="product", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//    private List<Racquets> racquets;

}
