package ama;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/** 
 * Modificare la classe Posizione affinché 
 * questi test abbiano successo <B>(Vedi DOMANDA 1)</B>
 */
public class PosizioneTest {

	@Test
	public void testEquals() {
		assertEquals(new Posizione(0,0), new Posizione(0,0));
	}
	
	@Test
	public void testSetDiPosition() {
		final Set<Posizione> insieme = new HashSet<>();
		final Posizione fratello = new Posizione(0,0);
		final Posizione gemello = new Posizione(0,0);
		assertNotSame(fratello, gemello);
		insieme.add(fratello);
		insieme.add(gemello);
		assertEquals("due oggetti Posizione distinti ma con le stesse coordinate dovrebbero contare 1!",
					 1, insieme.size());
	}

	
}
