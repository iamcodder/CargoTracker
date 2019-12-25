package com.patronusstudio.cargotracker.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.vipulasri.timelineview.TimelineView;
import com.patronusstudio.cargotracker.R;
import com.patronusstudio.cargotracker.model.cargoes_movement;

import java.util.List;

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.TimeLineViewHolder> {

    private List<cargoes_movement> list;

    public TimeLineAdapter(List<cargoes_movement> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position, getItemCount());
    }

    @NonNull
    @Override
    public TimeLineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_timeline, parent, false);

        return new TimeLineViewHolder(rootView, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeLineViewHolder holder, int position) {

        String yaz = "";
        String kontrol = list.get(position).getMovement();
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

        holder.txt_date.setText(list.get(position).getTime());
        holder.txt_title.setText(yaz);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class TimeLineViewHolder extends RecyclerView.ViewHolder {
        public TimelineView mTimelineView;
        private TextView txt_date, txt_title;

        public TimeLineViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);
            mTimelineView = itemView.findViewById(R.id.timeline);
            mTimelineView.initLine(viewType);

            txt_date = itemView.findViewById(R.id.timeline_date);
            txt_title = itemView.findViewById(R.id.timeline_title);
        }
    }
}
