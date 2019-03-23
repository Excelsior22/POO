package ama.rifiuto;

import static ama.costanti.CostantiGUI.IMMAGINE_VETRO;

import java.awt.Image;

import ama.Differenziatore;
import ama.Posizione;

public class Vetro extends Rifiuto {
	
	public Vetro(Posizione p) {
		super(p);
	}
	
	public Image getImmagine() {
		return IMMAGINE_VETRO;
	}

	@Override
	public void differenziaPresso(Differenziatore differenziatore) {
		differenziatore.differenzia(this);
	}

}
