package com.patronusstudio.cargotracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class responseUserSave implements Parcelable {

    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("success")
    private boolean success;

    protected responseUserSave(Parcel in) {
        message = in.readString();
        success = in.readByte() != 0;
    }

    public static final Creator<responseUserSave> CREATOR = new Creator<responseUserSave>() {
        @Override
        public responseUserSave createFromParcel(Parcel in) {
            return new responseUserSave(in);
        }

        @Override
        public responseUserSave[] newArray(int size) {
            return new responseUserSave[size];
        }
    };

    public String getMessage() {
        return message;
    }

    public boolean getSuccess() {
        return success;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(message);
        dest.writeByte((byte) (success ? 1 : 0));
    }
}
