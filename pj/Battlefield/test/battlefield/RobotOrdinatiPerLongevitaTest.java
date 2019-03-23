package battlefield;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.SortedSet;

import org.junit.Before;
import org.junit.Test;

/* Senza introdurre nuove classi, implementare un metodo 
 * SortedSet<Robot> getRobotOrdinatiPerLongevità() 
 * all'interno della classe Battlefield che restituisca 
 * l'insieme ordinato di tutti robot del campo ordinato 
 * per longevità. 
 * (vedi DOMANDA 6) 
 */
public class RobotOrdinatiPerLongevitaTest {

	private Battlefield field;
	
	private Position origine;
	private Position unitari;
	
	@Before
	public void setUp() throws Exception {
		this.field = new Battlefield(2);
		this.origine = new Position(0, 0);
		this.unitari = new Position(1, 1);
	}
	
	/* DA RIFATTORIZZARE dopo aver svolto la DOMANDA 2*/
	private void setLongevita(Walker w, int l) {
		for(int i=0; i<l; i++)
			w.incrementaLongevita();
	}
	private void setLongevita(Chaser c, int l) {
		for(int i=0; i<l; i++)
			c.incrementaLongevita();
	}
	
	/* DA RIFATTORIZZARE dopo aver svolto la DOMANDA 2        */
	/* (vedi DOMANDA 6)	per l'utilizzo dei seguenti test-case */
	@Test
	public void testRobotOrdinatiPerLongevitaTest_equals() {
		this.field.addWalker(new Walker(origine)); // n.b. longevità 0;
		this.field.addWalker(new Walker(origine)); // n.b. longevità 0;
		assertEquals(1, this.field.getRobotOrdinatiPerLongevita().size());
	}

	@Test
	public void testRobotOrdinatiPerLongevitaTest_stessaLongevitaTipoDiverso() {
		this.field.addWalker(new Walker(origine)); // n.b. longevità 0;
		this.field.addWalker(new Walker(unitari)); // n.b. longevità 0;
		assertEquals(2, this.field.getRobotOrdinatiPerLongevita().size());
	}

	@Test
	public void testRobotOrdinatiPerLongevitaTest_longevitaDiverse() {
		final Walker giovane = new Walker(origine);
		setLongevita(giovane, 0);   // n.b. longevità 0;
		this.field.addWalker(giovane);
		final Chaser vecchio = new Chaser(unitari);
		setLongevita(vecchio, 100); // n.b. longevità 100;
		this.field.addChaser(vecchio);
		final SortedSet<?> perLongevita = this.field.getRobotOrdinatiPerLongevita();
		assertEquals(2, perLongevita.size());
		assertSame(giovane, perLongevita.first());
		assertSame(vecchio, perLongevita.last());
	}

}
