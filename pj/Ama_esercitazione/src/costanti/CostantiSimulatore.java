package ama.costanti;

public class CostantiSimulatore {

	/**
	 * La {@link Citta} è un quadrato di queste dimensioni (incluso i bordi)
	 */
	static final public int DIMENSIONE = 32;

	/**
	 * Numero di mezzi per ogni tipologia
	 */
	static final public int NUMERO_MEZZI_PER_TIPOLOGIA = 5;

	/**
	 * Durata (in passi) totale della simulazione
	 */
	static final public int DURATA_SIMULAZIONE = 250;

	/**
	 * Pausa (in millisecondonsi) tra due passi consecutivi della simulazione
	 */
	static final public int RITMO = 50; // millis
	
	/**
	 * Probabilità di aggiungere un rifiuto ad ogni passo
	 */
	static final public double PROBABILITA_RIFIUTO = 0.65d;
	
	/**
	 * Massimo carico prima di dover svuotare presso il centro di raccolta
	 */
	static final public int MAX_CARICO = 5;

	/**
	 * Durata (in passi) prima che la raccolta deve concludersi
	 * per fine del turno lavorativo
	 */
	static final public int DURATA_MAX_TURNO = 50;

	/**
	 * Durata (in passi) per lo smaltimento dei rifiuti
	 * di un carico raccolto da un mezzo presso il centro di raccolta
	 */
	static final public int DURATA_SMALTIMENTO  = 10;

}
