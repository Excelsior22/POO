package it.uniroma3.diadia.ambienti;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class CaricatoreLabirinto {

	/* prefisso di una singola riga di testo contenente tutti i nomi delle stanze */
	private static final String STANZE_MARKER = "Stanze:";
	
	/* prefisso di una singola riga di testo contenente tutti i nomi delle stanze */
	private static final String STANZE_SPECIALI_MARKER = "Stanze speciali:";
	
	/* prefisso di una singola riga contenente il nome della stanza iniziale */
	private static final String STANZA_INIZIALE_MARKER = "Inizio:";    

	/* prefisso della riga contenente il nome stanza vincente */
	private static final String STANZA_VINCENTE_MARKER = "Vincente:";  

	/* prefisso della riga contenente le specifiche degli attrezzi da collocare nel formato <nomeAttrezzo> <peso> <nomeStanza> */
	private static final String ATTREZZI_MARKER = "Attrezzi:";

	/* prefisso della riga contenente le specifiche dei collegamenti tra stanza nel formato <nomeStanzaDa> <direzione> <nomeStanzaA> */
	private static final String USCITE_MARKER = "Uscite:";
	
	/* prefisso della riga contenente le specifiche dei personaggi da posizionare nel formato <nomePersonaggio> <tipo(Prima lettera in maiuscolo)> <nomeStanza>*/
	private static final String PERSONAGGI_MARKER = "Personaggi:";
	


	/*
	 *  Esempio di un possibile file di specifica di un labirinto (vedi POO-26-eccezioni-file.pdf)

		Stanze: biblioteca, N10, N11
		Stanze speciali:
		Inizio: N10
		Vincente: N11
		Attrezzi: martello 10 biblioteca, pinza 2 N10
		Uscite: biblioteca nord N10, biblioteca sud N11
		Personaggi: merlino Mago atrio

	 */
	private LineNumberReader reader;

	private Map<String, Stanza> nome2stanza;

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;


	public CaricatoreLabirinto(String nomeFile) throws FileNotFoundException {
		this.nome2stanza = new HashMap<String,Stanza>();
		this.reader = new LineNumberReader(new FileReader(nomeFile));
	}

	public void carica() throws FormatoFileNonValidoException, FileNotFoundException, IOException {
		try {                                             //blocco di codice che puo' sollevare eccezioni
			this.leggiECreaStanze(); 
			this.leggiECreaStanzeSpeciali();
			this.leggiInizialeEvincente();
			this.leggiECollocaAttrezzi();
			this.leggiEImpostaUscite();
			this.leggiEPosizionaPesonaggi();
			
		} finally {                                       //blocco di codice sempre eseguito
			try {
				reader.close();
			} catch (IOException e) {                     //gestione eccezione
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

	}

	private String leggiRigaCheCominciaPer(String marker) throws FormatoFileNonValidoException {
		try {
			String riga = this.reader.readLine();
			check(riga.startsWith(marker),"era attesa una riga che cominciasse per "+marker);
			return riga.substring(marker.length());
		} catch (IOException e) {
			throw new FormatoFileNonValidoException(e.getMessage());
		}
	}

	private void leggiECreaStanze() throws FormatoFileNonValidoException, FileNotFoundException, IOException  {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_MARKER);
		for(String nomeStanza : separaStringheAlleVirgole(nomiStanze)) {
			Stanza stanza = new Stanza(nomeStanza);
			this.nome2stanza.put(nomeStanza, stanza);
		}
	}

	private void leggiECreaStanzeSpeciali() throws FormatoFileNonValidoException {
		String nomiStanzeSpeciali=this.leggiRigaCheCominciaPer(STANZE_SPECIALI_MARKER);
		for(String specificaStanzeSpec : separaStringheAlleVirgole(nomiStanzeSpeciali)) {
			String nomeStanza=null;
			String tipoStanza=null;
			try (Scanner scannerLinea = new Scanner(specificaStanzeSpec)) {
				check(scannerLinea.hasNext(), msgTerminazionePrecoce("la stanza."));
				nomeStanza= scannerLinea.next();

				check(scannerLinea.hasNext(), msgTerminazionePrecoce("la tipologia di stanza."));
				tipoStanza= scannerLinea.next();
				
				this.CreaStanzeSpeciali(nomeStanza, tipoStanza);
			}

		}
	}
	
	private void CreaStanzeSpeciali(String nomeStanza, String tipoStanza) throws FormatoFileNonValidoException {
		
		try {
		@SuppressWarnings("unchecked")
		Class<? extends Stanza> cs= (Class<? extends Stanza>)Class.forName("it.uniroma3.diadia.ambienti.Stanza"+ tipoStanza);
		Stanza stanzaSpeciale= null;
		Constructor<? extends Stanza> costr;
		if(tipoStanza.equals("Bloccata")) {
			costr = cs.getConstructor(String.class, String.class, String.class);
			stanzaSpeciale=(Stanza) costr.newInstance(nomeStanza,"sud","chiave");
		}
		if(tipoStanza.equals("Buia")) {
			costr = cs.getConstructor(String.class, String.class);
			stanzaSpeciale=(Stanza) costr.newInstance(nomeStanza,"lanterna");
		}
		if(tipoStanza.equals("Magica")) {
			costr = cs.getConstructor(String.class, int.class);
			stanzaSpeciale=(Stanza) costr.newInstance(nomeStanza,2);
		}
		
		this.nome2stanza.put(nomeStanza, stanzaSpeciale);
		
		} catch (NoSuchMethodException e) {
	
			e.printStackTrace();
		} catch (SecurityException e) {
		
			e.printStackTrace();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {
	
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
		
			e.printStackTrace();
		} catch (InvocationTargetException e) {
	
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	private List<String> separaStringheAlleVirgole(String string) {
		List<String> result = new LinkedList<>();
		Scanner scanner = new Scanner(string);
		scanner.useDelimiter(",");
		try (Scanner scannerDiParole = scanner) {
			while(scannerDiParole.hasNext()) {
				String s= scannerDiParole.next();
				s=s.substring(1,s.length());
				result.add(s);
			}
			
		}
		return result;
	}


	private void leggiInizialeEvincente() throws FormatoFileNonValidoException {
		
		String nomeStanzaIniziale = this.leggiRigaCheCominciaPer(STANZA_INIZIALE_MARKER);;
		nomeStanzaIniziale = nomeStanzaIniziale.substring(1, nomeStanzaIniziale.length());
		check(this.isStanzaValida(nomeStanzaIniziale), nomeStanzaIniziale +" non definita");
		
		String nomeStanzaVincente = this.leggiRigaCheCominciaPer(STANZA_VINCENTE_MARKER);
		nomeStanzaVincente= nomeStanzaVincente.substring(1, nomeStanzaVincente.length());
		check(this.isStanzaValida(nomeStanzaVincente), nomeStanzaVincente + " non definita");
		
		this.stanzaIniziale = this.nome2stanza.get(nomeStanzaIniziale);
		this.stanzaVincente = this.nome2stanza.get(nomeStanzaVincente);
	}

	private void leggiECollocaAttrezzi() throws FormatoFileNonValidoException {
		String specificheAttrezzi = this.leggiRigaCheCominciaPer(ATTREZZI_MARKER);

		for(String specificaAttrezzo : separaStringheAlleVirgole(specificheAttrezzi)) {
			String nomeAttrezzo = null;
			String pesoAttrezzo = null;
			String nomeStanza = null; 
			try (Scanner scannerLinea = new Scanner(specificaAttrezzo)) {
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome di un attrezzo."));
				nomeAttrezzo = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il peso dell'attrezzo "+nomeAttrezzo+"."));
				pesoAttrezzo = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome della stanza in cui collocare l'attrezzo "+nomeAttrezzo+"."));
				nomeStanza = scannerLinea.next();
			}				
			posaAttrezzo(nomeAttrezzo, pesoAttrezzo, nomeStanza);
		}
	}

	private void posaAttrezzo(String nomeAttrezzo, String pesoAttrezzo, String nomeStanza) throws FormatoFileNonValidoException {
		int peso;
		try {
			peso = Integer.parseInt(pesoAttrezzo);
			Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
			check(isStanzaValida(nomeStanza),"Attrezzo "+ nomeAttrezzo+" non collocabile: stanza " +nomeStanza+" inesistente");
			this.nome2stanza.get(nomeStanza).addAttrezzo(attrezzo);
		}
		catch (NumberFormatException e) {
			check(false, "Peso attrezzo "+nomeAttrezzo+" non valido");
		}
	}


	private boolean isStanzaValida(String nomeStanza) {
		return this.nome2stanza.containsKey(nomeStanza);
	}

	
	private void leggiEImpostaUscite() throws FormatoFileNonValidoException {
		String specificheUscite = this.leggiRigaCheCominciaPer(USCITE_MARKER);
		try (Scanner scannerDiLinea = new Scanner(specificheUscite)) {			

			while (scannerDiLinea.hasNext()) {
				check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("le uscite di una stanza."));
				
				String stanzaPartenza = scannerDiLinea.next();
				check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la direzione di una uscita della stanza "+stanzaPartenza));
				
				String dir = scannerDiLinea.next();
				check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la destinazione di una uscita della stanza "+stanzaPartenza+" nella direzione "+dir));
				
				String stanzaDestinazione = scannerDiLinea.next();
				if(scannerDiLinea.hasNext())
					stanzaDestinazione= stanzaDestinazione.substring(0, stanzaDestinazione.length()-1);
				
				impostaUscita(stanzaPartenza, dir, stanzaDestinazione);
			}
		} 
	}
	
	private void leggiEPosizionaPesonaggi() throws FormatoFileNonValidoException {
		String specifichePersonaggi= this.leggiRigaCheCominciaPer(PERSONAGGI_MARKER);
		for(String specificaPersonaggio : separaStringheAlleVirgole(specifichePersonaggi)){
			String nomePersonaggio = null;
			String tipoPersonaggio = null;
			String nomeStanza = null;
			try (Scanner scannerLinea = new Scanner(specificaPersonaggio)) {
				
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome di un personaggio."));
				nomePersonaggio = scannerLinea.next();

				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il tipo del personaggio "+nomePersonaggio+"."));
				tipoPersonaggio = scannerLinea.next();

				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome della stanza in cui collocare il personaggio "+nomePersonaggio+"."));
				nomeStanza = scannerLinea.next();
			}
			creaPersonaggio(nomePersonaggio, tipoPersonaggio, nomeStanza);
		}
	}
	
	private void creaPersonaggio(String nomePersonaggio, String tipoPersonaggio, String nomeStanza) throws FormatoFileNonValidoException  {
		try {
		@SuppressWarnings("unchecked")
		Class<? extends AbstractPersonaggio> Cpg= (Class<? extends AbstractPersonaggio>) Class.forName("it.uniroma3.diadia.personaggi."+ tipoPersonaggio);
		AbstractPersonaggio pg;
		Constructor<? extends AbstractPersonaggio> costructor;
		costructor=Cpg.getConstructor(String.class);
		pg= costructor.newInstance(nomePersonaggio);
		
		Stanza stanzaPg= this.nome2stanza.get(nomeStanza);
		if(this.isStanzaValida(nomeStanza))
			stanzaPg.setPersonaggio(pg);
		else
			System.out.println("Stanza non valida");
		
		} catch (InstantiationException e) {
	
			e.printStackTrace();
		} catch (IllegalAccessException e) {
		
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
	
			e.printStackTrace();
		} catch (InvocationTargetException e) {
	
			e.printStackTrace();
		} catch (NoSuchMethodException e) {

			e.printStackTrace();
		} catch (SecurityException e) {
		
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
	}
	
	private String msgTerminazionePrecoce(String msg) {
		return "Terminazione precoce del file prima di leggere "+msg;
	}

	private void impostaUscita(String stanzaDa, String dir, String nomeA) throws FormatoFileNonValidoException {
		check(isStanzaValida(stanzaDa),"Stanza di partenza sconosciuta "+dir);
		check(isStanzaValida(nomeA),"Stanza di destinazione sconosciuta "+ dir);
		Stanza partenzaDa = this.nome2stanza.get(stanzaDa);
		Stanza arrivoA = this.nome2stanza.get(nomeA);
		partenzaDa.impostaStanzaAdiacente(dir, arrivoA);
	}


	final private void check(boolean condizioneCheDeveEsseraVera, String messaggioErrore) throws FormatoFileNonValidoException {
		if (!condizioneCheDeveEsseraVera)
			throw new FormatoFileNonValidoException("Formato file non valido [" + this.reader.getLineNumber() + "] "+messaggioErrore);		
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
}
