package Esonero3;

public class Ingegnere {
    private String nome;

    public Ingegnere (String nome) {
        this.nome = nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public static void main(String[] argc) {
        Ingegnere[] ing = new Ingegnere[3];

        Ingegnere a = new Ingegnere("Giorgio");
        ing[0] = a;
        a.setNome("Gigi");
        a = new Ingegnere("Luca");
        ing[1] = a;
        Ingegnere b;
        b = a;
        b.setNome("Paolo");
        ing[2] = b;
        for(Ingegnere i : ing)
            System.out.print(i.getNome()+" ");
    }
}