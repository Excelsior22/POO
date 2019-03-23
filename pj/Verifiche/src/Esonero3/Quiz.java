package Esonero3;

import java.util.*;
abstract class Veicolo {
      public String clacson() { return "boh"; }
}

class Automobile extends Veicolo {
      public String clacson() { return  "bip"; }
}

class Bicicletta extends Veicolo {
      public String clacson() { return "drin"; }
}

class Tandem extends Bicicletta {
      public String clacson() { return "drindran"; }
}

public class Quiz {
    public static void main(String args[]) {
        List<Veicolo> listaVeicoli = new ArrayList<Veicolo>();

        Veicolo v = null;
        Bicicletta b = new Bicicletta();
        Veicolo a = new Automobile();
        Bicicletta tb = new Tandem();
        Tandem t = new Tandem();

        v = b;
        listaVeicoli.add(v);
        v = a;
        listaVeicoli.add(v);
        v = tb;
        listaVeicoli.add(v);
        v = t;
        listaVeicoli.add(v);

        for(Veicolo veicolo : listaVeicoli)
            System.out.print(veicolo.clacson()+" ");
    }
}