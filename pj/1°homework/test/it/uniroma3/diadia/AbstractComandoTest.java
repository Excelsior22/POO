package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.ComandoFine;

import it.uniroma3.diadia.comandi.ComandoAiuto;

public class AbstractComandoTest {
	private Partita partita;
	private ComandoAiuto aiuto;
	private ComandoFine fine;
	

	@Before
	public void setUp() throws Exception {
		aiuto = new ComandoAiuto();
		partita= new Partita();
		fine= new ComandoFine();
	}

	@Test
	public void testNomeComando() {
		assertEquals("aiuto", aiuto.getNome());
	}
	
	
	@Test
	public void testEseguiComando() {
		fine.esegui(this.partita);
		assertTrue(this.partita.isFinita());
	}

}
