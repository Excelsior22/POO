/*
   Obiettivo: verifica comprensione overloading con le interfacce

   Leggere attentamente il programma.
   - cosa stampa ?
   - perche' ?
   - compilare ed eseguire il programma per verificare la risposta
*/


interface Atleta {
	void gareggia();
}

class Corridore implements Atleta {
	public Corridore() {}
	public void gareggia() {};
}

class Saltatore implements Atleta {
   public Saltatore() {}
   public void gareggia(){};
}

public class Olimpiadi {
	public void iscrivi(Atleta a){
		System.out.print("A ");
	}
	public void iscrivi(Corridore C) {
		System.out.print("C ");
	}
	public void iscrivi(Saltatore s) {
		System.out.print("S ");
	}

	public static void main(String args[]) {
	  Olimpiadi o = new Olimpiadi();

	  Corridore c = new Corridore();
	  Saltatore s = new Saltatore();
	  Atleta a = new Corridore();
	  a = s;

	  o.iscrivi(a);
	  o.iscrivi(s);
	  o.iscrivi(c);
	}
}
