package d18;

import java.util.*;

class ComparatoreLibri implements Comparator<Libro> {
    public int compare(Libro l1, Libro l2) {
        return (l1.getAnno()- l2.getAnno());
    }
}

class Libro implements Comparable<Libro> {
    public int anno;
    public String titolo;

    public Libro(String titolo, int anno) {
        this.anno = anno;
        this.titolo = titolo;
    }

    public int compareTo(Libro o) {
        return this.titolo.compareTo(o.getTitolo());
    }

    public int getAnno(){
        return this.anno;
    }

    public String getTitolo(){
        return this.titolo;
    }
}

public class Quiz {
    public static void main(String[] args) {
        List<Libro> biblioteca = new LinkedList<Libro>();

        biblioteca.add(new Libro("Cronosisma", 2003));
        biblioteca.add(new Libro("Zorro", 2000));
        biblioteca.add(new Libro("Zorro", 1800));
        biblioteca.add(new Libro("Mostri", 1999));
        Collections.sort(biblioteca, new ComparatoreLibri());

        for(Libro libro : biblioteca)
            System.out.print(libro.getTitolo()+" ");
    }
}