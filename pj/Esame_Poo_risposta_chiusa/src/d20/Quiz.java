package d20;

interface Moto {
    public void avvia();
}
class Scooter implements Moto {
    public Scooter() {}
    public void avvia() {}
}
class Cross implements Moto {
    public Cross() {}
    public void avvia(){}
}

public class Quiz {
    public void mostra(Moto a) {
        System.out.print("Moto ");
    }
    public void mostra(Scooter u) {
        System.out.print("Scooter ");
    }
    public void mostra(Cross c) {
        System.out.print("Cross ");
    }

    public static void main(String args[]) {
      Quiz q = new Quiz();
      Scooter s = new Scooter();
      Cross c = new Cross();
      Moto ms = new Scooter();
      ms = c;
      q.mostra(s);
      q.mostra(ms);
      q.mostra(c);
    }
}