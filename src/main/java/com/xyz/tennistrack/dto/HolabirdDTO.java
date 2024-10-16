package com.xyz.tennistrack.dto;

import com.xyz.tennistrack.model.enums.ProductType;

import java.util.*;


public class HolabirdDTO extends RetailerDTO {

    private int totalItems;
    private int startIndex;
    private int itemsPerPage;
    private int currentItemCount;
    private List<Items> items;
    private ProductType type;

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
        private List<Variants> variants;
        private String quantity_total;

        public Items() {}

        public Items(ItemBuilder builder) {
            this.product_id = builder.product_id;
            this.title = builder.title;
            this.description = builder.description;
            this.link = builder.link;
            this.price = builder.price;
            this.list_price = builder.list_price;
            this.quantity = builder.quantity;
            this.product_code = builder.product_code;
            this.image_link = builder.image_link;
            this.vendor = builder.vendor;
            this.discount = builder.discount;
            this.add_to_cart_id = builder.add_to_cart_id;
            this.total_reviews = builder.total_reviews;
            this.reviews_average_score = builder.reviews_average_score;
            this.variants = builder.variants;
            this.quantity_total = builder.quantity_total;

        }

        public static class ItemBuilder {
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
            public List<Variants> variants;
            private String quantity_total;


            public ItemBuilder product_id(String product_id) {
                this.product_id = product_id;
                return this;
            }

            public ItemBuilder title(String title) {
                this.title = title;
                return this;
            }

            public ItemBuilder description(String description) {
                this.description = description;
                return this;
            }

            public ItemBuilder link(String link) {
                this.link = link;
                return this;
            }

            public ItemBuilder price(String price) {
                this.price = price;
                return this;
            }

            public ItemBuilder list_price(String list_price) {
                this.list_price = list_price;
                return this;
            }

            public ItemBuilder quantity(String quantity) {
                this.quantity = quantity;
                return this;
            }

            public ItemBuilder product_code(String product_code) {
                this.product_code = product_code;
                return this;
            }

            public ItemBuilder image_link(String image_link) {
                this.image_link = image_link;
                return this;
            }

            public ItemBuilder vendor(String vendor) {
                this.vendor = vendor;
                return this;
            }

            public ItemBuilder discount(String discount) {
                this.discount = discount;
                return this;
            }

            public ItemBuilder add_to_cart_id(String add_to_cart_id) {
                this.add_to_cart_id = add_to_cart_id;
                return this;
            }

            public ItemBuilder total_reviews(String total_reviews) {
                this.total_reviews = total_reviews;
                return this;
            }

            public ItemBuilder reviews_average_score(String reviews_average_score) {
                this.reviews_average_score = reviews_average_score;
                return this;
            }

            public ItemBuilder variants(List<Variants> variants) {
                this.variants = variants;
                return this;
            }

            public ItemBuilder quantity_total(String quantity_total) {
                this.quantity_total = quantity_total;
                return this;
            }

            public Items build() {
                return new Items(this);
            }
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
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

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getProduct_code() {
            return product_code;
        }

        public void setProduct_code(String product_code) {
            this.product_code = product_code;
        }

        public String getImage_link() {
            return image_link;
        }

        public void setImage_link(String image_link) {
            this.image_link = image_link;
        }

        public String getVendor() {
            return vendor;
        }

        public void setVendor(String vendor) {
            this.vendor = vendor;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getAdd_to_cart_id() {
            return add_to_cart_id;
        }

        public void setAdd_to_cart_id(String add_to_cart_id) {
            this.add_to_cart_id = add_to_cart_id;
        }

        public String getTotal_reviews() {
            return total_reviews;
        }

        public void setTotal_reviews(String total_reviews) {
            this.total_reviews = total_reviews;
        }

        public String getReviews_average_score() {
            return reviews_average_score;
        }

        public void setReviews_average_score(String reviews_average_score) {
            this.reviews_average_score = reviews_average_score;
        }

        public List<Variants> getVariants() {
            return variants;
        }

        public void setVariants(List<Variants> variants) {
            this.variants = variants;
        }

        public String getQuantity_total() {
            return quantity_total;
        }

        public void setQuantity_total(String quantity_total) {
            this.quantity_total = quantity_total;
        }
    }

    public static class Variants {
        private String variant_id;
        private String sku;
        private String barcode;
        private String price;
        private String list_price;
        private String taxable;
        private String available;
        private String quantity_total;
        private String link;
        private Options options;

        public Variants() {}
        public Variants(VariantsBuilder builder) {
            this.variant_id = builder.variant_id;
            this.sku = builder.sku;
            this.barcode = builder.barcode;
            this.price = builder.price;
            this.list_price = builder.list_price;
            this.taxable = builder.taxable;
            this.available = builder.available;
            this.quantity_total = builder.quantity_total;
            this.link = builder.link;
            this.options = builder.options;
        }

        public static class VariantsBuilder {
            private String variant_id;
            private String sku;
            private String barcode;
            private String price;
            private String list_price;
            private String taxable;
            private String available;
            private String quantity_total;
            private String link;
            private Options options;

            public VariantsBuilder variant_id(String variant_id) {
                this.variant_id = variant_id;
                return this;
            }

            public VariantsBuilder sku(String sku) {
                this.sku = sku;
                return this;
            }

            public VariantsBuilder barcode(String barcode) {
                this.barcode = barcode;
                return this;
            }

            public VariantsBuilder price(String price) {
                this.price = price;
                return this;
            }

            public VariantsBuilder list_price(String list_price) {
                this.list_price = list_price;
                return this;
            }

            public VariantsBuilder options(Options options) {
                this.options = options;
                return this;
            }


            public VariantsBuilder quantity_total(String quantity_total) {
                this.quantity_total = quantity_total;
                return this;
            }


            public VariantsBuilder link(String link) {
                this.link = link;
                return this;
            }


            public Variants build() {
                return new Variants(this);
            }
        }


        public static class Options {
            private String size;
            private String width;

            public Options() {}
            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }
        }


        public String getVariant_id() {
            return variant_id;
        }

        public void setVariant_id(String variant_id) {
            this.variant_id = variant_id;
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

        public String getTaxable() {
            return taxable;
        }

        public void setTaxable(String taxable) {
            this.taxable = taxable;
        }

        public String getAvailable() {
            return available;
        }

        public void setAvailable(String available) {
            this.available = available;
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

        public Options getOptions() {
            return options;
        }

        public void setOptions(Options options) {
            this.options = options;
        }
    }


    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public int getCurrentItemCount() {
        return currentItemCount;
    }

    public void setCurrentItemCount(int currentItemCount) {
        this.currentItemCount = currentItemCount;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }


    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
