package Hashset_Treeset;
import java.util.*;

public class ComparatoreDiStudenti  implements Comparator<Studente>{
	@Override
	public int compare(Studente s1, Studente s2) {
		return s1.getNome().compareTo(s2.getNome());
	}

}
