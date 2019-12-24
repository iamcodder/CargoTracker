package com.patronusstudio.cargotracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class target_center implements Parcelable {


    @Expose
    @SerializedName("phone")
    private String phone;
    @Expose
    @SerializedName("address")
    private String address;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("id")
    private String id;

    protected target_center(Parcel in) {
        phone = in.readString();
        address = in.readString();
        name = in.readString();
        id = in.readString();
    }

    public static final Creator<target_center> CREATOR = new Creator<target_center>() {
        @Override
        public target_center createFromParcel(Parcel in) {
            return new target_center(in);
        }

        @Override
        public target_center[] newArray(int size) {
            return new target_center[size];
        }
    };

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
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
        dest.writeString(phone);
        dest.writeString(address);
        dest.writeString(name);
        dest.writeString(id);
    }
}
