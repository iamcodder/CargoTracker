package com.patronusstudio.cargotracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class default_model implements Parcelable {


    @Expose
    @SerializedName("target_center")
    private target_center target_center;
    @Expose
    @SerializedName("outlet_center")
    private outlet_center outlet_center;
    @Expose
    @SerializedName("cargoes")
    private cargoes cargoes;
    @Expose
    @SerializedName("cargo_movement")
    private List<cargoes_movement> cargoes_movements;

    protected default_model(Parcel in) {
        target_center = in.readParcelable(com.patronusstudio.cargotracker.model.target_center.class.getClassLoader());
        outlet_center = in.readParcelable(com.patronusstudio.cargotracker.model.outlet_center.class.getClassLoader());
        cargoes = in.readParcelable(com.patronusstudio.cargotracker.model.cargoes.class.getClassLoader());
        cargoes_movements = in.createTypedArrayList(cargoes_movement.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(target_center, flags);
        dest.writeParcelable(outlet_center, flags);
        dest.writeParcelable(cargoes, flags);
        dest.writeTypedList(cargoes_movements);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<default_model> CREATOR = new Creator<default_model>() {
        @Override
        public default_model createFromParcel(Parcel in) {
            return new default_model(in);
        }

        @Override
        public default_model[] newArray(int size) {
            return new default_model[size];
        }
    };

    public target_center getTarget_center() {
        return target_center;
    }

    public outlet_center getOutlet_center() {
        return outlet_center;
    }

    public cargoes getCargoes() {
        return cargoes;
    }

    public List<cargoes_movement> getCargoes_movements() {
        return cargoes_movements;
    }
}
