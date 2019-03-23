package p4;

import java.util.*;


class Studente implements Comparable<Studente> {
    private String matricola;
    private int eta;

    public Studente(String matricola, int eta) {
        this.matricola = matricola;
        this.eta = eta;
    }

    public String getMatricola() {
        return this.matricola;
    }

    public int getEta() {
        return this.eta;
    }

    public int compareTo(Studente that) {
    	if(this.eta == that.getEta())
        	return this.matricola.compareTo(that.getMatricola());
        return this.eta-that.getEta();
        
}
	public class Immatricolazioni {
		private List<Studente> elenco;

		public Immatricolazioni() {
			this.elenco = new ArrayList<Studente>();
		}

		public void aggiungiStudente(Studente studente) {
			this.elenco.add(studente);
		}

		public List<Studente> elencoOrdinatoPerEtaMatricola() {
			List<Studente> elencoOrdinato = new ArrayList<Studente>();

			for(Studente studente: this.elenco){
				elencoOrdinato.add(studente);
			}
			Collections.sort(elencoOrdinato);

			return elencoOrdinato;
		}
	}
}