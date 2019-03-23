package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi{

	@Override 
	public Comando costruisciComando(String istruzione) {
		//creare scanner
		Scanner scannerDiParole= new Scanner(istruzione);
		String nomeComando= null;
		String parametro=null;
		Comando comando= null;

		if (scannerDiParole.hasNext())
			nomeComando= scannerDiParole.next();
		if(scannerDiParole.hasNext())
			parametro= scannerDiParole.next();
		scannerDiParole.close();
		
		try {
		StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
		
		nomeClasse.append(Character.toUpperCase(nomeComando.charAt(0)));                 //Prende la lettera Maiuscola
		
		nomeClasse.append(nomeComando.substring(1));                                     //Completa il comando 
		
		comando=(Comando)Class.forName(nomeClasse.toString()).newInstance();
		comando.setParametro(parametro);
		}
		catch (Exception e) {
			comando= new ComandoNonValido();
		}
		return comando;
	}
}
