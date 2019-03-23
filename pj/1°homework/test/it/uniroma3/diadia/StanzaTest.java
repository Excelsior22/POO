package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;


public class StanzaTest {
	private Stanza bagno;
	private Stanza corridoio;
	private Stanza teatro;
	private Attrezzo martello;
	private Attrezzo chiodo;
	
	
	@Before
	public void SetUp() throws FileNotFoundException, IOException{
		bagno= new Stanza("bagno");
		corridoio= new Stanza("corridoio");
		teatro= new Stanza("teatro");
		martello= new Attrezzo("martello", 10);
		chiodo= new Attrezzo("chiodo", 1);
	}

	@Test
	public void testGetStanzaAdiacenteGiusta() {
		corridoio.impostaStanzaAdiacente("sud", bagno);
		assertEquals(bagno, this.corridoio.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetStanzaAdiacenteStessoOggetto() {
		corridoio.impostaStanzaAdiacente("sud", bagno);
		assertSame(bagno, this.corridoio.getStanzaAdiacente("sud"));
	}
	@Test
	public void testGetStanzaAdiacenteSbagliata() {
		corridoio.impostaStanzaAdiacente("sud", bagno);
		corridoio.impostaStanzaAdiacente("ovest", teatro );
		assertEquals(null, corridoio.getStanzaAdiacente("est"));
	}

	@Test
	public void testAddAttrezzo() {
		assertTrue(corridoio.addAttrezzo(martello));
	}
	
	@Test
	public void testHasAttrezzoPresente() {
		corridoio.addAttrezzo(martello);
		assertTrue(corridoio.hasAttrezzo("martello"));
		assertFalse(corridoio.hasAttrezzo("lingotto d'oro"));	
	}
	
	@Test
	public void testHasAttrezzoAssente() {
		assertFalse(corridoio.hasAttrezzo("lingotto d'oro"));	
	}
	
	@Test
	public void testHasAttrezzoSbagliato() {
		corridoio.addAttrezzo(martello);
		assertFalse(corridoio.hasAttrezzo("Falce"));	

	}

	@Test
	public void testGetAttrezzoPresente() {
		corridoio.addAttrezzo(martello);
		assertEquals(martello, corridoio.getAttrezzo("martello"));
	}
	
	@Test
	public void testGetAttrezzoNonPresente() {
		assertNull(corridoio.getAttrezzo("uova"));
	}
	
	@Test
	public void testRemoveAttrezzoPresente() {
		corridoio.addAttrezzo(martello);
		assertTrue(corridoio.removeAttrezzo(martello));
	}
	
	@Test
	public void testRemoveAttrezzoNonPresente() {
		corridoio.addAttrezzo(martello);
		assertFalse(corridoio.removeAttrezzo(chiodo));
	}
	
	@Test
	public void testRemoveAttrezzoStanzaVuota() {
		assertFalse(corridoio.removeAttrezzo(chiodo));
	}
	
	@Test
	public void testGetDirezioni() {
		this.corridoio.impostaStanzaAdiacente("sud", bagno);
		assertEquals("sud", this.corridoio.getDirezioni().get(0).name());
	}


}
