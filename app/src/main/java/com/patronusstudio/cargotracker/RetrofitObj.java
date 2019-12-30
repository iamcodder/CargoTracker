package com.patronusstudio.cargotracker;

import android.util.Log;

import androidx.annotation.NonNull;

import com.patronusstudio.cargotracker.Interface.JsonApi;
import com.patronusstudio.cargotracker.Interface.modelSend;
import com.patronusstudio.cargotracker.Interface.modelSend.send;
import com.patronusstudio.cargotracker.Interface.modelSend.sendUser;
import com.patronusstudio.cargotracker.model.cargoes;
import com.patronusstudio.cargotracker.model.default_model;
import com.patronusstudio.cargotracker.model.personnel;
import com.patronusstudio.cargotracker.Interface.modelSend.savePersonel;
import com.patronusstudio.cargotracker.model.responseUserSave;
import com.patronusstudio.cargotracker.Interface.modelSend.updateStatus;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObj {

    send modelSend;
    sendUser modelSendUser;
    savePersonel savePersonel;
    updateStatus updateStatus;


    public RetrofitObj(@NonNull send modelSend) {
        this.modelSend = modelSend;
    }

    public RetrofitObj(@NonNull sendUser modelSendUser) {
        this.modelSendUser = modelSendUser;
    }

    public RetrofitObj(@NonNull savePersonel savePersonel) {
        this.savePersonel = savePersonel;
    }

    public RetrofitObj(@NonNull updateStatus updateStatus) {
        this.updateStatus = updateStatus;
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://oguzhan.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    JsonApi jsonApi = retrofit.create(JsonApi.class);


    public void getDta(String id) {
        Call<default_model> list = jsonApi.getData(id);

        list.enqueue(new Callback<default_model>() {
            @Override
            public void onResponse(Call<default_model> call, Response<default_model> response) {
                if (response.isSuccessful()) {
                    default_model model = response.body();
                    if (model != null) {
                        modelSend.send(model);
                    }

                }
                else {
                    modelSend.errorMessage("Kargo bilgisi bulunamadı.");
                }
            }

            @Override
            public void onFailure(Call<default_model> call, Throwable t) {
                modelSend.errorMessage("Kargo bilgisi bulunamadı.");
            }
        });
    }

    public void getUser(String email, final String password) {
        Call<personnel> user = jsonApi.getUser(email, password);

        user.enqueue(new Callback<personnel>() {
            @Override
            public void onResponse(Call<personnel> call, Response<personnel> response) {

                if (response.isSuccessful()) {
                    personnel personnel = response.body();
                    if (personnel != null)
                        modelSendUser.sendUser(personnel);
                }
            }

            @Override
            public void onFailure(Call<personnel> call, Throwable t) {
                modelSendUser.errorMessage("Mail/Şifre hatalı.");
            }
        });
    }

    public void setUser(@NonNull personnel user){


        Call<responseUserSave> call=jsonApi.setUser(user.getId()+"",
                user.getPassword(),
                user.getEmail(),
                user.getPhone());

        call.enqueue(new Callback<responseUserSave>() {
            @Override
            public void onResponse(Call<responseUserSave> call, Response<responseUserSave> response) {

                if(response.isSuccessful()){
                    responseUserSave userSave=response.body();
                    savePersonel.isStatus(true,"Güncelleme başarılı");
                }
                else {
                    savePersonel.isStatus(false,response.message());
                }
            }

            @Override
            public void onFailure(Call<responseUserSave> call, Throwable t) {
                savePersonel.isStatus(true,t.getLocalizedMessage());
            }
        });
    }

    public void getAllCargoes(){

        final Call<List<cargoes>> list_cargoes = jsonApi.tumKargoDondur();

        list_cargoes.enqueue(new Callback<List<cargoes>>() {
            @Override
            public void onResponse(Call<List<cargoes>> call, Response<List<cargoes>> response) {

                if(response.isSuccessful()){

                    List<cargoes> list=response.body();
                    if(list!=null){
                        modelSendUser.sendList(list);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<cargoes>> call, Throwable t) {
                Log.d("Sülo",t.getLocalizedMessage());

            }
        });
    }

    public void setStatus(@NonNull cargoes cargo){

        Call<responseUserSave> call=jsonApi.setStatus(cargo.getTracking_number(),cargo.getStatus());


        call.enqueue(new Callback<responseUserSave>() {
            @Override
            public void onResponse(Call<responseUserSave> call, Response<responseUserSave> response) {
                if(response.isSuccessful()){
                    responseUserSave responseUserSave=response.body();
                    if(responseUserSave!=null){
                        updateStatus.update(responseUserSave);
                    }
                }

            }

            @Override
            public void onFailure(Call<responseUserSave> call, Throwable t) {
                updateStatus.update(null);
            }
        });

    }

}
