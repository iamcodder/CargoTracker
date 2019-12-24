package com.patronusstudio.cargotracker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class denemeTahtasi {


    @Expose
    @SerializedName("time")
    private String time;
    @Expose
    @SerializedName("movement")
    private String movement;
    @Expose
    @SerializedName("cargo_id")
    private String cargo_id;
    @Expose
    @SerializedName("id")
    private String id;

    public String getTime() {
        return time;
    }

    public String getMovement() {
        return movement;
    }

    public String getCargo_id() {
        return cargo_id;
    }

    public String getId() {
        return id;
    }
}
