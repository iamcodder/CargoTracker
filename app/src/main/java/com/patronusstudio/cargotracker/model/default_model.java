package com.patronusstudio.cargotracker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class default_model implements Serializable {

    @Expose
    @SerializedName("cargoes")
    private cargoes cargoes;
    @Expose
    @SerializedName("sender_info")
    private sender_info sender_info;
    @Expose
    @SerializedName("sender_address")
    private sender_address sender_address;
    @Expose
    @SerializedName("receiver_info")
    private receiver_info receiver_info;
    @Expose
    @SerializedName("receiver_address")
    private receiver_address receiver_address;
    @Expose
    @SerializedName("outlet_center")
    private outlet_center outlet_center;
    @Expose
    @SerializedName("outlet_adress")
    private outlet_adress outlet_adress;
    @Expose
    @SerializedName("outlet_cargoes_info")
    private outlet_cargoes_info outlet_cargoes_info;
    @Expose
    @SerializedName("target_center")
    private target_center target_center;
    @Expose
    @SerializedName("target_address")
    private target_address target_address;
    @Expose
    @SerializedName("target_cargoes_info")
    private target_cargoes_info target_cargoes_info;

    public void setCargoes(com.patronusstudio.cargotracker.model.cargoes cargoes) {
        this.cargoes = cargoes;
    }

    public void setSender_info(com.patronusstudio.cargotracker.model.sender_info sender_info) {
        this.sender_info = sender_info;
    }

    public void setSender_address(com.patronusstudio.cargotracker.model.sender_address sender_address) {
        this.sender_address = sender_address;
    }

    public void setReceiver_info(com.patronusstudio.cargotracker.model.receiver_info receiver_info) {
        this.receiver_info = receiver_info;
    }

    public void setReceiver_address(com.patronusstudio.cargotracker.model.receiver_address receiver_address) {
        this.receiver_address = receiver_address;
    }

    public void setOutlet_center(com.patronusstudio.cargotracker.model.outlet_center outlet_center) {
        this.outlet_center = outlet_center;
    }

    public void setOutlet_adress(com.patronusstudio.cargotracker.model.outlet_adress outlet_adress) {
        this.outlet_adress = outlet_adress;
    }

    public void setOutlet_cargoes_info(com.patronusstudio.cargotracker.model.outlet_cargoes_info outlet_cargoes_info) {
        this.outlet_cargoes_info = outlet_cargoes_info;
    }

    public void setTarget_center(com.patronusstudio.cargotracker.model.target_center target_center) {
        this.target_center = target_center;
    }

    public void setTarget_address(com.patronusstudio.cargotracker.model.target_address target_address) {
        this.target_address = target_address;
    }

    public void setTarget_cargoes_info(com.patronusstudio.cargotracker.model.target_cargoes_info target_cargoes_info) {
        this.target_cargoes_info = target_cargoes_info;
    }

    public com.patronusstudio.cargotracker.model.cargoes getCargoes() {
        return cargoes;
    }

    public com.patronusstudio.cargotracker.model.sender_info getSender_info() {
        return sender_info;
    }

    public com.patronusstudio.cargotracker.model.sender_address getSender_address() {
        return sender_address;
    }

    public com.patronusstudio.cargotracker.model.receiver_info getReceiver_info() {
        return receiver_info;
    }

    public com.patronusstudio.cargotracker.model.receiver_address getReceiver_address() {
        return receiver_address;
    }

    public com.patronusstudio.cargotracker.model.outlet_center getOutlet_center() {
        return outlet_center;
    }

    public com.patronusstudio.cargotracker.model.outlet_adress getOutlet_adress() {
        return outlet_adress;
    }

    public com.patronusstudio.cargotracker.model.outlet_cargoes_info getOutlet_cargoes_info() {
        return outlet_cargoes_info;
    }

    public com.patronusstudio.cargotracker.model.target_center getTarget_center() {
        return target_center;
    }

    public com.patronusstudio.cargotracker.model.target_address getTarget_address() {
        return target_address;
    }

    public com.patronusstudio.cargotracker.model.target_cargoes_info getTarget_cargoes_info() {
        return target_cargoes_info;
    }
}
