package battlefield;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/* Modificare la classe Position affinche'
 * questi test abbiano successo 
 * (Vedi DOMANDA 1)
 */
public class PositionTest {

	@Test
	public void testEquals() {
		assertEquals(new Position(0,0), new Position(0,0));
	}
	
	@Test
	public void testSetDiPosition() {
		Set<Position> insieme = new HashSet<>();
		Position p0 = new Position(0,0);
		Position p1 = new Position(0,0);
		assertNotSame(p0, p1);
		insieme.add(p0);
		insieme.add(p1);
		assertEquals("due oggetti Position distinti ma con le stesse coordinate dovrebbero contare 1!",
					 1, insieme.size());
	}

	
}
