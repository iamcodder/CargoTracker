package com.patronusstudio.cargotracker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class outlet_cargoes_info {

    @Expose
    @SerializedName("working_hours")
    private String working_hours;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("id")
    private String id;

    public String getWorking_hours() {
        return working_hours;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;

    }
}
