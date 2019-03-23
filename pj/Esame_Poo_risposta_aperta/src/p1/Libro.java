package p1;

/*Senza cambiare la classe Libro, riscrivere il metodo compare() di ComparatoreLibriPerPagineISIN 
ed il metodo elencoOrdinatoPerPagineISIN() di CatalogatoreLibri affinche' restituisca l'elenco 
dei libri ordinato per numero di pagine ed in subordine, a parita' di pagine, per isin. */

import java.util.*;

class Libro implements Comparable<Libro> {
    //NON toccare il codice di questa classe
    private String isin;
    private int pagine;

    public Libro(String isin, int p) {
        this.isin = isin;
        this.pagine = p;
    }
    //NON toccare il codice di questa classe
    public String getCodiceISIN() {
        return this.isin;
    }

    public int getNumeroPagine() {
        return this.pagine;
    }

    public int compareTo(Libro libro) {
        return this.getNumeroPagine() - libro.getNumeroPagine();
    }
    //NON toccare il codice di questa classe
}
