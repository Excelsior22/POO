/**
 * 
 */
package it.uniroma3.diadia;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.AttrezzoNomeComparator;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Questa classe ha la funzione di gestire la borsa del
 * giocatore, svolgendo operazioni con gli attrezzi contenuti.
 * 
 * @author fabrizio
 *
 */
public class Borsa {
	
	private static Properties prop;
	private Map<String, Attrezzo> attrezzi;
    private int pesoMax;
    private AttrezzoNomeComparator comp;
    private static int peso_max_default;
    
    {
 	prop= new Properties();
	try {
		prop.load(new FileReader("resource/diadia.properties"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	peso_max_default= Integer.parseInt(prop.getProperty("DEFAULT_PESO_MAX_BORSA"));
    }
 

    

	public Borsa() {
		this(peso_max_default);

    }
    
    public Borsa(int pesoMax) {
    	this.pesoMax= pesoMax;
    	this.attrezzi= new HashMap<String, Attrezzo>();
    }
    
	/**
     * Mette un attrezzo nella borsa.
     * @param attrezzo l'attrezzo da mettere nella borsa.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
    	if(this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
    		return false;
    	attrezzi.put(attrezzo.getNome(),attrezzo);
    	return true;
    	
    }
    
    public int getPesoMax() {
 		return this.pesoMax;
 	}
    
    public int getNumeroAttrezzi() {
		return this.attrezzi.size();
	}
    
    public Map<String, Attrezzo> getAttrezzi() {
 		return this.attrezzi;
 	}
    
	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella borsa.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella borsa.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}
	
    public int getPeso() {
    	int peso=0;
    	for(Attrezzo attrezzo: this.attrezzi.values()) {
    		peso+= attrezzo.getPeso();
    	}
    	return peso;
    }
    
    public boolean isEmpty() {
    	return this.attrezzi.size()==0;
    }
    
    /**
	* Controlla se un attrezzo esiste nella borsa (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella borsa, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}
	
	/**
	 * Rimuove un attrezzo dalla borsa (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzi.containsKey(attrezzo.getNome())) {
			this.attrezzi.remove(attrezzo.getNome());
			return true;
		}
		return false;
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		
		List<Attrezzo> attrezziOrdinatiPerPeso= new ArrayList<>(this.attrezzi.size());
		attrezziOrdinatiPerPeso.addAll(this.attrezzi.values());
		Collections.sort(attrezziOrdinatiPerPeso);
		return attrezziOrdinatiPerPeso;
	}
	
	public List<Attrezzo> listanomi(){
		comp= new AttrezzoNomeComparator();
		List<Attrezzo> s= new ArrayList<>(this.attrezzi.size());
		s.addAll(this.attrezzi.values());
		Collections.sort(s,comp);
		return s;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		
		comp= new AttrezzoNomeComparator();
		SortedSet<Attrezzo> attrezziOrdinatiPerNome= new TreeSet<Attrezzo>(comp);
		attrezziOrdinatiPerNome.addAll(this.attrezzi.values());
		return attrezziOrdinatiPerNome;
		
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> attrezziOrdinatiPerPeso= new TreeSet<>();
		attrezziOrdinatiPerPeso.addAll(this.attrezzi.values());
		return attrezziOrdinatiPerPeso;
	}
	
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> AttrezziOrdinatiPerPeso= new TreeMap<>();
		Set<Attrezzo> tmp;
		for (Attrezzo attrezzo: this.attrezzi.values()) {
			tmp=AttrezziOrdinatiPerPeso.get(attrezzo.getPeso());
			if(tmp==null) {
				tmp= new HashSet<Attrezzo>();
				AttrezziOrdinatiPerPeso.put(attrezzo.getPeso(), tmp);
			}
			tmp.add(attrezzo);
		}
		return AttrezziOrdinatiPerPeso;
	}
	
	public String guardaAttrezziPerPeso() {
		
		StringBuilder str= new StringBuilder();
		SortedSet<Attrezzo> attrezziOrdinatiPerPeso= this.getSortedSetOrdinatoPerPeso();
		if(!this.isEmpty()) {
			str.append("Attrezzi nella borsa:\n ");
			for(Attrezzo att: attrezziOrdinatiPerPeso) {
				str.append(att.getNome()+", ");
			}
		}
		
		else
			str.append("La borsa non contiene attrezzi!");
		return str.toString();
	}
	
	public String guardaAttrezziPerNome() {
		
		StringBuilder str= new StringBuilder();
		SortedSet<Attrezzo> attrezziOrdinatiPerNome= this.getContenutoOrdinatoPerNome();
		if(!this.isEmpty()) {
			str.append("Attrezzi nella borsa:\n");
			for(Attrezzo att: attrezziOrdinatiPerNome) {
				str.append(att.getNome() +", ");
			}
		}
		else
			str.append("La borsa non contiene attrezzi!");
		return str.toString();
	}
	
	public String guardaAttrezziRaggruppatiPerPeso() {
		StringBuilder str= new StringBuilder();
		Map<Integer,Set<Attrezzo>> AttrezziOrdinatiPerPeso= this.getContenutoRaggruppatoPerPeso();
		if(!this.isEmpty()) {
			str.append("Attrezzi raggruppati per per peso nella borsa:\n");      //(1, { piuma } ) ; (5, { libro, ps } ) ;
			for(int peso: AttrezziOrdinatiPerPeso.keySet()) {
				str.append("("+peso+", { ");
				for(Attrezzo att: AttrezziOrdinatiPerPeso.get(peso)) {
					str.append(att.getNome());
				}
				str.append(" } ) ;");
			}
		}
		else
			str.append("La borsa non contiene attrezzi!");
		return str.toString();
	}
	
	

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo attrezzo : this.attrezzi.values())
				s.append(attrezzo.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

}
