package ant.simulatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ant.Cibo;
import ant.Coordinate;
import ant.formica.Esploratrice;
import ant.formica.Inseguitrice;

@SuppressWarnings("unused")
public class StatisticheTest {

	private Simulatore simulatore;

	private Statistiche stats;	
	
	final private Coordinate origine = new Coordinate(0, 0);
	
	private Esploratrice formica ;
	private Inseguitrice altraFormica ;
	
	@Before
	public void setUp() throws Exception {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();
		this.formica = this.simulatore.creaEsploratrice();
		this.altraFormica = this.simulatore.creaInseguitrice();
	}

	
	private Cibo creaCiboRaccoltoDaEsploratrice() {
		final Cibo cibo = new Cibo(this.origine);
		cibo.setRaccoglitrice(this.simulatore.creaEsploratrice());	
		return cibo;
	}

	private Cibo creaCiboRaccoltoDaInseguitore() {
		final Cibo cibo = new Cibo(this.origine);
		cibo.setRaccoglitrice(this.simulatore.creaInseguitrice());	
		return cibo;
	}
	
	private Cibo creaCiboRaccoltoDaAggressiva() {
		final Cibo cibo = new Cibo(this.origine);
		cibo.setRaccoglitrice(this.simulatore.creaAggressiva());	
		return cibo;
	}

	@Test
	public void testRaccoltoPerFormica() {
		// DA COMPLETARE ( VEDI DOMANDA 3 ) SUGG.: USARE I METODI FACTORY SOPRA
		
		Set<Cibo> raccolto=new HashSet<>();
		raccolto.add(this.creaCiboRaccoltoDaAggressiva());
		
		assertTrue(!this.stats.raccoltoPerFormica(raccolto).isEmpty());
	}
	
	@Test
	public void testRaccoltoPerFormica_empty() {
		// DA COMPLETARE ( VEDI DOMANDA 3 ) SUGG.: USARE I METODI FACTORY SOPRA
		
		Set<Cibo> raccolto=new HashSet<>();
		assertTrue(this.stats.raccoltoPerFormica(raccolto).isEmpty());
	}
	
	@Test
	public void testRaccoltoPerFormica_notEmpty() {
		// DA COMPLETARE ( VEDI DOMANDA 3 ) SUGG.: USARE I METODI FACTORY SOPRA
		
		Set<Cibo> raccolto=new HashSet<>();
		raccolto.add(this.creaCiboRaccoltoDaAggressiva());
		raccolto.add(this.creaCiboRaccoltoDaEsploratrice());
		
		assertEquals(2, this.stats.raccoltoPerFormica(raccolto).size());
	}
	
	@Test
	public void testRaccoltoPerTipoDiFormica() {
		// DA COMPLETARE ( VEDI DOMANDA 4 ) SUGG.: USARE I METODI FACTORY SOPRA
	}
	
}
