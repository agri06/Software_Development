package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jboss.jandex.Main;

import java.io.IOException;

public class StageHelper {
    public static void setScene(String sceneName, String stageTile) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(sceneName));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = MainApp.stage;

                stage.setTitle(stageTile);
                stage.setScene(scene);
                stage.show();
                stage.centerOnScreen();
            } catch (IOException ignored) {
                System.out.println("Could not load " + sceneName);
            }
        }
    }

