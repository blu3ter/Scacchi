package Controller;

import Oggetti.Pezzo;
import Oggetti.Scacchiera;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class ScacchieraController {

    @FXML
    private GridPane scacchieraGrid;

    private Scacchiera scacchiera;
    private Pezzo pezzoSelezionato = null;
    private int rigaPartenza, colPartenza;
    private boolean turnoBianco = true; // Inizia il bianco

    @FXML
    public void initialize() {
        scacchiera = new Scacchiera();
        
    }
    
    
    private void ClickCasella(int riga, int colonna) {
      
    }

  
}