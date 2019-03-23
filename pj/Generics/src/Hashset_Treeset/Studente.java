package Hashset_Treeset;
import java.util.*;

public class Studente implements Comparable<Studente>{
	private String nome;
	
	public Studente(String nome) {
		this.nome=nome;
	}
	public String getNome() {
		return this.nome;
	}
	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		Studente that= (Studente)o;
		return this.getNome().equals(that.getNome());
	}
	
	@Override
	public int compareTo(Studente that) {
		return this.getNome().compareTo(that.getNome());
	}
}

class Aula{
	private Set<Studente> studenti;
	public Aula() {
		this.studenti= new TreeSet<Studente>();
	}
	public boolean addStudente(Studente studente) {
		return this.studenti.add(studente);
	}
}
