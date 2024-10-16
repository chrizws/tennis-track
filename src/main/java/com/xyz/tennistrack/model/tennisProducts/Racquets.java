package com.xyz.tennistrack.model.tennisProducts;

import com.xyz.tennistrack.model.Product;
import jakarta.persistence.*;

@Entity
public class Racquets extends Product<Racquets>{

    private String racquet_id;

    private String sku;
    private String barcode;
    private String price;
    private String list_price;
    private String quantity_total;
    private String link;

    @Embedded
    private Options options;

    @ManyToOne
    private Product<Racquets> product;


    public Racquets() {}

    public Racquets(RacquetBuilder builder) {
        this.racquet_id = builder.racquet_id;
        this.sku = builder.sku;
        this.barcode = builder.barcode;
        this.price = builder.price;
        this.list_price = builder.list_price;
        this.options = builder.options;
        this.quantity_total = builder.quantity_total;
        this.link = builder.link;
    }

    public static class RacquetBuilder {

        private String racquet_id;
        private String sku;
        private String barcode;
        private String price;
        private String list_price;
        private Options options;
        private String quantity_total;
        private String link;



        public RacquetBuilder racquet_id(String racquet_id) {
            this.racquet_id = racquet_id;
            return this;
        }
        public RacquetBuilder sku(String sku) {
            this.sku = sku;
            return this;
        }
        public RacquetBuilder barcode(String barcode) {
            this.barcode = barcode;
            return this;
        }
        public RacquetBuilder price(String price) {
            this.price = price;
            return this;
        }
        public RacquetBuilder list_price(String list_price) {
            this.list_price = list_price;
            return this;
        }
        public RacquetBuilder quantity_total(String quantity_total) {
            this.quantity_total = quantity_total;
            return this;
        }
        public RacquetBuilder link(String link) {
            this.link = link;
            return this;
        }
        public RacquetBuilder options(Options options) {
            this.options = options;
            return this;
        }

        public Racquets build() {
            return new Racquets(this);
        }
    }
    @Embeddable
    public static class Options {


        private String size;

        public String getSize() {
            return size;
        }
        public void setSize(String size) {
            this.size = size;
        }
    }

    public Product<Racquets> getProduct() {
        return product;
    }

    public void setProduct(Product<Racquets> product) {
        this.product = product;
    }

    public String getRacquet_id() {
        return racquet_id;
    }

    public void setRacquet_id(String id) {
        this.racquet_id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getList_price() {
        return list_price;
    }

    public void setList_price(String list_price) {
        this.list_price = list_price;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public String getQuantity_total() {
        return quantity_total;
    }

    public void setQuantity_total(String quantity_total) {
        this.quantity_total = quantity_total;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


}
