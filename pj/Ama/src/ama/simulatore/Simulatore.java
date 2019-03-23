package ama.simulatore;

import static ama.costanti.CostantiSimulatore.*;

import java.util.*;

import javax.swing.SwingUtilities;

import ama.Citta;
import ama.gui.GUI;
import ama.mezzo.*;
import ama.rifiuto.Rifiuto;

public class Simulatore {

	final private Citta citta;

	final private List<Mezzo> mezzi;

	private long totale;

	private int passo;

	private GUI gui;

	public Simulatore() {
		this(DIMENSIONE);
	}

	public Simulatore(int dim) {
		this.citta = new Citta(dim);
		this.passo = 0;
		this.totale = 0;
		this.mezzi = new ArrayList<>();
		creaMezzi();
	}

	/* VEDI DOMANDA 2, ultimo punto */
	private void creaMezzi() {
		for(int i=0; i<NUMERO_MEZZI_PER_TIPOLOGIA; i++) {
			this.mezzi.add(creaBrowniano());
			this.mezzi.add(creaChaser());
			this.mezzi.add(creaPendo());
		}
	}
	
	/**
	 * Facilita la creazione di un mezzo con politica di spostamento casuale
	 * @return un nuovo mezzo con politica {@link Brown}
	 */
	public Mezzo creaBrowniano() {
		return new Mezzo(this, new Brown());
	}

	/**
	 * Facilita la creazione di un mezzo con politica di spostamento casuale
	 * @return un nuovo mezzo con politica {@link Chaser}
	 */
	public Mezzo creaChaser() {
		return new Mezzo(this, new Chase(this.getCitta()));
	}
	
	public Mezzo creaPendo() {
		return new Mezzo(this, new Pendo(this.getCitta()));
	}


	public List<Mezzo> getMezzi() {
		return this.mezzi;
	}

	public void setGUI(GUI gui) {
		this.gui = gui;
	}

	public Citta getCitta() {
		return this.citta;
	}

	public int getTempo() {
		return this.passo;
	}

	public void simula() {

		for(this.passo=0; this.passo<DURATA_SIMULAZIONE; this.passo++) {
			/* produzione dei rifiuti */
			generaRifiuto();

			/* simulazione dei mezzi di raccolta */
			simulaMezzi();

			/* simulazione centro di smaltimento */
			simulaCentroDiRaccolta();

			/* aggiornamento statistiche */
			aggiornaStatisticheProgressive();

			/* pausa ed aggiornamento GUI */
			pausaAggiornaGUI();
		}
		/**
		 * Termina la partita corrente stampando il punteggio finale da console
		 */
		new Statistiche().stampaStatisticheFinali(this.getCitta());

		terminaSimulazione();		
	}

	private void simulaCentroDiRaccolta() {
		this.citta.getCentroDiRaccolta().simula();
	}

	private void simulaMezzi() {
		/* passo di simulazione secondo un ordinamento casuale */
		Collections.shuffle(this.mezzi);
		for(Mezzo mezzo : this.mezzi) {
			mezzo.passo();
		}
	}

	private void aggiornaStatisticheProgressive() {
		/* riporta livello sporcizia corrente & medio in citta' */
		final long livello = this.getCitta().getLivelloRifiuti();
		this.totale += livello;
		final long medio = this.totale / (this.getTempo()+1);
		this.gui.riportaNelTitolo(this.passo, livello, medio);
	}

	private void pausaAggiornaGUI() {
		this.updateGui();

		try {
			Thread.sleep(RITMO);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void updateGui() {
		SwingUtilities.invokeLater( new Runnable() {			
			@Override
			public void run() {
				Simulatore.this.gui.repaint();
			}
		});
	}

	private void generaRifiuto() {
		final Rifiuto nuovo = GeneratoreCasuale.generaRifiutoCasuale();
		if (nuovo!=null && this.citta.getRifiuto(nuovo.getPosizione())==null) {
			nuovo.setGeneratoAlPasso(this.getTempo());
			this.citta.addRifiuto(nuovo);
		}
	}	

	/**
	 * Termina la partita corrente
	 */
	public void terminaSimulazione() {
		System.exit(0);
	}


}
