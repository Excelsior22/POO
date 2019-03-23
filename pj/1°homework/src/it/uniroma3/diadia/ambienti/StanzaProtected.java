package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class StanzaProtected {
	
	
	
	private static Properties prop;
	protected String nome;
	protected List<Attrezzo> attrezzi;
    protected int numeroAttrezzi;
    protected Map<String,Stanza> stanzeAdiacenti;
	protected List<String> direzioni;
	protected int num_dir_max;
	protected int num_att_max;
	
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public StanzaProtected(String nome) throws FileNotFoundException, IOException {
    	prop= new Properties();
    	prop.load(new FileReader("resource/diadia.properties"));
    	num_dir_max= Integer.parseInt(prop.getProperty("NUMERO_MASSIMO_DIREZIONI"));
    	num_att_max= Integer.parseInt(prop.getProperty("NUMERO_MASSIMO_ATTREZZI"));
    	
        this.nome = nome;
        this.numeroAttrezzi = 0;
        this.direzioni= new ArrayList<String>(num_dir_max);
        this.attrezzi= new ArrayList<Attrezzo>(num_att_max);
        this.stanzeAdiacenti= new HashMap<>();
        
        /*
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
        this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
        */
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanzaAdicente) {
    	this.stanzeAdiacenti.put(direzione, stanzaAdicente);
    	this.direzioni.add(direzione);
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}
	
    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.numeroAttrezzi < num_att_max) {
        	this.attrezzi.add(attrezzo);
        	this.numeroAttrezzi++;
        	return true;
        }
        else {
        	return false;
        }
    }
    
    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }
    
    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public List<Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	for (String direzione : this.direzioni)
    		if (direzione!=null)
    			risultato.append(" " + direzione);
    	risultato.append("\nAttrezzi nella stanza: ");
    	for (Attrezzo a: this.attrezzi) {
    		risultato.append(a.toString()+" ");
    	}
    	return risultato.toString();
    }
    
    /**
     * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
     * @return true se l'attrezzo esiste nella stanza, false altrimenti.
     */
    public boolean hasAttrezzo(String nomeAttrezzo) {
    	boolean trovato;
    	trovato = false;
    	for(Attrezzo a: this. attrezzi) {
    		if (a.getNome().equals(nomeAttrezzo))
    			trovato = true;
    	}
    	return trovato;
    }

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
    	Attrezzo attrezzoCercato;
    	attrezzoCercato = null;
    	for(Attrezzo a: this.attrezzi) {
    		if (a.getNome().equals(nomeAttrezzo))
    			attrezzoCercato = a;
    	}
    	return attrezzoCercato;	
    }
    
	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		for(Attrezzo a: this.attrezzi) {
			if(a.getNome().equals(attrezzo.getNome())) {
				attrezzi.remove(a);
				this.numeroAttrezzi--;
				return true;
			}
		}
		return false;
		
	}

    

	public List<String> getDirezioni() {
		
		return this.direzioni;

    }
}
