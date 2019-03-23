package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	private Giocatore Tester;
	private Attrezzo ascia;
	private Attrezzo scudo;
	private Attrezzo spadone;


	@Before
	public void setUp() throws Exception {
		Tester= new Giocatore();
		ascia= new Attrezzo("Ascia",5);
		scudo= new Attrezzo("Scudo",4);
		spadone= new Attrezzo("Spadone", 11);      //peso eccessivo

		
	}

	@Test
	public void testRemoveAttrezzoDueVolte() {
		Tester.addAttrezzo(ascia);
		assertTrue(Tester.removeAttrezzo(ascia));
		assertFalse(Tester.removeAttrezzo(ascia));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		Tester.addAttrezzo(ascia);
		assertTrue(Tester.removeAttrezzo(ascia));
	}
	
	@Test
	public void testRemoveAttrezzoNonInPossesso() {
		assertFalse(Tester.removeAttrezzo(scudo));
	}
	
	@Test
	public void testAddAttrezzo() {
		assertTrue(Tester.addAttrezzo(ascia));
	}
	
	@Test
	public void testAddAttrezzoPesoEccessivo() {
		assertFalse(Tester.addAttrezzo(spadone));
	}
	
	@Test
	public void testSetCfu() {
		Tester.setCfu(22);
		assertEquals(22,Tester.getCfu());
	}

}
