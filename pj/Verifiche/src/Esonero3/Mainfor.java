package Esonero3;

public class Mainfor {
	public static void main(String[] args) {
		
		final Ver_dup persone= new Ver_dup(3);
		persone.aggiungiNome("A", 0);
		persone.aggiungiNome("A", 1);
		persone.aggiungiNome("C", 2);
		
		System.out.println(persone.verificaDuplicati("A"));
		ContatoreOccorrenzePosizione c= new ContatoreOccorrenzePosizione();
		String[] daControllare={"a", "b", "c"};
		String[] sequenza={"a","c","a","e"};
		int[] occ;
		occ=c.contaOccorrenze(sequenza, daControllare);
		for(int a:occ) {
			System.out.println(a);
		}
		
		
		
		
		
	}

}
