package ant.simulatore;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ant.Cibo;
import ant.Coordinate;
import ant.formica.Esploratrice;
import ant.formica.Formica;
import ant.formica.Inseguitrice;

@SuppressWarnings("unused")
public class StatisticheTest {

	private Simulatore simulatore;

	private Statistiche stats;	
	
	final private Coordinate origine = new Coordinate(0, 0);
	
	private Esploratrice formica ;
	private Inseguitrice altraFormica ;
	private Set<Cibo> Cibo;
	
	@Before
	public void setUp() throws Exception {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();
		this.formica = this.simulatore.creaEsploratrice();
		this.altraFormica = this.simulatore.creaInseguitrice();
		this.Cibo= new HashSet<>();
	}

	
	private Cibo creaCiboRaccoltoDaEsploratore() {
		final Cibo cibo = new Cibo(this.origine);
		cibo.setRaccoglitrice(this.simulatore.creaEsploratrice());	
		return cibo;
	}

	private Cibo creaCiboRaccoltoDaInseguitore() {
		final Cibo cibo = new Cibo(this.origine);
		cibo.setRaccoglitrice(this.simulatore.creaInseguitrice());	
		return cibo;
	}

	@Test
	public void testRaccoltoPerFormica() {
		// DA COMPLETARE ( VEDI DOMANDA 3 ) SUGG.: USARE I METODI FACTORY SOPRA
		Cibo.add(this.creaCiboRaccoltoDaEsploratore());
		Cibo.add(this.creaCiboRaccoltoDaInseguitore());
		Map<Formica, Integer> raccoltoPerFormica= stats.raccoltoPerFormica(Cibo);
		assertEquals(2, raccoltoPerFormica.keySet().size());
	}
	
	@Test
	public void testRaccoltoPerTipoDiFormica() {
		// DA COMPLETARE ( VEDI DOMANDA 4 ) SUGG.: USARE I METODI FACTORY SOPRA
		Cibo.add(this.creaCiboRaccoltoDaEsploratore());
		Cibo.add(this.creaCiboRaccoltoDaEsploratore());
		Cibo.add(this.creaCiboRaccoltoDaInseguitore());
		Map<Class<?>, Set<Cibo>> raccoltoPerFormica= stats.raccoltoPerTipoDiFormica(Cibo);
		assertEquals(2, raccoltoPerFormica.get(Esploratrice.class).size());
	}
	
}
