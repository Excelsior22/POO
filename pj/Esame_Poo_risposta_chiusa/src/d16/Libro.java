package d16;

import java.util.*;

class Libro implements Comparable<Libro> {
    private String titolo;
    
    public Libro(String titolo){
        this.titolo    = titolo;
    } 
    
    public String getTitolo() {
        return this.titolo;
    }

    public int compareTo(Libro libro){
        return this.titolo.compareTo(libro.getTitolo());
    }
    
    public boolean equals(Object o){
        return this.titolo.equals(((Libro)o).getTitolo());
     }
     
     public int hashCode(){
     	return this.titolo.hashCode();
     }
}

