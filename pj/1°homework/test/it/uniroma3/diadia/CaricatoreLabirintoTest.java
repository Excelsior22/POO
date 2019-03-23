package it.uniroma3.diadia;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class CaricatoreLabirintoTest {

	Labirinto monolocale;
	Labirinto uni;
	Attrezzo penna;

	@Before
	public void setUp() throws Exception {
		this.monolocale= new Labirinto("LabirintoMonoTest.txt");
		this.uni= new Labirinto("Labirinto.txt");
		this.penna= new Attrezzo("penna",1);
		
	}
	
	@Test
	public void testStanzaVincenteCaricata_mono() {
		assertEquals("N10",monolocale.getStanzaVincente().getNome());
		
	}

	@Test
	public void testStanzaVincenteCaricata_uni() {
		assertEquals("biblioteca",uni.getStanzaVincente().getNome());
		
	}
	
	@Test
	public void testStanzaInizialeCaricata_mono() {
		assertEquals("N10",monolocale.getStanzaCorrente().getNome());
		
	}

	@Test
	public void testStanzaInizialeCaricata_uni() {
		assertEquals("atrio",uni.getStanzaCorrente().getNome());
		
	}
	
	@Test
	public void testCaricatoreLabirinto_mono_hasAttrezzo() {
		Stanza stanza= this.monolocale.getStanzaCorrente();
		assertTrue(stanza.hasAttrezzo("pinza"));
	}
	
	@Test
	public void testCaricatoreLabirinto_mono_direzioni() {
		Stanza stanza= this.monolocale.getStanzaCorrente();
		assertTrue(stanza.getStanzeAdiacenti().isEmpty());
	}
	
	@Test
	public void testCaricatoreLabirinto_uni_direzioni() {
		Stanza stanza= this.uni.getStanzaCorrente();
		assertFalse(stanza.getStanzeAdiacenti().isEmpty());
	}
	
	@Test
	public void testCaricatoreLabirinto_uni_stanzaadiacente() {
		Stanza stanza= this.uni.getStanzaCorrente();
		assertEquals("biblioteca",stanza.getStanzeAdiacenti().get("nord").getNome());
	}
	
	


	
}
