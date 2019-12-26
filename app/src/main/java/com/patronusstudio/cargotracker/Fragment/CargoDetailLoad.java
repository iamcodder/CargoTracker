package com.patronusstudio.cargotracker.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.patronusstudio.cargotracker.Interface.modelSend;
import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.RetrofitObj;
import com.patronusstudio.cargotracker.model.cargoes;
import com.patronusstudio.cargotracker.model.responseUserSave;

public class CargoDetailLoad extends AppCompatActivity implements modelSend.updateStatus {

    private cargoes cargo;
    private RetrofitObj retrofitObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_detail_load);
        getData();
        init();
    }

    private void getData() {
        cargo = getIntent().getExtras().getParcelable("cargoes");
        getIntent().removeExtra("cargoes");
    }
    private void init(){
        retrofitObj=new RetrofitObj(this);
        retrofitObj.setStatus(cargo);
    }

    @Override
    public void update(@NonNull responseUserSave response) {
        if(response.getSuccess()){
            Toast.makeText(this,"Durum güncellendi",Toast.LENGTH_SHORT).show();
            finish();
        }
        else if(response==null){
            Toast.makeText(this,"Hata alındı",Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            Toast.makeText(this,"Hata alındı",Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
