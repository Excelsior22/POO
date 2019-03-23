package ama.costanti;


import static ama.costanti.LettoreImmagini.leggImmagineRicolorata;
import static ama.costanti.LettoreImmagini.leggiImmagine;
import static java.awt.Color.*;

import java.awt.Color;
import java.awt.Image;

public interface CostantiGUI {


	// dimensione in px di una cella
	static final public int DIM_CELLE = 20;

	
	static final public Color COLORE_BORDO  = GRAY;

	static final public Color COLORE_CENTRO = RED;

	static public Image IMMAGINE_CARTA = leggiImmagine("carta.jpg");
	
	static public Image IMMAGINE_VETRO = leggiImmagine("vetro.jpg");

	static public Image IMMAGINE_ORGANICO = leggiImmagine("organico.jpg");

	static public Image IMMAGINE_CENTRO = leggiImmagine("centro.png");

	static public Image IMMAGINE_CAMION_BIANCO = leggiImmagine("camion.png");

	static public Image IMMAGINE_CAMION_GIALLO = leggImmagineRicolorata("camion.png",WHITE,YELLOW);

	static public Image IMMAGINE_CAMION_VERDE = leggImmagineRicolorata("camion.png",WHITE,GREEN);

	/* N.B. rosso è un colore libero per successivi utilizzi: VEDI DOMANDA 2 */
	static public Image IMMAGINE_CAMION_ROSSO = leggImmagineRicolorata("camion.png",WHITE,RED);
	

}

