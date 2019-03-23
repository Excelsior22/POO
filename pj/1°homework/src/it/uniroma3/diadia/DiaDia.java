package it.uniroma3.diadia;




import java.io.IOException;

import it.uniroma3.diadia.ambienti.FormatoFileNonValidoException;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;
import it.uniroma3.diadia.comandi.InterfacciaUtenteConsole;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	
	private Partita partita;
	private InterfacciaUtenteConsole IO;

	public DiaDia() throws FormatoFileNonValidoException, IOException {
		this.partita = new Partita();
		this.IO= new InterfacciaUtenteConsole();
	}

	public void gioca() throws Exception{
		String istruzione; 
		
		this.IO.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = IO.prendiIstruzione() ;
		while (!processaIstruzione(istruzione));
		IO.chiudiScanner();
	}   
	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) throws Exception {
		Comando comandoDaEseguire;
		FabbricaDiComandiRiflessiva factory= new FabbricaDiComandiRiflessiva();
		
		comandoDaEseguire= factory.costruisciComando(istruzione);
		IO.mostraMessaggio(comandoDaEseguire.esegui(this.partita));
		if(this.partita.vinta())
			IO.mostraMessaggio("Hai vinto");
		if(!this.partita.giocatoreIsVivo())
			IO.mostraMessaggio("Hai esaurito i CFU");
		return this.partita.isFinita();
	}
	
	public static void main(String[] argc) throws Exception{
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}