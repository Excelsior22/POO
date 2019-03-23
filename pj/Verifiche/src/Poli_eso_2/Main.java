package Poli_eso_2;

public class Main {
	
	public static void main(String[] args) {
		Persone gente= new Persone(5);
		gente.aggiungiNome("Fabrizio", 0);
		gente.aggiungiNome("Micol", 1);
		gente.aggiungiNome("Micol", 2);
		gente.aggiungiNome("Mirko", 3);
		gente.aggiungiNome("Matteo", 4);
		
		System.out.println(gente.verificaDuplicati("Micol"));
		System.out.println(gente.verificaDuplicati("Fabrizio"));
		
		/*Prova di ContatoreOccorrenzePosizione*/
		
		String[] daControllare = {"a","a","c","a"};
		String[] sequenza= {"a","c","c"};
		int[] risultato;
		ContatoreOccorrenzePosizione num_occ= new ContatoreOccorrenzePosizione();
		risultato= num_occ.contaOccorrenze(sequenza, daControllare);
		for(int num: risultato) {
			System.out.println(num );
		}
				
		
	}

}
