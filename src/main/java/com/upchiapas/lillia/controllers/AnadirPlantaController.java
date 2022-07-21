package com.upchiapas.lillia.controllers;
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
private String seccion;

    public String getSeccion() {
        return seccion;
    }
Archivo archivo= new Archivo();
    ArrayList<Planta> Listaplantas=new ArrayList<>();
     ArrayList<Planta> ListaplantasB;
public void initAttributes(ArrayList<Planta> Listaplantas,ArrayList<Planta>ListaplantasB){
    this.Listaplantas=Listaplantas;
    this.ListaplantasB=ListaplantasB;
}
public AnadirPlantaController(){
    this.Listaplantas=archivo.leer();
    this.ListaplantasB=archivo.leerB();
}
    @FXML
    private Button btnAnadir;

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
        String nombre = this.txtNombre.getText();
        int status= 0;
        int id= 1;
        int cantidad= Integer.parseInt(this.txtCantidad.getText());
       seccion= txtSeccion.getText();
        for (int i = 0; i < Listaplantas.size(); i++) {
            if (txtNombre.getText().equals(Listaplantas.get(i).getNombre())){
                System.out.println(status);
                status=1;
                JOptionPane.showMessageDialog(null,"ESTA PLANTA YA EXISTE! EN LA SECCION A.","AVISO!",JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
        System.out.println("Aqui voy al B y sigo en "+status);
        if (status == 0){
            for (int i = 0; i < ListaplantasB.size(); i++) {
                if (txtNombre.getText().equals(ListaplantasB.get(i).getNombre())){
                    JOptionPane.showMessageDialog(null,"ESTA PLANTA YA EXISTE! EN LA SECCION B.","AVISO!",JOptionPane.INFORMATION_MESSAGE);
                    status=1;
                    break;
                }
                else System.out.println("no encontre xd" );
            }
        }
        System.out.println("Aqui voy al añadir y sigo en "+status);
        if (status==0){
            System.out.println("entre aca tambien");
            if (txtSeccion.getText().equals("A") || txtSeccion.getText().equals("B")){
                JOptionPane.showMessageDialog(null,"PLANTA AÑADIDA CORRECTAMENTE.","AVISO!",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Te añadi jejeje");
                Planta p = new Planta(id,nombre,cantidad);
                this.planta=p;
                Stage stage = (Stage) this.btnAnadir.getScene().getWindow();
                stage.close();

            }
            else {
                JOptionPane.showMessageDialog(null,"SECCION NO RECONOCIDA","AVISO!",JOptionPane.INFORMATION_MESSAGE);
            }
        }


    }

    public Planta getPlanta() {
        return planta;
    }

    @FXML
    void btnSalirOnMouseClicked(MouseEvent event) {
   //   this.planta=null;
        Stage stage = (Stage) this.btnAnadir.getScene().getWindow();
        stage.close();

    }

}
