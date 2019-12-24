package com.patronusstudio.cargotracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class cargoes_movement implements Parcelable {


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

    protected cargoes_movement(Parcel in) {
        time = in.readString();
        movement = in.readString();
        cargo_id = in.readString();
        id = in.readString();
    }

    public static final Creator<cargoes_movement> CREATOR = new Creator<cargoes_movement>() {
        @Override
        public cargoes_movement createFromParcel(Parcel in) {
            return new cargoes_movement(in);
        }

        @Override
        public cargoes_movement[] newArray(int size) {
            return new cargoes_movement[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(time);
        dest.writeString(movement);
        dest.writeString(cargo_id);
        dest.writeString(id);
    }
}
