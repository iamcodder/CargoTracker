package com.patronusstudio.cargotracker.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.model.personnel;

public class UserHome extends AppCompatActivity {

    private personnel personel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

    }

    private void getData(){
        personel=getIntent().getExtras().getParcelable("personnel");
        getIntent().removeExtra("personnel");
    }

}
