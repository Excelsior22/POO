
public class CalcolatoreMaxParallelo implements CalcolatoreMax {
	final private CalcolatoreMaxSeriale calcolatoreSeriale = new CalcolatoreMaxSeriale();
	@Override
	public int calcolaIlMaxDi(final int[] array) {
		int _N_CORE = Runtime.getRuntime().availableProcessors();
		final int[] maxRelativi = new int[_N_CORE];
		final Thread[] lavoratori = new Thread[_N_CORE];
		int dimensioneFetta = ( array.length ) / _N_CORE;
		for(int i=0; i<_N_CORE; i++) {
			final int inizio_fetta =
					dimensioneFetta * i;
			final int fine_fetta = Math.min(array.length, inizio_fetta+dimensioneFetta);
			final int indiceFetta = i;
			lavoratori[indiceFetta] = new Thread(new Runnable() {
				@Override
				public void run() {
					maxRelativi[indiceFetta]=calcolatoreSeriale.calcolaIlMaxDi(array, inizio_fetta, fine_fetta);
				}
			});
			lavoratori[i].start();
		}
		for(int i=0; i<_N_CORE; i++) { // aspetta abbiano tutti terminato
			
			try { lavoratori[i].join(); } catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			
		}
		return calcolatoreSeriale.calcolaIlMaxDi(maxRelativi);
	}
	
}