

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Territorio {
	private static final int NUM_INIZIALE_ANIMALI = 2200;
	private static final double PROBABILITA_CARNIVORO = 0.2;

	private int dimensione;	
	private Map<Posizione, Animale> posizione2Animale;		

	public Territorio(int dimensione){
		this.dimensione = dimensione;
		this.posizione2Animale = new HashMap<Posizione, Animale>();
		this.popolaTerritorio();
	}
	
	public Animale getAnimale(Posizione posizione){
		return posizione2Animale.get(posizione);
	}
	
	public void rimuoviAnimale(Animale animale) {
		this.posizione2Animale.remove(animale.getPosizione());
	}

	public void setAnimale(Animale animale, Posizione posizione) {
		if (this.getAnimale(posizione)==null){
			this.posizione2Animale.put(posizione, animale);
			animale.setPosizione(posizione);
		} 
	}
	
	public Collection<Animale> getAnimali(){
		return this.posizione2Animale.values();
	}

	
	public void sposta(Animale animale, Posizione nuovaPosizione) {
		this.rimuoviAnimale(animale);
		this.setAnimale(animale, nuovaPosizione);		
	}	
	
	public List<Posizione> adiacenti(Posizione posizione) {
		List<Posizione> adiacenti = new LinkedList<Posizione>();
		int x = posizione.getX();
		int y = posizione.getY();
		
		for(int i = -1; i<2; i++) {
			for(int j = -1; j<2; j++) {
				adiacenti.add(new Posizione(x+i, y+j));
				}
			}
		Iterator<Posizione> it = adiacenti.iterator();
		while(it.hasNext()){
			Posizione p = it.next();
			if ((p.getX()<0) || (p.getX()>=this.dimensione) || (p.getY()<0) || 
					(p.getY()>=this.dimensione) || (p.equals(posizione)))
				it.remove();
		}
		Collections.shuffle(adiacenti);
		return adiacenti;
	} 
	
	public Posizione posizioneLiberaVicino(Posizione posizione) {
		for(Posizione p : this.adiacenti(posizione)) {
			if (this.isLibera(p)) {
				return p;
			}
		}
		return null;
	}
	
	public boolean isLibera(Posizione posizione) {
			if (this.getAnimale(posizione)==null)  {
				return true;
			} else
		return false;
	}

	public int getDimensione() {
		return this.dimensione;
	}
	
	private void popolaTerritorio(){

		int numeroAnimali = 0;

		while (numeroAnimali < NUM_INIZIALE_ANIMALI) {
			int x = (int)(Math.random()*this.dimensione);
			int y = (int)(Math.random()*this.dimensione);
			Posizione posizione = new Posizione(x, y);
			if (this.isLibera(posizione)) {
				if(Math.random() < PROBABILITA_CARNIVORO) {
					Carnivoro nuovoAnimale = new Carnivoro();
					this.setAnimale(nuovoAnimale, posizione);
				} else {
					Erbivoro nuovoAnimale = new Erbivoro();
					this.setAnimale(nuovoAnimale, posizione);
				}
				numeroAnimali++;
			}
		}
	}

	Set<Posizione> posizioniErbivoriVecchi(){
		Set<Posizione> PosOldErb= new HashSet<Posizione>();
		Iterator<Animale> iter= this.posizione2Animale.values().iterator();
		int max=0;    //se c'è, è il valore minimo
		Animale animale;
			while(iter.hasNext()) {
				animale= iter.next();
				if(animale.getAnni()>max && iter.getClass().equals(Erbivoro.class))
					max=animale.getAnni();
			}
		Iterator<Animale> iter2= this.posizione2Animale.values().iterator();
		while(iter2.hasNext()) {
			Animale anim= iter2.next();
			if(anim.getAnni()==max &&  anim.getClass().equals(Erbivoro.class)) {
				PosOldErb.add(anim.getPosizione());
			}
		}
		return PosOldErb;
	}

	Map<Integer, Set<Erbivoro>> anno2erbivori(){
		Map<Integer, Set<Erbivoro>> mappa= new HashMap<>();
		List<Animale> lista = new ArrayList<Animale>(this.posizione2Animale.values());
		for(Animale anim:lista) {
			if(anim.getClass().equals(Erbivoro.class)){
				Integer numero= new Integer(anim.getAnni());
				if(!mappa.containsKey(numero)) {
					Set<Erbivoro> erbi= new HashSet<Erbivoro>();
					erbi.add((Erbivoro)anim);
					mappa.put(numero, erbi);
				}
				else {
					Set<Erbivoro> erbi= mappa.get(numero);
					erbi.add((Erbivoro)anim);
					mappa.put(numero, erbi);
				}
			}
		}
		return mappa;
	}
	
}
