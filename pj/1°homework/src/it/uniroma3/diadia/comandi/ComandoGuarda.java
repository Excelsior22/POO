package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;


public  class ComandoGuarda extends AbstractComando {
	
	
	public ComandoGuarda() {
		super("guarda");
	}
	
	@Override
	public String esegui(Partita partita) {
	StringBuilder msg= new StringBuilder();
	msg.append("Stanza corrente:"+partita.getStanzaCorrente().getDescrizione()+"\n"+"Cfu Giocatore:"+partita.getCfu());
	return msg.toString();
	}


}

