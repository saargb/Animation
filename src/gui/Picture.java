package gui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import lib.Movable;

public class Picture extends Movable implements MouseListener {
	
	private int x;
	private int y;
	
	static final int XSPEED = 10;
	static final int YSPEED = 10;
	
	private ImageIcon image;
	private Component component;
	
	public Picture(String url, Component component) {
		super(0, YSPEED, 0, 4);
		this.component = component;
		image = new ImageIcon(url);
	}
	
	@Override
	protected void setY(int y) {
		this.y = y;
	}
	
	@Override
	protected void setX(int x) {
		this.x = x;
	}
	
	@Override
	protected int getY() {
		return y;
	}
	
	@Override
	protected int getX() {
		return x;
	}
	
	public void draw(Graphics g) {
		image.paintIcon(component, g, x, y);
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
