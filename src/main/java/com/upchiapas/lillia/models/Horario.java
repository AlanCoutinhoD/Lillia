package com.upchiapas.lillia.models;

import java.util.ArrayList;

public class Horario {

private String dia;
    public int getMinutos() {
        return minutos;
    }

    private String HoraD;
private int minutos;
    public int getHora() {
        return hora;
    }

    public int getAño() {
        return año;
    }

    public String getDia() {
        return dia;
    }

    private int hora;
   private int año;



    public ArrayList<Horario> setMinuto(int minuto) {
        this.minutos=minuto;
        return null;
    }



    public Horario(String dia, int minutos, int hora) {
        this.dia= dia;
        this.minutos = minutos;
        this.hora = hora;

    }


    public ArrayList<Horario> setHora(int hora) {
    this.hora=hora;
    return null;
    }
    public ArrayList<Horario> setMinutos(int hora) {
        this.minutos=minutos;
        return null;
    }
}
