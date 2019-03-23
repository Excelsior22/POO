package d13;

import java.util.LinkedList;
import java.util.List;

public class Quiz {

    public static void main(String[] argc) {
        List<Persona2> l = new LinkedList<Persona2>();

        Persona2 a = new Persona2("Paolo");
        l.add(a);
        a.setNome("Luca");
        a = new Persona2("Antonio");
        l.add(a);
        Persona2 b;
        b = a;
        b.setNome("Elisabetta");
        l.add(b);
        for(Persona2 p : l)
            System.out.print(p.toString()+" ");
    }
}
