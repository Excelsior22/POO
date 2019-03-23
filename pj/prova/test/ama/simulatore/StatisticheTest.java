package ama.simulatore;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ama.Posizione;
import ama.mezzo.Brown;
import ama.mezzo.Chase;
import ama.mezzo.Mezzo;
import ama.rifiuto.Rifiuto;
import ama.rifiuto.Vetro;

public class StatisticheTest {

	private Simulatore simulatore;

	private Statistiche stats;	
	private Set<Rifiuto> rifiuti;
	
	final static private Posizione ORIGINE = new Posizione(0, 0);
	
	@Before
	public void setUp() throws Exception {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();
		this.rifiuti= new HashSet<>();
	}

	/* N.B. E' POSSIBILE USARE I  METODI CHE SEGUONO (E CREARNE DI SIMILARI) 
	 * PER VELOCIZZARE IL TESTING RELATIVO ALLE DOMANDE 3 E SUCCESSIVE */
	private Vetro creaVetroRaccoltoDaBrowniano() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaBrowniano());	
		return rifiuto;
	}

	
	private Vetro creaVetroRaccoltoDaChaser() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaChaser());	
		return rifiuto;
	}
	
	/* N.B. E' POSSIBILE USARE I METODI SOPRA (E CREARNE DI SIMILARI) 
	 * PER VELOCIZZARE IL TESTING RELATIVO ALLE DOMANDE 3 E SUCCESSIVE */
	
	@Test
	public void testRaccoltoPerMezzo() {
		this.rifiuti.add(this.creaVetroRaccoltoDaBrowniano());
		this.rifiuti.add(this.creaVetroRaccoltoDaChaser());
		this.rifiuti.add(this.creaVetroRaccoltoDaChaser());
		Map<Mezzo, Integer> mappa= stats.raccoltoPerMezzo(rifiuti);
		/* DA COMPLETARE VEDI DOMANDA 3 */
		assertEquals(3, mappa.entrySet().size());
	}

	
	@Test
	public void testRaccoltoPerPolitica() {
		/* DA COMPLETARE VEDI DOMANDA 4 */
		this.rifiuti.add(this.creaVetroRaccoltoDaBrowniano());
		this.rifiuti.add(this.creaVetroRaccoltoDaChaser());
		this.rifiuti.add(this.creaVetroRaccoltoDaChaser());
		Map<Class<?>, Integer> mappa= stats.raccoltoPerPolitica(rifiuti);
		assertEquals(1, mappa.get(Brown.class).intValue());
		assertEquals(2, mappa.get(Chase.class).intValue());
	}
	
	/*                              */
	/* DA COMPLETARE VEDI DOMANDA 6 */
	/*                              */
	
	@Test
	public void ordinaPolitichePerRaccolta_empty(){
		Map<Class<?>, Integer> mappa= stats.raccoltoPerPolitica(rifiuti);
		List<Class<?>> lista= stats.ordinaPolitichePerRaccolta(mappa);
		assertTrue(lista.isEmpty());
		
	}
	
	
	
	@Test
	public void ordinaPolitichePerRaccolta_UnaPolitica(){
		this.rifiuti.add(this.creaVetroRaccoltoDaChaser());
		Map<Class<?>, Integer> mappa= stats.raccoltoPerPolitica(rifiuti);
		List<Class<?>> lista= stats.ordinaPolitichePerRaccolta(mappa);
		
		assertEquals(Chase.class, lista.get(0));
		
	}
	
	
	
	@Test
	public void ordinaPolitichePerRaccolta_PiuPolitiche(){
		this.rifiuti.add(this.creaVetroRaccoltoDaBrowniano());
		this.rifiuti.add(this.creaVetroRaccoltoDaChaser());
		this.rifiuti.add(this.creaVetroRaccoltoDaChaser());
		Map<Class<?>, Integer> mappa= stats.raccoltoPerPolitica(rifiuti);
		List<Class<?>> lista= stats.ordinaPolitichePerRaccolta(mappa);
		assertEquals(Brown.class, lista.get(0));
		assertEquals(Chase.class, lista.get(1));
	}

}
