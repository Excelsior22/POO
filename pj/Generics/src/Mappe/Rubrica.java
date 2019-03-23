package Mappe;
import java.util.*;


public class Rubrica {
	private Map<String, Integer> rubrica;

	public Rubrica () {
		this.rubrica= new HashMap<String, Integer>();    //Da java 7 basta new HashMap<>();
	}

	public void Inserisci(String nome, Integer intero) {
		this.rubrica.put(nome, intero);
	}

	public void Rimuovi(String nome) {
		this.rubrica.remove(nome);
	}

	public Set<String> nomiInRubrica(){
		return this.rubrica.keySet();           //Inisieme di tutte le chiavi
	}

	public Integer DammiIlNumeroDi(String nome) {
		return this.rubrica.get(nome);
	}

	public Integer aggiornaNumero(String nome, Integer numero) {
		return this.rubrica.put(nome, numero);
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("-------------------------------------------------\n");
		str.append("Rubrica\n");
		Set<String> nomi= this.rubrica.keySet();
		for(String s: nomi) {
			str.append(s);
			str.append(": ");
			str.append(this.rubrica.get(s));
			str.append("\n");
		}
		str.append("-------------------------------------------------\n");
		return str.toString();
	}
	
	public static void main(String[] args) {
		Rubrica r= new Rubrica();
		String s1= new String("Paolo"), s2= new String ("Fabio");
		String s3= new String("Anna"), s4= new String ("Carla");
		
		
		r.Inserisci(s1, 1111111111);
		r.Inserisci(s2, 222222222);
		r.Inserisci(s3, 333333333);
		System.out.println(r.toString());
		
		Integer numeroCercato= r.DammiIlNumeroDi(s4);
		if(numeroCercato==null)
			System.out.println("Il numero di "+s4+" non esiste");
		else
			System.out.println("Il numero di "+s4+" è "+numeroCercato);
		
		r.Rimuovi(s2);
		
		Integer nuovoNumero=444444444;
		Integer vecchioNumero= r.aggiornaNumero(s1, nuovoNumero);
		System.out.println("Aggiornato il numero di "+s1+" da "+vecchioNumero+" a "+ nuovoNumero );
		System.out.println(r.toString());
		
	}


}

