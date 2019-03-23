package Esonero3;

/* Obiettivo: comprensione uso HashSet<T>
   - cosa stampa questo programma?
   - compilare
   - eseguire il programma e verificare la propria risposta
*/

import java.util.*;

class Catastrofe {
    private int anno;

    Catastrofe(int anno) {
	  this.anno = anno;
    }
}

class Evento {
    private int anno;

    Evento (int anno) {
	  this.anno = anno;
    }
    
    public int hashCode() {
    	return this.anno;
    }

	public int getAnno() {
		return this.anno;
	}
	
    public boolean equals(Object o) {
	  Evento e = (Evento) o;
	  return this.anno == e.getAnno();
    }
}

public class ProveHashSet {

    public static void main(String[] argv) {
	  Set<Evento> set1 = new HashSet<Evento>();
 	  Evento e  = new Evento(2000);
	  set1.add(e);
 	  e = new Evento(2000);
  	  set1.add(e);

	  Set<Catastrofe> set2 = new HashSet<Catastrofe>();
 	  Catastrofe c = new Catastrofe(2000);
	  set2.add(c);
	  c = new Catastrofe(2000);
	  set2.add(c);

	  System.out.println("set1.size()="+set1.size());
	  System.out.println("set2.size()="+set2.size());
    }
}