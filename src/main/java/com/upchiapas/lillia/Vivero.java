package com.upchiapas.lillia;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Vivero extends Application {
private static Scene scene;
private static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
this.stage=stage;
      scene =new Scene(loadFXML("lillia-home"));
        stage.setTitle("Lillia - Home");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }

public static Parent loadFXML(String nameView){
    FXMLLoader fxmlLoader = new FXMLLoader(Vivero.class.getResource(nameView + ".fxml"));
    try {
        return fxmlLoader.load();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
public static void setFXML(String nameView, String title){
scene.setRoot(loadFXML(nameView));
stage.sizeToScene();
stage.centerOnScreen();
stage.setTitle(title);
stage.setResizable(false);

}


    public static void main(String[] args) {
        launch();
    }
}