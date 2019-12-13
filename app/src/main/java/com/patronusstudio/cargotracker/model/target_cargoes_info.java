package com.patronusstudio.cargotracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class target_cargoes_info implements Parcelable {

    @Expose
    @SerializedName("working_hours")
    private String working_hours;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("id")
    private String id;

    protected target_cargoes_info(Parcel in) {
        working_hours = in.readString();
        name = in.readString();
        id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(working_hours);
        dest.writeString(name);
        dest.writeString(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<target_cargoes_info> CREATOR = new Creator<target_cargoes_info>() {
        @Override
        public target_cargoes_info createFromParcel(Parcel in) {
            return new target_cargoes_info(in);
        }

        @Override
        public target_cargoes_info[] newArray(int size) {
            return new target_cargoes_info[size];
        }
    };

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
