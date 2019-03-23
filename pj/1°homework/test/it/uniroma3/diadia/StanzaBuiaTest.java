package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	
	private StanzaBuia darkRoom;
	private Attrezzo candela;
	private Attrezzo chiave;
	
	@Before
	public void setUp() throws Exception {

		darkRoom= new StanzaBuia("dark room","candela");
		candela= new Attrezzo("candela", 1);
		chiave= new Attrezzo("chiave", 2);
	}
	
	@Test
	public void testGetDescrizioneSenzaOggetto() {
		assertEquals("qui c'è un buio pesto", darkRoom.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneConOggettoGiusto() {
		darkRoom.addAttrezzo(candela);
		assertFalse(darkRoom.getDescrizione()=="qui c'è un buio pesto");
	}
	
	@Test
	public void testGetDescrizioneConOggettoSbagliato() {
		darkRoom.addAttrezzo(chiave);
		assertTrue(darkRoom.getDescrizione()=="qui c'è un buio pesto");
	}
	

}
