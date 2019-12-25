package com.patronusstudio.cargotracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class personnel implements Parcelable {

    @Expose
    @SerializedName("active")
    private int active;
    @Expose
    @SerializedName("register_key")
    private String register_key;
    @Expose
    @SerializedName("gender")
    private int gender;
    @Expose
    @SerializedName("tc")
    private String tc;
    @Expose
    @SerializedName("address")
    private String address;
    @Expose
    @SerializedName("phone")
    private String phone;
    @Expose
    @SerializedName("password")
    private String password;
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("surname")
    private String surname;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("id")
    private int id;

    protected personnel(Parcel in) {
        active = in.readInt();
        register_key = in.readString();
        gender = in.readInt();
        tc = in.readString();
        address = in.readString();
        phone = in.readString();
        password = in.readString();
        email = in.readString();
        surname = in.readString();
        name = in.readString();
        id = in.readInt();
    }

    public static final Creator<personnel> CREATOR = new Creator<personnel>() {
        @Override
        public personnel createFromParcel(Parcel in) {
            return new personnel(in);
        }

        @Override
        public personnel[] newArray(int size) {
            return new personnel[size];
        }
    };

    public int getActive() {
        return active;
    }

    public String getRegister_key() {
        return register_key;
    }

    public int getGender() {
        return gender;
    }

    public String getTc() {
        return tc;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setRegister_key(String register_key) {
        this.register_key = register_key;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(active);
        dest.writeString(register_key);
        dest.writeInt(gender);
        dest.writeString(tc);
        dest.writeString(address);
        dest.writeString(phone);
        dest.writeString(password);
        dest.writeString(email);
        dest.writeString(surname);
        dest.writeString(name);
        dest.writeInt(id);
    }
}
