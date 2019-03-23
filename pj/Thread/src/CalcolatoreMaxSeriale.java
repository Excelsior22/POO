import java.util.NoSuchElementException;

interface CalcolatoreMax {
	public int calcolaIlMaxDi(int[] array) ;
}

//codice

public class CalcolatoreMaxSeriale implements CalcolatoreMax {
	@Override
	public int calcolaIlMaxDi(int[] array) {
		return calcolaIlMaxDi(array, 0, array.length);
	}
	public int calcolaIlMaxDi(int[] array, int inizio, int fine) {
		if (fine-inizio==0) throw new NoSuchElementException();
		int max = array[inizio];
		for(int i=inizio+1; i<fine; i++) {
			if (array[i]>max)
				max = array[i];
		}
		return max;
	}
}

