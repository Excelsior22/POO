package prova;

/**
 * Crea un attrezzo
 * @author fabrizio
 * @param nome il nome che identifica l'attrezzo
 * @param peso il peso dell'attrezzo
 * @version 0.1
 */
public class Attrezzo {
	private String nome;
	private int peso;
	/**
	 * 
	 * @param nome il nome che identifica l'attrezzo
	 * @param peso il peso dell'attrezzo
	 */
	public Attrezzo(String nome, int peso) {
		this.nome= nome;
		this.peso= peso;
	}
	/**
	 * fornisce il nome dell'attrezzo
	 * @return identificatore dell'attrezzo
	 */
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * restituisce il peso dell'attrezzo
	 * @return peso dell'attrezzo
	 */
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public String toString() {
		return "Attrezzo di nome " + this.nome + ". Peso:" + this.peso;
	}
	

}
