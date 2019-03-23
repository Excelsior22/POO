

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulatore {

	private static final int PASSI = 10;
	private static final int DIMENSIONE = 50;

	private Territorio territorio;
	private VisualizzatoreTerritorio visualizzatore;
	
	public Simulatore(){
		this.territorio = new Territorio(DIMENSIONE);
		this.visualizzatore = new VisualizzatoreTerritorio(DIMENSIONE);
	}

	public void run(){
		for(int i=0;i<PASSI; i++) {
			List<Animale> animali = new ArrayList<Animale>(this.territorio.getAnimali());
			Collections.shuffle(animali);
			for(Animale a : animali) {
				a.agisci(territorio);
			}
			this.visualizzatore.aggiornaSchermata(i, this.territorio);
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Simulatore s = new Simulatore();
		s.run();
	}
}
