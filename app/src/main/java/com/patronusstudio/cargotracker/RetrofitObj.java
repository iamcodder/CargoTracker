package com.patronusstudio.cargotracker;

import com.patronusstudio.cargotracker.model.default_model;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObj {

    private modelSend modelSend;

    RetrofitObj(modelSend modelSend){
        this.modelSend=modelSend;
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://iamcodder.com/retrofit/")
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

}
