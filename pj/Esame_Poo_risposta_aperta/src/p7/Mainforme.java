package p7;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import p6.ContatoreDiStudenti;


public class Mainforme {
	public static void main(String[] args) {

		Studente fabrizio;
		Studente gianni;
		Studente luigi;
		Studente gianni2;
		Studente antonio;

		fabrizio= new Studente("1",18);
		gianni= new Studente("2", 15);
		luigi= new Studente("3", 17);
		gianni2= new Studente("3", 18);
		antonio= new Studente("4", 17);
		
		Immatricolazioni imm= new Immatricolazioni();
		imm.aggiungiStudente(fabrizio);
		imm.aggiungiStudente(gianni);
		imm.aggiungiStudente(luigi);
		imm.aggiungiStudente(gianni2);
		imm.aggiungiStudente(antonio);
		
		List<Studente> list;
		list= (List) imm.elencoOrdinatoPerEtaMatricola();
		Iterator<Studente> iter= list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next().getMatricola());
		}
		
		
		
		
		
		
	}
}
