

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class VisualizzatoreTerritorio extends JFrame {

	private static final long serialVersionUID = 1L;
    private static final String LABEL_ANNO = "Anno: ";
    private JLabel stepLabel;
    private FieldView fieldView;


    private Color scegliColore(Territorio territorio, Posizione posizione) {
        Animale animale = territorio.getAnimale(posizione);
        if(animale != null) {
            if (animale.getClass()==Erbivoro.class)
            	return Color.green;
            if (animale.getClass()==Carnivoro.class)
            	return Color.red;
        }   
        return Color.white;    	
    }

    
    public VisualizzatoreTerritorio(int dimensione) {
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Simulatore");
        this.stepLabel = new JLabel(LABEL_ANNO, JLabel.CENTER);        
        this.setLocation(50, 50);
        this.fieldView = new FieldView(dimensione, dimensione);
        Container contents = getContentPane();
        contents.add(stepLabel, BorderLayout.NORTH);
        contents.add(fieldView, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }
    
    public void aggiornaSchermata(int passo, Territorio territorio) {
        if(!isVisible())
            setVisible(true);

        this.stepLabel.setText(LABEL_ANNO + passo);
        this.fieldView.preparePaint();
            
        for(int x = 0; x < territorio.getDimensione(); x++) {
            for(int y = 0; y < territorio.getDimensione(); y++) {
            	Posizione posizione = new Posizione(x, y);
            	Color colore = this.scegliColore(territorio, posizione);
                fieldView.drawMark(y, x, colore);                
            }
        }
        this.fieldView.repaint();
    }
    
    private class FieldView extends JPanel  {
		private static final long serialVersionUID = 1L;

		private final int GRID_VIEW_SCALING_FACTOR = 6;
        private int gridWidth, gridHeight;
        private int xScale, yScale;
        private Dimension size;
        private Graphics g;
        private Image fieldImage;

        public FieldView(int height, int width) {
            gridHeight = height;
            gridWidth = width;
            size = new Dimension(0, 0);
        }

        public Dimension getPreferredSize() {
            return new Dimension(gridWidth * GRID_VIEW_SCALING_FACTOR,
                                 gridHeight * GRID_VIEW_SCALING_FACTOR);
        }
        
        public void preparePaint() {
            if(! size.equals(getSize())) {  
                size = getSize();
                fieldImage = fieldView.createImage(size.width, size.height);
                g = fieldImage.getGraphics();

                xScale = size.width / gridWidth;
                if(xScale < 1) {
                    xScale = GRID_VIEW_SCALING_FACTOR;
                }
                yScale = size.height / gridHeight;
                if(yScale < 1) {
                    yScale = GRID_VIEW_SCALING_FACTOR;
                }
            }
        }
        
        public void drawMark(int x, int y, Color color) {
            g.setColor(color);
            g.fillRect(x * xScale, y * yScale, xScale-1, yScale-1);
        }

        public void paintComponent(Graphics g) {
            if(fieldImage != null) {
                g.drawImage(fieldImage, 0, 0, null);
            }
        }
    }
}