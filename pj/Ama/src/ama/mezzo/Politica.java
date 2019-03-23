package ama.mezzo;

import java.awt.Image;
import java.util.Random;

import ama.Posizione;

public abstract class Politica {

	private int id;

	final private Random rnd;

	public Politica(int id) {
		this.id= id;
		this.rnd = new Random();
	}
	public int getId() {
		return this.id;
	}
	
	public Random getRandom(){
		return this.rnd;
	}
	
	public abstract Posizione decidiDirezione(Posizione corrente);
	
	/**
	 * 
	 * @return un numero intero casuale tra -1,0,+1
	 */

	public int deltaCasuale() {
		return this.rnd.nextInt(3)-1;
	}
	
	public abstract Image getImmagine();
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}

}


