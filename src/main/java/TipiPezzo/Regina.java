package TipiPezzo;

import Oggetti.Pezzo;
import Oggetti.Scacchiera;

public class Regina extends Pezzo {

    public Regina(boolean bianco, boolean isVivo, int riga, int colonna, Scacchiera scacchiera) {
        super(bianco, isVivo, riga, colonna, scacchiera);
    }

    @Override
    public boolean isMossaValida(int rigaInizioIniziale, int colIniziale, int rigaInizioArrivo, int colArrivo,
            Scacchiera scacchiera) {
        
        // La regina combina i movimenti di torre e alfiere
        Torre torre = new Torre(this.bianco, this.isVivo, this.rigaInizio, this.colInizio, scacchiera);
        Alfiere alfiere = new Alfiere(this.bianco, this.isVivo, this.rigaInizio, this.colInizio, scacchiera);
        
        return torre.isMossaValida(rigaInizioIniziale, colIniziale, rigaInizioArrivo, colArrivo, scacchiera) ||
               alfiere.isMossaValida(rigaInizioIniziale, colIniziale, rigaInizioArrivo, colArrivo, scacchiera);
    }
    
}
