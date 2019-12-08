package com.patronusstudio.cargotracker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class receiver_info {

    @Expose
    @SerializedName("address_id")
    private String address_id;
    @Expose
    @SerializedName("phone")
    private String phone;
    @Expose
    @SerializedName("surname")
    private String surname;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("tc")
    private String tc;

    public String getAddress_id() {
        return address_id;
    }

    public String getPhone() {
        return phone;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getTc() {
        return tc;

    }
}
