package p3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Persona {
    private String cognome;
    private String nome;
    private int eta;
    
    public Persona(String cognome, String nome, int eta) {
        this.cognome = cognome;
        this.nome = nome;
        this.eta = eta;
    }

    public int getEta() {
        return this.eta;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getCognome() {
        return this.cognome;
    }
    
    public int compareTo(Persona persona) {
        return this.getEta() - persona.getEta();
    }    
}

class ComparaPersonePerCognomeNome implements Comparator<Persona> {

    public int compare(Persona p1, Persona p2) {
    	return p1.getCognome().compareTo(p2.getCognome()) - 
    			p1.getNome().compareTo(p2.getNome());
    }
}

public class ElencoPersone2 {
    private List<Persona> elenco;
    
    public ElencoPersone2() {
        this.elenco = new ArrayList<Persona>();
    }

    public void aggiungiPersona(Persona persona) {
        this.elenco.add(persona);
    }

    public List<Persona> elencoOrdinatoPerCognomeNome() {
        List<Persona> elencoOrdinato = new ArrayList<Persona>(); 
        
        // scrivere il codice di questo metodo
        // deve ritornare una copia di elenco con gli elementi
        // ordinati per cognome e nome
        // NON e' possibile modificare la classe Persona
        
        for(Persona persona: this.elenco){
        	elencoOrdinato.add(this.elenco.get(persona.getEta()));
        	
        	Collections.sort(elencoOrdinato, new ComparaPersonePerCognomeNome());
        }
        return elencoOrdinato;
    }
}