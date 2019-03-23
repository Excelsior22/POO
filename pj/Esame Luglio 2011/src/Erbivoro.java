

public class Erbivoro extends Animale{
	private static int FORZA_ERBIVORO = 2;
	private static double PROBABILITA_RIPRODUZIONE = 0.45;

	public Erbivoro(){
		super(FORZA_ERBIVORO);	
	}	

	public void agisci(Territorio territorio) {
		if (this.isMorto()) {
			territorio.rimuoviAnimale(this);
			return;
		}
		this.riproduci(territorio);

		Posizione nuovaPosizione;
		nuovaPosizione = territorio.posizioneLiberaVicino(this.getPosizione());
		if (nuovaPosizione!=null){
			this.incrementaCibo(1);
			territorio.sposta(this, nuovaPosizione);
		} else {
			this.incrementaCibo(-1);
		}
		this.incrementaAnni();
	}
	
	public void riproduci(Territorio territorio)  {
		Double random = Math.random();
		Posizione posizioneFiglio = territorio.posizioneLiberaVicino(super.getPosizione());
		
		if ((posizioneFiglio!= null) && (PROBABILITA_RIPRODUZIONE > random)) {
			Animale figlio = creaFiglio();
			territorio.setAnimale(figlio, posizioneFiglio);
		}
	}
	
	private Erbivoro creaFiglio() {
		return new Erbivoro();
	}
	





}

