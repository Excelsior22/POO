package Poli_eso_2;

interface  D {
    public void dim(D d);
    public void dim(M m);
}

public class M implements D {
    public void dim(D d) {
       System.out.print("M.dim(D) ");
    }
    public void dim(M m) {
       System.out.print("M.dim(M) ");
    }

    public static void main(String args[]) {
       M a = new M(); 
       D b = new M();
       a.dim(b);
       M a1 = new M();
       a1.dim(a);
    }
}