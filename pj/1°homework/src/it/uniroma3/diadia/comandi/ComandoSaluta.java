package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando {
	
	private static final String MESSAGGIO_NESSUNO_IN_STANZA = "Non c'è nessuno da salutare!";
	private String messaggio;

	public ComandoSaluta() {
		super("Saluta");
	}

	@Override
	public String esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		StringBuilder msg= new StringBuilder();
		personaggio= partita.getStanzaCorrente().getPersonaggio();
		if(personaggio!=null) {
			messaggio= personaggio.saluta();
			msg.append(messaggio);
		}
		else
			msg.append(MESSAGGIO_NESSUNO_IN_STANZA);
		return msg.toString();

	}
	
	public String getMessaggio() {
		return this.messaggio;
	}

}
