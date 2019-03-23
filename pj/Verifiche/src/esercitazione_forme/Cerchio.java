package esercitazione_forme;

public class Cerchio implements Forma{
	
	private int raggio;
	private Punto centro;
	
	public Cerchio(Punto centro, int raggio) {
		this.raggio = raggio;
		this.centro = new Punto(centro.getX(), centro.getY());
	}
	
	public void trasla(int deltaX, int deltaY) {
		this.centro.setX(this.centro.getX() + deltaX);
		this.centro.setY(this.centro.getY() + deltaY);
	}
	
	public Punto getCentro() {
		return this.centro;
	}
	
	public int getRaggio() {
		return this.raggio;
		}
}