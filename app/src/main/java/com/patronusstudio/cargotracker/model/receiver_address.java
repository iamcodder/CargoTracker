package com.patronusstudio.cargotracker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class receiver_address {

    @Expose
    @SerializedName("city")
    private String city;
    @Expose
    @SerializedName("district")
    private String district;
    @Expose
    @SerializedName("street")
    private String street;
    @Expose
    @SerializedName("neighborhood")
    private String neighborhood;
    @Expose
    @SerializedName("id")
    private String id;

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getId() {
        return id;

    }
}
