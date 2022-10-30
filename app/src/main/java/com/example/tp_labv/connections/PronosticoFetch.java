package com.example.tp_labv.connections;

import android.os.Handler;

import com.example.tp_labv.HTTP.HTTPConnection;
import com.example.tp_labv.HTTP.HTTPExecute;
import com.example.tp_labv.models.Pronostico;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PronosticoFetch extends HTTPExecute<List<Pronostico>> {
    public PronosticoFetch(Handler handler, String url) {
        super(handler, url);
    }

    @Override
    public List<Pronostico> stringToObj(String json) throws JSONException {
        List<Pronostico> pronosticoList = new ArrayList<>();
        JSONObject object = new JSONObject(json);

        JSONArray forecastday = object.getJSONObject("forecast").getJSONArray("forecastday");

        for (int i = 0; i < forecastday.length(); i++) {
            Pronostico aux = new Pronostico();
            JSONObject day = forecastday.getJSONObject(i).getJSONObject("day");

            aux.setDate(forecastday.getJSONObject(i).getString("date"));
            aux.setTempAvg(day.getInt("avgtemp_c"));
            aux.setTempMax(day.getInt("maxtemp_c"));
            aux.setTempMin(day.getInt("mintemp_c"));
            aux.setIconUrl(HTTPConnection.LoadImageFromWebOperations("https:" + day.getJSONObject("condition").getString("icon")));

            pronosticoList.add(aux);
        }

        return pronosticoList;
    }
}
