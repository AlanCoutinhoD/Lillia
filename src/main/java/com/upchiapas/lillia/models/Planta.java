package com.upchiapas.lillia.models;
public class Planta {
   private  int id;
   private int cantidad;
    private String nombre;

    public void setId(int id) {
        this.id = id;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    //Metodo para poder imprimir en el text area
    public String toString() {
        return "\n" + id + "       " + nombre + "       " + cantidad ;
    }
}
