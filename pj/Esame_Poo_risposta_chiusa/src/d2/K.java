package d2;

class K extends C {
    public void dim(C c) {
       System.out.println("K.dim(C) ");
    }
    public void dim(Le l) {
       System.out.println("K.dim(L) ");
    }
    public void dim(K k) {
       System.out.println("K.dim(K) ");
    }
}
