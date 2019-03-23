package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	
	private static final String PRESENTAZIONE= "Sono un essere magico e se mi dai un attrezzo, te lo mostrero'";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, con una mia magica azione, troverai un nuovo oggetto per il tuo borsone!";
	private Attrezzo attrezzo= new Attrezzo("Bacchetta", 3);
	
	public Mago(String nome) {
		super(nome, PRESENTAZIONE);
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		if(this.attrezzo!=null) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo=null;
			msg= MESSAGGIO_DONO;
		}
		else {
			msg= MESSAGGIO_SCUSE;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		partita.removeAttrezzo(attrezzo);
		int peso= attrezzo.getPeso()/2;
		Attrezzo Attrezzo_pesodimez= new Attrezzo (attrezzo.getNome(),peso);
		partita.getStanzaCorrente().addAttrezzo(Attrezzo_pesodimez);
		return "Mago: Ho dimezzato il peso dell'attrezzo che mi hai donato, lo lascio qui nella stanza";
	}

}
