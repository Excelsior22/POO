package ama.mezzo;

import java.awt.Image;
import java.util.Random;

import ama.Citta;
import ama.Posizione;

public abstract class Politica {
	private final int id;
	private Citta citta;
	public Politica(int id) {
		this(id,null);
	}
	public Politica(int id, Citta citta) {
		this.id = id;
		this.citta = citta;
		this.rnd = new Random();
	}
	final private Random rnd;
	public abstract Posizione decidiDirezione(Posizione p);
	public int deltaCasuale() {
		return this.rnd.nextInt(3)-1;
	}
	public int getId() {
		return this.id;
	}
	
	public Citta getCitta() {
		return this.citta;
	}
	public abstract Image getImmagine();
	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}
}
