package com.patronusstudio.cargotracker.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.patronusstudio.cargotracker.R;


public class MainActivity extends AppCompatActivity  {

    private String[] tracking = {"Kargo Numarası", "79442698394", "67236086392", "60106553560"};
    private EditText edx;
    private Button button,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        edx=findViewById(R.id.edx_tracking_number);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), LoadCargoActivity.class);
                intent.putExtra("tracking_number",edx.getText().toString());
                startActivity(intent);
                Animatoo.animateFade(v.getContext());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),UserLoginActivity.class));
                Animatoo.animateFade(v.getContext());
            }
        });

    }


}
