package com.patronusstudio.cargotracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class receiver_info implements Parcelable {

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

    protected receiver_info(Parcel in) {
        address_id = in.readString();
        phone = in.readString();
        surname = in.readString();
        name = in.readString();
        tc = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address_id);
        dest.writeString(phone);
        dest.writeString(surname);
        dest.writeString(name);
        dest.writeString(tc);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<receiver_info> CREATOR = new Creator<receiver_info>() {
        @Override
        public receiver_info createFromParcel(Parcel in) {
            return new receiver_info(in);
        }

        @Override
        public receiver_info[] newArray(int size) {
            return new receiver_info[size];
        }
    };

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
