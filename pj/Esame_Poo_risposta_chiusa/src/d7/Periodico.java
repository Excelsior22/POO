package d7;

class Periodico {
    private String nome;

    public Periodico(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public String toString() {
        return this.getNome() + " (periodico)";
    }

}

