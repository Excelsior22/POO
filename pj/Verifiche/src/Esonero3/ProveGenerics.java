package Esonero3;

/* Obiettivo: comprensione generics
   - questo programma compila?
   - provare a compilare
   - se il programma non compila, correggere gli errori
   - cosa deve stampare il programma?
   - eseguire il programma e verificare la propria risposta
   - se il risultato e' diverso da quello atteso,
     modificare il codice
*/

import java.util.*;

class Libro {
    private String titolo;

    Libro(String titolo) {
	  this.titolo = titolo;
    }

	public String getTitolo() {
		return this.titolo;
	}
}

public class ProveGenerics {

    public static void main(String[] argv) {
	  List<Libro> biblioteca = new LinkedList<Libro>();
 	  Libro l1  = new Libro("Anna Karenina");
 	  Libro l2 = new Libro("I demoni");
	  Libro l3= new Libro("Madame Bovary");
	  biblioteca.add(l1);
  	  biblioteca.add(l2);
  	  biblioteca.add(l3);

	  Iterator<Libro> it = biblioteca.iterator();
	  while (it.hasNext())
		System.out.println(it.next().getTitolo());
    }
}