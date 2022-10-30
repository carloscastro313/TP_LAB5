package com.example.tp_labv.models;

import android.graphics.drawable.Drawable;

public class Pronostico {
    private String date;
    private Integer tempAvg;
    private Integer tempMax;
    private Integer tempMin;
    private Drawable iconUrl;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTempAvg() {
        return tempAvg;
    }

    public void setTempAvg(Integer tempAvg) {
        this.tempAvg = tempAvg;
    }

    public Drawable getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(Drawable iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Integer getTempMax() {
        return tempMax;
    }

    public void setTempMax(Integer tempMax) {
        this.tempMax = tempMax;
    }

    public Integer getTempMin() {
        return tempMin;
    }

    public void setTempMin(Integer tempMin) {
        this.tempMin = tempMin;
    }
}
