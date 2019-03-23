package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Stampa informazioni di aiuto.
 */
public  class ComandoAiuto extends AbstractComando  {
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa","guarda","interagisci","saluta","regala"};

	public ComandoAiuto () {
		super("aiuto");
	}


	@Override
	public String esegui(Partita partita) {
		StringBuilder msg= new StringBuilder();
		for(int i=0; i< elencoComandi.length; i++) 
			msg.append(elencoComandi[i]+" ");
		msg.append("\n");
		return msg.toString();

	}
}
