package TipiPezzo;
import Oggetti.Pezzo;
import Oggetti.Scacchiera;

public class Torre extends Pezzo {
        public Torre(boolean bianco, boolean isVivo, int riga, int colonna, Scacchiera scacchiera) {
            super(bianco, isVivo, riga, colonna, scacchiera);
        }

    @Override 
    public boolean isMossaValida(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo, Scacchiera scacchiera) {
        if (isStessaPosizione(rigaPartenza, colPartenza, rigaArrivo, colArrivo)) {
            return false; // La mossa non è valida se la posizione iniziale è uguale alla posizione finale
        }
        
        // La torre si muove in linea retta, quindi deve muoversi solo in orizzontale o verticale
        if (colPartenza == colArrivo) {
            // Movimento verticale
            int rigaInizio = Math.min(rigaPartenza, rigaArrivo);
            int rigaFine = Math.max(rigaPartenza, rigaArrivo);
            // Controlla se c'è un pezzo in mezzo
            for (int i = rigaInizio + 1; i < rigaFine; i++) {
                if (scacchiera.getPezzo(i, colPartenza) != null) {
                    return false; // C'è un pezzo in mezzo
                }
            }
            return true;
        } else if (rigaPartenza == rigaArrivo) {
            // Movimento orizzontale
            int colonnaInizio = Math.min(colPartenza, colArrivo);
            int colonnaFine = Math.max(colPartenza, colArrivo);
            // Controlla se c'è un pezzo in mezzo
            for (int j = colonnaInizio + 1; j < colonnaFine; j++) {
                if (scacchiera.getPezzo(rigaPartenza, j) != null) {
                    return false; // C'è un pezzo in mezzo
                }
            }
            return true;
        }
        return false; // Non è un movimento valido per una torre
    }
    
}
