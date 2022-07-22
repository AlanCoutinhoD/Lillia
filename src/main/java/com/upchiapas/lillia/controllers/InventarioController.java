package com.upchiapas.lillia.controllers;
import com.upchiapas.lillia.Vivero;
import com.upchiapas.lillia.models.Acuatica;
import com.upchiapas.lillia.models.Archivo;
import com.upchiapas.lillia.models.Planta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class InventarioController extends javax.swing.JFrame {
    Archivo objArchivo = new Archivo();
    ArrayList<Planta> ListaPlantas = new ArrayList<>();
    ArrayList<Planta> ListaPlantasB = new ArrayList<>();
    ArrayList<Acuatica>ListaPlantasC=new ArrayList<>();

    public InventarioController() {
        ListaPlantas = objArchivo.leer();
        ListaPlantasB = objArchivo.leerB();
        ListaPlantasC= objArchivo.leerC();
        setLocationRelativeTo(null);
    }

    @FXML
    private Button btnAnadirAcuatica;
    @FXML
    private Text lblInventario;
    @FXML
    private Button btn_seccionA;
    @FXML
    private Button btn_seccionB;
    @FXML
    private Button btnAnadir;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btn_seccionC;

    @FXML
    private TextArea txtArPlantas;
    @FXML
    private Button btnSalir;
    @FXML
    void btnBuscarOnMouseClicked(MouseEvent event) {
        Vivero.setFXML("busqueda","Busqueda");

    }
    @FXML
    void btnSeccionCOnMouseClicked(MouseEvent event) {
        lblInventario.setText("INVENTARIO SECCION C");
        lblInventario.setVisible(true);
        Acuatica aux;
        for (int i = 0; i < ListaPlantasC.size() - 1; i++) {
            for (int j = 0; j < ListaPlantasC.size() - 1; j++) {
                if (ListaPlantasC.get(j).getId() > ListaPlantasC.get(j + 1).getId()) {
                    aux = ListaPlantasC.get(j);
                    ListaPlantasC.set(j, ListaPlantasC.get(j + 1));
                    ListaPlantasC.set(j + 1, aux);
                }
            }
        }
        String msj = "";
        txtArPlantas.setText("ID          Nombre       Tipo de agua");
        for (int i = 0; i < ListaPlantasC.size(); i++) {
            Planta planta = ListaPlantasC.get(i);
            msj += planta.toString();
        }
        txtArPlantas.appendText(msj);
        txtArPlantas.setWrapText(true);
        txtArPlantas.setEditable(false);
    }

        @FXML
    void btnAnadirOnMouseClicked(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(Vivero.class.getResource("anadirPlanta.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        AnadirPlantaController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        Planta p = controlador.getPlanta();
        int id = 1;
        if (controlador.getSeccion().equals("A")) {
            for (int i = 0; i < ListaPlantas.size(); i++) {
                if (ListaPlantas.get(i).getId() == id) {
                    System.out.println("Este id ya existe!");
                    id += 1;
                    i = -1;
                }

            }
            System.out.println("te meti" + id);
            p.setId(id);
            this.ListaPlantas.add(p);
            objArchivo.escribir(ListaPlantas);
        } else if (controlador.getSeccion().equals("B")) {
            for (int i = 0; i < ListaPlantasB.size(); i++) {
                if (ListaPlantasB.get(i).getId() == id) {
                    System.out.println("Este id ya existe!");
                    id += 1;
                    i = -1;
                }

            }
            System.out.println("te meti" + id);
            p.setId(id);
            this.ListaPlantasB.add(p);
            objArchivo.escribirB(ListaPlantasB);
        }
    }
    @FXML
    void btnAnadirAcuaticaOnMouseClicked(MouseEvent event) {
Vivero.setFXML("anadirPlantaAcuatica","AÑADIR PLANTA ACUATICA");
    }


    @FXML
    void btn_seccionBOnMouseClicked(MouseEvent event) {
        lblInventario.setText("INVENTARIO SECCION B");
        lblInventario.setVisible(true);
        Planta auxB;
        for (int i = 0; i < ListaPlantasB.size() - 1; i++) {
            for (int j = 0; j < ListaPlantasB.size() - 1; j++) {
                if (ListaPlantasB.get(j).getId() > ListaPlantasB.get(j + 1).getId()) {
                    auxB = ListaPlantasB.get(j);
                    ListaPlantasB.set(j, ListaPlantasB.get(j + 1));
                    ListaPlantasB.set(j + 1, auxB);
                }
            }
        }
        /////////
        String msj = "";
        txtArPlantas.setText("ID          Nombre       Cantidad");
        for (int i = 0; i < ListaPlantasB.size(); i++) {
            Planta planta = ListaPlantasB.get(i);
            msj += planta.toString();
        }
        txtArPlantas.appendText(msj);
        txtArPlantas.setWrapText(true);
        txtArPlantas.setEditable(false);
    }

    @FXML
    void btn_seccionAOnMouseClicked(MouseEvent event) {
        lblInventario.setText("INVENTARIO SECCION A");
        lblInventario.setVisible(true);
        Planta aux;
        for (int i = 0; i < ListaPlantas.size() - 1; i++) {
            for (int j = 0; j < ListaPlantas.size() - 1; j++) {
                if (ListaPlantas.get(j).getId() > ListaPlantas.get(j + 1).getId()) {
                    aux = ListaPlantas.get(j);
                    ListaPlantas.set(j, ListaPlantas.get(j + 1));
                    ListaPlantas.set(j + 1, aux);
                }
            }
        }
        String msj = "";
        txtArPlantas.setText("ID          Nombre       Cantidad");
        for (int i = 0; i < ListaPlantas.size(); i++) {
            Planta planta = ListaPlantas.get(i);
            msj += planta.toString();
        }
        txtArPlantas.appendText(msj);
        txtArPlantas.setWrapText(true);
        txtArPlantas.setEditable(false);
    }
    @FXML
    void btnSalirOnMouseClicked(MouseEvent event) {
        Vivero.setFXML("lillia-home", "Home");
    }
}






