package prova;

public class Punto {
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void traslapunto(int deltaX, int deltaY) {
		this.x= this.x+deltaX;
		this.y= this.y+deltaY;
	}
}
