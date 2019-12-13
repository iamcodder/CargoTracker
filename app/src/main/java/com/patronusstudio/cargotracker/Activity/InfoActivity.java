package com.patronusstudio.cargotracker.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.Recycler.Adapter;
import com.patronusstudio.cargotracker.model.cargoes;
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

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        control();
    }

    private void control() {
        int value = getIntent().getExtras().getInt("value");
        list=new ArrayList<>();
        if (value == 1) {
            cargoes cargo = getIntent().getExtras().getParcelable("cargoes");
            list.add("Tracking Number : "+cargo.getTracking_number());
            list.add("Weight : "+cargo.getWeight());
            list.add("Status : "+cargo.getStat());
            list.add("Cost : "+cargo.getCost());
            recycSet();
        }
        else if(value==2){
            sender_address obj_sender_address= getIntent().getExtras().getParcelable("sender_address");
            sender_info obj_sender_info=getIntent().getExtras().getParcelable("sender_info");
            list.add("Name : "+obj_sender_info.getName());
            list.add("Surname : "+obj_sender_info.getSurname());
            list.add("Phone : +90"+obj_sender_info.getPhone());
            list.add("Tc : "+obj_sender_info.getTc().charAt(0)+obj_sender_info.getTc().charAt(1)+"*******"+obj_sender_info.getTc().charAt(9)+obj_sender_info.getTc().charAt(10));
            list.add("Neighborhood : "+obj_sender_address.getNeighborhood());
            list.add("Street : "+obj_sender_address.getStreet());
            list.add("District : "+obj_sender_address.getDistrict());
            list.add("City : "+obj_sender_address.getCity());
            recycSet();
        }
        else if(value==3){
            receiver_address obj_rec_adr=getIntent().getExtras().getParcelable("receiver_address");
            receiver_info obj_rec_inf=getIntent().getExtras().getParcelable("receiver_info");
            list.add("Name : "+obj_rec_inf.getName());
            list.add("Surname : "+obj_rec_inf.getSurname());
            list.add("Phone : +90"+obj_rec_inf.getPhone());
            list.add("Tc : "+obj_rec_inf.getTc().charAt(0)+obj_rec_inf.getTc().charAt(1)+"*******"+obj_rec_inf.getTc().charAt(9)+obj_rec_inf.getTc().charAt(10));
            list.add("Neighborhood : "+obj_rec_adr.getNeighborhood());
            list.add("Street : "+obj_rec_adr.getStreet());
            list.add("District : "+obj_rec_adr.getDistrict());
            list.add("City : "+obj_rec_adr.getCity());
            recycSet();
        }
        else if(value==4){
            outlet_adress obj_out_add=getIntent().getExtras().getParcelable("outlet_address");
            outlet_center obj_out_cen=getIntent().getExtras().getParcelable("outlet_center"); //null
            outlet_cargoes_info obj_out_car=getIntent().getExtras().getParcelable("outlet_cargo");
            list.add("Cargo Branch Name : "+obj_out_car.getName()+" "+obj_out_cen.getName());
            list.add("Cargo Branch Phone : "+obj_out_car.getName()+" "+obj_out_cen.getPhone());
            list.add("Working Hours : "+obj_out_car.getWorking_hours());

            list.add("Neighborhood : "+obj_out_add.getNeighborhood());
            list.add("Street : "+obj_out_add.getStreet());
            list.add("District : "+obj_out_add.getDistrict());
            list.add("City : "+obj_out_add.getCity());

            recycSet();
        }

        else if(value==5){
            target_address obj_tar_add=getIntent().getExtras().getParcelable("target_address");
            target_center obj_tar_cen=getIntent().getExtras().getParcelable("target_center");
            target_cargoes_info obj_tar_car=getIntent().getExtras().getParcelable("target_cargo");

            list.add("Cargo Branch Name : "+obj_tar_car.getName()+" "+obj_tar_cen.getName());
            list.add("Cargo Branch Phone : "+obj_tar_car.getName()+" "+obj_tar_cen.getPhone());
            list.add("Working Hours : "+obj_tar_car.getWorking_hours());

            list.add("Neighborhood : "+obj_tar_add.getNeighborhood());
            list.add("Street : "+obj_tar_add.getStreet());
            list.add("District : "+obj_tar_add.getDistrict());
            list.add("City : "+obj_tar_add.getCity());

            recycSet();
        }
    }

    private void recycSet(){
        recyclerView=findViewById(R.id.recycler);
        Adapter adapter=new Adapter(list);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
