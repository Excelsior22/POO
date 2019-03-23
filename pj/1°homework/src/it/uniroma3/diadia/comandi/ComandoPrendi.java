package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoPrendi implements Comando {
	
	private String nomeAttrezzo;
	private String nome= "prendi";
	

	/**
	 * Permette al giocatore di prendere un determinato 
	 * oggetto nella stanza e metterlo nella borsa
	 * @param oggetto
	 */
	@Override
	public String esegui(Partita partita) {
		Stanza stanzaAttuale= partita.getStanzaCorrente();
		StringBuilder msg= new StringBuilder();
		if(nomeAttrezzo==null) {
			msg.append("Nessun oggetto indicato");
		}
		else {
			if(stanzaAttuale.hasAttrezzo(nomeAttrezzo)) {
				partita.addAttrezzo(stanzaAttuale.getAttrezzo(nomeAttrezzo));
				stanzaAttuale.removeAttrezzo(stanzaAttuale.getAttrezzo(nomeAttrezzo));      //remove from stanza
				msg.append("L'oggetto:"+nomeAttrezzo+" è stato inserito nella borsa");
			}
			else
				msg.append("Oggetto non presente in: " + stanzaAttuale.getNome());
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
