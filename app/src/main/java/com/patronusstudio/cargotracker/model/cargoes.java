package com.patronusstudio.cargotracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class cargoes implements Parcelable {

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

    protected cargoes(Parcel in) {
        cost = in.readString();
        stat = in.readString();
        target_center = in.readString();
        outlet_center = in.readString();
        weight = in.readString();
        receiver_tc = in.readString();
        sender_tc = in.readString();
        tracking_number = in.readString();
    }

    public static final Creator<cargoes> CREATOR = new Creator<cargoes>() {
        @Override
        public cargoes createFromParcel(Parcel in) {
            return new cargoes(in);
        }

        @Override
        public cargoes[] newArray(int size) {
            return new cargoes[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cost);
        dest.writeString(stat);
        dest.writeString(target_center);
        dest.writeString(outlet_center);
        dest.writeString(weight);
        dest.writeString(receiver_tc);
        dest.writeString(sender_tc);
        dest.writeString(tracking_number);
    }
}
