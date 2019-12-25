package com.patronusstudio.cargotracker.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.model.cargoes;
import com.patronusstudio.cargotracker.model.cargoes_movement;
import com.patronusstudio.cargotracker.model.outlet_center;
import com.patronusstudio.cargotracker.model.target_center;

import java.util.ArrayList;

public class CargoMain extends AppCompatActivity {

    ArrayList<cargoes_movement> list;
    private target_center target_center;
    private outlet_center outlet_center;
    cargoes cargoes;

    private ImageView img_gonderici,img_alici,img_kargo,img_son_durum;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_main);
        getData();
        init();
        clicked();


    }

    private void getData() {
        cargoes = getIntent().getExtras().getParcelable("cargoes");
        outlet_center = getIntent().getExtras().getParcelable("outlet_center");
        target_center = getIntent().getExtras().getParcelable("target_center");
        list = getIntent().getExtras().getParcelableArrayList("cargoes_movement");

        getIntent().removeExtra("cargoes");
        getIntent().removeExtra("outlet_center");
        getIntent().removeExtra("target_center");
        getIntent().removeExtra("cargoes_movement");
    }

    private void init(){
        img_alici=findViewById(R.id.img_alici_bilglieri);
        img_gonderici=findViewById(R.id.img_gonderen_bilgileri);
        img_kargo=findViewById(R.id.img_kargo_bilgileri);
        img_son_durum=findViewById(R.id.img_kargo_durumu);

    }

    private void clicked(){
        img_alici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(v.getContext(),CargoReceiver.class);
                intent.putExtra("cargoes",cargoes);
                startActivity(intent);
            }
        });
        img_gonderici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(v.getContext(),CargoSender.class);
                intent.putExtra("cargoes",cargoes);
                startActivity(intent);
            }
        });
        img_kargo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(v.getContext(),CargoInfo.class);
                intent.putExtra("cargoes",cargoes);
                intent.putExtra("outlet_center",outlet_center);
                intent.putExtra("target_center",target_center);
                startActivity(intent);
            }
        });
        img_son_durum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(v.getContext(),CargoTimeline.class);
                intent.putParcelableArrayListExtra("cargoes_movement",list);
                startActivity(intent);
            }
        });
    }
}
