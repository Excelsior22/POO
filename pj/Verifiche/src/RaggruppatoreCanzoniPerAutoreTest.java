import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RaggruppatoreCanzoniPerAutoreTest
{
  private RaggruppatoreCanzoniPerAutore raggruppatore;
  
  public RaggruppatoreCanzoniPerAutoreTest() {}
  
  @Before
  public void setUp()
    throws Exception
  {
    raggruppatore = new RaggruppatoreCanzoniPerAutore();
  }
  
  @Test
  public final void testAutore2libri_vuoto() {
    Map<String, List<Canzone>> autore2libri = raggruppatore.autore2canzoni();
    Assert.assertNotNull(autore2libri);
    Assert.assertTrue(autore2libri.isEmpty());
  }
  
  @Test
  public final void testAutore2libri_unSoloLibro() {
    String dante = "Dante";
    Canzone commedia = new Canzone("Divina Commedia", dante);
    raggruppatore.aggiungiCanzone(commedia);
    Map<String, List<Canzone>> autore2libri = raggruppatore.autore2canzoni();
    Assert.assertNotNull(autore2libri);
    Assert.assertFalse(autore2libri.isEmpty());
    Assert.assertEquals(Integer.valueOf(1), Integer.valueOf(autore2libri.size()));
    Assert.assertTrue(autore2libri.containsKey(dante));
    List<Canzone> libriDiDante = (List)autore2libri.get(dante);
    Assert.assertNotNull(libriDiDante);
    Assert.assertEquals(Integer.valueOf(1), Integer.valueOf(libriDiDante.size()));
    Assert.assertSame(commedia, libriDiDante.get(0));
  }
  
  @Test
  public final void testAutore2libri_dueLibriStessoAutore() {
    String dante = "Dante";
    Canzone commedia = new Canzone("Divina Commedia", dante);
    Canzone vitaNuova = new Canzone("Vita Nuova", dante);
    raggruppatore.aggiungiCanzone(commedia);
    raggruppatore.aggiungiCanzone(vitaNuova);
    Map<String, List<Canzone>> autore2libri = raggruppatore.autore2canzoni();
    Assert.assertNotNull(autore2libri);
    Assert.assertFalse(autore2libri.isEmpty());
    Assert.assertEquals(Integer.valueOf(1), Integer.valueOf(autore2libri.size()));
    Assert.assertTrue(autore2libri.containsKey(dante));
    List<Canzone> libriDiDante = (List)autore2libri.get(dante);
    Assert.assertNotNull(libriDiDante);
    Assert.assertEquals(Integer.valueOf(2), Integer.valueOf(libriDiDante.size()));
    Assert.assertTrue(libriDiDante.contains(commedia));
    Assert.assertTrue(libriDiDante.contains(vitaNuova));
  }
  
  @Test
  public final void testAutore2libri_treLibriDueAutori() {
    String dante = "Dante";
    String boccaccio = "Boccaccio";
    Canzone commedia = new Canzone("Divina Commedia", dante);
    Canzone vitaNuova = new Canzone("Vita Nuova", dante);
    Canzone decamerone = new Canzone("Decamerone", boccaccio);
    raggruppatore.aggiungiCanzone(commedia);
    raggruppatore.aggiungiCanzone(decamerone);
    raggruppatore.aggiungiCanzone(vitaNuova);
    Map<String, List<Canzone>> autore2libri = raggruppatore.autore2canzoni();
    Assert.assertNotNull(autore2libri);
    Assert.assertFalse(autore2libri.isEmpty());
    Assert.assertEquals(Integer.valueOf(2), Integer.valueOf(autore2libri.size()));
    Assert.assertTrue(autore2libri.containsKey(dante));
    Assert.assertTrue(autore2libri.containsKey(boccaccio));
    List<Canzone> libriDiDante = (List)autore2libri.get(dante);
    List<Canzone> libriDiBoccaccio = (List)autore2libri.get(boccaccio);
    Assert.assertNotNull(libriDiDante);
    Assert.assertNotNull(libriDiBoccaccio);
    Assert.assertEquals(Integer.valueOf(2), Integer.valueOf(libriDiDante.size()));
    Assert.assertEquals(Integer.valueOf(1), Integer.valueOf(libriDiBoccaccio.size()));
    Assert.assertTrue(libriDiDante.contains(commedia));
    Assert.assertTrue(libriDiDante.contains(vitaNuova));
    Assert.assertTrue(libriDiBoccaccio.contains(decamerone));
  }
  
  @Test
  public final void testAutore2libri_quattroLibriDueAutori() {
    String dante = "Dante";
    String boccaccio = "Boccaccio";
    Canzone commedia = new Canzone("Divina Commedia", dante);
    Canzone vitaNuova = new Canzone("Vita Nuova", dante);
    Canzone decamerone = new Canzone("Decamerone", boccaccio);
    Canzone convivio = new Canzone("Convivio", dante);
    raggruppatore.aggiungiCanzone(commedia);
    raggruppatore.aggiungiCanzone(decamerone);
    raggruppatore.aggiungiCanzone(vitaNuova);
    raggruppatore.aggiungiCanzone(convivio);
    Map<String, List<Canzone>> autore2libri = raggruppatore.autore2canzoni();
    Assert.assertNotNull(autore2libri);
    Assert.assertFalse(autore2libri.isEmpty());
    Assert.assertEquals(Integer.valueOf(2), Integer.valueOf(autore2libri.size()));
    Assert.assertTrue(autore2libri.containsKey(dante));
    Assert.assertTrue(autore2libri.containsKey(boccaccio));
    List<Canzone> libriDiDante = (List)autore2libri.get(dante);
    List<Canzone> libriDiBoccaccio = (List)autore2libri.get(boccaccio);
    Assert.assertNotNull(libriDiDante);
    Assert.assertNotNull(libriDiBoccaccio);
    Assert.assertEquals(Integer.valueOf(3), Integer.valueOf(libriDiDante.size()));
    Assert.assertEquals(Integer.valueOf(1), Integer.valueOf(libriDiBoccaccio.size()));
    Assert.assertTrue(libriDiDante.contains(commedia));
    Assert.assertTrue(libriDiDante.contains(vitaNuova));
    Assert.assertTrue(libriDiDante.contains(convivio));
    Assert.assertTrue(libriDiBoccaccio.contains(decamerone));
  }
  
  @Test
  public final void testAutore2libri_cinqueLibriTreAutori() {
    String dante = "Dante";
    String boccaccio = "Boccaccio";
    String petrarca = "Petrarca";
    Canzone commedia = new Canzone("Divina Commedia", dante);
    Canzone vitaNuova = new Canzone("Vita Nuova", dante);
    Canzone decamerone = new Canzone("Decamerone", boccaccio);
    Canzone convivio = new Canzone("Convivio", dante);
    Canzone canzoniere = new Canzone("Canzoniere", petrarca);
    raggruppatore.aggiungiCanzone(commedia);
    raggruppatore.aggiungiCanzone(decamerone);
    raggruppatore.aggiungiCanzone(vitaNuova);
    raggruppatore.aggiungiCanzone(convivio);
    raggruppatore.aggiungiCanzone(canzoniere);
    Map<String, List<Canzone>> autore2libri = raggruppatore.autore2canzoni();
    Assert.assertNotNull(autore2libri);
    Assert.assertFalse(autore2libri.isEmpty());
    Assert.assertEquals(Integer.valueOf(3), Integer.valueOf(autore2libri.size()));
    Assert.assertTrue(autore2libri.containsKey(dante));
    Assert.assertTrue(autore2libri.containsKey(boccaccio));
    List<Canzone> libriDiDante = (List)autore2libri.get(dante);
    List<Canzone> libriDiBoccaccio = (List)autore2libri.get(boccaccio);
    List<Canzone> libriDiPetrarca = (List)autore2libri.get(petrarca);
    Assert.assertNotNull(libriDiDante);
    Assert.assertNotNull(libriDiBoccaccio);
    Assert.assertEquals(Integer.valueOf(3), Integer.valueOf(libriDiDante.size()));
    Assert.assertEquals(Integer.valueOf(1), Integer.valueOf(libriDiBoccaccio.size()));
    Assert.assertEquals(Integer.valueOf(1), Integer.valueOf(libriDiPetrarca.size()));
    Assert.assertTrue(libriDiDante.contains(commedia));
    Assert.assertTrue(libriDiDante.contains(vitaNuova));
    Assert.assertTrue(libriDiDante.contains(convivio));
    Assert.assertTrue(libriDiBoccaccio.contains(decamerone));
    Assert.assertTrue(libriDiPetrarca.contains(canzoniere));
  }
}