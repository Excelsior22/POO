package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public  class ComandoVai implements Comando {
	
	private String direzione;
	private String nome= "vai";
	 
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */

	@Override
	public String esegui(Partita partita) {
		StringBuilder msg= new StringBuilder();
		if(this.direzione==null) 
			msg.append("Dove vuoi andare ?");
		else {
		Stanza prossimaStanza = null;
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			msg.append("Direzione inesistente");
		else {
			partita.setStanzaCorrente(prossimaStanza);
			int cfu = partita.getCfu();
			partita.setCfu(cfu -1);
		}
		msg.append(partita.getStanzaCorrente().getDescrizione());
		}
		return msg.toString();
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;
		
	}
	
	@Override 
	public String getNome() {
		return this.nome;
	}

}
