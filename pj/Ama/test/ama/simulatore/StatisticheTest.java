package ama.simulatore;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ama.Posizione;
import ama.mezzo.Mezzo;
import ama.rifiuto.Rifiuto;
import ama.rifiuto.Vetro;

public class StatisticheTest {

	private Simulatore simulatore;

	private Statistiche stats;

	final static private Posizione ORIGINE = new Posizione(0, 0);

	private Vetro v1;
	private Vetro v2;


	@Before
	public void setUp() throws Exception {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();

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
		/* DA COMPLETARE VEDI DOMANDA 3 */

		v1= this.creaVetroRaccoltoDaBrowniano();
		v2= this.creaVetroRaccoltoDaChaser();

		Set<Rifiuto> rifiuti= new HashSet<Rifiuto>();
		rifiuti.add(v1);
		rifiuti.add(v2);
		Map<Mezzo, Integer> raccoltoPerMezzo= this.stats.raccoltoPerMezzo(rifiuti);
		assertTrue(raccoltoPerMezzo.containsKey(v1.getRaccoglitore()));
		assertEquals(1, raccoltoPerMezzo.get(v2.getRaccoglitore()).intValue());
	}

	@Test
	public void testRaccoltoPerPolitica_UnRifiuto() {
		/* DA COMPLETARE VEDI DOMANDA 4 */
		v1= this.creaVetroRaccoltoDaBrowniano();

		Set<Rifiuto> rifiuti= new HashSet<Rifiuto>();
		rifiuti.add(v1);

		Map<Class<?>, Integer> raccoltoPerPolitica= this.stats.raccoltoPerPolitica(rifiuti);
		assertEquals(1, raccoltoPerPolitica.get(v1.getRaccoglitore().getPolitica().getClass()).intValue());
	}

	@Test
	public void testRaccoltoPerPolitica_PiùRifiuti() {
		v1= this.creaVetroRaccoltoDaBrowniano();
		v2= this.creaVetroRaccoltoDaBrowniano();
		
		Set<Rifiuto> rifiuti= new HashSet<Rifiuto>();
		rifiuti.add(v1);
		rifiuti.add(v2);
		
		Map<Class<?>, Integer> raccoltoPerPolitica= this.stats.raccoltoPerPolitica(rifiuti);
		assertEquals(2, raccoltoPerPolitica.get(v2.getRaccoglitore().getPolitica().getClass()).intValue());
	}


	@Test
	public void testRaccoltoPerPolitica_NessunRifiuto() {
		v1= this.creaVetroRaccoltoDaBrowniano();
		v2= this.creaVetroRaccoltoDaChaser();
		
		Set<Rifiuto> rifiuti= new HashSet<Rifiuto>();
		rifiuti.add(v1);
		
		Map<Class<?>, Integer> raccoltoPerPolitica= this.stats.raccoltoPerPolitica(rifiuti);
		assertFalse(raccoltoPerPolitica.containsKey(v2.getRaccoglitore().getPolitica().getClass()));
		
	}


	/*                              */
	/* DA COMPLETARE VEDI DOMANDA 6 */
	/*                              */

}
