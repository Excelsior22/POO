package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Permette di posare un oggetto togliendolo dalla 
 * borsa per lasciarlo nella stanza
 * @param oggetto
 */

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	private String nome= "posa";

	@Override
	public String esegui(Partita partita) {
		Stanza stanzaAttuale= partita.getStanzaCorrente();
		StringBuilder msg= new StringBuilder();
		if(this.nomeAttrezzo==null)
			msg.append("Nessun oggetto indicato");
		else {
			if(partita.hasAttrezzo(nomeAttrezzo)) {
				stanzaAttuale.addAttrezzo(partita.getAttrezzo(nomeAttrezzo));
				partita.removeAttrezzo(partita.getAttrezzo(nomeAttrezzo));      //remove from stanza
				msg.append("L'oggetto:"+nomeAttrezzo+" è stato lasciato nella stanza");
			}
			else
				msg.append("Oggetto non è presente nella borsa");
		}
		return msg.toString();
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}
	
	@Override 
	public String getNome() {
		return this.nome;
	}

}
