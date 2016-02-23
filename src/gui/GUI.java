package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GUI extends JPanel {
	
	Circle circle;
	
	public GUI() {
		super();
		circle = new Circle();
		this.addMouseListener(circle);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1000, 800);
		g.setColor(Color.RED);
		circle.draw(g);
		repaint();
	}
	
}
