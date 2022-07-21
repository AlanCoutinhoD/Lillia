package com.upchiapas.lillia.models;

public class Acuatica extends Planta{
    private  String tipo;

    public String getTipo() {
        return tipo;
    }

    public  Acuatica(int id, String nombre, String tipo, int cantidad){
        super(id, nombre, cantidad);
        this.tipo=tipo;
    }
    public String toString() {
        return "\n" + getId() + "       " + getNombre() + "       " + getTipo() + "       "+ getCantidad() ;
    }
}