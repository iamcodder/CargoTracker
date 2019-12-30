package com.patronusstudio.cargotracker.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.patronusstudio.cargotracker.Interface.modelSend;
import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.RetrofitObj;
import com.patronusstudio.cargotracker.model.cargoes;
import com.patronusstudio.cargotracker.model.personnel;

import java.util.ArrayList;
import java.util.List;

public class UserLoginActivity extends AppCompatActivity implements modelSend.sendUser {

    EditText edx_email, edx_password;
    private Button mButton;
    LottieAnimationView lottieAnimationView;
    RetrofitObj retrofitObj;
    private List<cargoes> list;
    private int sayac;
    private personnel user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        init();
        clicked();
    }

    private void init() {
        edx_email = findViewById(R.id.edx_user_login_email);
        edx_password = findViewById(R.id.edx_user_login_password);
        mButton = findViewById(R.id.btn_user_login);
        lottieAnimationView = findViewById(R.id.user_login_loading);
        retrofitObj = new RetrofitObj(this);

        list = new ArrayList<>();
        sayac = 0;
    }

    private void clicked() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str_email = edx_email.getText().toString();
                String str_password = edx_password.getText().toString();

                if (!str_email.isEmpty() && !str_password.isEmpty()) {
                    lottieAnimationView.setVisibility(View.VISIBLE);
                    lottieAnimationView.playAnimation();
                    retrofitObj.getUser(str_email, str_password);
                    retrofitObj.getAllCargoes();
                } else {
                    Toast.makeText(v.getContext(), "Email veya şifre hatalı", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void sendUser(@NonNull personnel personnel) {
        user = personnel;
        sayac++;
        kontrolEt();

    }

    @Override
    public void errorMessage(@NonNull String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        lottieAnimationView.pauseAnimation();
        lottieAnimationView.setVisibility(View.GONE);
    }

    @Override
    public void sendList(@NonNull List<cargoes> liste) {
        this.list = liste;
        sayac++;
        kontrolEt();
    }

    private void kontrolEt() {

        if(user.getActive()==0){
            Toast.makeText(this,"Lütfen mailinizdn onaylayın",Toast.LENGTH_SHORT).show();
            lottieAnimationView.pauseAnimation();
            lottieAnimationView.setVisibility(View.GONE);
        }

        else if (sayac == 2 && user.getActive()==1) {
            sayac = 0;
            lottieAnimationView.pauseAnimation();
            lottieAnimationView.setVisibility(View.GONE);

            if (user != null) {
                Intent intent = new Intent(this, UserHome.class);
                intent.putExtra("personnel", user);
                intent.putParcelableArrayListExtra("list", (ArrayList<? extends Parcelable>) list);

                Log.d("Sülo2",list.size()+"");

                startActivity(intent);
                Animatoo.animateFade(this);
            } else {
                Toast.makeText(this, "Veri çekerken hata", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
