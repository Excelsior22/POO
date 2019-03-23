package prova;

public class Dummy {
	public int search(String[] elenco, String parola) {
	/*restituisce la posizione della string parola nell'array ELENCO o
	 * -1 se tale STRING non è contenuta nell'array
	 */
	int i=0;
	for (String stringacorrente: elenco) {
		if(stringacorrente.equals(parola)){
			return i;
		}
		i++;
	}
return -1;
}



public void searchTest() {
	//Inizializzazione elenco
	System.out.println ("test di search():");
	String [] elenco= new String [5];
	elenco [0]= new String("anna");
	elenco [1]= new String("carla");
	elenco [2]= new String("sedia");
	elenco [3]= new String("sei");
	elenco [4]= new String("puma");
	
	//output positivi
	System.out.println("\t"+(this.search(elenco, new String("sedia"))==2));
	System.out.println("\t"+(this.search(elenco, new String("sei"))==3));
	System.out.println("\t"+(this.search(elenco, new String("carla"))==1));
	System.out.println("\t"+(this.search(elenco, new String("puma"))==4));
	System.out.println("\t"+(this.search(elenco, new String("anna"))==0));
	
	//output negativi
	
	System.out.println("\t"+(this.search(elenco, new String("mela"))==-1));
	System.out.println("\t"+(this.search(elenco, new String("zuppa"))==-1));
	System.out.println("\t"+(this.search(elenco, new String("torta"))==-1));
	System.out.println("\t"+(this.search(elenco, new String("casa"))==-1));
}
	
public static void main (String[] args) {
	Dummy dummy= new Dummy();
	dummy.searchTest();
}
}
	
	