package it.uniroma3.diadia.personaggi;


import java.util.List;
import java.util.Map;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class Strega extends AbstractPersonaggio {
	
	private static final String PRESENTAZIONE= "Potrei diventare davvero dispettosa, ma dipende tutto da te!";
	private static final String MESSAGGIO_SALUTATA = "Mi sei simpatico, ti farò trovare tanti attrezzi!";
	private static final String MESSAGGIO_NON_SALUTATA = "Vai via, non voglio vederti!";
	
	public Strega(String nome) {
		super(nome, PRESENTAZIONE);
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		Map<String,Stanza>  stanze_possibili= partita.getStanzaCorrente().getStanzeAdiacenti();
		if(super.haSalutato()) {
			int num_attrezzi=0;
			Stanza destinazione= partita.getStanzaCorrente();
			for(Stanza stanza: stanze_possibili.values()) {
				int attrezzi_stanza = stanza.getAttrezzi().size();
				if(attrezzi_stanza>= num_attrezzi) {
					num_attrezzi= attrezzi_stanza;
					destinazione= stanza;	
				}
			}
			partita.setStanzaCorrente(destinazione);
			msg= MESSAGGIO_SALUTATA;		
		}
		else {
			List<Direzione> direzioni_possibili= partita.getStanzaCorrente().getDirezioni();
			int num_attrezzi= stanze_possibili.get(direzioni_possibili.get(0).name()).getAttrezzi().size();
			Stanza destinazione= partita.getStanzaCorrente();
			for(Stanza stanza: stanze_possibili.values()) {
				int attrezzi_stanza = stanza.getAttrezzi().size();
				if(attrezzi_stanza<= num_attrezzi)
					num_attrezzi= attrezzi_stanza;
					destinazione= stanza;				
			}
			partita.setStanzaCorrente(destinazione);
			
			msg= MESSAGGIO_NON_SALUTATA;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		partita.removeAttrezzo(attrezzo);
		return "AHHAHHAHAHAHAHAAAH!!";
	}

}
