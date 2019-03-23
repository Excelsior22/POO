package Hashset_Treeset;

public class ExEquals_Hashcode {
	
	public class calciatore{
		private String nome;
		private String cognome;
		private int numeroDiMaglia;


		public String getNome() {
			return nome;
		}

		public String getCognome() {
			return cognome;
		}

		public int getNumeroDiMaglia() {
			return numeroDiMaglia;
		}

		@Override
		public boolean equals(Object o) {                                       //Se non ridefinito utlizziamo quello ereditato da object, che confrota
			calciatore that=(calciatore)o;                                        //sui valori dell'indirizzo di memoria
			return this.getNome().equals(that.getNome()) &&
					this.getCognome().equals(that.getCognome()) &&
					this.getNumeroDiMaglia()==that.getNumeroDiMaglia();
		}
		
		@Override
		public int hashCode() {                                   //Come equals se non ridefinito ci sarebbe una funziona hash sugli indirizzi di memoria
			return this.getNome().hashCode()+
					this.getCognome().hashCode()+
					this.getNumeroDiMaglia();                   //già intero
		}

	}
}
