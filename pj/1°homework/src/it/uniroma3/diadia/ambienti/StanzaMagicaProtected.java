package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.io.IOException;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaProtected extends StanzaProtected {
	final static private int SOGLIA_MAGICA_DEFAULT= 3;
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	
	public StanzaMagicaProtected( String nome) throws FileNotFoundException, IOException {             //invoca il vero costruttore
		this(nome,SOGLIA_MAGICA_DEFAULT);
	}
	
	public StanzaMagicaProtected(String nome, int soglia) throws FileNotFoundException, IOException {  // costruttore 
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
		
			this.attrezzi.add(attrezzo);
			return true;
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