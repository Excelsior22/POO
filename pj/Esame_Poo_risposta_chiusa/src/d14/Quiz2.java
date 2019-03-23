package d14;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Quiz2 {
    public static void main(String[] args) {
        List<Libro2> biblioteca = new LinkedList<Libro2>();

        biblioteca.add(new Libro2("Cronosisma", 2003));
        biblioteca.add(new Libro2("Zorro", 2000));
        biblioteca.add(new Libro2("Zorro", 2000));
        biblioteca.add(new Libro2("Mostri", 1999));
        Collections.sort(biblioteca, new ComparatoreLibri());

        for(Libro2 libro : biblioteca)
            System.out.print(libro.getTitolo()+" ");
    }
}
