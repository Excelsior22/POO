package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	private Borsa btest;
	private Attrezzo ascia;
	private Attrezzo scudo;
	private Attrezzo elmo;
	private Attrezzo mappa;
	private Attrezzo a1;
	private Attrezzo a2;
	private Attrezzo a3;
	private Attrezzo a4;
	private Attrezzo candela;
	
	


	@Before
	public void setUp() throws Exception {
		/*Un oggetto borsa con peso massimo 10 */
		btest= new Borsa(10);
		ascia= new Attrezzo("Ascia",5);
		scudo= new Attrezzo("Scudo",4);
		elmo= new Attrezzo("Elmo", 3);
		mappa= new Attrezzo("Mappa", 1);
		candela= new Attrezzo("Candela", 2);
		a1= new Attrezzo("a1",1);
		a2= new Attrezzo("a2", 2);
		a3= new Attrezzo ("a3", 3);
		a4= new Attrezzo("a4", 1);
		
		
		
	}

	@Test
	public void testAddAttrezzo() {
		assertTrue(btest.addAttrezzo(ascia));
	}
	
	@Test
	public void testAddAttrezzoPesoLimite() {
		assertTrue(btest.addAttrezzo(ascia));
		btest.addAttrezzo(scudo);
		assertTrue(btest.addAttrezzo(mappa));
	}
	
	@Test
	public void testAddAttrezzoPesoEccessivo() {
		btest.addAttrezzo(ascia);
		btest.addAttrezzo(scudo);
		assertFalse(btest.addAttrezzo(elmo));
		
	}

	@Test
	public void testGetAttrezzi() {
		btest.addAttrezzo(ascia);
		btest.addAttrezzo(scudo);
		assertTrue(btest.hasAttrezzo("Scudo"));
	}

	@Test
	public void testGetAttrezzoPresente() {
		btest.addAttrezzo(ascia);
		btest.addAttrezzo(scudo);
		assertSame(ascia, btest.getAttrezzo("Ascia"));
	}
	
	@Test
	public void testGetAttrezzoNonPresente() {
		btest.addAttrezzo(ascia);
		btest.addAttrezzo(scudo);
		assertNull(btest.getAttrezzo("Lancia"));
	}

	@Test
	public void testGetPeso() {
		btest.addAttrezzo(ascia);
		btest.addAttrezzo(scudo); 
		btest.addAttrezzo(mappa);         
		assertEquals(10,btest.getPeso());  
	}

	@Test
	public void testIsEmptyVuota() {
		assertTrue(btest.isEmpty());
		btest.addAttrezzo(ascia);
		assertFalse(btest.isEmpty());
	}
	
	@Test
	public void testIsEmptyNonVuota() {
		btest.addAttrezzo(ascia);
		assertFalse(btest.isEmpty());
	}

	@Test
	public void testRemoveAttrezzo() {
		btest.addAttrezzo(ascia);
		assertFalse(btest.removeAttrezzo(elmo));
		assertTrue(btest.removeAttrezzo(ascia));
	}
	
	@Test
	public void testGetContenutoOdinatoPerPeso_NomiEPesiDifferenti() {
		this.btest.addAttrezzo(ascia);
		this.btest.addAttrezzo(elmo);
		SortedSet<Attrezzo> SortedSetOrdinatoPerPeso= this.btest.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> iter= SortedSetOrdinatoPerPeso.iterator();
		assertTrue(SortedSetOrdinatoPerPeso.contains(ascia));
		assertTrue(SortedSetOrdinatoPerPeso.contains(elmo));
		assertEquals("Elmo", iter.next().getNome());
		assertEquals("Ascia", iter.next().getNome());
	}
	
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_NomiDifferentiPesiUguali() {
		
		this.btest.addAttrezzo(a1);
		this.btest.addAttrezzo(a2);
		this.btest.addAttrezzo(a3);
		this.btest.addAttrezzo(a4);
		List<Attrezzo> getContenutoOrdinatoPerPeso= this.btest.getContenutoOrdinatoPerPeso();
		List<Attrezzo> contenutoAtteso = Arrays.asList(a1,a4,a2,a3);
		assertTrue(getContenutoOrdinatoPerPeso.get(0).equals(contenutoAtteso.get(0)));
		assertTrue(getContenutoOrdinatoPerPeso.get(1).equals(contenutoAtteso.get(1)));
		assertTrue(getContenutoOrdinatoPerPeso.get(2).equals(contenutoAtteso.get(2)));
		assertTrue(getContenutoOrdinatoPerPeso.get(3).equals(contenutoAtteso.get(3)));
	}
	
	//Compara ancora per peso error
	@Test
	public void testGetContenutoOdinatoPerNome_NomiEPesiDifferenti() {
		
		this.btest.addAttrezzo(ascia);
		this.btest.addAttrezzo(elmo);
		SortedSet<Attrezzo> SortedSetOrdinatoPerNome= this.btest.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> iter= SortedSetOrdinatoPerNome.iterator();
		assertTrue(SortedSetOrdinatoPerNome.contains(ascia));
		assertTrue(SortedSetOrdinatoPerNome.contains(elmo));
		assertEquals("Ascia", iter.next().getNome());
		assertEquals("Elmo", iter.next().getNome());
	}
	
	@Test
	public void testGetContenutoOdinatoPerNome_NomiDiversiEPesiDiversi() {
	
		this.btest.addAttrezzo(mappa);
		this.btest.addAttrezzo(elmo);
		this.btest.addAttrezzo(candela);
		SortedSet<Attrezzo> getContenutoOrdinatoPerNome= this.btest.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> iter= getContenutoOrdinatoPerNome.iterator();
		
		assertEquals("Candela", iter.next().getNome());
		assertEquals("Elmo", iter.next().getNome());
		assertEquals("Mappa", iter.next().getNome());
	}
	

	@Test
	public void testGetContenutoRaggruppatoPerPeso_StessoPesoNomeDiverso() {
		this.btest.addAttrezzo(a1);  //1
		this.btest.addAttrezzo(a2);  //2
		this.btest.addAttrezzo(a3);  //3
		this.btest.addAttrezzo(a4);  //1
		
		Map<Integer,Set<Attrezzo>> attrezziWeight= btest.getContenutoRaggruppatoPerPeso();
		
		assertTrue(attrezziWeight.get(1).contains(a1));
		assertFalse(attrezziWeight.get(2).contains(a1));
		assertTrue(attrezziWeight.get(1).contains(a4));
		assertTrue(attrezziWeight.get(2).contains(a2));
		assertTrue(attrezziWeight.get(3).contains(a3));
	}
	
	
	

	
	


}
