/*
   Obiettivo: verifica comprensione riferimenti ad oggetti

   Leggere attentamente il programma.
   - cosa stampa ?
   - perche' ?
   - tracciare l'evoluzione dello stato del programma attraverso un diagramma degli oggetti 
   - compilare ed eseguire il programma per verificare la risposta
   - NB: leggere attentamente il codice del metodo 	getRelatore()
*/

public class Tesi {
	private Persona studente;
	private Persona relatore;
	private String titolo;

	public Tesi(Persona studente, Persona relatore, String titolo) {
		this.studente = studente;
		this.relatore = relatore;
		this.titolo = titolo;
	}

	public Persona getStudente() {
		return this.studente;
	}

	public Persona getRelatore() {
		return new Persona(this.relatore.getNome(), this.relatore.getCognome(), this.relatore.getEta());
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setStudente(Persona studente) {
		this.studente = studente;
	}

	public void setRelatore(Persona relatore) {
		this.relatore = relatore;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public static void main(String[] args) {
	
		Persona p1 = new Persona("Paolo", "Rossi", 22);
		Persona p2 = new Persona("Antonio", "Bianchi", 33);

		p1 = p2;

		p2.setCognome("Bruni");

		System.out.println(p1.getCognome()+" "+p1.getNome()+" "+p1.getEta());

		Persona p3 = new Persona("Bill", "Gates", 44);

		Tesi tesi = new Tesi(p1, p3, "I misteri di Windows");
		p2 = tesi.getRelatore();
		p2.setCognome("Jobs");
		p2.setNome("Steve");

		Persona p4 = tesi.getStudente();
		p4.setNome("Mariolina");
		p4.setCognome("Taddei");

		System.out.println("Relatore:");
		System.out.println(tesi.getRelatore().getCognome()+" "+tesi.getRelatore().getNome()+" "+tesi.getRelatore().getEta());

		System.out.println("Studente:");
		System.out.println(tesi.getStudente().getCognome()+" "+tesi.getStudente().getNome()+" "+tesi.getStudente().getEta());

		System.out.println("Titolo:");
		System.out.println(tesi.getTitolo());

	}

}   //anotnio bruni 33 steve jobs 44 mariolina taddei 33 i misteri di win

class Persona {
	String nome;
	String cognome;
	int eta;

	public Persona(String nome, String cognome, int eta) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}
}
