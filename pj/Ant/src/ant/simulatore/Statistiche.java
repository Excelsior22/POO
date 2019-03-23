package ant.simulatore;


import java.util.*;

import ant.Ambiente;
import ant.Cibo;
import ant.Formicaio;
import ant.formica.Formica;

public class Statistiche {

	synchronized public void stampaStatisticheFinali(Ambiente ambiente) {
		final Formicaio formicaio = ambiente.getFormicaio();

		final Set<Cibo> raccolto = formicaio.getCiboRaccolto();
		System.out.println("Totale cibo presente nel formicaio: " + raccolto.size());
		System.out.println();

		// (VEDI DOMANDA 3)
		System.out.println("Quantita' raccolta da ciascuna formica:");
		final Map<Formica,Integer> formica2quantita = raccoltoPerFormica(raccolto);
		stampaRaccoltoPerFormica(formica2quantita);
		System.out.println();

		// (VEDI DOMANDA 4)
		System.out.println("Quantita' di cibo raccolto per ciascuna tipologia di formica:");
		final Map<Class<?>,Set<Cibo>> tipologia2cibo = raccoltoPerTipoDiFormica(raccolto);
		stampaRaccoltoPerTipoDiFormica(tipologia2cibo);
		System.out.println();

		// (VEDI DOMANDA 5)
		System.out.println("Classifica finale delle strategie di raccolta:");
		final List<Class<?>> classificaTipo = ordinaStrategieDiRaccolta(tipologia2cibo);
		stampaClassificaStrategie(classificaTipo,tipologia2cibo);
		System.out.println();
	}


	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 3)</B>
	 * @param raccolto - insieme di unita' di cibo raccolte
	 * @return una mappa che conti per ogni formica quante unita' di cibo ha raccolto
	 */
	public Map<Formica, Integer> raccoltoPerFormica(Set<Cibo> raccolto) {
		// DA COMPLETARE (VEDI DOMANDA 3)
		// N.B. il tipo restituito e' migliorabile dopo aver svolto la domanda 2
		Map<Formica, Integer> raccoltoPerFormica= new HashMap<>();
		for(Cibo cibo: raccolto) {
			Formica form= cibo.getRaccoglitrice();
			if(!raccoltoPerFormica.containsKey(form)) {
				Integer num= new Integer(1);
				raccoltoPerFormica.put(form, num);
			}
			else {
				int valore= raccoltoPerFormica.get(form).intValue();
				valore++;
				Integer nuovoNum= new Integer(valore);
				raccoltoPerFormica.put(form, nuovoNum);
			}
		}
		return raccoltoPerFormica;
	}


	/**
	 *  <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 * @param formica2quantita
	 */
	private void stampaRaccoltoPerFormica(final Map<Formica, Integer> formica2quantita) {
		// N.B. il tipo del parametro e' migliorabile dopo aver svolto la domanda 2
		for(Object formica : formica2quantita.keySet()) {
			Integer quantita = formica2quantita.get(formica);
			if (quantita==null)
				quantita = 0;
			System.out.println("La formica "+formica+" ha raccolto "+quantita);
		}
	}

	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 4)</B>
	 * @param raccolto - l'insieme di unita' di cibo raccolte
	 * @return una mappa che riporta per ciascuna tipologia di formiche quante unita' di cibo ha raccolto
	 */
	public Map<Class<?>, Set<Cibo>> raccoltoPerTipoDiFormica(Set<Cibo> raccolto) {
		// DA COMPLETARE (VEDI DOMANDA 4)
		Map<Class<?>, Set<Cibo>> raccoltoPerTipoDiFormica= new HashMap<>();
		for(Cibo cibo: raccolto) {
			Class<?> classe= cibo.getRaccoglitrice().getClass();
			if(!raccoltoPerTipoDiFormica.containsKey(classe)) {
				Set<Cibo> Cibo = new HashSet<>();
				Cibo.add(cibo);
				raccoltoPerTipoDiFormica.put(classe, Cibo);
			}
			else {
				Set<Cibo> Cibo= raccoltoPerTipoDiFormica.get(classe);
				Cibo.add(cibo);
				raccoltoPerTipoDiFormica.put(classe, Cibo);
			}
		}
		return raccoltoPerTipoDiFormica;
	}

	/**
	 *  <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 4</EM>
	 * @param tipo2cibo
	 */
	private void stampaRaccoltoPerTipoDiFormica(final Map<Class<?>, Set<Cibo>> tipo2cibo) {
		if (tipo2cibo==null) return;

		for(Class<?> tipo : tipo2cibo.keySet()) {
			Set<Cibo> raccolto = tipo2cibo.get(tipo);
			System.out.println("Le formiche di tipo "+tipo.getSimpleName()+" hanno raccolto "+raccolto.size());
		}
	}

	/**
	 * <B>DA COMPLETARE (VEDI DOMANDA 5)</B>
	 * @param c2c una mappa che per ogni tipologia di formica riporta quante unita' ha raccolto
	 * @return una lista ordinata degli oggetti {@link Class} associati ai diversi tipi di {@link Formica}
	 */
	@SuppressWarnings("unchecked")
	public List<Class<?>> ordinaStrategieDiRaccolta(final Map<Class<?>, Set<Cibo>> c2c) {
		// DA COMPLETARE (VEDI DOMANDA 5)
		List<Class<?>> lista= new ArrayList<>(c2c.keySet());
		
		class OrdinatorePerCibo implements Comparator<Class<?>>{

			@Override
			public int compare(Class<?> tipo1, Class<?> tipo2) {
				int output= -c2c.get(tipo1).size()+c2c.get(tipo2).size();
				if(output==0) {
					output= 1;
				}
				return output;
			}	
		}
		@SuppressWarnings("rawtypes")
		Comparator comp= new OrdinatorePerCibo();
		Collections.sort(lista, comp);
		return lista;
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 5</EM>
	 * @param classifica
	 * @param tipo2cibo
	 */
	private void stampaClassificaStrategie(List<Class<?>> classifica, Map<Class<?>, Set<Cibo>> tipo2cibo) {
		if (classifica==null) return;
		
		for(int i=1; i<classifica.size()+1; i++) {
			final Class<?> tipo = classifica.get(i-1);
			System.out.println(i+") "+tipo.getSimpleName()+" con "+tipo2cibo.get(tipo).size()+" unita' di cibo");
		}
	}
}
