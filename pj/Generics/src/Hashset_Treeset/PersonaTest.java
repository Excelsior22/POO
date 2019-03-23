package Hashset_Treeset;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

import org.junit.Test;

public class PersonaTest {

	@Test
	public void test(){
	
		Set<Persona> s= new TreeSet<Persona>();
		
		Persona paolo= new Persona("Paolo");
		Persona valter= new Persona("Valter");
		assertTrue(s.add(paolo));
		assertTrue(s.add(valter));
		assertFalse(s.add(valter));
		assertEquals(2,s.size());
		Iterator<Persona> it= s.iterator();
		assertSame(paolo, it.next());
		assertSame(valter,it.next());
		
	}

}
