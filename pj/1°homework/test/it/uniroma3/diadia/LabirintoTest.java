package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
	private Labirinto università;
	private Stanza stanzaTest;

	@Before
	public void setUp() throws Exception {
		università= new Labirinto("Labirinto.txt");
		stanzaTest= new Stanza("StanzaTest");
	}

	@Test
	public void testGetStanzaCorrenteDefault() {
		assertEquals("atrio", università.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testGetStanzaCorrente() {
		università.setStanzaCorrente(stanzaTest);
		assertEquals("StanzaTest", università.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testSetStanzaCorrenteDefault() {
		assertEquals("atrio", università.getStanzaCorrente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		università.setStanzaCorrente(stanzaTest);
		assertEquals("StanzaTest", università.getStanzaCorrente().getNome());
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals("biblioteca", università.getStanzaVincente().getNome());
	}

}
