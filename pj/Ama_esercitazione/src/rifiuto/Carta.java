package ama.rifiuto;

import static ama.costanti.CostantiGUI.IMMAGINE_CARTA;

import java.awt.Image;

import ama.Differenziatore;
import ama.Posizione;

public class Carta extends Rifiuto {
	
	public Carta(Posizione p) {
		super(p);
	}
	
	public Image getImmagine() {
		return IMMAGINE_CARTA;
	}

	@Override
	public void differenziaPresso(Differenziatore differenziatore) {
		differenziatore.differenzia(this);
	}

}
