package d17;


import java.util.*;
public class Quiz {
    public static void main(String[] argv) {
        Map<Integer,String> codice2nome;
        codice2nome = new HashMap<Integer,String>();

        codice2nome.put(1 , "Stefano");

        codice2nome.put(1, "Paolo");        //sostituisce
        codice2nome.put(2 , "Luca");
        codice2nome.put(3 , "Paolo");

        List<Integer> ll = new LinkedList<Integer>(codice2nome.keySet());
        Collections.sort(ll);
        Iterator<Integer> i = ll.iterator();
        while (i.hasNext())
            System.out.print(codice2nome.get(i.next())+" ");
    }
}