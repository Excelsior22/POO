package battlefield;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

public class RobotOrdinatiPerPosizioneTest {
	
	// (vedi DOMANDA 5)
	// scrivere dei test-case minimali per il metodo
	// Battlefield.getRobotOrdinatiPerPosizione()
	private Walker r1;
	private Walker r2;
	private Chaser r3;
	private Chaser r4;
	private Battlefield field;
	
	@Before
	public void setUp() throws Exception {
		r1= new Walker(new Position(0,0));
		r2= new Walker(new Position(0,2));
		r3= new Chaser(new Position(3,0));
		r4= new Chaser(new Position(2,2));
		field= new Battlefield(5);
	}
	@Test
	public void testRobotOrdinatiPerPosizioneCampoVuoto() {
		List<Robot> listaRobot= this.field.getRobotOrdinatiPerPosizione();
		assertEquals(0,listaRobot.size());
	}
	
	
	@Test
	public void testRobotOrdinatiPerPosizioneSingoloRobot() {
		field.addWalker(r1);
		List<Robot> listaRobot= this.field.getRobotOrdinatiPerPosizione();
		assertEquals(1,listaRobot.size());
		assertEquals(r1,listaRobot.get(0));
		
	}
	
	@Test
	public void testRobotOrdinatiPerPosizione2RobotXdiversa() {
		field.addWalker(r2);
		field.addChaser(r3);
		List<Robot> listaRobot= this.field.getRobotOrdinatiPerPosizione();
		assertEquals(r2,listaRobot.get(0));
		assertEquals(r3,listaRobot.get(1));
	}
	
	
	@Test
	public void testRobotOrdinatiPerPosizione2RobotXPariYDiversa() {
		field.addWalker(r1);
		field.addWalker(r2);
		List<Robot> listaRobot= this.field.getRobotOrdinatiPerPosizione();
		assertEquals(r1,listaRobot.get(0));
		assertEquals(r2,listaRobot.get(1));
	}
	
	
	@Test
	public void testRobotOrdinatiPerPosizione4Robot() {
		field.addWalker(r1);
		field.addWalker(r2);
		field.addChaser(r3);
		field.addChaser(r4);
		List<Robot> listaRobot= this.field.getRobotOrdinatiPerPosizione();
		assertEquals(r1,listaRobot.get(0));
		assertEquals(r2,listaRobot.get(1));
		assertEquals(r4,listaRobot.get(2));
		assertEquals(r3,listaRobot.get(3));
		
	}
	
}
