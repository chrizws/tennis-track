package com.xyz.tennistrack.model.enums;

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

    Retailer(String name, String abbrev) {
        this.name = name;
        this.abbrev = abbrev;
    }
    public String getName() {
        return name;
    }
    public String getAbbrev() {
        return abbrev;
    }

}
