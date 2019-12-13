package com.patronusstudio.cargotracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class target_address implements Parcelable {

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

    protected target_address(Parcel in) {
        city = in.readString();
        district = in.readString();
        street = in.readString();
        neighborhood = in.readString();
        id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(city);
        dest.writeString(district);
        dest.writeString(street);
        dest.writeString(neighborhood);
        dest.writeString(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<target_address> CREATOR = new Creator<target_address>() {
        @Override
        public target_address createFromParcel(Parcel in) {
            return new target_address(in);
        }

        @Override
        public target_address[] newArray(int size) {
            return new target_address[size];
        }
    };

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
