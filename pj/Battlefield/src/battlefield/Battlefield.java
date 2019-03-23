package battlefield;

import java.util.*;

public class Battlefield {

	static final private Class<?>[] TIPOLOGIE = { Walker.class, Chaser.class } ;

	static final private int NUMERO_TIPOLOGIE = TIPOLOGIE.length;

	static final private double OCCUPAZIONE_INIZIALE = 0.01d; // 1%

	private int dim;

	private Random random;
	
	private Map<Position, Robot> posizione2Robot;

	public Battlefield(int dimensione) {
		this.dim = dimensione;
		this.posizione2Robot = new HashMap<>();
		this.random = new Random();
	}

	public void addWalker(Walker w) {
		// (vedi DOMANDA 1)
		this.posizione2Robot.put(w.getPosizione(), w);
	}
	
	public void addChaser(Chaser c) {
		// (vedi DOMANDA 1)
		this.posizione2Robot.put(c.getPosizione(), c);
	}

	public Robot getRobot(Position p) {
		return posizione2Robot.get(p);
	}

	public Collection<Robot> getAllRobots() {
		return this.posizione2Robot.values();
	}

	@SuppressWarnings("rawtypes")
	public Map<Class, Set<Robot>> raggruppaRobotPerTipo() {
		// (vedi DOMANDA 3)
		Map<Class, Set<Robot>> RobotXTipo= new HashMap<>();
		for(Robot robot: this.getAllRobots()) {
			Class classeRobot= robot.getClass();
			if(!RobotXTipo.containsKey(classeRobot)) {
				Set<Robot> robots= new HashSet<>();
				robots.add(robot);
				RobotXTipo.put(classeRobot, robots);
			}
			else {
				Set<Robot> robots= RobotXTipo.get(classeRobot);
				robots.add(robot);
				RobotXTipo.put(classeRobot, robots);
			}
		}
		return RobotXTipo;
	}
	
	public List<Robot> getRobotOrdinatiPerPosizione() {
		// (vedi DOMANDA 4)
		List<Robot> robotXPosizione= new ArrayList<Robot>();
		robotXPosizione.addAll(this.getAllRobots());
		
		class OrdinatorePerPosizione implements Comparator<Robot>{
			@Override
			public int compare(Robot r1, Robot r2) {
				int output= r1.getPosizione().getX()-r2.getPosizione().getX();
				if(output==0)
					output= r1.getPosizione().getX()-r2.getPosizione().getX();
				return output;
			}
		}
		Collections.sort(robotXPosizione, new OrdinatorePerPosizione());
		return robotXPosizione;
	}
	
	public SortedSet<Robot> getRobotOrdinatiPerLongevita() {
		// (vedi DOMANDA 6)
		class OrdinatoreXLongevita implements Comparator<Robot>{

			@Override
			public int compare(Robot r1, Robot r2) {
				int output= r1.getLongevita()-r2.getLongevita();
				if(output==0) {
					//output=r1.getClass().getName().compareTo(r2.getClass().getName());
					output= r1.getPosizione().getX()-r2.getPosizione().getX() + r1.getPosizione().getY()-r2.getPosizione().getY();
				}
				return output;
			}
		}
		
		SortedSet<Robot> RobotXLongevita= new TreeSet<>(new OrdinatoreXLongevita());
		RobotXLongevita.addAll(this.getAllRobots());
		return RobotXLongevita;
	}

	public List<Position> adiacenti(Position perno) {
		final List<Position> adiacenti = new LinkedList<>();
		int x = perno.getX();
		int y = perno.getY();

		for(int i = -1; i<2; i++) {
			for(int j = -1; j<2; j++) {
				Position adiacente = new Position(x+i, y+j);
				if (inCampo(adiacente))
					adiacenti.add(adiacente);
			}
		}
		adiacenti.remove(perno);  // coincidono: quindi non sono adiacenti
		
		Collections.shuffle(adiacenti); /* ordine casuale */
		return adiacenti;
	}

	private boolean inCampo(Position p) {
		return  p.getX()>=0 && p.getX()<this.dim && 
				p.getY()>=0 && p.getY()<this.dim  ;
				
	} 

	public Position posizioneLiberaVicino(Position posizione) {
		for(Position p : this.adiacenti(posizione)) {
			if (this.isLibera(p)) {
				return p;
			}
		}
		return null;
	}

	public boolean isLibera(Position posizione) {
		return  this.getRobot(posizione)==null;
	}

	public int getDimensione() {
		return this.dim;
	}

	public void riempi() {
		long numeroIniziale = Math.round(OCCUPAZIONE_INIZIALE * dim * dim);
		for(int i=0 ; i<numeroIniziale; i++) {
			int x = this.random.nextInt(this.dim);
			int y = this.random.nextInt(this.dim);
			Position posizione = new Position(x, y);
			if (this.isLibera(posizione)) {
				switch (this.random.nextInt(NUMERO_TIPOLOGIE)) {
				case 0: Chaser chaser = new Chaser(posizione);
						this.addChaser(chaser);
				break;
				case 1: Walker walker = new Walker(posizione);
						this.addWalker(walker);
				break;
				//case: NUMERO_TIPOLOGIE-1...
				default: throw new IllegalStateException();
				} 
			}
		}
	}

}

