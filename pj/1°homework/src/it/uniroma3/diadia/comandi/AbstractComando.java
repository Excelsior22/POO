package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public abstract class AbstractComando implements Comando {
	private String nome;
	
	public AbstractComando(String nome) {
		this.nome= nome;
	}
	

	@Override
	public abstract String esegui(Partita partita);

	@Override
	public void setParametro(String parametro) {}

	@Override
	public String getNome() {
		return this.nome;
	}

}
