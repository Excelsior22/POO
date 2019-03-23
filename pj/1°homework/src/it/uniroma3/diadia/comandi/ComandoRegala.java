package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala implements Comando {
	private String nomeAttrezzo;
	private String nome= "regala";

	@Override
	public String esegui(Partita partita) {
		Attrezzo att= partita.getAttrezzo(this.nomeAttrezzo);
		StringBuilder msg= new StringBuilder();
		if(att==null) {
			msg.append("Indiacare un attrezzo presente in borsa!");
		}
		else {
			if(partita.getStanzaCorrente().getPersonaggio()==null)
				msg.append("Non c'è nessuno a cui poter regalare l'oggetto");
			else {
				msg.append("L'attrezzo è stato ceduto\n");
				String str=partita.getStanzaCorrente().getPersonaggio().riceviRegalo(att, partita);
				msg.append(str);
			}
		}
		return msg.toString();
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo= parametro;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

}
