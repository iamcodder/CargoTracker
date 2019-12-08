package com.patronusstudio.cargotracker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class cargoes {

    @Expose
    @SerializedName("cost")
    private String cost;
    @Expose
    @SerializedName("stat")
    private String stat;
    @Expose
    @SerializedName("target_center")
    private String target_center;
    @Expose
    @SerializedName("outlet_center")
    private String outlet_center;
    @Expose
    @SerializedName("weight")
    private String weight;
    @Expose
    @SerializedName("receiver_tc")
    private String receiver_tc;
    @Expose
    @SerializedName("sender_tc")
    private String sender_tc;
    @Expose
    @SerializedName("tracking_number")
    private String tracking_number;

    public String getCost() {
        return cost;
    }

    public String getStat() {
        return stat;
    }

    public String getTarget_center() {
        return target_center;
    }

    public String getOutlet_center() {
        return outlet_center;
    }

    public String getWeight() {
        return weight;
    }

    public String getReceiver_tc() {
        return receiver_tc;
    }

    public String getSender_tc() {
        return sender_tc;
    }

    public String getTracking_number() {
        return tracking_number;

    }
}
