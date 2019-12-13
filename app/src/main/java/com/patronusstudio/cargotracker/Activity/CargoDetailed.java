package com.patronusstudio.cargotracker.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.model.cargoes;
import com.patronusstudio.cargotracker.model.default_model;
import com.patronusstudio.cargotracker.model.outlet_adress;
import com.patronusstudio.cargotracker.model.outlet_cargoes_info;
import com.patronusstudio.cargotracker.model.outlet_center;
import com.patronusstudio.cargotracker.model.receiver_address;
import com.patronusstudio.cargotracker.model.receiver_info;
import com.patronusstudio.cargotracker.model.sender_address;
import com.patronusstudio.cargotracker.model.sender_info;
import com.patronusstudio.cargotracker.model.target_address;
import com.patronusstudio.cargotracker.model.target_cargoes_info;
import com.patronusstudio.cargotracker.model.target_center;
import com.ramotion.foldingcell.FoldingCell;

import java.util.List;

public class CargoDetailed extends AppCompatActivity {

    private cargoes obj_cargoes;
    private outlet_adress obj_outlet_adress;
    private outlet_cargoes_info obj_outlet_cargoes_info;
    private outlet_center obj_outlet_center;
    private receiver_address obj_receiver_adress;
    private receiver_info obj_receiver_info;
    private sender_address obj_sender_adress;
    private sender_info obj_sender_info;
    private target_address obj_target_address;
    private target_cargoes_info obj_target_cargoes_info;
    private target_center obj_target_center;

    private ImageView img_cargo_info,img_sender_info,img_receiver_info,img_outlet_info,
    img_target_info,img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_detailed);
        getPassedData();
        init();
        clicked();


    }

    private void init(){

        img_cargo_info=findViewById(R.id.img_cargo_box);
        img_sender_info=findViewById(R.id.img_sender_info);
        img_receiver_info=findViewById(R.id.img_receiver_info);
        img_outlet_info=findViewById(R.id.img_outlet_center);
        img_target_info=findViewById(R.id.img_target_center);
        img_back=findViewById(R.id.img_back);

    }

    private void clicked(){

        img_cargo_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),InfoActivity.class);
                intent.putExtra("value",1);
                intent.putExtra("cargoes",obj_cargoes);
                startActivity(intent);
            }
        });

        img_sender_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),InfoActivity.class);
                intent.putExtra("value",2);
                intent.putExtra("sender_address",obj_sender_adress);
                intent.putExtra("sender_info",obj_sender_info);
                startActivity(intent);
            }
        });

        img_receiver_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),InfoActivity.class);
                intent.putExtra("value",3);
                intent.putExtra("receiver_address",obj_receiver_adress);
                intent.putExtra("receiver_info",obj_receiver_info);
                startActivity(intent);
            }
        });

        img_outlet_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),InfoActivity.class);
                intent.putExtra("value",4);
                intent.putExtra("outlet_address",obj_outlet_adress);
                intent.putExtra("outlet_center",obj_outlet_center);
                intent.putExtra("outlet_cargo",obj_outlet_cargoes_info);
                startActivity(intent);
            }
        });

        img_target_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),InfoActivity.class);
                intent.putExtra("value",5);
                intent.putExtra("target_address",obj_target_address);
                intent.putExtra("target_center",obj_target_center);
                intent.putExtra("target_cargo",obj_target_cargoes_info);
                startActivity(intent);
            }
        });

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }




    private void getPassedData(){

        obj_cargoes=getIntent().getExtras().getParcelable("cargoes");
        obj_outlet_adress=getIntent().getExtras().getParcelable("outlet_adress");
        obj_outlet_cargoes_info=getIntent().getExtras().getParcelable("outlet_cargoes_info");
        obj_outlet_center=getIntent().getExtras().getParcelable("outlet_center");
        obj_receiver_adress=getIntent().getExtras().getParcelable("receiver_address");
        obj_receiver_info=getIntent().getExtras().getParcelable("receiver_info");
        obj_sender_adress=getIntent().getExtras().getParcelable("sender_address");
        obj_sender_info=getIntent().getExtras().getParcelable("sender_info");
        obj_target_address=getIntent().getExtras().getParcelable("target_address");
        obj_target_cargoes_info=getIntent().getExtras().getParcelable("target_cargoes_info");
        obj_target_center=getIntent().getExtras().getParcelable("target_center");

    }
}
