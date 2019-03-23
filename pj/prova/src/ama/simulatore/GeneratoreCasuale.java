package ama.simulatore;

import java.util.Random;

import ama.Posizione;
import ama.rifiuto.Carta;
import ama.rifiuto.Organico;
import ama.rifiuto.Rifiuto;
import ama.rifiuto.Vetro;
import static ama.costanti.CostantiSimulatore.*;

public class GeneratoreCasuale {

	static private Random rnd = new Random();

	
	static public Posizione generaPosizioneCasuale() {
		final int x = 1 + rnd.nextInt(DIMENSIONE-2);
		final int y = 1 + rnd.nextInt(DIMENSIONE-2);
		return new Posizione(x,y);
	}
	
	/**
	 * Tipo:
	 * 0 -> vetro ;
	 * 1 -> carta ;
	 * 2 -> organico ;
	 */
	static public Rifiuto generaRifiutoCasuale() {
		if (rnd.nextDouble()<PROBABILITA_RIFIUTO) {
			final Posizione p = generaPosizioneCasuale();
			int tipoCasuale = rnd.nextInt(3);
			switch (tipoCasuale) {
			case 0: return new Vetro(p);
			case 1: return new Carta(p);
			case 2: return new Organico(p);
			}
		}
		return null;
	}

}
