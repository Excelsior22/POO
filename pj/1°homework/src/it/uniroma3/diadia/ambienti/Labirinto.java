package it.uniroma3.diadia.ambienti;

import java.io.IOException;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe ha il compito di creare il labirinto
 * e di memorizzare la stanza iniziale (entrata) e 
 * quella finale (uscita).
 * 
 * @author fabrizio
 * @see Stanza, Attrezzo
 *
 */
public class Labirinto {
	
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private Set<Attrezzo> attrezzi;
	
	public Labirinto(String nomeFile) throws FormatoFileNonValidoException, IOException {
		CaricatoreLabirinto c =
		new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaCorrente = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
		}

    
	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}


	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}


	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	
	public Set<Attrezzo> getAttrezziLabirinto(){
		return this.attrezzi;
	}

	
}
