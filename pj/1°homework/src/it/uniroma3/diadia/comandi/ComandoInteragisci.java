package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando {
	
	public ComandoInteragisci() {
		super("Interagisci");
	}

	private static final String MESSAGGIO_CON_CHI = "Con chi dovrei interagire?";
	

	
	@Override
	public String esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		StringBuilder msg= new StringBuilder();
		personaggio= partita.getStanzaCorrente().getPersonaggio();              
		if( personaggio!=null) {
			msg.append(personaggio.agisci(partita));
			return msg.toString();
		}
		else
			return MESSAGGIO_CON_CHI;
	}
	

}
