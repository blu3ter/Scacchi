package Oggetti;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carica il file FXML dalle risorse
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Menu.fxml"));
        Parent root = loader.load();

        // Crea la scena con le dimensioni definite nel tuo FXML (600x400)
        Scene scene = new Scene(root);

        primaryStage.setTitle("Gioco degli Scacchi");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}