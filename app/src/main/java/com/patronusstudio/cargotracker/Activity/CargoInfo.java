package com.patronusstudio.cargotracker.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.Recycler.InfoAdaptr;
import com.patronusstudio.cargotracker.model.cargoes;
import com.patronusstudio.cargotracker.model.outlet_center;
import com.patronusstudio.cargotracker.model.target_center;

import java.util.ArrayList;

public class CargoInfo extends AppCompatActivity {

    private cargoes cargoes;
    private target_center target_center;
    private outlet_center outlet_center;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_info);
        getData();
        function();
        recyclerSet();
    }

    private void getData(){
        cargoes=getIntent().getExtras().getParcelable("cargoes");
        outlet_center=getIntent().getExtras().getParcelable("outlet_center");
        target_center=getIntent().getExtras().getParcelable("target_center");

        getIntent().removeExtra("cargoes");
        getIntent().removeExtra("outlet_center");
        getIntent().removeExtra("target_center");
    }
    private void function(){
        list=new ArrayList<>();

        String getStatus=cargoes.getStatus();
        String status="";
        switch (getStatus) {
            case "1":
                status = "Hazırlanıyor";
                break;
            case "2":
                status = "Çıkış Şubesinde";
                break;
            case "3":
                status = "Varış Şubesinde";
                break;
            case "4":
                status = "Teslim Edildi";
                break;
            case "5":
                status = "Alıcıya Ulaşılamadı";
                break;
        }
        list.add("Takip No : "+cargoes.getTracking_number());
        list.add("Ücret : "+cargoes.getCost()+" TL");
        list.add("Ağırlık : "+cargoes.getWeight()+" Kg");
        list.add("Durum : "+status);
        list.add("Son Güncelleme : "+cargoes.getTime());
        list.add("Çıkış Yeri Adı: "+outlet_center.getName());
        list.add("Çıkış Yeri Adresi: "+outlet_center.getAddress());
        list.add("Hedef Yeri Adı: "+target_center.getName());
        list.add("Hedef Yeri Adresi: "+target_center.getAddress());


    }

    private void recyclerSet(){
        RecyclerView recyclerView=findViewById(R.id.cargo_info_recyc);
        InfoAdaptr adaptr=new InfoAdaptr(list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setAdapter(adaptr);
        recyclerView.setLayoutManager(layoutManager);
    }


}
