package Esonero3;

public class Calciatore {
    private String nome;

    public Calciatore(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }


    public static void main(String args[]) {
        Calciatore[] uomo = new Calciatore[10];
        Calciatore p1 = new Calciatore("paolo");

        uomo[0] = p1;
        p1.setNome("francesco");
        uomo[1] = p1;
        uomo[2] = new Calciatore("daniele");
        uomo[3] = new Calciatore("max");

        Calciatore mister = new Calciatore("max");

        for(int i = 0; i<4; i++)
            if (uomo[i] != mister)
                System.out.print(uomo[i].getNome()+" ");
     }
}