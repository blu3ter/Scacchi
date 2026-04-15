package TipiPezzo;

import Oggetti.Pezzo;
import Oggetti.Scacchiera;

public class Pedone extends Pezzo {
    
    public Pedone(boolean bianco, boolean isVivo, int rigaInizio, int colInizio, Scacchiera scacchiera) {
        super(bianco, isVivo, rigaInizio, colInizio, scacchiera);
    }

    @Override
    public boolean isMossaValida(int rigaIniziale, int colIniziale, int rigaArrivo, int colArrivo, Scacchiera scacchiera) {
        int deltaCol = colArrivo - colIniziale;
        int deltaRiga = rigaArrivo - rigaIniziale; // Rimosso Math.abs per gestire la direzione
        
        /**
         * Direzione del movimento:
         * I Bianchi (true) partono da riga 6 e vanno verso la 0 (direzione negativa: -1)
         * I Neri (false) partono da riga 1 e vanno verso la 7 (direzione positiva: +1)
         */
        int direzione = this.bianco ? -1 : 1;
        
        // 1. Movimento in avanti semplice (1 casella)
        if (deltaCol == 0 && deltaRiga == direzione) {
            return scacchiera.getPezzo(rigaArrivo, colArrivo) == null;
        }
        
        // 2. Movimento in avanti doppio (Solo dalla posizione iniziale)
        int rigaInizialePedone = this.bianco ? 6 : 1;
        if (deltaCol == 0 && deltaRiga == 2 * direzione && rigaIniziale == rigaInizialePedone) {
            // Controlla che sia la casella di arrivo che quella intermedia siano libere
            return scacchiera.getPezzo(rigaArrivo, colArrivo) == null && 
                   scacchiera.getPezzo(rigaIniziale + direzione, colIniziale) == null;
        }
        
        // 3. Cattura diagonale (Mossa personalizzata del pedone)
        if (Math.abs(deltaCol) == 1 && deltaRiga == direzione) {
            Pezzo pezzoDestinazione = scacchiera.getPezzo(rigaArrivo, colArrivo);
            // Il pedone può muoversi in diagonale SOLO se cattura un pezzo nemico
            return pezzoDestinazione != null && pezzoDestinazione.bianco != this.bianco;
        }
        
        return false;
    }
}