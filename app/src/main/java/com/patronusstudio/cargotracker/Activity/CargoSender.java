package com.patronusstudio.cargotracker.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.Recycler.InfoAdaptr;
import com.patronusstudio.cargotracker.model.cargoes;

import java.util.ArrayList;

public class CargoSender extends AppCompatActivity {

    cargoes cargoes;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_sender);
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
        list.add("Tc : "+cargoes.getSender_tc());
        list.add("Adı : "+cargoes.getSender_name());
        list.add("Soyadı : "+cargoes.getSender_surname());
        list.add("Telefon Numarası : "+cargoes.getSender_phone());
        list.add("Adresi "+cargoes.getSender_address());
    }

    private void recyclerSet(){
        RecyclerView recyclerView=findViewById(R.id.cargo_sender_recyc);
        InfoAdaptr adaptr=new InfoAdaptr(list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adaptr);
    }

}
