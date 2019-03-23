package ama.simulatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;

import org.junit.Before;
import org.junit.Test;

import ama.mezzo.Mezzo;

public class MezziOrdinatiPerPoliticaTest {

	
	private Simulatore simulatore;
	
	private Statistiche stats;

	private Mezzo brown;
	private Mezzo chase;
	
	@Before
	public void setUp() throws Exception {
		this.simulatore = new Simulatore();
		this.stats = new Statistiche();
		this.brown = this.simulatore.creaBrowniano();
		this.chase = this.simulatore.creaChaser();
	}

	/* (vedi DOMANDA 6)	per l'utilizzo dei seguenti test-case */
	@Test
	public void testMezziOrdinatiPerRaccolta_equals() {
		final Map<Mezzo,Integer> mezzo2quantita = new HashMap<>();
		mezzo2quantita.put(this.brown,0); // n.b. raccolti 0;
		mezzo2quantita.put(this.chase,0); // n.b. raccolti 0;
		assertEquals(2, this.stats.ordinaMezziPerRaccolta(mezzo2quantita).size());
	}

	@Test
	public void testMezziOrdinatiPerRaccolto_stessoRaccoltoMaTipoDiverso() {
		final Map<Mezzo,Integer> mezzo2quantita = new HashMap<>();
		mezzo2quantita.put(this.brown,0); // n.b. raccolti 0;
		mezzo2quantita.put(this.chase,0); // n.b. raccolti 0;
		assertEquals(2, this.stats.ordinaMezziPerRaccolta(mezzo2quantita).size());
	}

	@Test
	public void testMezziOrdinatiPerRaccoltoTest_raccoltiDiverse() {
		final Map<Mezzo,Integer> mezzo2quantita = new HashMap<>();
		final Mezzo aSecco = this.simulatore.creaBrowniano();
		final Mezzo prendiTutto = this.simulatore.creaChaser();
			
		mezzo2quantita.put(aSecco,0);        // n.b. raccolti 0;
		mezzo2quantita.put(prendiTutto,100); // n.b. raccolti 100;
		
		final SortedSet<Mezzo> perRaccolto = this.stats.ordinaMezziPerRaccolta(mezzo2quantita);
		assertEquals(2, perRaccolto.size());
		assertSame(prendiTutto, perRaccolto.first());
		assertSame(aSecco, perRaccolto.last());
	}

}
