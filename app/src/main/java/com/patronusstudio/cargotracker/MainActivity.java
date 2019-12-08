package com.patronusstudio.cargotracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.patronusstudio.cargotracker.model.default_model;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener,modelSend{

    private String[] tracking={"Kargo Numarası","79442698394","67236086392","60106553560"};
    private EditText edx;
    private Button button;
    private Spinner spinner;
    private ProgressBar progressBar;
    private RetrofitObj retrofitObj;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        position=0;
        edx=findViewById(R.id.editText3);
        button=findViewById(R.id.button);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        spinner=findViewById(R.id.spinner2);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,tracking);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

        retrofitObj=new RetrofitObj(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==1){
                    retrofitObj.getDta(edx.getText().toString());
                    progressBar.setVisibility(View.VISIBLE);
                }
                else if(position==2){
                    retrofitObj.getDta(edx.getText().toString());
                    progressBar.setVisibility(View.VISIBLE);

                }
                else if(position==3){
                    retrofitObj.getDta(edx.getText().toString());
                    progressBar.setVisibility(View.VISIBLE);

                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(position==1){
            edx.setText(tracking[position]);
            this.position=1;
        }
        else if(position==2){
            edx.setText(tracking[position]);
            this.position=2;
        }
        else if(position==3){
            edx.setText(tracking[position]);
            this.position=3;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void send(default_model model) {
        progressBar.setVisibility(View.INVISIBLE);

        String write=
        "\nSender Name : "+model.getSender_info().getName()+"\n"+
        "Sender Phone : "+model.getSender_info().getPhone()+"\n"+
        "Receiver Name : "+model.getReceiver_info().getName()+"\n"+
        "Receiver Phone : "+model.getReceiver_info().getPhone()+"\n"+
        "Status : "+model.getCargoes().getStat()+"\n"+
        "Cost : "+model.getCargoes().getCost()+"\n"+
        "Target Name :"+model.getTarget_center().getName()+"\n"+
        "Receiver Name :"+model.getOutlet_center().getName()+"\n"+
                "Cargo Info :"+model.getTarget_cargoes_info().getName();

        Log.d("Odev-- Durumu",write);

    }
}
