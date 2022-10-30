package com.example.tp_labv.views;

import android.app.Activity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tp_labv.R;
import com.example.tp_labv.controllers.TiempoActualController;
import com.example.tp_labv.models.TiempoActual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TiempoActualView {

    public Activity activity;
    TextView paisCiudad;
    TextView temperaturaActual;
    TextView sensacionTermica;
    TextView temperaturaPromedio;
    TextView temperaturaMaxima;
    TextView temperaturaMinima;
    TextView humedad;
    TextView precipitacion;
    TextView velocidadViento;
    Button btnPronostico;
    LinearLayout bgTiempoActual;
    TiempoActualController tiempoActualController;
    TiempoActual tiempoActual;

    public TiempoActualView(TiempoActual tiempoActual, Activity activity, TiempoActualController tiempoActualController){
        this.tiempoActualController = tiempoActualController;
        this.tiempoActual = tiempoActual;

        this.activity = activity;

        paisCiudad = this.activity.findViewById(R.id.paisCiudad);
        temperaturaActual = this.activity.findViewById(R.id.temperaturaActual);
        sensacionTermica = this.activity.findViewById(R.id.sensacionTermica);
        temperaturaPromedio = this.activity.findViewById(R.id.tvPromedio);
        temperaturaMaxima = this.activity.findViewById(R.id.tvMaxima);
        temperaturaMinima = this.activity.findViewById(R.id.tvMinima);
        humedad = this.activity.findViewById(R.id.tvHumedad);
        precipitacion = this.activity.findViewById(R.id.tvPrecipitacion);
        velocidadViento = this.activity.findViewById(R.id.tvViento);
        bgTiempoActual = this.activity.findViewById(R.id.bgTiempoActual);
        btnPronostico = this.activity.findViewById(R.id.btnPronostico);

        btnPronostico.setOnClickListener(this.tiempoActualController);
    }

    public void setModel(){
        paisCiudad.setText(tiempoActual.getCiudad() + ", " + tiempoActual.getPais());
        temperaturaActual.setText(tiempoActual.getTemperaturaActual() + "°C");
        sensacionTermica.setText(tiempoActual.getSensacionTermica() + "°C");
        temperaturaPromedio.setText(tiempoActual.getTemperaturaPromedio()+ "°C");
        temperaturaMaxima.setText(tiempoActual.getTemperaturaMaxima() + "°C");
        temperaturaMinima.setText(tiempoActual.getTemperaturaMinima() + "°C");
        humedad.setText(tiempoActual.getHumedad() + " %");
        precipitacion.setText(tiempoActual.getPrecipitacion().toString() + "mm");
        velocidadViento.setText(tiempoActual.getVelocidadViento() + " km/h");
        setBg(tiempoActual.getCode(),tiempoActual.getIsDay());
    }

    private void setBg(int code, int isDay){
        List<Integer> arrClear = new ArrayList<>(Arrays.asList(1000, 1003));
        List<Integer> arrRain = new ArrayList<>(Arrays.asList(1006, 1009, 1030, 1063, 1087, 1135, 1150, 1153, 1180, 1183, 1186, 1189,
                1192, 1195, 1240, 1243, 1246, 1279, 1276));
        List<Integer> arrShow = new ArrayList<>(Arrays.asList(1066, 1069, 1072, 1114, 1117, 1135, 1168, 1171, 1198, 1201, 1204, 1207,
                1210, 1216, 1219, 1222, 1225, 1237, 1249, 1252, 1255, 1258, 1261, 1264,
                1279, 1282));
        int id = R.color.white;
        if(arrClear.contains(code)){
            if(isDay == 1)
                id = R.color.soleado;
            else
                id = R.color.despejado;
        }else if(arrRain.contains(code)){
            id = R.color.lluvioso;
        }else if (arrShow.contains(code)){
            if(isDay == 1)
                id = R.color.nieveDia;
            else
                id = R.color.nieveNoche;
        }

        bgTiempoActual.setBackgroundColor(this.activity.getResources().getColor(id));
    }
}
