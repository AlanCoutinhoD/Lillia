package com.upchiapas.lillia.controllers;

import com.upchiapas.lillia.Vivero;
import com.upchiapas.lillia.models.Archivo;
import com.upchiapas.lillia.models.Planta;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.*;
import java.util.ArrayList;

public class BusquedaController extends javax.swing.JFrame{
    Archivo objArchivo = new Archivo();
    ArrayList <Planta> ListaPlantas= new ArrayList<>();
    ArrayList <Planta> ListaPlantasB= new ArrayList<>();
    public BusquedaController(){
        ListaPlantas=objArchivo.leer();
        ListaPlantasB=objArchivo.leerB();
    }
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnModificar;
    @FXML
 private Button btnBuscar;
    @FXML
    private TextArea txtArBusqueda;
    @FXML
    private TextField txtNombre;

    @FXML

    public void btnBuscarOnMouseClicked(MouseEvent mouseEvent) {
        int indexA=0;
      int indexB=0;
      boolean statusG=false;
      boolean statusA=false;
      boolean statusB=false;
        txtArBusqueda.setText("");
        for (Planta planta:ListaPlantas) {
            if (planta.getNombre().matches(".*"+txtNombre.getText()+".*")){
                txtArBusqueda.appendText("     SECCION A\n");
                statusA = true;
                statusG = true;
                break;
            }
        }
        if (statusA==true){
        while (indexA < ListaPlantas.size()){
            if (ListaPlantas.get(indexA).getNombre().matches(".*"+txtNombre.getText()+".*")){
                txtArBusqueda.appendText("ID: "+ListaPlantas.get(indexA).getId() + ". "+ ListaPlantas.get(indexA).getNombre()+"    Cantidad:  "+ListaPlantas.get(indexA).getCantidad()+"\n");

            }
            indexA++;
        }
        }
        //Busqueda en seccion B
        for (Planta plantasB:ListaPlantasB) {
            if (plantasB.getNombre().matches(".*"+txtNombre.getText()+".*")){
                txtArBusqueda.appendText("     SECCION B\n");
                statusB =true;
                statusG =true;
                break;
            }

        }
        if (statusB==true){
            while (indexB < ListaPlantasB.size()){
                if (ListaPlantasB.get(indexB).getNombre().matches(".*"+txtNombre.getText()+".*")){
                    txtArBusqueda.appendText(ListaPlantasB.get(indexB).getId() + ". "+ ListaPlantasB.get(indexB).getNombre()+"    Cantidad:  "+ListaPlantasB.get(indexB).getCantidad()+"\n");
                }
                indexB++;
            }
if (statusG==false){
    JOptionPane.showMessageDialog(null,"NINGUN RESULTADO! Intente de nuevo...","AVISO!",JOptionPane.INFORMATION_MESSAGE);
}
        }

    }
    @FXML
    void btnModificarOnMouseClicked(MouseEvent event) {
        boolean status=false;
        String s;
        for (int i = 0; i < ListaPlantas.size(); i++) {
            if (txtNombre.getText().equals(ListaPlantas.get(i).getNombre())){
                status=true;
                int n = JOptionPane.showConfirmDialog(null, "Modificar nombre de "+ ListaPlantas.get(i).getNombre(), "Titulo del Diálogo", JOptionPane.YES_NO_OPTION);
                if (n==0){
                    s = JOptionPane.showInputDialog("Inserte nuevo nombre de " + ListaPlantas.get(i).getNombre()+" : ");
                    int c = Integer.parseInt(JOptionPane.showInputDialog("Inserte la cantidad nueva (anterior : "+ ListaPlantas.get(i).getCantidad()+") "));
                    ListaPlantas.get(i).setNombre(s);
                    ListaPlantas.get(i).setCantidad(c);
                    objArchivo.escribir(ListaPlantas);
                }
                else{

              s=ListaPlantas.get(i).getNombre();
                int c = Integer.parseInt(JOptionPane.showInputDialog("Inserte la cantidad nueva (anterior : "+ ListaPlantas.get(i).getCantidad()+") "));
               ListaPlantas.get(i).setCantidad(c);
                   objArchivo.escribir(ListaPlantas);
               }
                break;
            }
            if (status==true){
                JOptionPane.showMessageDialog(null,"NINGUN RESULTADO! Intente de nuevo...","AVISO!",JOptionPane.INFORMATION_MESSAGE);
            }


        }
    }
    @FXML
    void btnVolverOnMouseClicked(MouseEvent event) {
        Vivero.setFXML("inventario","INVENTARIO");
    }
}