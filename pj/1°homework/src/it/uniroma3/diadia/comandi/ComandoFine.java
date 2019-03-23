package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Comando "Fine".
 */

public  class ComandoFine extends AbstractComando {
	
	public ComandoFine () {
		super("fine");
	}

	@Override
	public String esegui(Partita partita) {
		StringBuilder msg= new StringBuilder();
		msg.append("Grazie di aver giocato!");
		partita.setFinita();
		return msg.toString();
	}
}
