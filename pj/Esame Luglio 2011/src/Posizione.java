

public class Posizione {
	
	public int x, y;
	
	public Posizione (int x, int y){
		this.x = x;
		this.y = y;
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
	
	@Override
	public boolean equals(Object o) {
		Posizione that= (Posizione) o;
		return this.getX()== that.getX() && this.getY()==that.getY();
	}
	@Override
	public int hashCode() {
		return this.getX()+this.getY();
	}

}