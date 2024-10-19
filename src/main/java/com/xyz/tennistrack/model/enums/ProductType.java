package com.xyz.tennistrack.model.enums;

import java.util.Arrays;

public enum ProductType {
    RACQUETS("Racquets", "Rackets", "Racquet", "Racquet"),
    SHOES("Shoes", "Shoe"),
    BAGS("Bags", "Backpack"),
    APPAREL("Apparel", "Hats", "Sock"),
    EQUIPMENT("Equipment"),
    PICKLEBALL("Pickleball"),
    STRINGS("Strings", "String"),
    ACCESSORIES("Accessories", "Accessory");

    private final String[] names;

    ProductType (String... names) {
        this.names = names;
    }

    public String[] getNames() {
        return names;
    }

    public static ProductType getProductType(String name) {
        for (ProductType type : values()) {
            String found = Arrays.stream(type.names).filter(e -> e.equalsIgnoreCase(name)).findFirst().get();
            if (!found.isEmpty())
                return type;
        }
        return null;
    }

    public static boolean hasCategoryName(String name) {
        for (ProductType cat : values()) {
            for (String n : cat.getNames()) {
                if (name.toLowerCase().contains(n.toLowerCase()))
                    return true;
            }

        }
        return false;
    }

    public boolean hasName(String name) {
        for (String s : getNames()) {
            if (name.toLowerCase().contains(s.toLowerCase()))
                return true;
        }
        return false;
    }

    public String getName() {
        return this.name();
    }
}
