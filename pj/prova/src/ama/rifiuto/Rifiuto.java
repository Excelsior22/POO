package ama.rifiuto;

import java.awt.Image;

import ama.Differenziatore;
import ama.Posizione;
import ama.mezzo.Mezzo;

public abstract class Rifiuto {

	private Posizione posizione;
	
	private int generatoAlPasso;
	
	private int raccoltoAlPasso;

	private Mezzo raccoglitore;
	
	protected Rifiuto(Posizione p) {
		this.posizione = p;
	}

	public Posizione getPosizione() {
		return this.posizione;
	}

	abstract public Image getImmagine();

	public int getRaccoltoAlPasso() {
		return this.raccoltoAlPasso;
	}

	public int getGeneratoAlPasso() {
		return this.generatoAlPasso;
	}

	public void setRaccoltoAlPasso(int passo) {
		this.raccoltoAlPasso = passo;
	}

	public void setGeneratoAlPasso(int passo) {
		this.generatoAlPasso = passo;
	}
	
	public void setRaccoltoDa(Mezzo mezzo) {
		this.raccoglitore = mezzo;
	}

	public Mezzo getRaccoglitore() {
		return this.raccoglitore;
	}

	abstract public void differenziaPresso(Differenziatore differenziatore);
}
