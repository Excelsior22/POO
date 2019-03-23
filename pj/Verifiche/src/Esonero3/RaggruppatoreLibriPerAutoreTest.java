package Esonero3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class RaggruppatoreLibriPerAutoreTest {
	Libro2 l1;
	Libro2 l2;
	Libro2 l3;
	RaggruppatoreLibriPerAutore rag;
	List<Libro2> li1;
	List<Libro2> li2;
	Map<String, List<Libro2>> risultato;
	Map<String, List<Libro2>> output;
	

	@Before
	public void setUp() throws Exception {
		l1= new Libro2("aaa","b");
		l2= new Libro2("bbb", "a");
		l3= new Libro2("ccc", "b");
		li1= new ArrayList<Libro2>();
		li2= new ArrayList<Libro2>();
		li1.add(l2);
		li2.add(l1);
		li2.add(l3);
		risultato= new HashMap<String, List<Libro2>>();
		
		risultato.put("a", li1);
		risultato.put("b", li2);
		
		/*------------------*/
		rag= new RaggruppatoreLibriPerAutore();
		rag.aggiungiLibro(l1);
		rag.aggiungiLibro(l2);
		rag.aggiungiLibro(l3);
		output= rag.autore2libri();
		
	}

	@Test
	public void testRaggruppatoreLibriPerAutore_l1() {
		assertEquals(risultato.get("a").get(0), output.get("a").get(0));
	}
	
	@Test
	public void testRaggruppatoreLibriPerAutore_l3() {
		assertEquals(risultato.get("b").get(0), output.get("b").get(0));
	}
	@Test
	public void testRaggruppatoreLibriPerAutore_l2() {
		assertEquals(risultato.get("b").get(1), output.get("b").get(1));
	}

	


}
