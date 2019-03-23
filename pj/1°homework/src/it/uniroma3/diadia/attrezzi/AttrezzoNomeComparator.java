package it.uniroma3.diadia.attrezzi;
import java.util.Comparator;


public class AttrezzoNomeComparator implements Comparator<Attrezzo> {
	
	@Override
	public int compare(Attrezzo o1, Attrezzo o2) {
		int diffNome= o1.getNome().compareTo(o2.getNome());
		if(diffNome!=0) {
			return diffNome;
		}
		return o1.getPeso()-o2.getPeso();
	}

}
