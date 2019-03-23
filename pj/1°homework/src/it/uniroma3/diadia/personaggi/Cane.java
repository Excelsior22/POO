package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	private static final String PRESENTAZIONE= "Bau Bau!";
	private static final String MORSO = "Il cane ti ha mozziccato, Hai un CFU in meno!";
	private final String Oggetto_preferito= "osso";
	private Attrezzo chiave= new Attrezzo("Chiave",1);
	
	public Cane(String nome) {
		super(nome, PRESENTAZIONE);
	}
		
	@Override
	public String agisci(Partita partita) {
		partita.setCfu(partita.getCfu()-1);
		return MORSO;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo.getNome().equals(this.Oggetto_preferito)) {
			partita.removeAttrezzo(attrezzo);
			partita.getStanzaCorrente().addAttrezzo(chiave);
			return "grazie! Non so a cosa serva, ma ti regalo la chiave";
		}
		else {
			partita.removeAttrezzo(attrezzo);
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			return "Non mi interessa, è solo spazzatura!";
		}
		
	}

}
