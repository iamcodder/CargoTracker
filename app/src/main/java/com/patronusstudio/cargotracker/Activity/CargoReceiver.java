package com.patronusstudio.cargotracker.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.Recycler.InfoAdaptr;
import com.patronusstudio.cargotracker.model.cargoes;

import java.util.ArrayList;

public class CargoReceiver extends AppCompatActivity {
    com.patronusstudio.cargotracker.model.cargoes cargoes;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_receiver);
        getData();
        function();
        recyclerSet();
    }

    private void getData(){

        cargoes=getIntent().getExtras().getParcelable("cargoes");
        getIntent().removeExtra("cargoes");

    }

    private void function(){
        list=new ArrayList<>();
        list.add("Tc : "+cargoes.getReceiver_tc());
        list.add("Adı : "+cargoes.getReceiver_name());
        list.add("Soyadı : "+cargoes.getReceiver_surname());
        list.add("Telefon Numarası : "+cargoes.getReceiver_phone());
        list.add("Adresi "+cargoes.getReceiver_address());
    }

    private void recyclerSet(){
        RecyclerView recyclerView=findViewById(R.id.cargo_receiver_recy);
        InfoAdaptr adaptr=new InfoAdaptr(list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adaptr);
    }

}
