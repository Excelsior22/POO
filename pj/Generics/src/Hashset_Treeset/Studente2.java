package Hashset_Treeset;
import java.util.*;

public class Studente2 {
	private String nome;
	
	public Studente2(String nome) {
		this.nome=nome;
	}
	
	public String getNome() {
		return this.nome;
	}
}

class Aula2{
	private Set<Studente> studenti;
	public Aula2() {
		this.studenti= new TreeSet<>(new ComparatoreDiStudenti());
	}
	public boolean addStudente(Studente studente) {
		return this.studenti.add(studente);
	}
}
