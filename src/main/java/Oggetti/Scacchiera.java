package Oggetti;
import java.util.ArrayList;
import java.util.List;
import TipiPezzo.*; // Importa tutti i tipi di pezzi

public class Scacchiera {
    
    public Pezzo[][] board = new Pezzo[8][8]; // La scacchiera ora contiene direttamente i pezzi
    public List<Pezzo> pezzi;


    // costruttore
    public Scacchiera() {
        this.pezzi = new ArrayList<>();
        inizializzaPezzi();
    }

    //implementazione della scacchiera logica, posizionamento pezzi, gestione mosse, ecc.
    private void inizializzaPezzi() {
        // Pezzi Bianchi
        pezzi.add(new Torre(true, true, 0, 0, this)); board[0][0] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Cavallo(true, true, 0, 1, this)); board[0][1] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Alfiere(true, true, 0, 2, this)); board[0][2] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Regina(true, true, 0, 3, this)); board[0][3] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Re(true, true, 0, 4, this)); board[0][4] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Alfiere(true, true, 0, 5, this)); board[0][5] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Cavallo(true, true, 0, 6, this)); board[0][6] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Torre(true, true, 0, 7, this)); board[0][7] = pezzi.get(pezzi.size() - 1);
        for (int i = 0; i < 8; i++) {
            pezzi.add(new Pedone(true, true, 1, i, this)); board[1][i] = pezzi.get(pezzi.size() - 1);
        }

        // Pezzi Neri
        pezzi.add(new Torre(false, true, 7, 0, this)); board[7][0] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Cavallo(false, true, 7, 1, this)); board[7][1] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Alfiere(false, true, 7, 2, this)); board[7][2] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Regina(false, true, 7, 3, this)); board[7][3] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Re(false, true, 7, 4, this)); board[7][4] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Alfiere(false, true, 7, 5, this)); board[7][5] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Cavallo(false, true, 7, 6, this)); board[7][6] = pezzi.get(pezzi.size() - 1);
        pezzi.add(new Torre(false, true, 7, 7, this)); board[7][7] = pezzi.get(pezzi.size() - 1);
        for (int i = 0; i < 8; i++) {
            pezzi.add(new Pedone(false, true, 6, i, this)); board[6][i] = pezzi.get(pezzi.size() - 1);
        }
    }

    
  public boolean eseguiMossa(int rigaPartenza, int colPartenza, int rigaArrivo, int colArrivo, boolean turnoBianco) {
    Pezzo pezzoDaMuovere = this.getPezzo(rigaPartenza, colPartenza);
    
    // Controlla che ci sia un pezzo
    if (pezzoDaMuovere == null) {
        return false;
    }
    
    // Controlla che sia il turno giusto
    if (pezzoDaMuovere.bianco != turnoBianco) {
        return false;
    }
    
    Pezzo pezzoDestinazione = this.getPezzo(rigaArrivo, colArrivo);
    
    // Non puoi mangiare i tuoi pezzi
    if (pezzoDestinazione != null && pezzoDestinazione.bianco == pezzoDaMuovere.bianco) {
        return false;
    }
    
    // Controlla se la mossa è valida secondo le regole del pezzo
    if (!pezzoDaMuovere.isMossaValida(rigaPartenza, colPartenza, rigaArrivo, colArrivo, this)) {
        return false;
    }
    
    // Se c'è un pezzo nemico, mangialo
    if (pezzoDestinazione != null) {
        pezzoDaMuovere.mangiaPezzo(pezzoDestinazione);
    }
    
    // Esegui la mossa
    board[rigaArrivo][colArrivo] = pezzoDaMuovere;
    board[rigaPartenza][colPartenza] = null;
    pezzoDaMuovere.setrigaInizio(rigaArrivo);
    pezzoDaMuovere.setColonna(colArrivo);
    
    return true;
}


    


    public Pezzo selezionaPezzo(int riga, int colonna, boolean turnoBianco) {
        Pezzo pezzo = this.getPezzo(riga, colonna);
        
        while (pezzo == null || pezzo.bianco != turnoBianco) {
            if (pezzo == null) {
                System.out.println("Nessun pezzo a questa posizione! Riprova:");
            } else {
                System.out.println("Non puoi muovere i pezzi dell'avversario! Riprova:");
            }
            // Attendi nuovo input
            pezzo = this.getPezzo(riga, colonna);
        }
        
        return pezzo;
    }

    public Pezzo selezionaDestinazionePezzo(Pezzo pezzoDaMuovere, int rigaFinale, int colFinale) {
        Pezzo pezzoDestinazione;
        
        do {
            // Controlla se la destinazione è dentro la scacchiera
            if (rigaFinale < 0 || rigaFinale >= 8 || colFinale < 0 || colFinale >= 8) {
                System.out.println("Destinazione fuori dalla scacchiera! Riprova:");
                // Qui attendi un nuovo input (da GUI o console)
                continue;
            }
            
            pezzoDestinazione = this.getPezzo(rigaFinale, colFinale);
            
            // Controlla se c'è un pezzo dello stesso colore nella destinazione
            if (pezzoDestinazione != null && pezzoDestinazione.bianco == pezzoDaMuovere.bianco) {
                System.out.println("Non puoi muovere in una casella occupata da un tuo pezzo! Riprova:");
                // Qui attendi un nuovo input (da GUI o console)
                continue;
            }
            
            break; // Destinazione valida
        } while (true);
        
        return pezzoDestinazione; // null se vuota, oppure pezzo nemico (catturabile)
    }


//GET E SET

    public Pezzo getPezzo(int riga, int colonna) {
        if (riga >= 0 && riga < 8 && colonna >= 0 && colonna < 8) {
            return board[riga][colonna];
        }
        return null;
    }
    //public void VisualizzaScacchiera()

    public Pezzo[][] getBoard() {
        return board;
    }

    public void setBoard(Pezzo[][] board) {
        this.board = board;
    }

   
}
