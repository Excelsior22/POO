package esercitazione_forme;

public class Rettangolo implements Forma {
	private int altezza, base;
	private Punto vertice;

	public Rettangolo(Punto vertice, int altezza, int base) {
		this.altezza = altezza;
		this.base = base;
		this.vertice = new Punto(vertice.getX(), vertice.getY());
	}

	public void trasla(int deltaX, int deltaY) {
		this.vertice.setX(this.vertice.getX() + deltaX);
		this.vertice.setY(this.vertice.getY() + deltaY);
	}

	public Punto getVertice() {
		return this.vertice; 
	}

	public int getBase() {
		return this.base;
	}

	public int getAltezza() { 
		return this.altezza;
	}
}