package com.patronusstudio.cargotracker.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.patronusstudio.cargotracker.Interface.modelSend;
import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.RetrofitObj;
import com.patronusstudio.cargotracker.model.personnel;

public class UserLoginActivity extends AppCompatActivity implements modelSend.sendUser
{

    EditText edx_email,edx_password;
    private Button mButton;
    LottieAnimationView lottieAnimationView;
    RetrofitObj retrofitObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        init();
        clicked();
    }

    private void init(){
        edx_email=findViewById(R.id.edx_user_login_email);
        edx_password=findViewById(R.id.edx_user_login_password);
        mButton=findViewById(R.id.btn_user_login);
        lottieAnimationView=findViewById(R.id.user_login_loading);
        retrofitObj=new RetrofitObj(this);
    }

    private void clicked(){
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_email=edx_email.getText().toString();
                String str_password=edx_password.getText().toString();

                if(!str_email.isEmpty() && !str_password.isEmpty()){
                    lottieAnimationView.setVisibility(View.VISIBLE);
                    lottieAnimationView.playAnimation();
                    retrofitObj.getUser(str_email,str_password);
                }
                else {
                    Toast.makeText(v.getContext(),"Email veya şifre hatalı",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void sendUser(personnel personnel) {

        lottieAnimationView.setVisibility(View.GONE);
        lottieAnimationView.pauseAnimation();

        if(personnel !=null){
            Intent intent =new Intent(this,UserHome.class);
            intent.putExtra("personnel", personnel);
            startActivity(intent);
            Animatoo.animateFade(this);
        }
        else{
            Toast.makeText(this,"Veri çekerken hata",Toast.LENGTH_SHORT).show();
        }
    }
}
