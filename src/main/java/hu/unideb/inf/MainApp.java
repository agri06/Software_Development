package hu.unideb.inf;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.h2.tools.Server;

public class MainApp extends Application {

    public static Stage stage;
    public static Server s= new Server();

    @Override
    public void start(Stage stage) throws Exception {
        MainApp.stage = stage;



        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/home.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Hotel Management");
        stage.setScene(scene);
        stage.show();
    }
    private static void startDatabase() throws SQLException {
        s.runTool("-tcp", "-web", "-ifNotExists");
    }

    public static void stopDatabase()  {
        s.shutdown();
    }

    public static void main(String[] args) throws SQLException {
        startDatabase();
        launch(args);
        stopDatabase();
    }
}
