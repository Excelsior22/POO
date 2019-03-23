package ama.mezzo;

import java.awt.Image;
import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_ROSSO;
import ama.Citta;
import ama.Posizione;

public class Pendo extends Politica{

	static private int progId=0;
	private Citta citta;
	private int verso=1;

	public Pendo(Citta citta) {
		super(progId++);
		this.citta=citta;
		
	}

	public static void resetId() {
		progId=0;
	}

	public Citta getCitta() {
		return this.citta;
	}

	@Override
	public Posizione decidiDirezione(Posizione corrente) {
		if(this.citta.sulBordo(corrente.traslazioneUnitaria(1, 0))
				|| this.citta.sulBordo(corrente.traslazioneUnitaria(-1, 0)	)) {
			this.verso= this.verso*-1;
		}
		return corrente.traslazioneUnitaria(1*this.verso, 0);
	}
	

	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_ROSSO;
	}

}
