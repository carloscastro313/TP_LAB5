package com.example.tp_labv.connections;

import android.os.Handler;

import com.example.tp_labv.HTTP.HTTPExecute;
import com.example.tp_labv.models.TiempoActual;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class TiempoActualFetch extends HTTPExecute<TiempoActual> {

    public TiempoActualFetch(Handler handler, String url){
        super(handler,url);
    }

    @Override
    public TiempoActual stringToObj(String json) throws JSONException {
        TiempoActual tiempoActual = new TiempoActual();
        JSONObject object = new JSONObject(json);

        JSONObject location = object.getJSONObject("location");
        JSONObject current = object.getJSONObject("current");
        JSONObject day = object.getJSONObject("forecast").getJSONArray("forecastday").getJSONObject(0).getJSONObject("day");
        JSONObject condicion = current.getJSONObject("condition");

        tiempoActual.setTemperaturaActual(current.getInt("temp_c"));
        tiempoActual.setCiudad(location.getString("name"));
        tiempoActual.setPais(location.getString("country"));
        tiempoActual.setSensacionTermica(current.getInt("feelslike_c"));
        tiempoActual.setHumedad(current.getInt("humidity"));
        tiempoActual.setPrecipitacion(current.getDouble("precip_mm"));
        tiempoActual.setVelocidadViento(current.getDouble("wind_mph"));
        tiempoActual.setTemperaturaPromedio(day.getInt("avgtemp_c"));
        tiempoActual.setTemperaturaMaxima(day.getInt("maxtemp_c"));
        tiempoActual.setTemperaturaMinima(day.getInt("mintemp_c"));
        tiempoActual.setTemperaturaMinima(day.getInt("mintemp_c"));
        tiempoActual.setCode(condicion.getInt("code"));
        tiempoActual.setIsDay(current.getInt("is_day"));

        return tiempoActual;
    }
}
