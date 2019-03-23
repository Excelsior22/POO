package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_GIALLO;

import java.awt.Image;
import java.util.Random;

import ama.Posizione;

public class Brown extends Politica{

	static private int progId=0;	

	@SuppressWarnings("unused")
	private void resetIds() {
		progId=0;
	}

	public Brown() {
		super(progId++);
	}

	@Override
	public Posizione decidiDirezione(Posizione p) {
		return p.traslazioneUnitaria(super.deltaCasuale(),super.deltaCasuale());
	}

	/**
	 * 
	 * @return un numero intero casuale tra -1,0,+1
	 */

	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_GIALLO;
	}

}
