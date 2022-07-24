package com.upchiapas.lillia.controllers;
import com.upchiapas.lillia.Vivero;
import com.upchiapas.lillia.models.Acuatica;
import com.upchiapas.lillia.models.Archivo;
import com.upchiapas.lillia.models.Planta;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.*;
import java.util.ArrayList;

public class AnadirPlantaAcuaticaController {
    private Acuatica acuatica;
    ArrayList<Planta> ListaPlantasA;
    ArrayList<Planta> ListaPlantasB;
    ArrayList<Acuatica> ListaPlantasC;
    Archivo archivo= new Archivo();
    public AnadirPlantaAcuaticaController(){
        ListaPlantasC=archivo.leerC();
        ListaPlantasA=archivo.leer();
        ListaPlantasB=archivo.leerB();
    }
    @FXML
    private Button btnAnadir;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTipo;

    @FXML
    void btnAnadirOnMouseClicked(MouseEvent event) {
        String nombre = this.txtNombre.getText();
        System.out.println(nombre);
        String tipo= this.txtTipo.getText();
        boolean status=false;
        int id=1;
        int cantidad= Integer.parseInt(this.txtCantidad.getText());
        Acuatica c=new Acuatica(id,nombre,tipo,cantidad);
        this.acuatica=c;
        if (txtNombre.getText().isEmpty()||txtTipo.getText().isEmpty()||txtCantidad.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"NO PUEDE DEJAR NINGUN CUADRO VACIO VERIFIQUE NUEVAMENTE","AVISO!",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            if (cantidad<=0){
                JOptionPane.showMessageDialog(null,"NO PUEDE INSERTAR UN NUMERO MENOR A 0","AVISO!",JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                for (int i = 0; i < ListaPlantasA.size(); i++) {
                    if (txtNombre.getText().equals(ListaPlantasA.get(i).getNombre())){
                        System.out.println(status);
                        status=true;
                        JOptionPane.showMessageDialog(null,"ESTA PLANTA YA EXISTE! EN LA SECCION A.","AVISO!",JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }
                if (status == false){
                    for (int i = 0; i < ListaPlantasB.size(); i++) {
                        if (txtNombre.getText().equals(ListaPlantasB.get(i).getNombre())){
                            JOptionPane.showMessageDialog(null,"ESTA PLANTA YA EXISTE! EN LA SECCION B.","AVISO!",JOptionPane.INFORMATION_MESSAGE);
                            status=true;
                            break;
                        }

                    }
                }
        for (int i = 0; i <ListaPlantasC.size() ; i++) {
            if (ListaPlantasC.get(i).getNombre().equals(nombre)){
                JOptionPane.showMessageDialog(null,"ESTA PLANTA YA EXISTE EN ESTA SECCION");
            status=true;
                break;
            }
        }

        if (status==false){
            for (int i = 0; i < ListaPlantasC.size(); i++) {
                if (ListaPlantasC.get(i).getId() == id) {
                    id += 1;
                    i = -1;
                }

            }
            c.setId(id);
        JOptionPane.showMessageDialog(null,"PLANTA AÑADIDA CORRECTAMENTE.","AVISO!", JOptionPane.INFORMATION_MESSAGE);
        this.ListaPlantasC.add(c);
        archivo.escribirC(ListaPlantasC);
            Vivero.setFXML("inventario","INVENTARIO");
        }
                }
            }
        }

    @FXML
    void btnCancelarOnMouseClicked(MouseEvent event) {
Vivero.setFXML("inventario","INVENTARIO");
    }

            }