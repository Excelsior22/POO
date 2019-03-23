package battlefield;


/*
 * Da sistemare. Vedi PositionTest.
 * (vedi DOMANDA 1)
 */
public class Position {
	
	private int x, y;

	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o) {
		Position that= (Position) o;
		return this.getX()==that.getX() &&this.getY()==that.getY();
	}
	
	@Override
	public int hashCode() {
		return this.getX()+this.getY();
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
		
	public String toString() {
		return this.x+"-"+this.y;
	}

}