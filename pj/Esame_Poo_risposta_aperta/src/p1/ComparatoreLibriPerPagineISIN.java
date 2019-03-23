package p1;

import java.util.Comparator;

class ComparatoreLibriPerPagineISIN implements Comparator<Libro> {

    public int compare(Libro l1, Libro l2) {
    	
		return l1.getNumeroPagine()-l2.getNumeroPagine() + 
				l1.getCodiceISIN().compareTo(l2.getCodiceISIN());
        // scrivere il codice di questo metodo
    }
}