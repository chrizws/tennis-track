package com.xyz.tennistrack.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.*;

public enum Retailer {

    DO_IT_TENNIS("Do It Tennis", "DIT"),
    TENNIS_WAREHOUSE("Tennis Warehouse", "TW"),
    TENNIS_PLAZA("Tennis Plaza", "TPZ"),
    TENNIS_POINT("Tennis Point", "TP"),
    HOLABIRD("HolaBird", "HB"),
    TENNIS_EXPRESS("Tennis Express", "TE"),
    NIKE("Nike", "NIKE"),
    COURTSIDE_TENNIS("Courtside Tennis", "CT"),
    CAYMAN_SPORTS("Cayman Sports", "CS"),
    DICK_SPORTING_GOODS("Dick's Sporting Goods", "DSG"),
    OLE_TENNIS("Ole Tennis", "OT"),
    PGA_TOUR("PGA Tour Superstore", "PGA"),
    TENNISZON("TennisZon", "TZ");

    private final String name;
    private final String abbrev;

    private static final Map<String, Retailer> BY_RETAILER_NAME = new HashMap<>();
    private static final Map<String, Retailer> BY_RETAILER_ABBREV = new HashMap<>();

    static {
        for (Retailer retailer : values()) {
            BY_RETAILER_NAME.put(retailer.name.toLowerCase(), retailer);
            BY_RETAILER_ABBREV.put(retailer.abbrev.toLowerCase(), retailer);
        }
    }

    Retailer(String name, String abbrev) {
        this.name = name;
        this.abbrev = abbrev;
    }

    public static Retailer getRetailerByName(String name) {
        return BY_RETAILER_NAME.get(name.toLowerCase());
    }

    public static Retailer getRetailerByAbbrev(String abbrev) {
        return BY_RETAILER_ABBREV.get(abbrev.toLowerCase());
    }

    @JsonValue
    public String getName() {
        return name;
    }
    public String getAbbrev() {
        return abbrev;
    }

}
