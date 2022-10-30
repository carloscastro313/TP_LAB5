package com.example.tp_labv.holders;

import android.app.Activity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp_labv.models.Pronostico;

public class PronosticoViewHolder extends RecyclerView.ViewHolder {

    Pronostico pronostico;

    public PronosticoViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void setPronostico(Pronostico pronostico) { this.pronostico = pronostico;}
}
