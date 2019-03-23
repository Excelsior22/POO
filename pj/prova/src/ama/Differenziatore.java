package ama;

import java.util.HashSet;
import java.util.Set;

import ama.rifiuto.Carta;
import ama.rifiuto.Organico;
import ama.rifiuto.Rifiuto;
import ama.rifiuto.Vetro;

public class Differenziatore {

	private Set<Vetro> raccoglitoreVetro;
	private Set<Carta> raccoglitoreCarta;
	private Set<Organico> raccoglitoreOrganico;
	
	public Differenziatore() {
		this.raccoglitoreVetro = new HashSet<>();
		this.raccoglitoreCarta = new HashSet<>();
		this.raccoglitoreOrganico = new HashSet<>();
	}

	public void differenzia(Iterable<Rifiuto> daDifferenziare) {
		for(Rifiuto rifiuto : daDifferenziare)
			rifiuto.differenziaPresso(this);			
	}

	public void differenzia(Vetro vetro) {
		this.raccoglitoreVetro.add(vetro);
	}
	
	public void differenzia(Carta carta) {
		this.raccoglitoreCarta.add(carta);
	}

	public void differenzia(Organico organico) {
		this.raccoglitoreOrganico.add(organico);
	}
	
	public Set<Vetro> getRaccoltaDifferenziataDiVetro() {
		return this.raccoglitoreVetro;
	}

	public Set<Carta> getRaccoltaDifferenziataDiCarta() {
		return this.raccoglitoreCarta;
	}
	
	public Set<Organico> getRaccoltaDifferenziataDiOrganico() {
		return this.raccoglitoreOrganico;
	}

}
