package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class ComandoPrendiTest {
	Partita game1;
	Comando comando;
	Stanza TestingRoom;
	Attrezzo Martello;

	@Before
	public void setUp() throws Exception {
		game1= new Partita();
		comando= new ComandoPrendi();
		comando.setParametro("osso");
		TestingRoom= new Stanza("Testing Room");
	}

	@Test
	public void testEseguiBase() {
		comando.esegui(game1);
		assertTrue(game1.hasAttrezzo("osso"));
	}
	
	@Test
	public void testEseguiStanzaVuota() {
		game1.setStanzaCorrente(TestingRoom);
		comando.esegui(game1);
		assertFalse(game1.hasAttrezzo("osso"));
	}
	
	@Test
	public void testEseguiAttrezzoParametroNullo() {
		comando.setParametro(null);
		comando.esegui(game1);
		assertFalse(game1.hasAttrezzo("osso"));
	}
}
