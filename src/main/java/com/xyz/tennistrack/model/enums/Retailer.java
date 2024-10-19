package com.xyz.tennistrack.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private String name;
    private String abbrev;
    private List<String> names = new ArrayList<>();

    Retailer(String name, String abbrev) {
        this.name = name;
        this.abbrev = abbrev;
        names.addAll(List.of(name, abbrev));
    }

    public List<String> getNames() {
        return names;
    }

    public static Retailer getRetailer(String name) {
        for (Retailer r : Retailer.values()) {
            if (r.names.stream().anyMatch(e -> e.equalsIgnoreCase(name)))
                return r;
        }
        return null;
    }
    public String getName() {
        return name;
    }
    public String getAbbrev() {
        return abbrev;
    }

}
