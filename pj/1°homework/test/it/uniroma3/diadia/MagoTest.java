package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.personaggi.Mago;

public class MagoTest{
	
	private Mago merlino;
	private Stanza stanzatest;
	private Partita partita;

	@Before
	public void setUp() throws Exception {
		
		merlino= new Mago("Merlino");
		stanzatest= new Stanza("Stanzatest");
		partita= new Partita();
		partita.setStanzaCorrente(stanzatest);
		
	}
	
	@Test 
	public void saluta() {
		assertFalse(merlino.haSalutato());
		merlino.saluta();
		assertTrue(merlino.haSalutato());
	}

	@Test
	public void testAgisci() {
		merlino.agisci(partita);
		assertEquals("Bacchetta magica", stanzatest.getAttrezzi().get("Bacchetta magica").getNome());
		int numero_attrezzi= stanzatest.getAttrezzi().size();  //1
		merlino.agisci(partita);
		assertEquals(1, numero_attrezzi);
		
	}
	
	


}
