package ama;

import static ama.costanti.CostantiSimulatore.DURATA_SMALTIMENTO;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import ama.mezzo.Mezzo;
import ama.rifiuto.Rifiuto;
import ama.simulatore.Simulatore;

public class CentroDiRaccolta {

	private LinkedList<Mezzo> inSmaltimento; // mezzi in coda

	private Posizione posizione;

	private Set<Mezzo> prontiAlluscita;      // dopo scarico

	private Set<Rifiuto> smaltiti;           // rifiuti già raccolti

	private int durataSmaltimentoCorrente;

	private Differenziatore differenziatore;
	
	public CentroDiRaccolta(Posizione posizione) {
		this.posizione  = posizione;
		this.inSmaltimento = new LinkedList<>();
		this.smaltiti = new HashSet<>();
		this.durataSmaltimentoCorrente = 0;
		this.prontiAlluscita = new HashSet<>();
		this.differenziatore = new Differenziatore();
	}
	
	public Posizione getPosizione() {
		return this.posizione;
	}
	
	public Differenziatore getDifferenziatore() {
		return this.differenziatore;
	}

	public void accodaPerSmaltimento(Mezzo mezzo) {
		this.inSmaltimento.addLast(mezzo);
	}

	public boolean esceDalloSmaltimento(Mezzo mezzo) {
		if (this.prontiAlluscita.contains(mezzo)) {
			smaltimentoCaricoDel(mezzo);
			this.prontiAlluscita.remove(mezzo);
			return true;
		}
		return false;
	}

	private void smaltimentoCaricoDel(Mezzo mezzo) {
		final Set<Rifiuto> carico = scaricaRifiutiRaccoltiDa(mezzo);
		differenziaCarico(carico);
		this.smaltiti.addAll(carico);
	}

	public Set<Rifiuto> scaricaRifiutiRaccoltiDa(Mezzo mezzo) {
		final Set<Rifiuto> result = new HashSet<>(mezzo.getCarico());
		mezzo.getCarico().clear();
		return result;
	}

	private void differenziaCarico(Set<Rifiuto> carico) {
		this.differenziatore.differenzia(carico);
	}

	public Set<Rifiuto> getRifiutiSmaltiti() {
		return this.smaltiti;
	}

	/**
	 * N.B. metodo invocato ad ogni passo della simulazione da {@link Simulatore}
	 */
	public void simula() {
		simulaSmaltimentoSequenziale();
	}

	private void simulaSmaltimentoSequenziale() {
		while (!this.inSmaltimento.isEmpty()) {
			this.durataSmaltimentoCorrente++;
			if (this.durataSmaltimentoCorrente>=DURATA_SMALTIMENTO) {
				final Mezzo mezzo = this.inSmaltimento.removeFirst();
				this.prontiAlluscita.add(mezzo);
				this.durataSmaltimentoCorrente = 0;
			}
		}
	}

}
