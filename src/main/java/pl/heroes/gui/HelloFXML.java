package pl.heroes.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloFXML extends Application {
    @Override
    public void start(Stage _stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));

        Scene scene = new Scene(root, 300, 275);

        _stage.setScene(scene);
        _stage.show();
    }
}
