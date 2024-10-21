package com.xyz.tennistrack.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum Brand {

    ADIDAS("Adidas"),
    ASICS("Asics"),
    ALTRA("Altra"),
    BABOLAT("Babolat"),
    BROOKS("Brooks"),
    DIADORA("Diadora"),
    DUNLOP("Dunlop"),
    FILA("Fila"),
    GAMMA("Gamma"),
    KIRSCHBAUM("Kirschbaum"),
    LUXILON("Luxilon"),
    LACOSTE("Lacoste"),
    LOTTO("Lotto"),
    HARTRU("Har-Tru"),
    HEAD("Head"),
    HOKA("Hoka"),
    MIZUNO("Mizuno"),
    NIKE("Nike"),
    NEW_BALANCE("New Balance"),
    PRINCE("Prince"),
    PROKENNEX("Pro Kennex"),
    SOLINCO("Solinco"),
    TECNIFIBRE("Tecnifibre"),
    TOURNA("Tourna"),
    TYROL("Tyrol"),
    VOLKL("Volkl"),
    WILSON("Wilson"),
    YONEX("Yonex");

    private final String name;
    private static final Map<String, Brand> BY_NAME = new HashMap<>();

    static {
        for (Brand brand : values()) {
            BY_NAME.put(brand.name.toLowerCase(), brand);
        }
    }
    Brand(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public static Brand getBrandByName(String name) {
        return BY_NAME.get(name.toLowerCase());

    }
}
