package d2;

public class Le extends C {
    public void dim(C c) {
       System.out.println("L.dim(C) ");
    }
    public void dim(Le l) {
       System.out.println("L.dim(L) ");
    }
    public void dim(K k) {
       System.out.println("L.dim(K) ");
    }

    public static void main(String args[]) {
       C a = new K();
       C b = new Le();
       a.dim(b);
       Le a1 = new Le();
       a1.dim(a);
    }
}
