package Esonero3;

public class Ver_dup {
	private String[] nomi;

	public Ver_dup(int numeroPersone) {
		this.nomi = new String[numeroPersone];
	}

	public void aggiungiNome(String nome, int indice) {
		this.nomi[indice] = nome;
	}

	public boolean verificaDuplicati(String nome) {
		int uguali=0;
		for(String nome1: this.nomi){
			if(nome1.equals(nome)){
				uguali++;
			}
		}
		if(uguali>=2)
			return true;
		else
			return false;
	}

}