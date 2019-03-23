package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

public class FabbricaDiComandiFisarmonicaTest  {
	private String Istruzione;
	private FabbricaDiComandiRiflessiva factoryTest;
	private Comando comando;

	@Before
	public void setUp() throws Exception {
		factoryTest= new FabbricaDiComandiRiflessiva();
	}
	
	@Test
	public void testCostruisciComandoNonValido() throws Exception {
		Istruzione= "dfdfddf";
		comando=factoryTest.costruisciComando(Istruzione);
		assertEquals("comando non valido", comando.getNome());
	}
	@Test
	public void testCostruisciComandoVaiConParametro()  throws Exception{
		Istruzione="vai nord";
		comando=factoryTest.costruisciComando(Istruzione);
		assertEquals("vai", comando.getNome());

	}
	@Test
	public void testCostruisciComandoGuardaSenzaParametro()throws Exception {
		Istruzione="guarda";
		comando=factoryTest.costruisciComando(Istruzione);
		assertEquals("guarda", comando.getNome());

	}
	
	
}
