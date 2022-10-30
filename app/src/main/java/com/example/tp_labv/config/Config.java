package com.example.tp_labv.config;

public class Config {
    private static String key = "c3856336ee914b9ba07192801211001";
    private static String URL = "http://api.weatherapi.com/v1/forecast.json";

    public static String getURL(String busqueda){
        return URL + "?key=" + key + "&q=" + busqueda + "&aqi=no&lang=es";
    }

    public static String getURL(double lat, double lon,int days){
        return URL + "?key=" + key + "&q=" + lat + "," + lon + "&days="+ days +"&aqi=no&lang=es";
    }
}
