package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_VERDE;

import java.awt.Image;

import ama.Citta;
import ama.Posizione;

public class Chase extends Politica {

	static private int progId=0;
	private Citta citta;

	public Chase(Citta citta) {
		super(progId++);
		this.citta=citta;
		
	}

	public static void resetId() {
		progId=0;
	}

	public Citta getCitta() {
		return this.citta;
	}
	
	public Posizione decidiDirezione(Posizione corrente) {
		final Posizione posizioneRifiutoNelleVicinanze = 
				this.getCitta().getRifiutoVicinoA(corrente);
		if (posizioneRifiutoNelleVicinanze==null) 
			return corrente.traslazioneUnitaria(super.deltaCasuale(),super.deltaCasuale());
		else return posizioneRifiutoNelleVicinanze;
	}
	

	public Image getImmagine() {
		return IMMAGINE_CAMION_VERDE;
	}



}
