package ant.simulatore;

import static ant.costanti.CostantiSimulazione.DIMENSIONE;
import static ant.costanti.CostantiSimulazione.DURATA_SIMULAZIONE;
import static ant.costanti.CostantiSimulazione.NUMERO_FORMICHE_PER_TIPOLOGIA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.SwingUtilities;

import ant.Ambiente;
import ant.Cibo;
import ant.Coordinate;
import ant.Formicaio;
import ant.costanti.CostantiSimulazione;
import ant.formica.Esploratrice;
import ant.formica.Inseguitrice;
import ant.gui.GUI;

public class Simulatore {

	final private Ambiente ambiente;

	/* DA CAMBIARE VEDI DOMANDA 2 */
	final private List<Esploratrice> formicheEsploratrici;
	final private List<Inseguitrice> formicheInseguitrici;

	private int passo;

	private GUI gui;
	
	private GeneratoreCasuale generatoreCasuale;

	public Simulatore() {
		this(DIMENSIONE);
	}

	public Simulatore(int dim) {
		this.ambiente = new Ambiente(dim);
		this.passo = 0;
		this.formicheInseguitrici = new ArrayList<>();
		this.formicheEsploratrici = new ArrayList<>();
		this.generatoreCasuale = new GeneratoreCasuale();
		creaFormica();
	}

	private void creaFormica() {
		/* DA AGGIORNARE (VEDI DOMANDA 2, ed anche 7) */
		for(int i=0; i<NUMERO_FORMICHE_PER_TIPOLOGIA; i++) {
			this.formicheEsploratrici.add(creaEsploratrice());
			this.formicheInseguitrici.add(creaInseguitrice());
		}
	}
	
	public Esploratrice creaEsploratrice() {
		return new Esploratrice(this.getAmbiente());
	}

	public Inseguitrice creaInseguitrice() {
		return new Inseguitrice(this.getAmbiente());
	}

	public List<Esploratrice> getFormicheEsploratici() {
		return this.formicheEsploratrici;
	}

	public List<Inseguitrice> getFormicheInseguitrici() {
		return this.formicheInseguitrici;
	}

	public void setGUI(GUI gui) {
		this.gui = gui;
	}

	public Ambiente getAmbiente() {
		return this.ambiente;
	}

	public int getPasso() {
		return this.passo;
	}

	public void simula() {

		for(this.passo=0; this.passo<DURATA_SIMULAZIONE; this.passo++) {
			/* produzione cibo */
			generaCibo();

			simulaFormiche();

			simulaDissipazioneFerormone();
			
			aggiornaStatistiche();

			pausa();
		}
		/**
		 * Termina la simulazione corrente stampando le statistiche finali
		 */
		new Statistiche().stampaStatisticheFinali(this.getAmbiente());

		terminaSimulazione();
	}

	private void simulaFormiche() {
		/* DA CAMBIARE ( VEDI DOMANDA 2 )*/
		Collections.shuffle(this.formicheEsploratrici);
		Collections.shuffle(this.formicheInseguitrici);
		for(Esploratrice formica : this.formicheEsploratrici) {
			formica.simula(this.getPasso());
		}
		for(Inseguitrice formica : this.formicheInseguitrici) {
			formica.simula(this.getPasso());
		}
	}

	private void simulaDissipazioneFerormone() {
		this.ambiente.dissipaFerormone();
	}

	private void aggiornaStatistiche() {

		final Formicaio formicaio = this.getAmbiente().getFormicaio();
		final long livello = formicaio.getCiboRaccolto().size();
		/* stampa livello cibo nel formicaio */
		this.gui.riportaNelTitolo(this.passo, livello);
	}

	private void pausa() {
		this.updateGui();

		try {
			Thread.sleep(CostantiSimulazione.RITMO);
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

	private void generaCibo() {
		final Cibo nuovo = this.generatoreCasuale.ciboCasuale();
		if (nuovo!=null && posizioneLibera(nuovo.getPosizione())) {
			this.ambiente.addCibo(nuovo);
		}
	}

	private boolean posizioneLibera(Coordinate posizione) {
		return ( this.ambiente.getCibo(posizione)==null && !this.ambiente.getOstacoli().contains(posizione) );
	}	

	/**
	 * Termina la partita corrente
	 */
	public void terminaSimulazione() {
		System.exit(-1);
	}

}
