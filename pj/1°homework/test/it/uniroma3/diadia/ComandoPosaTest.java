package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {
	private Partita game1;
	private Attrezzo scudo;
	private Comando comando;

	@Before
	public void setUp() throws Exception {
		game1= new Partita();
		scudo= new Attrezzo("Scudo", 3);
		comando= new ComandoPosa();
		comando.setParametro("Scudo");
		
	}

	@Test
	public void testEseguiBase() {
		game1.addAttrezzo(scudo);                //metto
		assertTrue(game1.hasAttrezzo("Scudo"));     
		comando.esegui(game1);                   //tolgo 
		assertFalse(game1.hasAttrezzo("Scudo"));    
	}
	
	@Test
	public void testEseguiEmpty() {
		comando.esegui(game1);
		assertFalse(game1.hasAttrezzo("Scudo"));
	}
	@Test
	public void testEseguiNonPresente() {
		game1.addAttrezzo(scudo);
		assertFalse(game1.hasAttrezzo("mantello"));
		
	}

}
