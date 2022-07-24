package com.upchiapas.lillia.controllers;
import com.upchiapas.lillia.Vivero;
import com.upchiapas.lillia.models.Acuatica;
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
    ArrayList <Planta> ListaPlantas;
    ArrayList <Planta> ListaPlantasB;
    ArrayList<Acuatica> ListaPlantasC;
    public BusquedaController(){
        ListaPlantas=objArchivo.leer();
        ListaPlantasB=objArchivo.leerB();
        ListaPlantasC=objArchivo.leerC();
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
        int indexC=0;
      boolean statusG=false;
      boolean statusA = false;
      boolean statusB = false;
      boolean statusC = false;
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

            }
            for (Acuatica plantasC:ListaPlantasC) {
                if (plantasC.getNombre().matches(".*"+txtNombre.getText()+".*")){
                    txtArBusqueda.appendText("     SECCION C\n");
                    statusG =true;
                    statusC =true;
                    break;
                }
            }
            if (statusC==true){
                while (indexC < ListaPlantasC.size()){
                    if (ListaPlantasC.get(indexC).getNombre().matches(".*"+txtNombre.getText()+".*")){
                        txtArBusqueda.appendText("ID: "+ListaPlantasC.get(indexC).getId() + ". "+ ListaPlantasC.get(indexC).getNombre()+"    Tipo:  "+ListaPlantasC.get(indexC).getTipo()+"    Cantidad:  "+ListaPlantasC.get(indexC).getCantidad()+"\n");
                    }
                    indexC++;
                }
            }
if (!statusG){
    JOptionPane.showMessageDialog(null,"NINGUN RESULTADO! Intente de nuevo...","AVISO!",JOptionPane.INFORMATION_MESSAGE);
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
                if (ListaPlantas.get(i).getCantidad()==0){

                    ListaPlantas.remove(i);
                    objArchivo.escribir(ListaPlantas);
                }
                break;

            }
            }
        for (int i = 0; i < ListaPlantasB.size(); i++) {
            if (txtNombre.getText().equals(ListaPlantasB.get(i).getNombre())){
                status=true;
                int n = JOptionPane.showConfirmDialog(null, "Modificar nombre de "+ ListaPlantasB.get(i).getNombre(), "Titulo del Diálogo", JOptionPane.YES_NO_OPTION);
                if (n==0) {
                    boolean nombre;
                    do {
                        nombre=false;
                        s = JOptionPane.showInputDialog("Inserte nuevo nombre de " + ListaPlantasB.get(i).getNombre() + " : ");
                        for (int k = 0; k < ListaPlantasB.size(); k++) {
                            if (s.equals(ListaPlantasB.get(i).getNombre())){
                                JOptionPane.showMessageDialog(null,"ESTA PLANTA YA EXISTE! EN LA SECCION B.","AVISO!",JOptionPane.INFORMATION_MESSAGE);
                                nombre=true;
                                break;
                            }

                        }
                        for (int k = 0; k < ListaPlantas.size(); k++) {
                            if (s.equals(ListaPlantas.get(i).getNombre())){
                                JOptionPane.showMessageDialog(null,"ESTA PLANTA YA EXISTE! EN LA SECCION A.","AVISO!",JOptionPane.INFORMATION_MESSAGE);
                                nombre=true;
                                break;
                            }

                        }
                        for (int k = 0; k < ListaPlantasC.size(); k++) {
                            if (s.equals(ListaPlantasC.get(i).getNombre())){
                                JOptionPane.showMessageDialog(null,"ESTA PLANTA YA EXISTE! EN LA SECCION C.","AVISO!",JOptionPane.INFORMATION_MESSAGE);
                                nombre=true;
                                break;
                            }

                        }
                    } while (nombre);

                    int c = Integer.parseInt(JOptionPane.showInputDialog("Inserte la cantidad nueva (anterior : " + ListaPlantasB.get(i).getCantidad() + ") "));
                    ListaPlantasB.get(i).setNombre(s);
                    ListaPlantasB.get(i).setCantidad(c);
                    objArchivo.escribirB(ListaPlantasB);

                }

                else{
                    s=ListaPlantasB.get(i).getNombre();
                    int c = Integer.parseInt(JOptionPane.showInputDialog("Inserte la cantidad nueva (anterior : "+ ListaPlantasB.get(i).getCantidad()+") "));
                    ListaPlantasB.get(i).setCantidad(c);
                    objArchivo.escribirB(ListaPlantasB);
                }
                if (ListaPlantasB.get(i).getCantidad()==0){
                    ListaPlantasB.remove(i);
                    objArchivo.escribirB(ListaPlantasB);
                }
                break;
            }

        }
        for (int i = 0; i < ListaPlantasC.size(); i++) {
            if (txtNombre.getText().equals(ListaPlantasC.get(i).getNombre())){
                status=true;
                int n = JOptionPane.showConfirmDialog(null, "Modificar nombre de "+ ListaPlantasC.get(i).getNombre(), "Titulo del Diálogo", JOptionPane.YES_NO_OPTION);
                if (n==0){
                    s = JOptionPane.showInputDialog("Inserte nuevo nombre de " + ListaPlantasC.get(i).getNombre()+" : ");
                    int c = Integer.parseInt(JOptionPane.showInputDialog("Inserte la cantidad nueva (anterior : "+ ListaPlantasC.get(i).getCantidad()+") "));
                    ListaPlantasC.get(i).setNombre(s);
                    ListaPlantasC.get(i).setCantidad(c);
                    objArchivo.escribirC(ListaPlantasC);
                }

                else{
                    s=ListaPlantasC.get(i).getNombre();
                    int c = Integer.parseInt(JOptionPane.showInputDialog("Inserte la cantidad nueva (anterior : "+ ListaPlantasC.get(i).getCantidad()+") "));
                    ListaPlantasC.get(i).setCantidad(c);
                    objArchivo.escribirC(ListaPlantasC);
                }
                if (ListaPlantasC.get(i).getCantidad()==0){

                    ListaPlantasC.remove(i);
                    objArchivo.escribirC(ListaPlantasC);
                }
                break;

            }
        }

        if (!status){
            JOptionPane.showMessageDialog(null,"NINGUN RESULTADO! Intente de nuevo...","AVISO!",JOptionPane.INFORMATION_MESSAGE);
        }
        }

    @FXML
    void btnVolverOnMouseClicked(MouseEvent event) {
        Vivero.setFXML("inventario","INVENTARIO");
    }
}