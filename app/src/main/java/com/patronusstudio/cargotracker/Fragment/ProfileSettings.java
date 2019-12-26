package com.patronusstudio.cargotracker.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.model.personnel;

public class ProfileSettings extends Fragment {

    private View rootView;
    private AppCompatEditText edx_email,edx_sifre,edx_adres;
    private AppCompatTextView txt_tc,txt_isim;
    private Button mButton;
    personnel user;

    public ProfileSettings(@NonNull personnel user) {
        this.user = user;
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_profile_settings,container,false);

        init();
        clicked();
        setData();

        return rootView;
    }

    private void clicked(){
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user.setAddress(edx_adres.getText().toString());
                user.setPassword(edx_sifre.getText().toString());
                user.setEmail(edx_email.getText().toString());
                Intent intent=new Intent(v.getContext(), ProfileLoad.class);
                intent.putExtra("personel",user);
                v.getContext().startActivity(intent);

            }
        });
    }

    private void init(){
        edx_adres=rootView.findViewById(R.id.profile_edx_address);
        edx_sifre=rootView.findViewById(R.id.profile_edx_password);
        edx_email=rootView.findViewById(R.id.profile_edx_email);
        mButton=rootView.findViewById(R.id.profile_btn_kaydet);
        txt_isim=rootView.findViewById(R.id.profile_txt_nameSurname);
        txt_tc=rootView.findViewById(R.id.profile_txt_tc);
    }

    private void setData(){
        edx_adres.setText(user.getAddress());
        edx_sifre.setText(user.getPassword());
        edx_email.setText(user.getEmail());
        txt_isim.setText(user.getName()+" "+user.getSurname());
        txt_tc.setText(user.getTc());
    }

}
