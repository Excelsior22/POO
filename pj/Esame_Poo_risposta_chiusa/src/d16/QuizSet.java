package d16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class QuizSet {
    
    public static void main(String[] args) {
        List<Libro> libri = new ArrayList<Libro>();
        Libro l = new Libro("Karenina");
        libri.add(l);
        l = new Libro("Zorro");
        libri.add(l);
        l = new Libro("Karenina");
        libri.add(l);
        l = new Libro("Bovary");
        libri.add(l);
        libri.add(l);
        
        List<Libro> listaLibri = new ArrayList<Libro>(libri);
        Collections.sort(listaLibri);
        for(Libro libro : listaLibri) {
            System.out.println(libro.getTitolo());
        }
    }
}
