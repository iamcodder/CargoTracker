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
    @SerializedName("status")
    private String status;
    @Expose
    @SerializedName("time")
    private String time;
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
    @SerializedName("receiver_address")
    private String receiver_address;
    @Expose
    @SerializedName("receiver_tc")
    private String receiver_tc;
    @Expose
    @SerializedName("receiver_phone")
    private String receiver_phone;
    @Expose
    @SerializedName("receiver_surname")
    private String receiver_surname;
    @Expose
    @SerializedName("receiver_name")
    private String receiver_name;
    @Expose
    @SerializedName("sender_address")
    private String sender_address;
    @Expose
    @SerializedName("sender_tc")
    private String sender_tc;
    @Expose
    @SerializedName("sender_phone")
    private String sender_phone;
    @Expose
    @SerializedName("sender_surname")
    private String sender_surname;
    @Expose
    @SerializedName("sender_name")
    private String sender_name;
    @Expose
    @SerializedName("tracking_number")
    private String tracking_number;
    @Expose
    @SerializedName("id")
    private String id;

    public void setStatus(String status) {
        this.status = status;
    }

    protected cargoes(Parcel in) {
        cost = in.readString();
        status = in.readString();
        time = in.readString();
        target_center = in.readString();
        outlet_center = in.readString();
        weight = in.readString();
        receiver_address = in.readString();
        receiver_tc = in.readString();
        receiver_phone = in.readString();
        receiver_surname = in.readString();
        receiver_name = in.readString();
        sender_address = in.readString();
        sender_tc = in.readString();
        sender_phone = in.readString();
        sender_surname = in.readString();
        sender_name = in.readString();
        tracking_number = in.readString();
        id = in.readString();
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

    public String getStatus() {
        return status;
    }

    public String getTime() {
        return time;
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

    public String getReceiver_address() {
        return receiver_address;
    }

    public String getReceiver_tc() {
        return receiver_tc;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public String getReceiver_surname() {
        return receiver_surname;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public String getSender_address() {
        return sender_address;
    }

    public String getSender_tc() {
        return sender_tc;
    }

    public String getSender_phone() {
        return sender_phone;
    }

    public String getSender_surname() {
        return sender_surname;
    }

    public String getSender_name() {
        return sender_name;
    }

    public String getTracking_number() {
        return tracking_number;
    }

    public String getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cost);
        dest.writeString(status);
        dest.writeString(time);
        dest.writeString(target_center);
        dest.writeString(outlet_center);
        dest.writeString(weight);
        dest.writeString(receiver_address);
        dest.writeString(receiver_tc);
        dest.writeString(receiver_phone);
        dest.writeString(receiver_surname);
        dest.writeString(receiver_name);
        dest.writeString(sender_address);
        dest.writeString(sender_tc);
        dest.writeString(sender_phone);
        dest.writeString(sender_surname);
        dest.writeString(sender_name);
        dest.writeString(tracking_number);
        dest.writeString(id);
    }
}
