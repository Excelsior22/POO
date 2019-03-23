
package it.uniroma3.diadia;


import java.io.IOException;

import it.uniroma3.diadia.ambienti.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Labirinto,Giocatore
 * @version base
 */

public class Partita {

	private boolean finita;
	private Labirinto l1;
	private Giocatore player1;
	
	public Partita() throws FormatoFileNonValidoException, IOException{
		this.l1= new Labirinto("Labirinto.txt");
		this.player1= new Giocatore();
		this.finita = false;
	}


	public Stanza getStanzaVincente() {
		return l1.getStanzaVincente();
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		l1.setStanzaCorrente(stanzaCorrente); 
	}

	public Stanza getStanzaCorrente() {
		return l1.getStanzaCorrente();
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		/*return this.getStanzaCorrente()== this.getStanzaVincente();*/
		
		return this.getStanzaCorrente().getNome().equals(this.getStanzaVincente().getNome());
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (player1.getCfu()== 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	/**
	 * 
	 * @return un booleno che indica se il giocatore è ancora in gioco
	 */
	public boolean giocatoreIsVivo() {
		return player1.getCfu()>=1;
	}
	
	public int getCfu() {
		return player1.getCfu();
	}

	public void setCfu(int cfu) {
		this.player1.setCfu(cfu);	
	}
	/*Metodi aggiunti per le operazioni: prendere e posare*/
	
	public void addAttrezzo(Attrezzo attrezzo) {
		player1.addAttrezzo(attrezzo);
	}
	
	public void removeAttrezzo(Attrezzo attrezzo) {
		player1.removeAttrezzo(attrezzo);
	}
	
	public boolean hasAttrezzo(String oggetto) {
		return player1.hasAttrezzo(oggetto);
	}
	public Attrezzo getAttrezzo(String oggetto) {
		return player1.getAttrezzo(oggetto);
	}
}
