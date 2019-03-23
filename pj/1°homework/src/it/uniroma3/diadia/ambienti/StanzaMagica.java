package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {
	
	private static Properties prop;
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	private static int soglia_magica_max;
    {
 	prop= new Properties();
	try {
		prop.load(new FileReader("resource/diadia.properties"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	soglia_magica_max= Integer.parseInt(prop.getProperty("SOGLIA_MAGICA_DEFAULT"));
    }
	
	public StanzaMagica( String nome) throws FileNotFoundException, IOException {             //invoca il vero costruttore
		this(nome,soglia_magica_max);
	}
	
	public StanzaMagica(String nome, int soglia) throws FileNotFoundException, IOException {  // costruttore 
		super(nome);
		this.contatoreAttrezziPosati=0;
		this.sogliaMagica= soglia;
	}
	
	
    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
	@Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if(this.contatoreAttrezziPosati>this.sogliaMagica)
			attrezzo= this.modificaAttrezzo(attrezzo);
		return super.addAttrezzo(attrezzo);
    }
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2= attrezzo.getPeso()*2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito= nomeInvertito.reverse();
		attrezzo= new Attrezzo (nomeInvertito.toString(),pesoX2);
		return attrezzo;
	}
}
