package p6;

import java.util.HashSet;

public class Mainforme {
	public static void main(String[] args) {

		Studente fabrizio;
		Studente gianni;
		Studente luigi;
		Studente gianni2;
		Studente antonio;

		fabrizio= new Studente("1","fabrizio");
		gianni= new Studente("2","gianni");
		luigi= new Studente("3","luigi");
		gianni2= new Studente("4","gianni");
		antonio= new Studente("1","antonio");
		ContatoreDiStudenti cont= new ContatoreDiStudenti();
		
		HashSet<Studente> studenti;
		studenti= new HashSet<Studente>();
		studenti.add(fabrizio);
		studenti.add(gianni);
		studenti.add(luigi);
		studenti.add(gianni2);
		studenti.add(antonio);
		
		System.out.println(cont.contaMatricoleDellInsieme(studenti));
		
		
	}
}
