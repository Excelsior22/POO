package ant;

/**
 * Rappresenta le coordinate di una posizione modellata come coppia di interi 
 * ascissa (x) ed ordinata (y), all'interno dell'{@link Ambiente}.
 * <B>(DA COMPLETARE VEDI DOMANDA 1)</B>
 */
public class Coordinate {

	private int x;

	private int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	/**
	 * Crea un oggetto {@link Coordinate} traslato rispetto all'originale.
	 * @param dir  direzione verso cui spostarsi (delta su coordinate)
	 * @return il nuovo oggetto {@link Coordinate} traslato 
	 */
	public Coordinate trasla(Direzione dir) {
		return new Coordinate(getX()+dir.getDx(), getY()+dir.getDy());
	}

	@Override
	public String toString() {
		return "("+getX()+","+getY()+")";
	}

}
