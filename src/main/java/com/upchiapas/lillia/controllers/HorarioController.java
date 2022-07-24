package com.upchiapas.lillia.controllers;
import com.upchiapas.lillia.Vivero;
import com.upchiapas.lillia.models.Archivo;
import com.upchiapas.lillia.models.Horario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javax.swing.*;
import java.util.ArrayList;
public class HorarioController  extends javax.swing.JFrame {
    Archivo objArchivo = new Archivo();

    ArrayList<Horario> ListaHorario ;
    public HorarioController(){
        ListaHorario=objArchivo.leerHorario();
        setLocationRelativeTo(null);
    }
    @FXML
    private Button btnSalir;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextArea txtArHorarios;

    @FXML
    void btnModificarOnMouseClicked(MouseEvent event) {
boolean validacion=false;
int hora = -1;
int minutos = -1;
        String dia= JOptionPane.showInputDialog("INSERTE EL DIA QUE DESEA MODIFICAR ");
if (dia.equals("Lunes")|dia.equals("Martes")|dia.equals("Miercoles")|dia.equals("Jueves")|dia.equals("Viernes")|dia.equals("Sabado")|dia.equals("Domingo")){
    for (int i = 0; i <ListaHorario.size() ; i++) {
        if (dia.equals(ListaHorario.get(i).getDia())){
            do {
         hora = Integer.parseInt(JOptionPane.showInputDialog(" INSERTE LA HORA EN FORMATO DE 24 HORAS "));
         if (hora>24|hora<0){
             JOptionPane.showMessageDialog(null,"ERROR VERIFIQUE LOS FORMATOS DE 24 HORAS");
         }
         else{
         minutos= Integer.parseInt(JOptionPane.showInputDialog("INSERTE LOS MINUTOS MAX 59"));
                    if (minutos>59|minutos<0){
                        JOptionPane.showMessageDialog(null,"ERROR VERIFIQUE EL FORMMATO DE MINUTOS");
                    }
                    else validacion=true;
             }
                } while (!validacion);



         ListaHorario.get(i).setHora(hora);
         ListaHorario.get(i).setMinuto(minutos);
         objArchivo.escribirHorario(ListaHorario);
        }
    }
    JOptionPane.showMessageDialog(null," EL DIA SE A MODIFICADO CORRECTAMENTE");
}
else{
    JOptionPane.showMessageDialog(null,"INCORRECTO NO EXISTE ESE DIA O VERIFIQUE");
}
    ListaHorario=objArchivo.leerHorario();
    }

    @FXML
    void btnUpdateOnMouseClicked(MouseEvent event) {
        txtArHorarios.clear();
        for (Horario horario: ListaHorario) {
            txtArHorarios.appendText(horario.getDia());
            txtArHorarios.appendText("     "+(horario.getHora()));
            txtArHorarios.appendText(":"+ (horario.getMinutos())+"\n");

        }
    }
    @FXML
    void btnSalirOnMouseClicked(MouseEvent event) {
        Vivero.setFXML("lillia-home","HOME");
    }

}



