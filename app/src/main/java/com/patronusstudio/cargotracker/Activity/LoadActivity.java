package com.patronusstudio.cargotracker.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.patronusstudio.cargotracker.Interface.modelSend;
import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.RetrofitObj;
import com.patronusstudio.cargotracker.model.default_model;

import java.util.ArrayList;

public class LoadActivity extends AppCompatActivity implements modelSend {

    private RetrofitObj retrofitObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        retrofitObj = new RetrofitObj(this);

        Intent intent=getIntent();
        String str_track=intent.getExtras().getString("tracking_number");

        if(str_track!=null && !str_track.isEmpty()){
            retrofitObj.getDta(str_track);
        }



    }


    @Override
    public void send(@NonNull default_model model) {

        if(model.getReceiver_info()!=null){
            Intent nIntent=new Intent(this,CargoDetailed.class);
            nIntent.putExtra("cargoes",model.getCargoes());
            nIntent.putExtra("outlet_adress",model.getOutlet_adress());
            nIntent.putExtra("outlet_cargoes_info",model.getOutlet_cargoes_info());
            nIntent.putExtra("outlet_center",model.getOutlet_center());
            nIntent.putExtra("receiver_address",model.getReceiver_address());
            nIntent.putExtra("receiver_info",model.getReceiver_info());
            nIntent.putExtra("sender_address",model.getSender_address());
            nIntent.putExtra("sender_info",model.getSender_info());
            nIntent.putExtra("target_address",model.getTarget_address());
            nIntent.putExtra("target_cargoes_info",model.getTarget_cargoes_info());
            nIntent.putExtra("target_center",model.getTarget_center());

            startActivity(nIntent);
            finish();
        }
        else{
            Toast.makeText(this,"Kargo bilgisi bulunamadı",Toast.LENGTH_SHORT).show();
            finish();
        }

    }

    @Override
    public void onBackPressed() {
    }
}