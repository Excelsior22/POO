package ama;


import static ama.costanti.CostantiSimulatore.DIMENSIONE;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ama.rifiuto.Rifiuto;


/**
 * 
 */
public class Citta {

	final private int dimensione;

	final private CentroDiRaccolta centro;
			
	final private Map<Posizione,Rifiuto> pos2rifiuto;

	/**
	 * Crea un citta' delle dimensioni di default
	 */
	public Citta() {
		this(DIMENSIONE);
	}

	/**
	 * Crea una citta' (quadrata) delle dimensioni date.
	 * @param dim - dimensione
	 */
	public Citta(int dim) {
		this.dimensione = dim;
		this.centro = creaCentroDiRaccolta();
		this.pos2rifiuto = new HashMap<>();		
	}

	private CentroDiRaccolta creaCentroDiRaccolta() {		
		Posizione posizioneDeposito = new Posizione(this.dimensione/8, this.dimensione/8);
		return new CentroDiRaccolta(posizioneDeposito);
	}

	public CentroDiRaccolta getCentroDiRaccolta() {
		return this.centro;
	}

	/* utile per DOMANDA 2 ultimo punto */
	public boolean sulBordo(Posizione pos) {
		return pos.getX()==0 || pos.getX()==DIMENSIONE-1 || 
			   pos.getY()==0 || pos.getY()==DIMENSIONE-1;
	}

	public void addRifiuto(Rifiuto rifiuto) {
		this.pos2rifiuto.put(rifiuto.getPosizione(), rifiuto);
	}
	
	public Collection<Rifiuto> getRifiuti() {
		return this.pos2rifiuto.values();
	}

	public Rifiuto getRifiuto(Posizione posizione) {
		return this.pos2rifiuto.get(posizione);
	}

	public Rifiuto remove(Rifiuto rifiuto) {
		return this.pos2rifiuto.remove(rifiuto.getPosizione());
	}

	public long getLivelloRifiuti() {
		return this.pos2rifiuto.size();
	}

	public Posizione getRifiutoVicinoA(Posizione pivot) {
		int[] delta  = {-1, 0, -1};
		for(int dx : delta)
			for(int dy : delta) {
				if (dx==0 && dy==0) continue;
				Posizione adiacente = pivot.traslazioneUnitaria(dx, dy);
				if (this.getRifiuto(adiacente)!=null)
					return adiacente;
			}
		return null;
	}
	
}
