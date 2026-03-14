package Oggetti;
import TipiPezzo.Re;
public class Partita {

    public boolean turnoBianco = true;
    public static boolean ScaccoMatto = false;
    public Scacchiera scacchiera = new Scacchiera();
    
    


    /**
     * Esegue una mossa dalla GUI
     * @return true se la mossa è stata eseguita con successo, false altrimenti
     */
    public boolean eseguiMossa(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo) {
        // Delega a Scacchiera e controlla il turno
        if (scacchiera.eseguiMossa(rigaPartenza, colPartenza, rigaArrivo, colArrivo, turnoBianco)) {
            // Controlla se la mossa ha portato a scacco matto
            if (controllaMatto()) {
                return true; // Partita finita
            }
            CambiaTurno();
            return true;
        }
        return false;
    }
    
    /**
     * Controlla se il Re avversario è stato catturato (Scacco Matto)
     * @return true se il giocatore attuale ha vinto, false altrimenti
     */
    public boolean controllaMatto() {
        // Cerca il Re avversario nella lista dei pezzi
        for (Pezzo pezzo : scacchiera.pezzi) {
            if (pezzo instanceof Re) {
                // Se il Re avversario (colore opposto a chi ha appena mosso) non è vivo
                if (!pezzo.isVivo && pezzo.bianco != turnoBianco) {
                    ScaccoMatto = true;
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Ritorna il nome del vincitore se la partita è finita
     * @return il vincitore ("Bianco" o "Nero") oppure null se la partita è ancora in corso
     */
    public String getVincitore() {
        if (ScaccoMatto) {
            // Chi ha vinto è colui il cui turno è adesso (perché ha appena mosso)
            return turnoBianco ? "Bianco" : "Nero";
        }
        return null;
    }

    public void CambiaTurno() {
        turnoBianco = !turnoBianco; // Cambia il turno
    }
}


