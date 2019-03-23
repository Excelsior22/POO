package d12;

public class Libro {
    private String titolo;
    
    public Libro(String titolo){
        this.titolo = titolo;
    }
    
    public String getTitolo(){
        return this.titolo;
    }
    
    public String cambiaTitolo(String titolo){
        String vecchioTitolo;
        vecchioTitolo = this.titolo;
        this.titolo = titolo;
        return vecchioTitolo;
    }
    
    public static void main(String[] args) {
        Libro l1 = new Libro("Anna Karenina");
        Libro l2 = new Libro("Guerra e pace");
        
        l1.cambiaTitolo(l2.cambiaTitolo("Il principe"));
        System.out.println(l1.getTitolo());
        System.out.println(l2.getTitolo());
        
        l1 = l2;
        l1.cambiaTitolo(l2.cambiaTitolo("Madame Bovary"));
        System.out.println(l1.getTitolo());
        System.out.println(l2.getTitolo());
    }
}
