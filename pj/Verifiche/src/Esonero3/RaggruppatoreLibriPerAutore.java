package Esonero3;
/*Scrivere il metodo autore2libri() della classe RaggruppatoreLibriPerAutore che restituisce
 *  una mappa le cui chiavi sono i nomi di autori di libri; la mappa associa ad ogni nome 
 *  un valore che risulta essere la lista di tutti gli oggetti Libro scritti da tale autore
 */

import java.util.*;

class Libro2 {

    private String titolo;

    private String autore;

    public Libro2(String titolo, String autore) {
        this.titolo = titolo;
        this.autore = autore;
    }

    public String getAutore() {
        return this.autore;
    }

    public String getTitolo() {
        return this.titolo;
    }

}


public class RaggruppatoreLibriPerAutore {

    private List<Libro2> elencoLibri;

    public RaggruppatoreLibriPerAutore(){
        this.elencoLibri = new ArrayList<Libro2>();
    }

    public void aggiungiLibro(Libro2 libro) {
        this.elencoLibri.add(libro);
    }

    public Map<String, List<Libro2>> autore2libri() {
        Map<String, List<Libro2>> autore2libri = new HashMap<String, List<Libro2>>();
        List<Libro2> libri;
        if(this.elencoLibri==null)
        	return Collections.emptyMap();
        for(Libro2 libro: this.elencoLibri) {
        	libri= autore2libri.get(libro.getAutore());
        	if(libri==null)
        		libri=new ArrayList<Libro2>();
        	libri.add(libro);
        	autore2libri.put(libro.getAutore(), libri);
        }
        return autore2libri;
    }
}