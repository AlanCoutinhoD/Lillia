package com.upchiapas.lillia.controllers;
import com.upchiapas.lillia.Vivero;
import com.upchiapas.lillia.models.Acuatica;
import com.upchiapas.lillia.models.Archivo;
import com.upchiapas.lillia.models.Planta;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;


public class AnadirPlantaController {

    Archivo archivo= new Archivo();
    ArrayList<Planta> Listaplantas;
    ArrayList<Acuatica> ListaplantasC;
    ArrayList<Planta> ListaplantasB;
    public void initAttributes(ArrayList<Planta> Listaplantas, ArrayList<Planta>ListaplantasB, ArrayList<Acuatica>ListaplantasC){
        this.Listaplantas=Listaplantas;
        this.ListaplantasB=ListaplantasB;
        this.ListaplantasC=ListaplantasC;
    }
    public AnadirPlantaController(){
        this.Listaplantas=archivo.leer();
        this.ListaplantasB=archivo.leerB();
        this.ListaplantasC=archivo.leerC();
    }
    @FXML
    private Button btnAnadir;
    @FXML
    private Button btnAnadirAcuatica;

    @FXML
    private TextField txtTipo;

    @FXML
    private Button btnSalir;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtNombre;
    private Planta planta;
    @FXML
    private TextField txtSeccion;
    @FXML
    void btnAnadirOnMouseClicked(MouseEvent event) {
        String seccion;
        String nombre = this.txtNombre.getText();
        int status= 0;
        int id= 1;

        if (txtNombre.getText().isEmpty()||txtSeccion.getText().isEmpty()||txtCantidad.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"NO PUEDE DEJAR NINGUN CUADRO VACIO VERIFIQUE NUEVAMENTE","AVISO!",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            int cantidad= Integer.parseInt(this.txtCantidad.getText());
            if (cantidad<=0){
                JOptionPane.showMessageDialog(null,"NO PUEDE INSERTAR UN NUMERO MENOR A 0","AVISO!",JOptionPane.INFORMATION_MESSAGE);
            }
            else {

            seccion= txtSeccion.getText();
        for (int i = 0; i < Listaplantas.size(); i++) {
            if (txtNombre.getText().equals(Listaplantas.get(i).getNombre())){
                System.out.println(status);
                status=1;
                JOptionPane.showMessageDialog(null,"ESTA PLANTA YA EXISTE! EN LA SECCION A.","AVISO!",JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
        if (status == 0){
            for (int i = 0; i < ListaplantasB.size(); i++) {
                if (txtNombre.getText().equals(ListaplantasB.get(i).getNombre())){
                    JOptionPane.showMessageDialog(null,"ESTA PLANTA YA EXISTE! EN LA SECCION B.","AVISO!",JOptionPane.INFORMATION_MESSAGE);
                    status=1;
                    break;
                }

            }
        }
        if (status==0){
            if (txtSeccion.getText().equals("A") || txtSeccion.getText().equals("B")){
                JOptionPane.showMessageDialog(null,"PLANTA AÑADIDA CORRECTAMENTE.","AVISO!",JOptionPane.INFORMATION_MESSAGE);
                status=2;
            }
            else {
                JOptionPane.showMessageDialog(null,"SECCION NO RECONOCIDA","AVISO!",JOptionPane.INFORMATION_MESSAGE);
            }
            if(status==2){

                if (txtSeccion.getText().equals("A")) {
                    for (int i = 0; i < Listaplantas.size(); i++) {
                        if (Listaplantas.get(i).getId() == id) {
                            // aqui le digo que el id ya existe y le sumo uno al id para checar con otro valor
                            // y a la posicion i le resto uno para volver a verificar esa posicion
                            id += 1;
                            i = -1;
                        }
                    }
                    // se inserta el id si encontro un valor no repetido
                   Listaplantas.add(new Planta(id,nombre,cantidad));
                    archivo.escribir(Listaplantas);
                    Vivero.setFXML("inventario","INVENTARIO DE PLANTAS");
                } else if (txtSeccion.getText().equals("B")) {
                    for (int i = 0; i < ListaplantasB.size(); i++) {
                        if (ListaplantasB.get(i).getId() == id) {
                            id += 1;
                            i = -1;
                        }

                    }
                    ListaplantasB.add(new Planta(id,nombre,cantidad));
                    archivo.escribirB(ListaplantasB);
                    Vivero.setFXML("inventario","INVENTARIO DE PLANTAS");
                }
            }
        }
        }
        }
    }
    @FXML
    void btnSalirOnMouseClicked(MouseEvent event) {
        Stage stage = (Stage) this.btnAnadir.getScene().getWindow();
        stage.close();

    }


}

