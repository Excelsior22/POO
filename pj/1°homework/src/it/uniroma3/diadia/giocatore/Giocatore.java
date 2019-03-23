package it.uniroma3.diadia.giocatore;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import it.uniroma3.diadia.Borsa;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe ha la funzione di gestire i CFU
 * e di memorizzare gli attrezzi in un oggetto
 * istanza della classe borsa.
 * 
 * @author fabrizio
 *
 */
public class Giocatore {
	private static Properties prop;
	
	private int cfu;
	private Borsa b1;
	
	public Giocatore() throws FileNotFoundException, IOException {
	  	prop= new Properties();
    	prop.load(new FileReader("resource/diadia.properties"));
		this.cfu = Integer.parseInt(prop.getProperty("CFU_INIZIALI"));;
		this.b1= new Borsa(10);
	}
	
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return b1.removeAttrezzo(attrezzo);
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
			return b1.addAttrezzo(attrezzo);
	}
	public boolean hasAttrezzo(String oggetto) {
		return b1.hasAttrezzo(oggetto);
	}
	public Attrezzo getAttrezzo(String oggetto) {
		return b1.getAttrezzo(oggetto);
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	
	

}
