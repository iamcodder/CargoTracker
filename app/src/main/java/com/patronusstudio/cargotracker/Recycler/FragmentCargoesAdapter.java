package com.patronusstudio.cargotracker.Recycler;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.patronusstudio.cargotracker.Interface.fragAct;
import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.model.cargoes;

import java.util.List;

public class FragmentCargoesAdapter extends RecyclerView.Adapter<FragmentCargoesAdapter.viewHolder> {

    private List<cargoes> list;
    private fragAct fragAct;

    public FragmentCargoesAdapter(List<cargoes> list,fragAct fragAct) {
        this.list = list;
        this.fragAct=fragAct;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new viewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {

        holder.takip_numarası.setText("TNO : "+list.get(position).getTracking_number());
        holder.alıcı_ad_soyad.setText("Alıcı Adresi: "+list.get(position).getReceiver_name() + " " + list.get(position).getReceiver_surname());
        holder.alıcı_adresi.setText("Alıcı : "+list.get(position).getReceiver_address());

        String pos = list.get(position).getStatus();
        String status = "";
        switch (pos) {
            case "1":
                status = "Hazırlanıyor";
                break;
            case "2":
                status = "Çıkış Şubesinde";
                break;
            case "3":
                status = "Varış Şubesinde";
                break;
            case "4":
                status = "Teslim Edildi";
                break;
            case "5":
                status = "Alıcıya Ulaşılamadı";
                break;
        }
        holder.kargo_durumu.setText(status);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragAct.sendClickedCardInfo(list.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView takip_numarası, alıcı_adresi, alıcı_ad_soyad, kargo_durumu;
        CardView cardView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            takip_numarası = itemView.findViewById(R.id.recyc_takip_numarası);
            alıcı_adresi = itemView.findViewById(R.id.recyc_ad_soyaad);
            alıcı_ad_soyad = itemView.findViewById(R.id.recyc_adres);
            kargo_durumu = itemView.findViewById(R.id.recyc_kargo);
            cardView = itemView.findViewById(R.id.cardview);

        }
    }
}
