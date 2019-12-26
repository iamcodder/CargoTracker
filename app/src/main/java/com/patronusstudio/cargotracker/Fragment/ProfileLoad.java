package com.patronusstudio.cargotracker.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.patronusstudio.cargotracker.Interface.modelSend;
import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.RetrofitObj;
import com.patronusstudio.cargotracker.model.personnel;

public class ProfileLoad extends AppCompatActivity implements modelSend.savePersonel{

    personnel user;
    RetrofitObj retrofitObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile_load);

        getData();
        init();

    }

    private void getData(){
        user=getIntent().getExtras().getParcelable("personel");
        getIntent().removeExtra("personel");

    }

    private void init(){
        retrofitObj=new RetrofitObj(this);
        retrofitObj.setUser(user);
    }

    @Override
    public void isStatus(boolean isSuccess, String message) {

        if(isSuccess){
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
            finish();
        }

    }
}
