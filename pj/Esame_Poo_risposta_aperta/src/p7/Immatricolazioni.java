package p7;
/*Senza cambiare la classe Studente, riscrivere il metodo compare() di 
 * ComparatoreStudentePerEtaMatricola ed il metodo elencoOrdinatoPerEtaMatricola() di Immatricolazioni 
 * affinche' quest'ultimo restituisca l'elenco degli studenti ordinato per eta' ed in subordine,
 *  a parita' di eta', per matricola
 */

import java.util.*;

class Studente implements Comparable<Studente> {
    //NON toccare il codice di questa classe
    private String matricola;
    private int eta;

    public Studente(String matricola, int eta) {
        this.matricola = matricola;
        this.eta = eta;
    }
    //NON toccare il codice di questa classe
    public String getMatricola() {
        return this.matricola;
    }

    public int getEta() {
        return this.eta;
    }

    public int compareTo(Studente studente) {
        return this.getEta() - studente.getEta();
    }
    //NON toccare il codice di questa classe
}

class ComparatoreStudentePerEtaMatricola implements Comparator<Studente> {

    public int compare(Studente p1, Studente p2) {
        int output;
        output= p1.getEta()-p2.getEta();
        if(output==0)
        	output= p1.getMatricola().compareTo(p2.getMatricola());
        return output;
    }
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
        

        
        List<Studente> elencoOrdinato = null;
		for(Studente stud: this.elenco)
        	elencoOrdinato.add(stud);
        Collections.sort(elencoOrdinato, new ComparatoreStudentePerEtaMatricola());
        return elencoOrdinato;
    }
}
