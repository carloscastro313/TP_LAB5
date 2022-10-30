package com.example.tp_labv.controllers;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.tp_labv.Pronostico;
import com.example.tp_labv.models.TiempoActual;
import com.example.tp_labv.views.TiempoActualView;

public class TiempoActualController implements View.OnClickListener {

    TiempoActualView tiempoActualView;
    TiempoActual tiempoActual;

    public TiempoActualController(TiempoActual tiempoActual) { this.tiempoActual = tiempoActual; }

    public void setTiempoActualView (TiempoActualView tiempoActualView) { this.tiempoActualView = tiempoActualView; }
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this.tiempoActualView.activity, Pronostico.class);

        this.tiempoActualView.activity.startActivity(intent);
    }
}
