package ama.mezzo;

import static ama.simulatore.GeneratoreCasuale.generaPosizioneCasuale;

import java.util.HashSet;
import java.util.Set;

import ama.CentroDiRaccolta;
import ama.Citta;
import ama.Posizione;
import static ama.costanti.CostantiSimulatore.*;
import ama.rifiuto.Rifiuto;
import ama.simulatore.Simulatore;

/**
 * Modella le quattro fasi del ciclo di vita di un {@link Mezzo}
 * ma lascia la modellazione dei dettagli della fase di raccolta
 * alle due classi {@link Brown} e {@link Chase} fuori da questa
 * classe.
 * <B>(VEDI DOMANDA 2)</B>
 */
public class Mezzo {

	public final static int USCITA       = 0; // in uscita verso zona di raccolta
	public final static int RACCOLTA     = 1; // raccolta rifiuti (nella zone di raccolta)
	public final static int RIENTRO      = 2; // in rientro verso il centro di smaltimento
	public final static int SMALTIMENTO  = 3; // smaltimento, rifornimento, manutenzione ecc. ecc.
	// ovvero tutto quanto è necessario per ricominciare da primo stato.

	private final static int NUMERO_STATI   = 4;


	private int stato; // stato corrente

	private int passiStessoStato = -1; // passi consecutivi nello stesso stato

	private Simulatore simulatore;

	private Citta citta;	

	private Posizione zonaDiRaccolta;

	// (DA CAMBIARE: VEDI DOMANDA 2)
	private Politica politica; //


	private Posizione posizione;

	private Set<Rifiuto> carico;
	
	public Mezzo(Simulatore simulatore, Politica politica) {
		this(simulatore);
		this.politica = politica;
	}


	private Mezzo(Simulatore simulatore) {		
		this.simulatore = simulatore;
		this.citta = simulatore.getCitta();
		this.stato = USCITA;
		this.zonaDiRaccolta = generaPosizioneCasuale();
		/* parte dal centro di raccolta */
		this.posizione = citta.getCentroDiRaccolta().getPosizione();
		this.carico = new HashSet<>();
	}


	public Set<Rifiuto> getCarico() {
		return this.carico;
	}

	public void setPosizione(Posizione nuovaPos) {
		this.posizione = nuovaPos;
	}

	public Posizione getPosizione() {
		return this.posizione;
	}

	/* DA CAMBIARE: VEDI DOMANDA 2 */
	public Politica getPolitica() {
		return this.politica;
	}

	public int getStato() {
		return this.stato;
	}

	public void passo() {
		this.passiStessoStato++;
		final CentroDiRaccolta centro = this.citta.getCentroDiRaccolta();
		switch (this.stato) {
		case USCITA:
			this.tentaSpostamentoVersoPosizione(this.zonaDiRaccolta);
			if (this.getPosizione().equals(this.zonaDiRaccolta)) {
				this.zonaDiRaccolta = generaPosizioneCasuale(); // eventuale successiva
				prossimoStato();
			}
			break;
		case RACCOLTA:
			eseguiRaccolta();
			if (aPienoCarico() || fineTurno()) {
				prossimoStato();
			}
			break;
		case RIENTRO: 
			this.tentaSpostamentoVersoPosizione(centro.getPosizione());
			if (inCentroDiRaccolta()) {
				centro.accodaPerSmaltimento(this);
				prossimoStato();
			}
			break;
		case SMALTIMENTO:
			if (centro.esceDalloSmaltimento(this)) {
				prossimoStato();
			}
			break;
		}

	}

	/* DA CAMBIARE: VEDI DOMANDA 2 */
	private void eseguiRaccolta() {
		final int passo = this.simulatore.getTempo();
		final Posizione corrente = this.getPosizione();
		Posizione nuova = null;
		if (this.getPolitica()!=null) {
			nuova = this.getPolitica().decidiDirezione(corrente);
		}
		this.tentaSpostamentoVersoPosizione(nuova);
		final Rifiuto rifiuto = this.raccogliRifiuto();
		if (rifiuto!=null) {
			rifiuto.setRaccoltoDa(this);
			rifiuto.setRaccoltoAlPasso(passo);
		}
	}

	/**
	 * Esegue una traslazione unitaria verso la posizione specificata,
	 * evitando di salire sul bordo della {@link Citta}
	 * @param obiettivo - posizione da raggiungere
	 * @return la nuova posizione
	 */
	public Posizione tentaSpostamentoVersoPosizione(Posizione obiettivo) {
		if (obiettivo==null) return this.getPosizione(); // don't move
		
		final Posizione nuovaPos = this.getPosizione().traslazioneUnitariaVerso(obiettivo);
		if (!this.citta.sulBordo(nuovaPos)) {
			this.setPosizione(nuovaPos);
		}

		return this.getPosizione();
	}
	
	/**
	 * Raccoglie un {@link Rifiuto} dalla {@link Posizione} corrente della {@link Citta}
	 * @return il rifiuto raccolto, oppure null se nessuno è stato raccolto
	 */
	private Rifiuto raccogliRifiuto() {
		final Rifiuto rifiuto = this.citta.getRifiuto(this.getPosizione());
		if (rifiuto!=null) {
			// raccoglie: ovvero toglie dalla città e mette nel carico del mezzo
			this.carico.add(this.citta.remove(rifiuto));
		}
		return rifiuto;
	}
	
	private void prossimoStato() {
		this.stato = (this.stato + 1) % NUMERO_STATI;
		this.passiStessoStato = 0;
	}

	private boolean aPienoCarico() {
		return this.getCarico().size() >= MAX_CARICO;
	}

	
	private boolean fineTurno() {
		return ( this.passiStessoStato >= DURATA_MAX_TURNO );
	}

	private boolean inCentroDiRaccolta() {
		return getPosizione().equals(this.citta.getCentroDiRaccolta().getPosizione());
	}

}
