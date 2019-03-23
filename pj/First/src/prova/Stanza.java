package prova;



public class Stanza {
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private String nome;
	public Stanza (String nome) {
		this.nome= nome;
		this.attrezzi= new Attrezzo[10];
		this.numeroAttrezzi=0;
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.numeroAttrezzi<10) {    //massimo 10 attrezzi
			this.attrezzi[numeroAttrezzi]= attrezzo;
			this.numeroAttrezzi++;
			return true;
		}
		else
			return false;

	}
	/*
	public boolean hasAttrezzo (String nomeAttrezzo) {
		boolean trovato;
		trovato= false;
		for (Attrezzo attrezzo: this. attrezzi) {
			if(attrezzo!=null) {
			if(attrezzo.getNome().equals(nomeAttrezzo));
			trovato=true;
			}
		}
		return trovato;
}
*/
		public boolean hasAttrezzo (String nomeAttrezzo) {
		boolean trovato;
		trovato= false;
		for (int i=0; i<this.numeroAttrezzi; i++) {
			if(attrezzi[i]!=null) {
			if(attrezzi[i].getNome().equals(nomeAttrezzo));
			trovato=true;
			}
		}
		return trovato;
}
		public Attrezzo getAttrezzo(String nomeAttrezzo) {
			for(Attrezzo attrezzo: this.attrezzi) {
				if(attrezzo!=null) {
					if(attrezzo.getNome().equals(nomeAttrezzo));
					return attrezzo;
				}
			}
			return null;
		}

		
		public String toString() {
			String s;
			s="stanza di nome " + this.nome + " lista degli attrezzi disponibili:\n";
			for(int v=0;v<this.numeroAttrezzi;v++){
				if(attrezzi!=null)
					s=s+attrezzi[v].toString()+", ";
			}
			return s;
		}
		

}

