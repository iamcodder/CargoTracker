package com.patronusstudio.cargotracker.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.Recycler.Adapter;
import com.patronusstudio.cargotracker.model.cargoes;
import com.patronusstudio.cargotracker.model.cargoes_movement;
import com.patronusstudio.cargotracker.model.outlet_center;
import com.patronusstudio.cargotracker.model.target_center;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CargoDetailed extends AppCompatActivity {

    private ArrayList<cargoes_movement> list;
    private target_center target_center;
    private outlet_center outlet_center;
    private cargoes cargoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_detailed);

        getData();
        sortList();
        recyclerSet();
    }


    private void sortList(){
        Collections.sort(list, new Comparator<cargoes_movement>() {
            @Override
            public int compare(cargoes_movement o1, cargoes_movement o2) {
                String date1=o1.getTime();
                String date2=o2.getTime();
                return date1.compareTo(date2);
            }
        });
        Collections.reverse(list);
    }

    private void recyclerSet(){
        RecyclerView timelineView=findViewById(R.id.timeline);

        Adapter adapter=new Adapter(list);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);

        timelineView.setLayoutManager(layoutManager);
        timelineView.setAdapter(adapter);
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


}
