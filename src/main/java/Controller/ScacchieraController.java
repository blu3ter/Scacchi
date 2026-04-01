package Controller;

import Oggetti.Partita;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class ScacchieraController {

    @FXML
    private GridPane scacchieraGrid;

    // Istanza della logica di gioco
    private Partita partita = new Partita();
    
    // Variabili "memoria" per gestire i due click
    private int rigaPartenza = -1;
    private int colPartenza = -1;

    @FXML
    public void ClickCasella(MouseEvent event) {
        // Otteniamo lo StackPane (la casella) cliccato
        StackPane casellaCliccata = (StackPane) event.getSource();
        
        // Estraiamo le coordinate della casella nel GridPane
        Integer rigaIndex = GridPane.getRowIndex(casellaCliccata);
        int rigaCliccata = (rigaIndex == null) ? 0 : rigaIndex; 
        
        Integer colIndex = GridPane.getColumnIndex(casellaCliccata);
        int colonnaCliccata = (colIndex == null) ? 0 : colIndex;
        
        if (rigaPartenza == -1) {
            // --- PRIMO CLICK: Selezione ---
            rigaPartenza = rigaCliccata;
            colPartenza = colonnaCliccata;
            System.out.println("Pezzo selezionato in: " + rigaPartenza + ", " + colPartenza);
            
            // Evidenziamo la casella selezionata con un bordo giallo
            casellaCliccata.setStyle("-fx-border-color: yellow; -fx-border-width: 3;");
        } 
        else {
            // --- SECONDO CLICK: Destinazione ---
            System.out.println("Tentativo di mossa verso: " + rigaCliccata + ", " + colonnaCliccata);

            // Chiediamo al Model (Partita) di eseguire la mossa
            if (partita.eseguiMossa(rigaPartenza, colPartenza, rigaCliccata, colonnaCliccata)) {
                
                // Se la logica conferma il successo, aggiorniamo la grafica (View)
                aggiornaGrafica(rigaPartenza, colPartenza, rigaCliccata, colonnaCliccata);
                System.out.println("Mossa eseguita con successo!");
            } else {
                System.out.println("Mossa non valida o turno errato.");
            }

            // Puliamo l'evidenziazione della casella di partenza
            StackPane casellaPrecedente = (StackPane) getNodeByRowColumnIndex(rigaPartenza, colPartenza);
            if (casellaPrecedente != null) {
                casellaPrecedente.setStyle(""); // Rimuove il bordo giallo
            }

            // Resettiamo la memoria per la prossima mossa
            rigaPartenza = -1;
            colPartenza = -1;
        }
    }

    /**
     * Metodo per spostare fisicamente l'ImageView tra gli StackPane
     */
    private void aggiornaGrafica(int rP, int cP, int rA, int cA) {
        StackPane casellaOrigine = (StackPane) getNodeByRowColumnIndex(rP, cP);
        StackPane casellaDestinazione = (StackPane) getNodeByRowColumnIndex(rA, cA);

        if (casellaOrigine != null && casellaDestinazione != null) {
            // Se c'è un'immagine (pezzo) nella casella di partenza
            if (!casellaOrigine.getChildren().isEmpty()) {
                // Prendiamo il primo figlio dello StackPane (l'ImageView)
                Node pezzoImmagine = casellaOrigine.getChildren().get(0);
                
                // Rimuoviamo eventuali immagini presenti nella destinazione (caso di pezzo mangiato)
                casellaDestinazione.getChildren().clear();
                
                // Spostiamo il pezzo
                casellaOrigine.getChildren().remove(pezzoImmagine);
                casellaDestinazione.getChildren().add(pezzoImmagine);
            }
        }
    }

    /**
     * Metodo di supporto per trovare una casella nel GridPane conoscendo le coordinate
     */
    private Node getNodeByRowColumnIndex(final int row, final int column) {
        for (Node node : scacchieraGrid.getChildren()) {
            Integer r = GridPane.getRowIndex(node);
            Integer c = GridPane.getColumnIndex(node);
            if (r != null && r == row && c != null && c == column) {
                return node;
            }
        }
        return null;
    }
}