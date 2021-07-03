package com.xiaopantx.design.builder;

import java.util.stream.Stream;

/**
 * @author panxj
 */
public class Location {

    private String country;
    private String streetNo;

    public Location(String country, String streetNo) {
        this.country = country;
        this.streetNo = streetNo;
    }

    @Override
    public String toString() {
        return "Location{" +
                "country='" + country + '\'' +
                ", streetNo='" + streetNo + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }
}
