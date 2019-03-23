/*
  Obiettivo: verifica comprensione tipi statici e dinamici

  Il seguente programma contiene molti errori.
  - quali?
  - compialre il programma e verificare le proprie risposte

*/

 interface Edificio{
	void numeroPiani();
}

 class Palazzo implements Edificio {
	public void numeroPiani() {};
}


public class Villa implements Edificio {
	public void numeroPiani(){}

	public static void main(String[] argc){

		Edificio e;
		Villa v = new Villa();
		Edificio e1 = new Villa();
	
		e=v;
		e1=v;
		e1.numeroPiani();
		e = new Palazzo();
		e=v;
		e.numeroPiani();
	}

}


