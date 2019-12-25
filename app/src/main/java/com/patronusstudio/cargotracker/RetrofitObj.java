package com.patronusstudio.cargotracker;

import android.util.Log;

import androidx.annotation.NonNull;

import com.patronusstudio.cargotracker.Interface.JsonApi;
import com.patronusstudio.cargotracker.model.default_model;
import com.patronusstudio.cargotracker.model.personnel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.patronusstudio.cargotracker.Interface.modelSend.sendUser;
import com.patronusstudio.cargotracker.Interface.modelSend.send;

public class RetrofitObj {

    send modelSend;
    sendUser modelSendUser;

    public RetrofitObj(@NonNull send modelSend){
        this.modelSend=modelSend;
    }

    public RetrofitObj(@NonNull sendUser modelSendUser){
        this.modelSendUser=modelSendUser;
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://oguzhan.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    JsonApi jsonApi = retrofit.create(JsonApi.class);



    public void getDta(String id){
        Call<default_model> list = jsonApi.getData(id);

        list.enqueue(new Callback<default_model>() {
            @Override
            public void onResponse(Call<default_model> call, Response<default_model> response) {
                if(response.isSuccessful()){
                    default_model model=response.body();
                    if(model!=null){
                        modelSend.send(model);
                    }

                }
            }

            @Override
            public void onFailure(Call<default_model> call, Throwable t) {

            }
        });
    }

    public void getUser(String email, final String password){
        Call<personnel> user=jsonApi.getUser(email,password);

        user.enqueue(new Callback<personnel>() {
            @Override
            public void onResponse(Call<personnel> call, Response<personnel> response) {
                if(response.isSuccessful()){
                    personnel personnel =response.body();
                    if(personnel!=null)
                    modelSendUser.sendUser(personnel);

                }
            }

            @Override
            public void onFailure(Call<personnel> call, Throwable t) {
                Log.d("Sülo ",t.getLocalizedMessage().toString()+" ");

            }
        });
    }

}
