package Esonero3;

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
        // completare questo metodo
        for(Canzone song: elencoCanzoni){
            String autore= song.getAutore();
            if(!autore2canzoni.containsKey(autore)){
                List<Canzone> canzoni= new ArrayList<>();
                canzoni.add(song);
                autore2canzoni.put(autore,canzoni);
            }
            else{
                List<Canzone> canzoni= autore2canzoni.get(autore);
                canzoni.add(song);
                autore2canzoni.put(autore,canzoni);
            }
        }
        return autore2canzoni;
    }
}
