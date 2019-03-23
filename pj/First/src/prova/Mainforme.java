package prova;

public class Mainforme {
	public static void main(String[] args) {
		Punto origine= new Punto();                //creo un oggetto di tipo punto, origine ne è il riferimento
		origine.setX(0);
		origine.setY(0);                 //setter da evitare, tramite costruttori
		/*OUTPUT1*/
		System.out.println(origine.getX());
		System.out.println(origine.getY());
		System.out.println("\n");
		/*FINE OUTPUT1*/
		origine.traslapunto(2,2);
		/*OUTPUT2*/
		System.out.println(origine.getX());
		System.out.println(origine.getY());
		System.out.println("\n");
		/*FINE OUTPUT2*/
		//Parte 2, introduzione di un rettangolo
		Rettangolo rect= new Rettangolo();
		rect.setBase(4);
		rect.setAltezza(2);
		rect.setVertice(origine);
		rect.sposta(2,2);
		/*OUTPUT3*/
		System.out.println(rect.getBase());
		System.out.println(rect.getAltezza());
		System.out.println(origine.getX());
		System.out.println(origine.getY());
		System.out.println("\n");

		Attrezzo martello= new Attrezzo("martello", 10);
		Attrezzo pc= new Attrezzo("pc", 3);
		Attrezzo sedia= new Attrezzo("sedia", 2);
		System.out.println(martello.toString());
		
		Stanza s1= new Stanza("casa");
		System.out.println(s1.addAttrezzo(martello));
		System.out.println(s1.addAttrezzo(pc));
		System.out.println(s1.addAttrezzo(sedia));
		
		System.out.println(s1.hasAttrezzo("martello"));
		System.out.println(s1.hasAttrezzo("tavolo"));
		
		System.out.println(s1.toString());
		

	}
}
