package Controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MenuController {

      @FXML
    private Button BtnGioca;
    

 @FXML
private void AvviaPartita() {
    try {
        // 1. Carica il nuovo file FXML della scacchiera
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Scacchiera.fxml"));
        Parent root = loader.load();

        // 2. Ottieni lo Stage attuale (la finestra) dal bottone cliccato
        Stage stage = (Stage) BtnGioca.getScene().getWindow();

        // 3. Cambia la scena con quella della scacchiera
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