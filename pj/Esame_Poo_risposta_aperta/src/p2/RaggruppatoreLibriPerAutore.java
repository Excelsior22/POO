package p2;

/* Scrivere il metodo autore2libri() della classe RaggruppatoreLibriPerAutore  
 * che restituisce una mappa le cui chiavi sono i nomi di autori di libri; 
 * la mappa associa ad ogni nome un valore che risulta essere la lista di tutti gli oggetti Libro scritti da tale autore 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaggruppatoreLibriPerAutore {
	private List<Libro> elencoLibri;

	public RaggruppatoreLibriPerAutore(){
		this.elencoLibri = new ArrayList<Libro>();
	}

	public void aggiungiLibro(Libro libro) {
		this.elencoLibri.add(libro);
	}

	public Map<String, List<Libro>> autore2libri() {
		Map<String, List<Libro>> autore2libri = new HashMap<String, List<Libro>>();
		List<Libro> libri = new ArrayList<Libro>();

		if (this.elencoLibri == null)
			return Collections.emptyMap();

		for(Libro titolo: this.elencoLibri){
			libri = autore2libri.get(titolo.getAutore());

			if(libri == null)
				libri = new ArrayList<Libro>();
			libri.add(titolo);
			autore2libri.put(titolo.getAutore(), libri);
		}
		return autore2libri;
	}
}