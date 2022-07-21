package com.upchiapas.lillia.controllers;

import com.upchiapas.lillia.Vivero;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class HomeController {

    @FXML
    private Button btn_horario;

    @FXML
    private Button btn_inventario;

    @FXML
    private Button btn_salir;

    @FXML
    void btn_horarioOnMouseClicked(MouseEvent event) {
Vivero.setFXML("horarioRiego","Horario De Riego");
    }

    @FXML
    void btn_inventarioOnMouseClicked(MouseEvent event) {
        Vivero.setFXML("inventario","Inventario De Plantas");
    }

    @FXML
    void btn_salirOnMouseClicked(MouseEvent event) {
System.exit(1);
    }

}
