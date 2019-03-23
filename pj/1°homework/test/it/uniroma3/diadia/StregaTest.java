package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Strega;

public class StregaTest {

	private Strega strega;
	private Partita partita;
	private Stanza stanza0;
	private Stanza stanza_oggetto;
	private Stanza stanza_vuota;
	private Attrezzo oggetto;
	
	@Before
	public void setUp() throws Exception {
		partita= new Partita();
		strega= new Strega("Strega");
		stanza0= new Stanza("stanza0");
		stanza_oggetto= new Stanza("stanza con oggetto");
		stanza_vuota= new Stanza("stanza vuota");
		oggetto= new Attrezzo("oggetto", 1);
		partita.setStanzaCorrente(stanza0);
		stanza0.impostaStanzaAdiacente("nord", stanza_oggetto);
		stanza_oggetto.addAttrezzo(oggetto);
		stanza0.impostaStanzaAdiacente("sud", stanza_vuota);
	}

	
	@Test
	public void testSaluta() {
		assertFalse(strega.haSalutato());
		strega.saluta();
		assertTrue(strega.haSalutato());
	}
	
	@Test
	public void testAgisci_non_salutata(){
		strega.agisci(partita);
		assertSame(stanza_vuota, this.partita.getStanzaCorrente());
	}
	
	@Test
	public void testAgisci_salutata() {
		strega.saluta();
		strega.agisci(partita);
		assertSame(stanza_oggetto, this.partita.getStanzaCorrente());
	}
	


}
