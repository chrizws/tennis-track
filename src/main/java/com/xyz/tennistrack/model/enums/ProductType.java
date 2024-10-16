package com.xyz.tennistrack.model.enums;

public enum ProductType {
    RACQUETS("Racquets", "Rackets", "Racquet", "Racquet"),
    SHOES("Shoes", "Shoe"),
    BAGS("Bags", "Backpack"),
    APPAREL("Apparel", "Hats", "Sock"),
    EQUIPMENT("Equipment"),
    PICKLEBALL("Pickleball"),
    STRINGS("Strings", "String"),
    ACCESSORIES("Accessories", "Accessory");

    private String[] names;
    ProductType (String... names) {
        this.names = names;
    }

    public String[] getNames() {
        return names;
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
