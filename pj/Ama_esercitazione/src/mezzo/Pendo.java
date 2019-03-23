package ama.mezzo;
import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_ROSSO;
import java.awt.Image;

import ama.Citta;
import ama.Posizione;

public class Pendo extends Politica {
	private static int progId = 0;
	public Pendo(Citta citta) {
		super(Pendo.progId++,citta);
	}
	private int dx = 1;
	@Override
	public Posizione decidiDirezione(Posizione p) {
		if(this.getCitta().sulBordo(p.traslazioneUnitaria(dx, 0)))
			dx = -dx;
		return p.traslazioneUnitaria(dx, 0);
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_ROSSO;
	}

}
