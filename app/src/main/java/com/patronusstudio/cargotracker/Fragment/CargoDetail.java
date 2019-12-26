package com.patronusstudio.cargotracker.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.model.cargoes;

import org.angmarch.views.NiceSpinner;
import org.angmarch.views.OnSpinnerItemSelectedListener;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CargoDetail extends AppCompatActivity {

    private cargoes cargoe;
    private AppCompatTextView g_tc,g_ad,g_tel,g_adres,a_tc,a_ad,a_adres,a_tel,k_agirlik,k_ucret,k_durum,k_takipno;
    private Button mButton;
    private NiceSpinner niceSpinner;
    private String durum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_detail);
        init();
        setData();
        clicked();
    }

    private void clicked(){

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cargoe.setStatus(durum);
                Intent intent =new Intent(v.getContext(),CargoDetailLoad.class);
                intent.putExtra("cargoes",cargoe);
                startActivity(intent);

                Animatoo.animateZoom(v.getContext());

                k_durum.setText("Durum : "+sonuc(cargoe.getStatus()));

            }
        });

        niceSpinner.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
            @Override
            public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
                durum=position+"";
            }
        });

    }

    private void init(){
        durum="";

        cargoe=getIntent().getExtras().getParcelable("cargoes");
        getIntent().removeExtra("cargoes");

        g_tc=findViewById(R.id.cargo_sender_tc);
        g_ad=findViewById(R.id.cargo_sender_ad);
        g_tel=findViewById(R.id.cargo_sender_telNo);
        g_adres=findViewById(R.id.cargo_sender_adress);

        a_tc=findViewById(R.id.cargo_receiver_tc);
        a_ad=findViewById(R.id.cargo_receiver_ad);
        a_tel=findViewById(R.id.cargo_receiver_telNo);
        a_adres=findViewById(R.id.cargo_receiver_adress);

        k_agirlik=findViewById(R.id.cargo_cargo_weight);
        k_ucret=findViewById(R.id.cargo_cargo_cost);
        k_durum=findViewById(R.id.cargo_cargo_status);
        k_takipno=findViewById(R.id.cargo_cargo_track);

        mButton=findViewById(R.id.detail_btn);

        niceSpinner = findViewById(R.id.nice_spinner);
        List<String> dataset = new LinkedList<>(Arrays.asList("Kargo Durumu","Hazırlanıyor", "Çıkış Şubesinde", "Varış Şubesinde", "Teslim Edildi", "Alıcıya Ulaşılamadı"));
        niceSpinner.attachDataSource(dataset);
    }

    private void setData(){
        g_tc.setText("TC No : "+cargoe.getSender_tc());
        g_ad.setText("Ad Soyad : "+cargoe.getSender_name()+" "+cargoe.getSender_surname());
        g_tel.setText("Tel No : "+cargoe.getSender_phone());
        g_adres.setText("Adress : "+cargoe.getSender_address());

        a_tc.setText("TC No : "+cargoe.getReceiver_tc());
        a_ad.setText("Ad Soyad : "+cargoe.getReceiver_name()+" "+cargoe.getReceiver_surname());
        a_tel.setText("Tel No : "+cargoe.getReceiver_phone());
        a_adres.setText("Adress : "+cargoe.getReceiver_address());

        k_agirlik.setText("Ağırlık : "+cargoe.getWeight()+" Kg");
        k_ucret.setText("Ücret : "+cargoe.getCost()+" TL");
        k_takipno.setText("TNo : "+cargoe.getTracking_number());


        k_durum.setText("Durum : "+sonuc(cargoe.getStatus()));

    }

    private String sonuc(String id){
        String yaz = "";
        String kontrol = cargoe.getStatus();
        switch (kontrol) {
            case "1":
                yaz = "Hazırlanıyor";
                break;
            case "2":
                yaz = "Çıkış Şubesinde";
                break;
            case "3":
                yaz = "Varış Şubesinde";
                break;
            case "4":
                yaz = "Teslim Edildi";
                break;
            case "5":
                yaz = "Alıcıya Ulaşılamadı";
                break;
        }
        return yaz;
    }

}
