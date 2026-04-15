package TipiPezzo;

import Oggetti.Pezzo;
import Oggetti.Scacchiera;

public class Re extends Pezzo{

    public Re(boolean bianco, boolean isVivo, int riga, int colonna, Scacchiera scacchiera) {
        super(bianco, isVivo, riga, colonna, scacchiera);
    }

    @Override
    public boolean isMossaValida(int rigaInizioIniziale, int colIniziale, int rigaInizioArrivo, int colArrivo,
            Scacchiera scacchiera) {
        
        // Calcola la differenza tra posizione iniziale e finale
        int deltaRiga = Math.abs(rigaInizioArrivo - rigaInizioIniziale);
        int deltaCol = Math.abs(colArrivo - colIniziale);
        
       
        return (deltaRiga <= 1 && deltaCol <= 1) && (deltaRiga > 0 || deltaCol > 0);
    }

    
    
}
