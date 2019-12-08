package com.patronusstudio.cargotracker;


import com.patronusstudio.cargotracker.model.default_model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonApi {

    @GET("kargoTrack.php")
    Call<default_model> getData(@Query("tracking_number") String kargo_numarası);

}
