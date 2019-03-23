package battlefield;


public class Walker extends Robot{
  
	
	public Walker(Position p) {
		super(p);
	}
	
	public void passo(Battlefield field) {
		Position nuova = this.decidiLaPosizione(field);
		if (nuova!=null) {
			Walker clone = new Walker(nuova);
			field.addWalker(clone);
		}
		this.incrementaLongevita();
	}
	
	public Position decidiLaPosizione(Battlefield field) {
		Position corrente = this.getPosizione();
		Position libera = field.posizioneLiberaVicino(corrente);
		return libera; // verso una posizione libera
					   // tutto occupato: fermo
	}
}

