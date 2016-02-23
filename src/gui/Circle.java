package gui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import lib.Movable;

public class Circle extends Movable implements MouseListener {
	
	static /*final*/ double SPEED = 200; // pixles per second.
	static /*final*/ int X = 300;
	static /*final*/ int Y = 300;
	static /*final*/ int RADIUS = 20;
	
	private int x;
	private int y;
	private int radius;
	
	public Circle() {
		super(0, 10, 0, 4);
		x = X;
		y = Y;
		radius = RADIUS;
	}
	
	public void draw(Graphics g) {
		g.fillOval(x, y, radius, radius);
	}

	@Override
	protected void setX(int x) {
		this.x = x;
	}

	@Override
	protected void setY(int y) {
		this.y = y;
	}

	@Override
	protected int getX() {
		return x;
	}

	@Override
	protected int getY() {
		return y;
	}
	
	@Override
	public void mouseClicked(MouseEvent m) {
		setDestination(m.getPoint());
		go();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

}
