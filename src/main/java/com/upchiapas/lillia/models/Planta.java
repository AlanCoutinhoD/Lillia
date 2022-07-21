package com.upchiapas.lillia.models;

import java.util.ArrayList;

public class Planta {
   private  int id;
   private int cantidad;
    private String nombre;

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Planta> setCantidad(int cantidad) {
        this.cantidad = cantidad;
        return null;
    }

    public ArrayList<Planta> setNombre(String nombre) {
        this.nombre = nombre;
        return null;
    }



    public int getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }
    public Planta(int id, String nombre, int cantidad){
        this.id=id;
        this.nombre=nombre;
        this.cantidad=cantidad;

    }
    public String toString() {
        return "\n" + id + "       " + nombre + "       " + cantidad ;
    }
}
