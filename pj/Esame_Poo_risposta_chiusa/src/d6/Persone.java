package d6;

public class Persone {
    private String nome;
    private int eta;

    public Persone(String nome, int eta) {
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
        Persone paolo = new Persone("Paolo", 40);
        Persone valter = new Persone("Valter",30);

        System.out.println(paolo);
        System.out.println(valter);
        paolo = valter;

        paolo.cambioNome("Luigi");
        System.out.println(paolo);
        System.out.println(valter);
    }
}