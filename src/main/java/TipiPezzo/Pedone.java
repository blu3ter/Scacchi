package TipiPezzo;

import Oggetti.Pezzo;
import Oggetti.Scacchiera;

public class Pedone extends Pezzo{
    
    public Pedone(boolean bianco, boolean isVivo, int rigaInizio, int Inizio, Scacchiera scacchiera) {
        super(bianco, isVivo, rigaInizio, Inizio, scacchiera);
    }

    public boolean isMossaValida(int rigaIniziale, int colIniziale, int rigaArrivo, int colArrivo, Scacchiera scacchiera) {
        // Calcola la differenza tra posizione iniziale e finale
        int deltaRiga = Math.abs(rigaArrivo - rigaIniziale);
        int deltaCol = Math.abs(colArrivo - colIniziale);
        
        // Il pedone si muove solo in avanti di una casella
        if (deltaCol == 0 && deltaRiga == 1) {
            // Controlla se la casella è libera
            Pezzo pezzoDestinazione = scacchiera.getPezzo(rigaArrivo, colArrivo);
            return pezzoDestinazione == null;
        }
        
        // Se il pedone è nella posizione iniziale (riga 1 o 6), può muoversi di due caselle
        if (deltaCol == 0 && deltaRiga == 2 && ((this.bianco && rigaIniziale == 6) || (!this.bianco && rigaIniziale == 1))) {
            // Controlla se le caselle intermedie sono libere
            int medioRiga = (rigaIniziale + rigaArrivo) / 2;
            Pezzo pezzoMedio = scacchiera.getPezzo(medioRiga, colIniziale);
            return pezzoMedio == null;
        }
        
        return false;
    }
    
}
