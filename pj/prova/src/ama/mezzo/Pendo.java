package ama.mezzo;

import java.awt.Image;
import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_ROSSO;
import ama.Citta;
import ama.Posizione;

public class Pendo extends Politica{
	
	static private int progId=0;
	private int verso=1;
	
	private Citta citta;
	
	public Pendo(Citta citta) {
		super(progId++);
		this.citta = citta;
	}

	@Override
	public Posizione decidiDirezione(Posizione corrente) {
		final Posizione posizioneSpostamento;
		if(this.citta.sulBordo(new Posizione( corrente.getX()+1*this.verso, corrente.getY()))) {
			this.verso= this.verso*-1;
		}
		posizioneSpostamento= corrente.traslazioneUnitaria(1* this.verso, 0);
		return posizioneSpostamento;
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_ROSSO;
	}

}
