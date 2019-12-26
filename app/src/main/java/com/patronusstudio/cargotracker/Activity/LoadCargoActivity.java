package com.patronusstudio.cargotracker.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import com.patronusstudio.cargotracker.Interface.modelSend;
import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.RetrofitObj;
import com.patronusstudio.cargotracker.model.default_model;

import java.util.ArrayList;

public class LoadCargoActivity extends AppCompatActivity implements modelSend.send {

    private RetrofitObj retrofitObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_cargo);

        retrofitObj = new RetrofitObj(this);

        Intent intent=getIntent();
        String str_track=intent.getExtras().getString("tracking_number");

        if(str_track!=null && !str_track.isEmpty()){
            retrofitObj.getDta(str_track);
        }



    }

    @Override
    public void send(@NonNull default_model model) {
        if(model.getCargoes()!=null){
            Intent nIntent=new Intent(this, CargoMain.class);
            nIntent.putExtra("cargoes",model.getCargoes());
            nIntent.putExtra("outlet_center",model.getOutlet_center());
            nIntent.putExtra("target_center",model.getTarget_center());
            nIntent.putParcelableArrayListExtra("cargoes_movement", (ArrayList<? extends Parcelable>) model.getCargoes_movements());

            startActivity(nIntent);
            finish();
        }
        else{
            Toast.makeText(this,"Kargo bilgisi bulunamadı",Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void errorMessage(String message) {
        Toast.makeText(this,"Kargo bilgisi bulunamadı",Toast.LENGTH_SHORT).show();
        finish();
    }



}
