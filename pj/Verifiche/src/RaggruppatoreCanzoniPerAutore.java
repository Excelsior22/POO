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
        List<Canzone> titoli;
        
        if(this.elencoCanzoni==null)
        Collections.emptyMap();
        for(Canzone song: elencoCanzoni){
            titoli= autore2canzoni.get(song.getAutore());
            if(titoli==null)
            	titoli= new ArrayList<Canzone>();
            titoli.add(song);
            autore2canzoni.put(song.getAutore(), titoli);
        }

        return autore2canzoni;
    }
}
