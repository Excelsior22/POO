package prova;

/*Differenza classe Punto: utilizzo dei costruttori  per l'inizializzazione iniziale del'oggetto punto*/

public class Punto_2 {
	private int x;
	private int y;
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}


	public Punto_2() {     //Costruttore 
		this.x=0;
		this.y=0;          //costruzione di un oggetto nel main del tipo:"Punto_2 origine= new Punto_2(0,0);"
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public void traslapunto(int deltaX, int deltaY) {
		this.x= this.x+deltaX;
		this.y= this.y+deltaY;
	}
}
