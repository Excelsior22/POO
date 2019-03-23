package d26;


interface Dimensione {
    public void gool();
}
class Larga implements Dimensione {
    public Larga() {}
    public void gool() {}
}
class Stretta implements Dimensione {
       public Stretta() {}
       public void gool(){}
}

public class Quiz {
    public void scrivi(Dimensione r) { 
        System.out.println("Dimensione "); 
    }
    public void scrivi(Larga l) { 
        System.out.println("Larga "); 
    }
    public void scrivi(Stretta s) { 
        System.out.println("Stretta "); 
    }

    public static void main(String args[]) {
      Quiz  m = new Quiz();

      Larga l = new Larga();
      Stretta s = new Stretta();
      Dimensione d = new Larga();
      d = s;
      m.scrivi(d);
      m.scrivi(s);
      m.scrivi(l);
    }
}