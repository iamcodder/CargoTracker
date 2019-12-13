package com.patronusstudio.cargotracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class outlet_adress implements Parcelable {

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

    protected outlet_adress(Parcel in) {
        city = in.readString();
        district = in.readString();
        street = in.readString();
        neighborhood = in.readString();
        id = in.readString();
    }

    public static final Creator<outlet_adress> CREATOR = new Creator<outlet_adress>() {
        @Override
        public outlet_adress createFromParcel(Parcel in) {
            return new outlet_adress(in);
        }

        @Override
        public outlet_adress[] newArray(int size) {
            return new outlet_adress[size];
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(city);
        dest.writeString(district);
        dest.writeString(street);
        dest.writeString(neighborhood);
        dest.writeString(id);
    }
}
