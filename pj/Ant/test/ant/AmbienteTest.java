package ant;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AmbienteTest {

	private Ambiente amb1;
	private Ambiente amb2;
	

	@Before
	public void setUp() throws Exception {
		amb1= new Ambiente(3);
		amb2= new Ambiente(5);
	}

	@Test
	public void test_Nessunadirezione() {
		Set<Direzione>  dir= amb1.getPossibiliDirezioni(new Coordinate(1,1));
		assertEquals(0, dir.size());
	}
	
	@Test
	public void test_3direzione() {
		Set<Direzione>  dir= amb2.getPossibiliDirezioni(new Coordinate(1,1));
		assertEquals(3, dir.size());
	}
	
	@Test
	public void test_8direzione() {
		Set<Direzione>  dir= amb2.getPossibiliDirezioni(new Coordinate(2,2));
		assertEquals(8, dir.size());
	}

}
