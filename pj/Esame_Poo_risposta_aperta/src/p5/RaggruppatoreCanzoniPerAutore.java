package p5;

import java.util.*;

class Canzone {

    private String titolo;

    private String autore;

    public Canzone(String titolo, String autore) {
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


public class RaggruppatoreCanzoniPerAutore {

    private List<Canzone> elencoCanzoni;

    public RaggruppatoreCanzoniPerAutore(){
        this.elencoCanzoni = new ArrayList<Canzone>();
    }

    public void aggiungiCanzone(Canzone canzone) {
        this.elencoCanzoni.add(canzone);
    }

    public Map<String, List<Canzone>> autore2canzoni() {
        Map<String, List<Canzone>> autore2canzoni = new HashMap<String, List<Canzone>>();
        List<Canzone> canzoni = new ArrayList<Canzone>();
        
        for(Canzone song: this.elencoCanzoni){
            canzoni = autore2canzoni.get(song.getAutore());
            
            if(canzoni == null)
                canzoni = new ArrayList<Canzone>();
                canzoni.add(song);
                autore2canzoni.put(song.getAutore(), canzoni);
        }

        return autore2canzoni;
    }
}