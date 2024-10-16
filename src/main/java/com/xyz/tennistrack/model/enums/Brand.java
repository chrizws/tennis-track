package com.xyz.tennistrack.model.enums;

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
    SOLINCO("Solinco"),
    TECNIFIBRE("Tecnifibre"),
    TOURNA("Tourna"),
    TYROL("Tyrol"),
    VOLKL("Volkl"),
    WILSON("Wilson"),
    YONEX("Yonex");

    private String name;

    Brand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Brand getBrandName(String name) {
        for (Brand brand : Brand.values()) {
            if (brand.name.equalsIgnoreCase(name))
                return brand;
        }
        return null;
    }
}
