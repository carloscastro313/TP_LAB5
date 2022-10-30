package com.example.tp_labv.models;

public class TiempoActual {
    private Integer temperaturaActual;
    private String pais;
    private String ciudad;
    private Integer sensacionTermica;
    private Integer humedad;
    private Double precipitacion;
    private Double velocidadViento;
    private Integer temperaturaMaxima;
    private Integer temperaturaMinima;
    private Integer temperaturaPromedio;
    private Integer code;
    private Integer isDay;

    public TiempoActual() { }

    public TiempoActual(Integer temperaturaActual, String pais, String ciudad) {
        this.temperaturaActual = temperaturaActual;
        this.pais = pais;
        this.ciudad = ciudad;
    }

    public Integer getTemperaturaActual() {
        return temperaturaActual;
    }

    public void setTemperaturaActual(Integer temperaturaActual) {
        this.temperaturaActual = temperaturaActual;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getSensacionTermica() {
        return sensacionTermica;
    }

    public void setSensacionTermica(Integer sensacionTermica) {
        this.sensacionTermica = sensacionTermica;
    }

    public Integer getHumedad() {
        return humedad;
    }

    public void setHumedad(Integer humedad) {
        this.humedad = humedad;
    }

    public Double getPrecipitacion() {
        return precipitacion;
    }

    public void setPrecipitacion(Double precipitacion) {
        this.precipitacion = precipitacion;
    }

    public Double getVelocidadViento() {
        return velocidadViento;
    }

    public void setVelocidadViento(Double velocidadViento) {
        this.velocidadViento = velocidadViento;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(Integer temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public Integer getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(Integer temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public Integer getTemperaturaPromedio() {
        return temperaturaPromedio;
    }

    public void setTemperaturaPromedio(Integer temperaturaPromedio) {
        this.temperaturaPromedio = temperaturaPromedio;
    }

    public Integer getIsDay() {
        return isDay;
    }

    public void setIsDay(Integer isDay) {
        this.isDay = isDay;
    }
}
