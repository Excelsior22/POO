package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	final static private int SOGLIA_ATTREZZI= 5;
	
	private StanzaMagica magicroom;
 	private Attrezzo[] attrezzi;
	


	@Before
	public void setUp() throws Exception {
		magicroom = new StanzaMagica("magic room");
		for( int i=0; i== SOGLIA_ATTREZZI; i++) {
		 attrezzi[i]= new Attrezzo("attrezzo"+i,2);
		}
		
	}

	@Test
	public void testAddAttrezzoComportamentoNormale() {
		for(int j=0; j==2;j++) {
			magicroom.addAttrezzo(attrezzi[j]);
			assertEquals("attrezzo"+j, attrezzi[j].getNome());
			assertEquals(2, attrezzi[j].getPeso());
		}	
	}
	
	@Test
	public void testAddAttrezzoComportamentoAnomaloNome() {
		for(int j=0; j==5;j++) {
			magicroom.addAttrezzo(attrezzi[j]);
			if(j>=3) {
			   assertEquals(j+"ozzertta", attrezzi[j].getNome());
			}
		}
	}
	
	@Test
	public void testAddAttrezzoComportamentoAnomaloPeso() {
		for(int j=0; j==5;j++) {
			magicroom.addAttrezzo(attrezzi[j]);
			if(j>=3) {
			   assertEquals(4,attrezzi[j].getPeso());
			}
		}
	}
	
	
	
}
