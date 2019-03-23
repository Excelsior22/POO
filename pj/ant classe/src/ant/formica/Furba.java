package ant.formica;

import static ant.costanti.CostantiGUI.IMMAGINE_FORMICA_BIANCA;

import java.awt.Image;
import java.util.Set;

import ant.Ambiente;
import ant.Direzione;

public class Furba extends Inseguitrice {
	static private int progId=0;

	public Furba(Ambiente ambiente) {
		super(ambiente, progId++);
		
	}
	
	
	public Direzione scegliDirezioneDopoPerditaTraccia(Set<Direzione> possibili) {
		Direzione direzioneCiboVicino = this.getAmbiente().getDirezioneCiboVicino(this.getPosizione());
		if(direzioneCiboVicino!=null)
				return direzioneCiboVicino;
		return Direzione.scegliAcasoTra(possibili);
	}

	@Override
	public Image getImmagine() {
			return IMMAGINE_FORMICA_BIANCA;
	
	}

}
