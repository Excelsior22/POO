package ama.simulatore;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import ama.CentroDiRaccolta;
import ama.Citta;
import ama.mezzo.Mezzo;
import ama.rifiuto.Rifiuto;

public class Statistiche {

	public void stampaStatisticheFinali(Citta citta) {
		final CentroDiRaccolta centro = citta.getCentroDiRaccolta();

		final Set<Rifiuto> smaltiti = centro.getRifiutiSmaltiti();
		System.out.println("Rifiuti smaltiti in totale: " + smaltiti.size());
		System.out.println();
		
		// (VEDI DOMANDA 3 - metodo da completare a seguire)
		System.out.println("Quantita' raccolta da ciascun mezzo impegnato:");
		final Map<Mezzo,Integer> mezzo2quantita = raccoltoPerMezzo(smaltiti);
		stampaRaccoltoPerMezzo(mezzo2quantita);
		System.out.println();
		
		// (VEDI DOMANDA 4 - metodo da completare a seguire)
		System.out.println("Quantita' raccolta per ogni politica:");
		final Map<Class<?>,Integer> politica2quantita = raccoltoPerPolitica(smaltiti);
		stampaRaccoltoPerPolitica(politica2quantita);
		System.out.println();
		
		// (VEDI DOMANDA 5 - metodo da completare a seguire)
		System.out.println("Classifica finale delle politiche raccolta:");
		final List<Class<?>> classificaTipo = ordinaPolitichePerRaccolta(politica2quantita);
		stampaClassificaPolitiche(classificaTipo);
		System.out.println();

		// (VEDI DOMANDA 7 - metodo da completare a seguire)
		System.out.println("Classifica finale dei mezzi per raccolta:");
		final SortedSet<Mezzo> classificaMezzi = ordinaMezziPerRaccolta(mezzo2quantita);
		stampaClassificaMezzi(classificaMezzi);
		System.out.println();
		
	}

	public Map<Mezzo, Integer> raccoltoPerMezzo(Set<Rifiuto> smaltiti) {
		final Map<Mezzo,Integer> mezzo2quantita = new HashMap<>();
		// DA COMPLETARE (VEDI DOMANDA 3)
		for(Rifiuto rifiuto: smaltiti) {
			Mezzo mezzo= rifiuto.getRaccoglitore();
			if(!mezzo2quantita.containsKey(mezzo)) {
				Integer numero= new Integer(1);
				mezzo2quantita.put(mezzo, numero);
			}
			else {
				Integer numero= mezzo2quantita.get(mezzo);
				int num= numero.intValue();
				num++;
				Integer numeroAgg= new Integer(num);
				mezzo2quantita.put(mezzo, numeroAgg);
			}
		}
		return mezzo2quantita;
	}

	//  UTILE PER STAMPARE RISULTATI DOMANDA 3
	private void stampaRaccoltoPerMezzo(final Map<Mezzo, Integer> mezzo2quantita) {
		for(Mezzo mezzo : mezzo2quantita.keySet()) {
			Integer quantita = mezzo2quantita.get(mezzo);
			if (quantita==null)
				quantita = 0;
			System.out.println("Il mezzo "+mezzo.getPolitica().toString()+" ha raccolto "+quantita);
		}
	}

	public Map<Class<?>, Integer> raccoltoPerPolitica(Set<Rifiuto> smaltiti) {
		final Map<Class<?>,Integer> politica2quantita = new HashMap<>();
		// DA COMPLETARE (VEDI DOMANDA 4)
		for(Rifiuto rifiuto: smaltiti) {
			Class<?> classe= rifiuto.getRaccoglitore().getPolitica().getClass();
			if(!politica2quantita.containsKey(classe)) {
				Integer valore= new Integer(1);
				politica2quantita.put(classe, valore);
			}
			else {
				Integer valorePrec= politica2quantita.get(classe);
				Integer valoreAgg= new Integer(valorePrec.intValue()+1);
				politica2quantita.put(classe, valoreAgg);
			}
		}
		return politica2quantita;
	}

	// UTILE PER STAMPARE RISULTATI DOMANDA 4
	private void stampaRaccoltoPerPolitica(final Map<Class<?>, Integer> tipo2quantita) {
		for(Class<?> tipo : tipo2quantita.keySet()) {
			Integer q = tipo2quantita.get(tipo);
			if (q==null)
				q = 0;
			System.out.println("La politica "+tipo.getSimpleName()+" ha raccolto "+q);
		}
	}
	
	
	public List<Class<?>> ordinaPolitichePerRaccolta(final Map<Class<?>, Integer> politica2quantita) {
		// DA COMPLETARE (VEDI DOMANDA 5)
		List<Class<?>> PoliticheXRaccolta= new ArrayList<Class<?>>(politica2quantita.keySet());
		class ComparatorePerIntero implements Comparator<Class<?>>{
			@Override
			public int compare(Class<?> tipo1, Class<?> tipo2) {
				return politica2quantita.get(tipo2).intValue()-politica2quantita.get(tipo1).intValue();
			}
		}
		Collections.sort(PoliticheXRaccolta, new ComparatorePerIntero());
		return PoliticheXRaccolta;
	}
	
	/* Altra soluzione
	 * public List<Class<?>> ordinaPolitichePerRaccolta(final Map<Class<?>, Integer> politica2quantita) {
		// DA COMPLETARE (VEDI DOMANDA 5)
		List<Class<?>> PoliticheXRaccolta= new ArrayList<Class<?>>(politica2quantita.keySet());
		Collections.sort(PoliticheXRaccolta, new Comparator<Class<?>>() {
			@Override
			public int compare(Class<?> tipo1, Class<?> tipo2) {
				return politica2quantita.get(tipo1).intValue()-politica2quantita.get(tipo2).intValue();
			}

		});	s
		return PoliticheXRaccolta;
	}
	 */

	//  UTILE PER STAMPARE RISULTATI DOMANDA 5
	private void stampaClassificaPolitiche(List<Class<?>> classifica) {
		for(int i=1; i<classifica.size()+1; i++)
			System.out.println(i+") "+classifica.get(i-1).getSimpleName());
	}

	public SortedSet<Mezzo> ordinaMezziPerRaccolta(final Map<Mezzo, Integer> mezzo2quantita) {
		// DA COMPLETARE (VEDI DOMANDA 7)
		class ComparatorePerIntero implements Comparator<Mezzo>{
			@Override
			public int compare(Mezzo tipo1, Mezzo tipo2) {
				int output= mezzo2quantita.get(tipo2).intValue()-mezzo2quantita.get(tipo1).intValue();	
				if( output==0)
					output=tipo1.getPolitica().getClass().hashCode()-tipo2.getPolitica().getClass().hashCode();
				return output;
			}
		}
		SortedSet<Mezzo> MezziXRaccolta= new TreeSet<Mezzo>(new ComparatorePerIntero());
		MezziXRaccolta.addAll(mezzo2quantita.keySet());
		return MezziXRaccolta;
	}

	//  UTILE PER STAMPARE RISULTATI DOMANDA 7
	private void stampaClassificaMezzi(SortedSet<Mezzo> classifica) {
		int posto = 1;
		for(Mezzo mezzo : classifica) {
			System.out.println(posto+") "+mezzo.getPolitica().toString());
			posto++;
		}
	}
}
