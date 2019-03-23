package p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        // scrivere il codice di questo metodo
        
        if(this.elenco==null)
        	return Collections.emptyList();
        
        for(Libro libro: this.elenco){
        	elencoOrdinato.add(libro);
        	Collections.sort(elencoOrdinato, new ComparatoreLibriPerPagineISIN());
        }
        
        return elencoOrdinato;
    }
}