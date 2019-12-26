package com.patronusstudio.cargotracker.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.patronusstudio.cargotracker.Interface.fragAct;
import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.Recycler.FragmentCargoesAdapter;
import com.patronusstudio.cargotracker.model.cargoes;

import java.util.ArrayList;
import java.util.List;

public class FragmentCargoes extends Fragment implements fragAct {

    private View rootView;
    private RecyclerView recyclerView;
    private List<cargoes> list;

    public FragmentCargoes(@NonNull List<cargoes> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_cargoes,container,false);
        setRecycler();


        return rootView;
    }

    private void setRecycler(){
        recyclerView=rootView.findViewById(R.id.fragment_cargoes_recyc);
        FragmentCargoesAdapter adapter=new FragmentCargoesAdapter(list,this);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }


    @Override
    public void sendClickedCardInfo(@NonNull cargoes cargoes) {
        Intent intent =new Intent(getContext(),CargoDetail.class);
        intent.putExtra("cargoes",cargoes);
        startActivity(intent);
        Animatoo.animateZoom(getContext());
    }
}
