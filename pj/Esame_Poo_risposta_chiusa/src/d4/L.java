package d4;

interface  C {
    public void dim(C c);
    public void dim(L l);
    public void dim(K k);
}

class K implements C {
    public void dim(C c) {
       System.out.println("K.dim(C) ");
    }
    public void dim(L l) {
       System.out.println("K.dim(L) ");
    }
    public void dim(K k) {
       System.out.println("K.dim(K) ");
    }
}

public class L implements C {
    public void dim(C c) {
       System.out.println("L.dim(C) ");
    }
    public void dim(L l) {
       System.out.println("L.dim(L) ");
    }
    public void dim(K k) {
       System.out.println("L.dim(K) ");
    }

    public static void main(String args[]) {
       C a = new K();
       C b = new L();
       a.dim(b);
       L a1 = new L();
       a1.dim(a);
    }
}