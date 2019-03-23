package ant;

import ant.formica.Esploratrice;
import ant.formica.Inseguitrice;

public class Cibo {

	private Coordinate posizione;
	
	/* DA CAMBIARE: VEDI DOMANDA 2 */
	private Esploratrice raccoglitriceEsploratrice;
	private Inseguitrice raccoglitriceInseguitrice;
	
	public Cibo(Coordinate p) {
		this.posizione = p;
	}

	public Coordinate getPosizione() {
		return this.posizione;
	}
	
	public void setRaccoglitrice(Esploratrice formica) {
		this.raccoglitriceEsploratrice = formica;
	}

	public void setRaccoglitrice(Inseguitrice formica) {
		this.raccoglitriceInseguitrice = formica;
	}

	public Esploratrice getRaccoglitriceEsploratrice() {
		return this.raccoglitriceEsploratrice;
	}

	public Inseguitrice getRaccoglitriceInseguitrice() {
		return this.raccoglitriceInseguitrice;
	}
}
