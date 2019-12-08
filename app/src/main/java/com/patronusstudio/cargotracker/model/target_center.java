package com.patronusstudio.cargotracker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class target_center {

    @Expose
    @SerializedName("address")
    private String address;
    @Expose
    @SerializedName("cargoes_info")
    private String cargoes_info;
    @Expose
    @SerializedName("phone")
    private String phone;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("id")
    private String id;

    public String getAddress() {
        return address;
    }

    public String getCargoes_info() {
        return cargoes_info;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;

    }
}
