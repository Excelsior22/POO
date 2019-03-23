import java.util.*;
/*Cambiare la classe Libro completando il metodo compareTo(), e la classe CatalogatoreLibri completando il metodo elencoOrdinatoPerPagineISIN() 
 * affinche' quest'ultimo restituisca l'elenco dei libri ordinato per pagine ed in subordine, a parita' di pagine, per codice isin. 
 */


class Libro implements Comparable<Libro> {
    private String isin;
    private int pagine;

    public Libro(String isin, int pagine) {
        this.isin = isin;
        this.pagine = pagine;
    }

    public String getCodiceISIN() {
        return this.isin;
    }

    public int getNumeroPagine() {
        return this.pagine;
    }

    public int compareTo(Libro that) {
    	if(this.getNumeroPagine()-that.getNumeroPagine()==0)
    		return this.getCodiceISIN().compareTo(that.getCodiceISIN());
    	return this.getNumeroPagine()-that.getNumeroPagine();
    }
}

public class CatalogatoreLibri {
    private List<Libro> elenco;

    public CatalogatoreLibri() {
        this.elenco = new ArrayList<Libro>();
    }

    public void aggiungiLibro(Libro libro) {
        this.elenco.add(libro);
    }

    public List<Libro> elencoOrdinatoPerPagineISIN() {
        List<Libro> elencoOrdinato = new ArrayList<Libro>();
        if(this.elenco==null)
        	return Collections.emptyList();
        for(Libro book: this.elenco) {
        	elencoOrdinato.add(book);
        }
        Collections.sort(elencoOrdinato);
        return elencoOrdinato;
    }
}
