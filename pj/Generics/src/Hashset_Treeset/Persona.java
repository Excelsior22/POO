package Hashset_Treeset;

public class Persona implements Comparable<Persona>{
	private String nome;
	
	public Persona(String nome){
		this.nome=nome;
	}
	
	public String toString() {
		return this.nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}
	
	@Override
	public int compareTo(Persona that) {
		return this.getNome().compareTo(that.getNome());
	}
	
	@Override
	public boolean equals(Object o) {
		return this.getNome().equals(((Persona)o).getNome());
	}

}
