package com.patronusstudio.cargotracker.Interface;


import com.patronusstudio.cargotracker.model.cargoes;
import com.patronusstudio.cargotracker.model.default_model;
import com.patronusstudio.cargotracker.model.personnel;
import com.patronusstudio.cargotracker.model.responseUserSave;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonApi {

    @GET("android/fetchTrackCargo.php")
    Call<default_model> getData(@Query("tracking_number") String kargo_numarası);

    @GET("android/userLogin.php")
    Call<personnel> getUser(@Query("email") String email, @Query("password")String password);

    @GET("android/PostUser.php")
    Call<responseUserSave> setUser(@Query("id")String id,
                                   @Query("sifre")String sifre,
                                   @Query("email")String email,
                                   @Query("adres")String adres);

    @GET("android/fetchCargoes.php")
    Call<List<cargoes>> tumKargoDondur();

    @GET("android/setCargoStatus.php")
    Call<responseUserSave> setStatus(@Query("tracking_number")String tracking_number,
                                     @Query("status")String status);

}
