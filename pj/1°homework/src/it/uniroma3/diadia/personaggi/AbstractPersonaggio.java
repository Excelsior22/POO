package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio {
	private String nome;
	private String presentazione;
	private boolean haSalutato;
	private Attrezzo regalo;
	
	public AbstractPersonaggio(String nome, String presentazione) {
		this.nome= nome;
		this.presentazione= presentazione;
		this.haSalutato= false;
		this.regalo= null;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public boolean haSalutato() {
		return this.haSalutato;
	}
	
	public String saluta() {
		StringBuilder risposta= new StringBuilder("Ciao io sono ");
		risposta.append(this.getNome());
		if(!haSalutato)
			risposta.append(", "+this.presentazione);
		else
			risposta.append(" Ci siamo già presentati!");
		this.haSalutato= true;
		return risposta.toString();
	}
	
	abstract public String agisci(Partita partita);
	
	@Override
	public String toString() {
		return this.getNome();
	}
	
	public abstract String riceviRegalo(Attrezzo attrezzo, Partita partita);
	
	public Attrezzo getRegalo() {
		return this.regalo;
	}
	
	public void setRegalo(Attrezzo regalo) {
		this.regalo= regalo;
	}

}