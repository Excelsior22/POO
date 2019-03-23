package ama.gui;

import static ama.costanti.CostantiGUI.COLORE_BORDO;
import static ama.costanti.CostantiGUI.DIM_CELLE;
import static ama.costanti.CostantiGUI.IMMAGINE_CENTRO;
import static ama.costanti.CostantiSimulatore.DIMENSIONE;
import static java.awt.Color.BLACK;
import static java.awt.Color.YELLOW;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ama.CentroDiRaccolta;
import ama.Posizione;
import ama.mezzo.Mezzo;
import ama.rifiuto.Rifiuto;
import ama.simulatore.Simulatore;

public class GUI extends JPanel {

	static final private long serialVersionUID = 0L;

	final private Simulatore simulatore;

	final private JFrame jframe;

	GUI(final Simulatore simulatore) {
		this.simulatore = simulatore;
		this.jframe = new JFrame("AMU");		
		jframe.add(this);
		jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// N.B.: lascia ampio margine per i bordi sotto Windows
		jframe.setSize((DIMENSIONE+1)*DIM_CELLE, (DIMENSIONE+2)*DIM_CELLE);
		jframe.setVisible(true);		
	}

	public void initControlliDaTastiera(final Simulatore simulatore) {

		/* Gestione eventi associati alla tastiera */
		this.jframe.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==VK_ESCAPE)
					simulatore.terminaSimulazione();
			}
		});
	}


	public void riportaNelTitolo(int passo, long attuali, long medi) {
		this.jframe.setTitle("Passo: "+passo+"\tLivello rifiuti:\tattuale="+attuali+" medio="+medi);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setFont(new Font("Arial", Font.TRUETYPE_FONT, DIMENSIONE / 2));
		g.setColor(BLACK);
		g.fillRect(0, 0, DIMENSIONE * DIM_CELLE, DIMENSIONE * DIM_CELLE);
		this.disegnaBordo(g);
		g.setColor(YELLOW); // per stampare id mezzi

		for (Mezzo mezzo : this.simulatore.getMezzi()) {
			disegnaMezzo(g, mezzo);
		}

		for (Rifiuto rifiuto : this.simulatore.getCitta().getRifiuti()) {
			disegnaRifiuto(g, rifiuto);
		}

		disegnaCentro(g);
	}

	private void disegnaRifiuto(Graphics g, Rifiuto rifiuto) {
		final Posizione posizione = rifiuto.getPosizione();
		disegnaImmagine(g, rifiuto.getImmagine(), posizione);
	}

	private void disegnaCentro(Graphics g) {
		final CentroDiRaccolta centro = this.simulatore.getCitta().getCentroDiRaccolta();
		disegnaImmagine(g, IMMAGINE_CENTRO, centro.getPosizione(), 2f);
		g.setColor(BLACK);
		final String totSmaltiti = Integer.toString(centro.getRifiutiSmaltiti().size());
		disegnaTesto(g, centro.getPosizione(), totSmaltiti);
	}

	private void disegnaMezzo(Graphics g, Mezzo mezzo) {
        final Posizione pos = mezzo.getPosizione();
		Image immagine = null;
		String ids = null;
		/* VEDI DOMANDA 2 */
		if (mezzo.getPolitica()!=null) {
			immagine = mezzo.getPolitica().getImmagine();
			ids = mezzo.getPolitica().toString();
		}
		disegnaTesto(g, pos, ids);
		if (mezzo.getStato()==Mezzo.RACCOLTA) {
			/* ingrandisce immagine dei mezzi in fase di raccolta scalando x 1.5 */
			disegnaImmagine(g, immagine, pos, 1.5f);
		}
		else disegnaImmagine(g, immagine, pos);
	}

	private void disegnaTesto(Graphics g, Posizione p, String testo) {
		final int x = p.getX();
		final int y = p.getY();
		int d = DIM_CELLE;
		int gx = x*d, gy = y*d;
        g.drawString(testo, gx-d/2, gy);
	}

	private void disegnaImmagine(Graphics g, Image image, Posizione p) {
		final int x = p.getX();
		final int y = p.getY();
		int d = DIM_CELLE;
		int gx = x*d, gy = y*d;
		g.drawImage(image, gx, gy, d, d, null);		
	}

	private void disegnaImmagine(Graphics g, Image image, Posizione p, float scala) {
		final int x = p.getX();
		final int y = p.getY();
		int d = DIM_CELLE;
		int gx = Math.round(x*d-d*(scala-1)/2), gy = Math.round(y*d-d*(scala-1)/2);
		int size = Math.round(d*scala);
		g.drawImage(image, gx, gy, size, size, null);		
	}

	private void disegnaBordo(Graphics g) {
		int n = DIMENSIONE;
		for(int i=0; i<n; i++) {
			disegnaCella(g, 0,   i, COLORE_BORDO); 
			disegnaCella(g, i,   0, COLORE_BORDO); 
			disegnaCella(g, n-1, i, COLORE_BORDO); 
			disegnaCella(g, i, n-1, COLORE_BORDO); 
		}
	}

	private void disegnaCella(Graphics g, int x, int y, Color colore) {
		g.setColor(colore);
		int d = DIM_CELLE;
		int gx = x*d, gy = y*d;
		disegnaCellaInRilievo(g, d, gx, gy);
	}

	private void disegnaCellaInRilievo(Graphics g, int l, int x, int y) {
		g.fill3DRect(   x,  y,   l-1, l-1, false);
		g.fillRoundRect(x+2,y+2, l-4, l-4, 2, 2 );
		g.fill3DRect(   x+3,y+3, l-6, l-6, true );
	}

}
