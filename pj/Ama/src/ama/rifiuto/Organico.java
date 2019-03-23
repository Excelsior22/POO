package ama.rifiuto;

import static ama.costanti.CostantiGUI.IMMAGINE_ORGANICO;

import java.awt.Image;

import ama.Differenziatore;
import ama.Posizione;

public class Organico extends Rifiuto {
	
	public Organico(Posizione p) {
		super(p);
	}
	
	public Image getImmagine() {
		return IMMAGINE_ORGANICO;
	}
	
	@Override
	public void differenziaPresso(Differenziatore differenziatore) {
		differenziatore.differenzia(this);
	}

}
