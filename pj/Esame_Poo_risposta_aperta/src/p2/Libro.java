package p2;

import java.util.*;

class Libro {
	private String titolo;
	private String autore;

	public Libro(String titolo, String autore) {
		this.titolo = titolo;
		this.autore = autore;
	}

	public String getAutore() {
		return this.autore;
	}

	public String getTitolo() {
		return this.titolo;
	}
}
