package com.xyz.tennistrack.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xyz.tennistrack.model.enums.Brand;
import com.xyz.tennistrack.model.enums.ProductType;
import com.xyz.tennistrack.model.enums.Retailer;
import com.xyz.tennistrack.model.tennisProducts.Racquets;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product<T> {

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
    private String productUrl;
    private String imageUrl;
    private String quantity_total;
    private String highest_price;
    private String lowest_price;
    private String lowest_price_date;

    @OneToMany (mappedBy = "product", targetEntity=Racquets.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<T> variants;

    public Product() {}

    public Product(Builder<T> builder) {
        this.id = builder.id;
        this.retailer = builder.retailer;
        this.title = builder.title;
        this.price = builder.price;
        this.msrp = builder.msrp;
        this.discount = builder.discount;
        this.brand = builder.brand;
        this.productUrl = builder.productUrl;
        this.imageUrl = builder.imageUrl;
        this.quantity_total = builder.quantity_total;
        this.highest_price = builder.highest_price;
        this.lowest_price = builder.lowest_price;
        this.lowest_price_date = builder.lowest_price_date;
        this.productType = builder.productType;
        this.variants = builder.variants;
    }


    public static class Builder<T> {

        private String id;
        private Retailer retailer;
        private String title;
        private String price;
        private String msrp;
        private String discount;
        private Brand brand;
        private String productUrl;
        private String imageUrl;
        private String quantity_total;
        private String highest_price;
        private String lowest_price;
        private String lowest_price_date;
        private ProductType productType;
        private List<T> variants;



        public Builder<T> variants(List<T> variants) {
            this.variants = variants;
            return this;
        }

        public Builder<T> id(String id) {
            this.id = id;
            return this;
        }

        public Builder<T> productType(ProductType productType) {
            this.productType = productType;
            return this;
        }

        public Builder<T> highest_price(String highest_price) {
            this.highest_price = highest_price;
            return this;
        }

        public Builder<T> lowest_price(String lowest_price) {
            this.lowest_price = lowest_price;
            return this;
        }

        public Builder<T> lowest_price_date(String lowest_price_date) {
            this.lowest_price_date = lowest_price_date;
            return this;
        }

        public Builder<T> retailer(Retailer retailer) {
            this.retailer = retailer;
            return this;
        }

        public Builder<T> title(String title) {
            this.title = title;
            return this;
        }

        public Builder<T> price(String price) {
            this.price = price;
            return this;
        }

        public Builder<T> msrp(String msrp) {
            this.msrp = msrp;
            return this;
        }

        public Builder<T> discount(String discount) {
            this.discount = discount;
            return this;
        }

        public Builder<T> brand(Brand brand) {
            this.brand = brand;
            return this;
        }

        public Builder<T> productUrl(String productUrl) {
            this.productUrl = productUrl;
            return this;
        }

        public Builder<T> imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder<T> quantity_total(String quantity_total) {
            this.quantity_total = quantity_total;
            return this;
        }

        public Product<T> build() {
            return new Product<T>(this);
        }
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Retailer getRetailer() {
        return retailer;
    }

    public void setRetailer(Retailer retailer) {
        this.retailer = retailer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMsrp() {
        return msrp;
    }

    public void setMsrp(String msrp) {
        this.msrp = msrp;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getQuantity_total() {
        return quantity_total;
    }

    public void setQuantity_total(String quantity_total) {
        this.quantity_total = quantity_total;
    }

    public List<T> getVariants() {
        return variants;
    }

    public void setVariants(List<T> productType) {
        this.variants = productType;
    }

    public String getHighest_price() {
        return highest_price;
    }

    public void setHighest_price(String highest_price) {
        this.highest_price = highest_price;
    }

    public String getLowest_price() {
        return lowest_price;
    }

    public void setLowest_price(String lowest_price) {
        this.lowest_price = lowest_price;
    }

    public String getLowest_price_date() {
        return lowest_price_date;
    }

    public void setLowest_price_date(String lowest_price_date) {
        this.lowest_price_date = lowest_price_date;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
