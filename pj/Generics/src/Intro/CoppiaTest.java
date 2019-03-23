package Intro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoppiaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCoppiaDiPersona() {
		Coppia<Persona> coppia;
		Persona P1= new Persona("Stanlio");
		Persona P2= new Persona("olio");
		coppia= new Coppia<Persona>(P1,P2);
		assertSame(P1, coppia.getPrimo());
		assertSame(P2, coppia.getSecondo());
	}
	
	@Test
	public void testCoppiaDiInteri() {
		Coppia<Integer> coppia;
		Integer i1= new Integer(100);
		Integer i2= new Integer(1000);
		coppia= new Coppia<Integer>(i1,i2);
		assertEquals(100, coppia.getPrimo().intValue());
	}




}
