package battlefield;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/* Modificare la classe Position affinche' 
 * il primo test abbia successo (vedi DOMANDA 1) 
 */
public class BattlefieldTest {
	private Walker w1;
	private Chaser c1;
	
	private Battlefield field;
	
	@Before
	public void setUp() throws Exception {
		this.field = new Battlefield(2);
		w1= new Walker(new Position(0,0));
		c1= new Chaser(new Position(3,3));
	}

	@Test
	public void testAddWalker() {
		assertEquals(0, this.field.getAllRobots().size());
		this.field.addWalker(new Walker(new Position(0,0)));
		assertEquals(1, this.field.getAllRobots().size());
	}
	
	@Test
	public void testRaggruppaRobotDiDueTipiDiversi() {
		this.field.addWalker(w1);
		this.field.addChaser(c1);
		@SuppressWarnings("rawtypes")
		Map<Class, Set<Robot>> mappa= this.field.raggruppaRobotPerTipo();
		assertTrue(mappa.get(c1.getClass()).contains(c1));
		assertTrue(mappa.get(w1.getClass()).contains(w1));
		assertEquals(1, mappa.get(c1.getClass()).size());
	
		
	}

}
