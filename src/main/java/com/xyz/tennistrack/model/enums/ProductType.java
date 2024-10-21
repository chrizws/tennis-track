package com.xyz.tennistrack.model.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum ProductType {
    RACQUETS("Racquets", "Rackets", "Racquet", "Racquet"),
    SHOES("Shoes", "Shoe"),
    BAGS("Bags", "Backpack"),
    APPAREL("Apparel", "Hats", "Sock"),
    EQUIPMENT("Equipment"),
    PICKLEBALL("Pickleball"),
    STRINGS("Strings", "String"),
    ACCESSORIES("Accessories", "Accessory");

    private final List<String> names;
    private static final Map<String, ProductType> BY_NAMES = new HashMap<>();

    static {
        for (ProductType type : values()) {
            for (String name : type.getNames()) {
                BY_NAMES.put(name.toLowerCase(), type);
            }
        }
    }

    ProductType (String... names) {
        this.names = Arrays.asList(names);
    }

    public List<String> getNames() {
        return names;
    }

    public static ProductType getProductTypeByName(String name) {
        return BY_NAMES.get(name.toLowerCase());
    }

    public String getName() {
        return this.name();
    }
}
