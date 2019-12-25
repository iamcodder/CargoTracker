package com.patronusstudio.cargotracker.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.patronusstudio.cargotracker.R;

import java.util.List;

public class InfoAdaptr extends RecyclerView.Adapter<InfoAdaptr.viewHolder>{

    private List<String> list;

    public InfoAdaptr(@NonNull List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_text,parent,false);

        return new viewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.txt_info.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        TextView txt_info;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            txt_info=itemView.findViewById(R.id.recyler_txt);
        }
    }
}
