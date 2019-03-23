package d11;

public class Persona {
    private int eta;
    private String nome;

    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }
    
    public void cambioNome(String nome){
        this.nome = nome;
    }
    
    public String toString() {
        return this.nome + " " + this.eta;
    }

    public static void main(String[] args) {
        Persona p1 = new Persona("Marco",40);
        Persona p2 = new Persona("Luca", 20);

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        p2 = p1; 
        p2.cambioNome("Giorgio"); 

        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}