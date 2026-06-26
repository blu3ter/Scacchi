package Controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;

public class MenuController {

    @FXML
    private Button BtnGioca;



    @FXML
    private void AvviaPartita() {
        try {
            Stage stage = (Stage) BtnGioca.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Scacchiera.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Esci() {
        System.out.println("Chiusura gioco...");
        System.exit(0);
    }
}