package com.patronusstudio.cargotracker.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.patronusstudio.cargotracker.R;

public class Exit extends Fragment {

    private View rootView;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_exit,container,false);



        return rootView;
    }



}
