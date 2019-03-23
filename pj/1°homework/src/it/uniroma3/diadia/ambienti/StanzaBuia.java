package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StanzaBuia extends Stanza {
	private String nomeAttrezzoPass;
	
	public StanzaBuia(String nome,String attrezzo) throws FileNotFoundException, IOException {
		super(nome);
		this.nomeAttrezzoPass=attrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(this.nomeAttrezzoPass))
			return super.getDescrizione();
		else
			return "qui c'è un buio pesto";
	}
}
