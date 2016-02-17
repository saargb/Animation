package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GUI extends JPanel {
	
	Picture img;
	Circle circle;
	
	public GUI() {
		super();
		img = new Picture("pics/electric_guitar.jpg", this);
		circle = new Circle();
		this.addMouseListener(circle);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1000, 800);
		g.setColor(Color.RED);
//		img.draw(g);
		circle.draw(g);
		repaint();
	}
	
}
