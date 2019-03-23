package p3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Persona2 {
    private String nome;
    private int eta;
    private String cognome;

    
    public Persona2(String cognome, String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
        this.cognome = cognome;

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
}


public class ElencoPersone3 {
    private List<Persona> elenco;
    
    public ElencoPersone3(){
        this.elenco = new ArrayList<Persona>();
    }

    public void aggiungiPersona(Persona persona) {
        this.elenco.add(persona);
    }

    public Map<Integer, List<Persona>> eta2persona() {
        Map<Integer, List<Persona>> eta2persona = new HashMap<Integer, List<Persona>>(); 
        // scrivere il codice di questo metodo
        // deve ritornare una mappa che ha per chiave un eta'
        //   per valore una lista delle persone di elenco con eta' uguale alla chiave

        List<Persona> persone;
        
        if(this.elenco==null)
        	return Collections.emptyMap();
        
        for(Persona persona: this.elenco){
              persone = eta2persona.get(persona.getEta());

        if(persone==null)
        	persone = new ArrayList<Persona>();
        persone.add(persona);
        eta2persona.put(persona.getEta(), persone);
        }
        return eta2persona;
    }
}
