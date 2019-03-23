package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class InterfacciaUtenteConsole implements InterfacciaUtente{
	Scanner scannerDiLinee;

	@Override
	public void mostraMessaggio(String messaggio) {
		System.out.println(messaggio);

	}

	@Override
	public String prendiIstruzione() {
		String istruzione;
		scannerDiLinee = new Scanner(System.in);
		istruzione= scannerDiLinee.nextLine();

		return istruzione;
	}

	public void chiudiScanner() {
		scannerDiLinee.close();
	}


}
