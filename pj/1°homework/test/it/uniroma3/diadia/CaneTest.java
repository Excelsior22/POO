package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.Cane;

public class CaneTest {

	private Partita partita;
	private Cane milo;
	
	@Before
	public void setUp() throws Exception {
		partita= new Partita();
		milo= new Cane("Milo");
		this.partita.setCfu(10);
	}

	@Test
	public void testSaluta() {
		assertFalse(milo.haSalutato());
		milo.saluta();
		assertTrue(milo.haSalutato());
	}

	@Test
	public void testAgisci() {
		milo.agisci(partita);
		assertEquals(9,this.partita.getCfu());
	}
	


}
