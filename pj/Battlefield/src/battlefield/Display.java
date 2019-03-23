package battlefield;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class Display extends JFrame {

	static final private long serialVersionUID = 1L;
	static final private String LABEL_PASSO = "Passo: ";

	private JLabel stepLabel;
	private FieldView fieldView;
 
	private Color getColore(Battlefield field, Position posizione) {
		Object t = field.getRobot(posizione);
		if (t==null) t = field.getRobot(posizione);
		if (t==null) return Color.white;

		if (t.getClass() == Chaser.class)
			return Color.orange;
		if (t.getClass() == Walker.class)
			return Color.blue;			

		throw new IllegalStateException("Mi aspettavo di dover scegliere il colore di un robot! "
				+ " invece ho trovato "+t.getClass()+"!");

	}

	public Display(int dimensione) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Battlefield");
		this.stepLabel = new JLabel(LABEL_PASSO, JLabel.CENTER);        
		this.setLocation(50, 50);
		this.fieldView = new FieldView(dimensione, dimensione);
		Container contents = getContentPane();
		contents.add(stepLabel, BorderLayout.NORTH);
		contents.add(fieldView, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}

	public void aggiornaSchermata(int passo, Battlefield field) {
		if (!isVisible())
			setVisible(true);

		this.stepLabel.setText(LABEL_PASSO + passo);
		this.fieldView.preparePaint();

		for(int x=0; x<field.getDimensione(); x++) {
			for(int y=0; y<field.getDimensione(); y++) {
				Position p = new Position(x, y);
				Color colore = this.getColore(field, p);
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