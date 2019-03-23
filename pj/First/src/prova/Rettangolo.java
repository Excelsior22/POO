package prova;

public class Rettangolo {
	private int base; 
	private int altezza;
	private Punto vertice= new Punto();       //vertice in alto a sinistra
	
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public int getAltezza() {
		return altezza;
	}
	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}
	public Punto getVertice() {
		return vertice;
	}
	public void setVertice(Punto vertice) {
		this.vertice = vertice;
	}
	public void sposta(int dx, int dy) {
		vertice.setX(vertice.getX()+dx);
		vertice.setY(vertice.getY()+dy);
	}
	
	

}
