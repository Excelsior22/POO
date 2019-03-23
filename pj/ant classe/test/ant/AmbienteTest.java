package ant;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AmbienteTest {

	
	private Ambiente gabbia;
	private Ambiente ambiente5x5;

	@Before
	public void setUp() throws Exception {
		this.gabbia=new Ambiente(3);
		this.ambiente5x5=new Ambiente(5);
	}

	@Test
	public void testGetPossibiliDirezioni_bloccata() {
		assertTrue(this.gabbia.getPossibiliDirezioni(new Coordinate(1, 1)).isEmpty());
	}
	
	@Test
	public void testGetPossibiliDirezioni_libera() {
		assertEquals(8, this.ambiente5x5.getPossibiliDirezioni(new Coordinate(2, 2)).size());
	}

	@Test
	public void testGetPossibiliDirezioni_bordo() {
		assertEquals(5, this.ambiente5x5.getPossibiliDirezioni(new Coordinate(1, 2)).size());
	}
}
