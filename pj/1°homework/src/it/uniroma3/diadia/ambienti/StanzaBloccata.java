package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StanzaBloccata extends Stanza{
	private String direzioneBloccata;
	private String Passepartout;

	public StanzaBloccata(String nome,String direzione, String attrezzo) throws FileNotFoundException, IOException {
		super(nome);
		this.direzioneBloccata=direzione;
		this.Passepartout=attrezzo;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione==this.direzioneBloccata) {
			if(super.hasAttrezzo(this.Passepartout))
				return super.getStanzaAdiacente(direzione);
			else {
				return this;
			}
		}
			 return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		String descrizione;
		descrizione= super.getDescrizione();
		descrizione= descrizione +"\nLa stanza è bloccatta a "+ this.direzioneBloccata +" posare qui: "+ this.Passepartout + " per continuare in quella direzione";
		return descrizione;
	}
	
	
}
