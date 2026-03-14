package TipiPezzo;
import Oggetti.Pezzo;
import Oggetti.Scacchiera;

public class Alfiere extends Pezzo {

    public Alfiere(boolean bianco, boolean isVivo, int riga, int colonna, Scacchiera scacchiera) {
        super(bianco, isVivo, riga, colonna, scacchiera);
    }

    @Override
    public boolean isMossaValida(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo,
            Scacchiera scacchiera) {
        if (isStessaPosizione(rigaPartenza, colPartenza, rigaArrivo, colArrivo)) {
            return false; // Il pezzo non si muove
        }

        // Controlla se la mossa è diagonale
        if (Math.abs(rigaArrivo - rigaPartenza) != Math.abs(colArrivo - colPartenza)) {
            return false; // Non è una mossa diagonale
        }

        int rigaDirezione = (rigaArrivo > rigaPartenza) ? 1 : -1;
        int colDirezione = (colArrivo > colPartenza) ? 1 : -1;

        // Controlla se ci sono pezzi che bloccano il percorso
        int rigaCorrente = rigaPartenza + rigaDirezione;
        int colCorrente = colPartenza + colDirezione;

        while (rigaCorrente != rigaArrivo && colCorrente != colArrivo) {
            if (scacchiera.getPezzo(rigaCorrente, colCorrente) != null) {
                return false; // Percorso bloccato
            }
            rigaCorrente += rigaDirezione;
            colCorrente += colDirezione;
        }

        return true; // Mossa valida
    }

    
}

