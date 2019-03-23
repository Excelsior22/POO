package d14;

import java.util.*;

class ComparatoreLibri implements Comparator<Libro2> {
    public int compare(Libro2 l1, Libro2 l2) {
        return (l1.getAnno()- l2.getAnno());
    }
}

class Libro2 implements Comparable<Libro2> {
    public int anno;
    public String titolo;

    public Libro2(String titolo, int anno) {
        this.anno = anno;
        this.titolo = titolo;
    }

    public int compareTo(Libro2 o) {
        return this.titolo.compareTo(o.getTitolo());
    }

    public int getAnno(){
        return this.anno;
    }

    public String getTitolo(){
        return this.titolo;
    }
}