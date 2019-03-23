package Esonero3;

import java.util.*;

class Studente {

    private String matricola;
    private String nome;

    Studente(String matricola, String nome) {
        this.matricola = matricola;
        this.nome = nome;
    }

    public String getMatricola() {
        return this.matricola;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean equals(Object o) {
        // Codice da completare
        Studente that= (Studente) o;
        return this.getMatricola().equals(that.getMatricola());
    }

    public int hashCode() {
        // Codice da completare
        return this.getMatricola().hashCode();
    }
}

public class ContatoreDiStudenti {
    //NON toccare questa classe
    public int contaMatricoleDellInsieme(HashSet<Studente> insieme) {
        return insieme.size();
    }
    //NON toccare questa classe
}
