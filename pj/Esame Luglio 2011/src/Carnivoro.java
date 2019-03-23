

import java.util.List;

public class Carnivoro extends Animale{
	private static int FORZA_CARNIVORO = 5;
	private static double PROBABILITA_RIPRODUZIONE = 0.45;


	public Carnivoro(){
		super(FORZA_CARNIVORO);	
	}
	
	

	public void agisci(Territorio territorio)  {
		if (this.isMorto()) {
			territorio.rimuoviAnimale(this);
			return;
		}
		this.riproduci(territorio);	
		
		Posizione nuovaPosizione;
		Erbivoro vittimaErbivoro;
		vittimaErbivoro = cercaVittimaErbivoro(territorio);
		if (vittimaErbivoro != null) {		
			this.incrementaCibo(1);
			territorio.rimuoviAnimale(vittimaErbivoro);
			nuovaPosizione = vittimaErbivoro.getPosizione();
		} else {
			Carnivoro vittimaCarnivoro;
			vittimaCarnivoro = cercaVittimaCarnivoro(territorio);
			if (vittimaCarnivoro != null) {		
				this.incrementaCibo(1);
				territorio.rimuoviAnimale(vittimaCarnivoro);
				nuovaPosizione = vittimaCarnivoro.getPosizione();
			} else {
				this.incrementaCibo(-1);
				nuovaPosizione = territorio.posizioneLiberaVicino(this.getPosizione());
			}
		}
		if (nuovaPosizione!=null){
			territorio.sposta(this, nuovaPosizione);
		}		
		this.incrementaAnni();
	}

	private Erbivoro cercaVittimaErbivoro(Territorio territorio) {
		List<Posizione> adiacenti = territorio.adiacenti(this.getPosizione());
		Erbivoro a=null;
		for(Posizione p : adiacenti) {
			Animale b = territorio.getAnimale(p);
			if(b!=null) {
			if(b.getClass().equals(Erbivoro.class))
				  a = (Erbivoro)b;
			}
			if ((a!=null) && (this.getForza()>a.getForza())) {
				return a;
			}
		}
		return null;
	}

	private Carnivoro cercaVittimaCarnivoro(Territorio territorio) {
		List<Posizione> adiacenti = territorio.adiacenti(this.getPosizione());
		Carnivoro a=null;
		for(Posizione p : adiacenti) {
			Animale b = territorio.getAnimale(p);
			if(b!=null) {
			if(b.getClass().equals(Carnivoro.class))
				  a = (Carnivoro)b;
			}
			if ((a!=null) && (this.getForza()>a.getForza())) {
				return a;
			}
		}
		return null;
	}
	
	public void riproduci(Territorio territorio)  {
		Double random = Math.random();
		Posizione posizioneFiglio = territorio.posizioneLiberaVicino(super.getPosizione());
		
		if ((posizioneFiglio!= null) && (PROBABILITA_RIPRODUZIONE > random)) {
			Animale figlio = creaFiglio();
			territorio.setAnimale(figlio, posizioneFiglio);
		}
	}
	

	private Carnivoro creaFiglio() {
		return new Carnivoro();
	}



}

