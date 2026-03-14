package TipiPezzo;

import Oggetti.Pezzo;
import Oggetti.Scacchiera;

public class Cavallo extends Pezzo{
    public Cavallo(boolean bianco, boolean isVivo, int riga, int colonna, Scacchiera scacchiera) {
        super(bianco, isVivo, riga, colonna, scacchiera);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean isMossaValida(int rigaIniziale, int colIniziale, int rigaArrivo, int colArrivo,
            Scacchiera scacchiera) {
        // Calcola la differenza tra posizione iniziale e finale
        int deltaRiga = Math.abs(rigaArrivo - rigaIniziale);
        int deltaCol = Math.abs(colArrivo - colIniziale);
        
        // Il cavallo si muove a L: 2 caselle in una direzione e 1 nell'altra
        // Può saltare sopra altri pezzi
        return (deltaRiga == 2 && deltaCol == 1) || (deltaRiga == 1 && deltaCol == 2);
    }
    
}
