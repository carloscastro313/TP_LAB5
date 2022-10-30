package com.example.tp_labv.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp_labv.HTTP.HTTPConnection;
import com.example.tp_labv.R;
import com.example.tp_labv.models.Pronostico;
import com.example.tp_labv.holders.PronosticoViewHolder;

import java.util.List;

public class PronosticoAdapter extends RecyclerView.Adapter<PronosticoViewHolder> {

    List<Pronostico> pronosticoList;
    Activity activity;

    public PronosticoAdapter(List<Pronostico> pronosticoList, Activity activity){
        this.pronosticoList = pronosticoList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PronosticoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pronostico,parent,false);
        return new PronosticoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PronosticoViewHolder holder, int position) {
        Pronostico p = this.pronosticoList.get(position);

        holder.setPronostico(p);

        TextView tvTempAvg = holder.itemView.findViewById(R.id.tvTempAvg);
        TextView tvDate = holder.itemView.findViewById(R.id.tvDate);
        TextView tvTempMin = holder.itemView.findViewById(R.id.tvTempMin);
        TextView tvTempMax = holder.itemView.findViewById(R.id.tvTempMax);
        ImageView imageView = holder.itemView.findViewById(R.id.iconClima);

        tvDate.setText(p.getDate());
        tvTempAvg.setText(p.getTempAvg().toString() + "°C");
        tvTempMax.setText(p.getTempMax().toString() + "°C");
        tvTempMin.setText(p.getTempMin().toString() + "°C");
        imageView.setImageDrawable(p.getIconUrl());
    }

    @Override
    public int getItemCount() {
        return this.pronosticoList.size();
    }
}
