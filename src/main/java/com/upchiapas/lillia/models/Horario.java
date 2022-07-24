package com.upchiapas.lillia.models;
public class Horario {
private final String dia;
    private int hora;
    public int getMinutos() {
        return minutos;
    }
private int minutos;
    public int getHora() {
        return hora;
    }

    public String getDia() {
        return dia;
    }

    public void setMinuto(int minuto) {
        this.minutos=minuto;
    }
    public void setHora(int hora) {
        this.hora=hora;
    }

    public Horario(String dia, int minutos, int hora) {
        this.dia= dia;
        this.minutos = minutos;
        this.hora = hora;

    }

}
