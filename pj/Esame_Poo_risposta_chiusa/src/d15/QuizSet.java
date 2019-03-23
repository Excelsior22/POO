package d15;

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
    
    public int hashCode() {
    	return this.titolo.hashCode();
    }
}

public class QuizSet {
    
    public static void main(String[] args) {
    	
        Set<Libro> libri = new HashSet<Libro>();
        Libro l = new Libro("Karenina");
        
        libri.add(l);
        l = new Libro("Zorro");
        libri.add(l);
        l = new Libro("Karenina");
        libri.add(l);
        l = new Libro("Bovary");
        libri.add(l);
            
        List<Libro> listaLibri = new ArrayList<Libro>(libri);
        Collections.sort(listaLibri);
        for(Libro libro : listaLibri) {
            System.out.println(libro.getTitolo());
        }
    }
}