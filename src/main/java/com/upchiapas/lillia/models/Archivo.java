package com.upchiapas.lillia.models;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Archivo {
    public void escribir(ArrayList<Planta>Plantas){
        PrintWriter salida= null;
        try {
            salida = new PrintWriter(new BufferedWriter(new FileWriter("ListaPlantasA.txt")));
            for (int i=0; i< Plantas.size(); i++){
                salida.println(Plantas.get(i).getNombre() + "-" + Plantas.get(i).getId()+ "-"+ Plantas.get(i).getCantidad());
            }
            salida.close();
        }catch (IOException ex){
            JOptionPane.showMessageDialog(null,"Error");
        } finally {
            salida.close();
        }
    }
    public  ArrayList<Planta> leer(){
        ArrayList<Planta> ListaPlantas = new ArrayList<>();
        try {
            BufferedReader entrada= new BufferedReader(new FileReader("ListaPlantasA.txt"));
            String s,s2 = new String();
            String nombre;
            int id;
            int cantidad;
            while ((s= entrada.readLine())!=null){
                s2+=s+ "\n";
                String[] information = s.split("-");
                nombre= information[0];
                id= Integer.parseInt(information[1]);
                cantidad= Integer.parseInt(information[2]);
                Planta objPlanta = new Planta(id,nombre,cantidad);
                ListaPlantas.add(objPlanta);

            }

            entrada.close();
        }catch (java.io.IOException e){
            JOptionPane.showMessageDialog(null,"Error Archivo");
        }
        return ListaPlantas;}

    public void escribirB(ArrayList<Planta>PlantasB){
        PrintWriter salida= null;
        try {
            salida = new PrintWriter(new BufferedWriter(new FileWriter("ListaPlantasB.txt")));
            for (int i=0; i< PlantasB.size(); i++){
                salida.println(PlantasB.get(i).getNombre() + "-" + PlantasB.get(i).getId()+ "-"+ PlantasB.get(i).getCantidad());
            }
            salida.close();
        }catch (IOException ex){
            JOptionPane.showMessageDialog(null,"Error");
        } finally {
            salida.close();
        }
    }
    public  ArrayList<Planta> leerB(){
        ArrayList<Planta> ListaPlantasB = new ArrayList<>();
        try {
            BufferedReader entrada= new BufferedReader(new FileReader("ListaPlantasB.txt"));
            String s,s2 = new String();
            String nombre;
            int id;
            int cantidad;
            while ((s= entrada.readLine())!=null){
                s2+=s+ "\n";
                String[] information = s.split("-");
                nombre= information[0];
                id= Integer.parseInt(information[1]);
                cantidad= Integer.parseInt(information[2]);
                Planta objPlanta = new Planta(id,nombre,cantidad);
                ListaPlantasB.add(objPlanta);

            }

            entrada.close();
        }catch (java.io.IOException e){
            JOptionPane.showMessageDialog(null,"Error Archivo");
        }
        return ListaPlantasB;}

    public  ArrayList<Horario> leerHorario(){
        ArrayList<Horario> ListaHorario = new ArrayList<Horario>();
        try {
            BufferedReader entrada= new BufferedReader(new FileReader("ListaHorario.txt"));
            String s,s2 = new String();
            String dia;
            int hora;
            int minutos;
            while ((s= entrada.readLine())!=null){
                s2+=s+ "\n";
                String[] information = s.split("-");
                dia= information[0];
                hora= Integer.parseInt(information[2]);
                minutos= Integer.parseInt(information[1]);
                Horario objHorario = new Horario(dia,minutos,hora);
                ListaHorario.add(objHorario);

            }

            entrada.close();
        }catch (java.io.IOException e){
            JOptionPane.showMessageDialog(null,"Error Archivo");
        }

        return ListaHorario;

    }
    public void escribirHorario(ArrayList<Horario>ListaHorario){
        PrintWriter salida= null;
        try {
            salida = new PrintWriter(new BufferedWriter(new FileWriter("ListaHorario.txt")));
            for (int i=0; i< ListaHorario.size(); i++){
                salida.println(ListaHorario.get(i).getDia() + "-" + ListaHorario.get(i).getMinutos()+ "-"+ ListaHorario.get(i).getHora());
            }
            salida.close();
        }catch (IOException ex){
            JOptionPane.showMessageDialog(null,"Error");
        } finally {
            salida.close();
        }
    }



}

