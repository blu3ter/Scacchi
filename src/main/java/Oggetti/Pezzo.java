package Oggetti;
public abstract class Pezzo{

    public boolean bianco;
    public boolean isVivo;
    public int rigaInizio;
    public int colInizio;
    public Scacchiera scacchiera;

  
    public Pezzo(boolean bianco, boolean isVivo, int rigaInizio, int colInizio, Scacchiera scacchiera) {
        this.bianco = bianco;
        this.isVivo = isVivo;
        this.rigaInizio = rigaInizio;
        this.colInizio = colInizio;
        this.scacchiera = scacchiera;
    }





//Metodi astratti e concreti


    public abstract boolean isMossaValida(int rigaInizioIniziale, int colIniziale, int rigaInizioArrivo, int colArrivo, Scacchiera scacchiera);
    /* Nota: passiamo 'Scacchiera' perché il pezzo deve sapere se c'è qualcuno in mezzo o se la casella è occupata */


    public boolean isStessaPosizione(int r1, int c1, int r2, int c2) {
        return r1 == r2 && c1 == c2;
    }


    public void mangiaPezzo(Pezzo pezzoDaMangiare) {
        pezzoDaMangiare.isVivo = false; // Il pezzo mangiato non è più vivo
        scacchiera.board[pezzoDaMangiare.rigaInizio][pezzoDaMangiare.colInizio

        ] = null; // Rimuove il pezzo dalla scacchiera
    }





//GET E SET
    
    public boolean isBianco() {
        return this.bianco;
    }

    public void setBianco(boolean bianco) {
        this.bianco = bianco;
    }

    public boolean isVivo() {
        return isVivo;
    }

    public void setVivo(boolean isVivo) {
        this.isVivo = isVivo;
    }

    public int getrigaInizio() {
        return rigaInizio;
    }

    public void setrigaInizio(int rigaInizio) {
        this.rigaInizio = rigaInizio;
    }

    public int getColonna() {
        return colInizio;
    }

    public void setColonna(int colInizio
    ) {
        this.colInizio = colInizio;
    }

    public Scacchiera getScacchiera() {
        return scacchiera;
    }

    public void setScacchiera(Scacchiera scacchiera) {
        this.scacchiera = scacchiera;
    }
    



}


