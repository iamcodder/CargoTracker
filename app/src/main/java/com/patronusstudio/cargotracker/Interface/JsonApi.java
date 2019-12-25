package com.patronusstudio.cargotracker.Interface;


import com.patronusstudio.cargotracker.model.default_model;
import com.patronusstudio.cargotracker.model.personnel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonApi {

    @GET("android/fetch.php")
    Call<default_model> getData(@Query("tracking_number") String kargo_numarası);

    @GET("android/user.php")
    Call<personnel> getUser(@Query("email")String email, @Query("password")String password);

}
