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
		final Map<Class<? extends Formica>,Set<Cibo>> tipologia2cibo = raccoltoPerTipoDiFormica(raccolto);
		stampaRaccoltoPerTipoDiFormica(tipologia2cibo);
		System.out.println();

		// (VEDI DOMANDA 5)
		System.out.println("Classifica finale delle strategie di raccolta:");
		final List<Class<? extends Formica>> classificaTipo = ordinaStrategieDiRaccolta(tipologia2cibo);
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
		Map<Formica, Integer> raccoltoXformica=new HashMap<>();
		for(Cibo cibo: raccolto){
			Formica raccoglitrice = cibo.getRaccoglitrice();
			if(!raccoltoXformica.containsKey(raccoglitrice))
				raccoltoXformica.put(raccoglitrice, 1);
			else {
				Integer giaRaccolto = raccoltoXformica.get(cibo.getRaccoglitrice());
				raccoltoXformica.put(raccoglitrice, giaRaccolto+1);
			}
			
		}
		
		return raccoltoXformica;
		
	}


	/**
	 *  <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 3</EM>
	 * @param formica2quantita
	 */
	private void stampaRaccoltoPerFormica(final Map<Formica, Integer> formica2quantita) {
		// N.B. il tipo del parametro e' migliorabile dopo aver svolto la domanda 2
		for(Formica formica : formica2quantita.keySet()) {
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
	public Map<Class<? extends Formica>, Set<Cibo>> raccoltoPerTipoDiFormica(Set<Cibo> raccolto) {
		// DA COMPLETARE (VEDI DOMANDA 4)
		Map<Class<? extends Formica>, Set<Cibo>> raccoltoXtipo= new HashMap<>();
		
		for(Cibo cibo: raccolto) {
			Class<? extends Formica> tipo = cibo.getRaccoglitrice().getClass();
			if(!raccoltoXtipo.containsKey(tipo)) {
				Set<Cibo> raccoltiDaQuestoTipo = new HashSet<>();
				raccoltiDaQuestoTipo.add(cibo);
				raccoltoXtipo.put(tipo, raccoltiDaQuestoTipo);
			}
			else {
				Set<Cibo> raccoltiDaQuestoTipo = raccoltoXtipo.get(tipo);
				raccoltiDaQuestoTipo.add(cibo);
			}
		}
		return raccoltoXtipo;
	}

	/**
	 *  <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 4</EM>
	 * @param tipo2cibo
	 */
	private void stampaRaccoltoPerTipoDiFormica(final Map<Class<? extends Formica>, Set<Cibo>> tipo2cibo) {
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
	public List<Class<? extends Formica>> ordinaStrategieDiRaccolta( final Map<Class<? extends Formica>, Set<Cibo>> c2c) {
		// DA COMPLETARE (VEDI DOMANDA 5)
		List<Class<? extends Formica>> classifica=new ArrayList<>(c2c.keySet());
		Collections.sort(classifica, new Comparator<Class<? extends Formica>>() {

			@Override
			public int compare(Class<? extends Formica> tipo1, Class<? extends Formica> tipo2) {
				return c2c.get(tipo1).size()-c2c.get(tipo2).size();
			}

			
		});
		
		return classifica;
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI DOMANDA 5</EM>
	 * @param classifica
	 * @param tipo2cibo
	 */
	private void stampaClassificaStrategie(List<Class<? extends Formica>> classifica, Map<Class<? extends Formica>, Set<Cibo>> tipo2cibo) {
		if (classifica==null) return;
		
		for(int i=1; i<classifica.size()+1; i++) {
			final Class<?> tipo = classifica.get(i-1);
			System.out.println(i+") "+tipo.getSimpleName()+" con "+tipo2cibo.get(tipo).size()+" unita' di cibo");
		}
	}
}
