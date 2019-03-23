package ant.formica;

import java.awt.Image;
import java.util.Set;

import static ant.costanti.CostantiGUI.IMMAGINE_FORMICA_ROSSA;
import ant.Ambiente;
import ant.Direzione;

public class Aggressiva extends Formica{

	static private int progId=0;
	
	static private void resetId(){
		progId=0;
	}
	
	
	public Aggressiva(Ambiente ambiente) {
		super(ambiente, progId++);
	}
	
	@Override
	public boolean decideDiCambiareDirezione() {

		Direzione direzioneCiboVicino = this.getAmbiente().getDirezioneCiboVicino(this.getPosizione());
		if(direzioneCiboVicino!=null)
			return direzioneCiboVicino!=null;
		return false;
	}

	@Override
	public Direzione cambioDirezione(Set<Direzione> possibili) {

		Direzione direzioneCiboVicino = this.getAmbiente().getDirezioneCiboVicino(this.getPosizione());
		if(direzioneCiboVicino!=null)
				return direzioneCiboVicino;
		return Direzione.scegliAcasoTra(possibili);
		

	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_FORMICA_ROSSA;
	}

}
