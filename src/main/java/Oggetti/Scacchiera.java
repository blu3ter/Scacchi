package Oggetti;
import java.util.ArrayList;
import java.util.List;
import TipiPezzo.*; // Importa tutti i tipi di pezzi

public class Scacchiera {
    
    public Pezzo[][] board = new Pezzo[8][8]; 
    public List<Pezzo> pezzi;

    public Scacchiera() {
        this.pezzi = new ArrayList<>();
        inizializzaPezzi();
    }

    private void inizializzaPezzi() {
        // --- PEZZI NERI (false) ---
        // Riga 0: Pezzi maggiori
        pezzi.add(new Torre(false, true, 0, 0, this)); board[0][0] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Cavallo(false, true, 0, 1, this)); board[0][1] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Alfiere(false, true, 0, 2, this)); board[0][2] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Regina(false, true, 0, 3, this)); board[0][3] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Re(false, true, 0, 4, this)); board[0][4] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Alfiere(false, true, 0, 5, this)); board[0][5] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Cavallo(false, true, 0, 6, this)); board[0][6] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Torre(false, true, 0, 7, this)); board[0][7] = pezzi.get(pezzi.size() - 1);
        
        // Riga 1: Pedoni
        for (int i = 0; i < 8; i++) {
            pezzi.add(new Pedone(false, true, 1, i, this)); board[1][i] = pezzi.get(pezzi.size() - 1);
        }

        // --- PEZZI BIANCHI (true) ---
        // Riga 7: Pezzi maggiori
        pezzi.add(new Torre(true, true, 7, 0, this)); board[7][0] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Cavallo(true, true, 7, 1, this)); board[7][1] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Alfiere(true, true, 7, 2, this)); board[7][2] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Regina(true, true, 7, 3, this)); board[7][3] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Re(true, true, 7, 4, this)); board[7][4] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Alfiere(true, true, 7, 5, this)); board[7][5] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Cavallo(true, true, 7, 6, this)); board[7][6] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Torre(true, true, 7, 7, this)); board[7][7] = pezzi.get(pezzi.size() - 1);
        
        // Riga 6: Pedoni
        for (int i = 0; i < 8; i++) {
            pezzi.add(new Pedone(true, true, 6, i, this)); board[6][i] = pezzi.get(pezzi.size() - 1);
        }
    }

    public boolean muoviPezzo(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo, boolean turnoBianco) {
        Pezzo pezzoDaMuovere = this.getPezzo(rigaPartenza, colPartenza);
        
        if (pezzoDaMuovere == null || pezzoDaMuovere.bianco != turnoBianco) {
            return false;
        }
        
        Pezzo pezzoDestinazione = this.getPezzo(rigaArrivo, colArrivo);
        
        if (pezzoDestinazione != null && pezzoDestinazione.bianco == pezzoDaMuovere.bianco) {
            return false;
        }
        
        if (!pezzoDaMuovere.isMossaValida(rigaPartenza, colPartenza, rigaArrivo, colArrivo, this)) {
            return false;
        }
        
        if (pezzoDestinazione != null) {
            pezzoDaMuovere.mangiaPezzo(pezzoDestinazione);
        }
        
        board[rigaArrivo][colArrivo] = pezzoDaMuovere;
        board[rigaPartenza][colPartenza] = null;
        pezzoDaMuovere.setrigaInizio(rigaArrivo);
        pezzoDaMuovere.setColonna(colArrivo);
        
        return true;
    }

    public Pezzo getPezzo(int riga, int colonna) {
        if (riga >= 0 && riga < 8 && colonna >= 0 && colonna < 8) {
            return board[riga][colonna];
        }
        return null;
    }

    public Pezzo[][] getBoard() { return board; }
    public void setBoard(Pezzo[][] board) { this.board = board; }
}