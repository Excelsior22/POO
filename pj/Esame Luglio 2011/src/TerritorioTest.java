import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Set;


public  class TerritorioTest {
	private Territorio terr;
	private Animale erb1;
	private Animale erb2;
	private Animale erb3;

	@Before
	public void setUp() throws Exception {
		terr= new Territorio(5);
		erb1= new Erbivoro();
		erb2=new Erbivoro();
		erb3= new Erbivoro();
	}

	@Test
	public void testAnno2erbivori_empty() {
		Map<Integer, Set<Erbivoro>> mappa= this.terr.anno2erbivori();
		assertTrue(mappa.isEmpty());
	}
	
	@Test
	public void testAnno2erbivori_1erb() {
		erb1.agisci(terr);
		terr.setAnimale(erb1, new Posizione(0,0));
		Map<Integer, Set<Erbivoro>> mappa= this.terr.anno2erbivori();
		assertEquals(1, mappa.size());
		assertEquals(1,mappa.get(new Integer(1)).size());
	}
	
	@Test
	public void testAnno2erbivori_piuErb() {
		erb1.agisci(terr);
		erb2.agisci(terr);
		terr.setAnimale(erb1, new Posizione(0,0));
		terr.setAnimale(erb2, new Posizione(1,1));
		terr.setAnimale(erb3, new Posizione(1,0));
		Map<Integer, Set<Erbivoro>> mappa= this.terr.anno2erbivori();
		assertEquals(3, mappa.size());
		assertEquals(2,mappa.get(new Integer(1)).size());
		assertEquals(1,mappa.get(new Integer(0)).size());
	}
	

}