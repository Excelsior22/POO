package Esonero3;

/* Obiettivo: comprensione uso TreeSet<T> e HashSet<T>
   - cosa stampa questo programma? perche'?
   - compilare
   - eseguire il programma e verificare la propria risposta
*/

import java.util.*;

class libro implements Comparable<libro> {
    private int anno;
    private String titolo;

    libro(int anno, String titolo) {
	  this.anno = anno;
	  this.titolo = titolo;
    }

    public int hashCode() {
    	return (this.anno + this.titolo.hashCode());
    }

	public int compareTo(libro libro) {
		return this.anno - libro.getAnno();
	}

	public String getTitolo() {
		return this.titolo;
	}

	public int getAnno() {
		return this.anno;
	}

    public boolean equals(Object o) {
	  libro l = (libro) o;
	  return ((this.anno == l.getAnno()) &&
	          (this.titolo.equals(l.getTitolo())));
    }
}

public class ProveTreeSet {

    public static void main(String[] argv) {
	  Set<libro> set1 = new TreeSet<libro>();
 	  libro l1  = new libro(2000,"Ieri e oggi");
 	  libro l2 = new libro(2000, "Domani e dopodomani");
	  set1.add(l1);
  	  set1.add(l2);

	  Set<libro> set2 = new HashSet<libro>();
	  set2.add(l1);
	  set2.add(l2);

	  System.out.println("set1.size()="+set1.size());
	  System.out.println("set2.size()="+set2.size());
    }
}