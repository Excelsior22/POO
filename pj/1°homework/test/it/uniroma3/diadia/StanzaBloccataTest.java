package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	private Stanza testRoom;
	private StanzaBloccata lockedRoom;
	private Attrezzo chiave;
	private Attrezzo candela;
	private Stanza anotherRoom;

	@Before
	public void setUp() throws Exception {
		testRoom= new Stanza("test room");
		anotherRoom= new Stanza("another room");
		chiave= new Attrezzo("chiave", 1);
		candela= new Attrezzo("candela", 2);
		lockedRoom= new StanzaBloccata("locked room","nord","chiave");
		lockedRoom.impostaStanzaAdiacente("nord", testRoom);
		lockedRoom.impostaStanzaAdiacente("est", anotherRoom);
	}

	@Test
	public void testGetStanzaAdiacenteStanzaDirezioneLibera() {
		assertEquals("another room", lockedRoom.getStanzaAdiacente("est").getNome());
	}
	
	@Test
	public void testGetStanzaAdiacenteStanzaSbloccaDirezioneBloccata() {
		lockedRoom.addAttrezzo(chiave);
		assertSame(testRoom, lockedRoom.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteStanzaDirezioneBloccata() {
		lockedRoom.addAttrezzo(candela);
		assertSame(lockedRoom, lockedRoom.getStanzaAdiacente("nord"));
	}
	

}
