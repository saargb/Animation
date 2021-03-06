package lib;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public abstract class Movable implements Runnable {
	
	private double speed;
	private Thread movement;
	Queue<Point> queue;
	
	private int xDestination;
	private int yDestination;
	
	public Movable(double speed) {
		this.speed = speed;
		movement = new Thread();
		queue = new LinkedList<Point>();
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public Point getDestination() {
		return new Point(xDestination, yDestination);
	}
	
	public void setDestination(int x, int y) {
		System.out.println("setDestination(" + x + ", " + y + ")");
		this.xDestination = x;
		this.yDestination = y;
	}
	
	public void setDestination(Point p) {
		System.out.println("setDestination(" + p.x + ", " + p.y + ")");
		this.xDestination = p.x;
		this.yDestination = p.y;
	}
	
	public void go() {
		System.out.println("go()");
		plan(getX(), getY(), xDestination, yDestination);
		movement = new Thread(this);
		movement.start();
	}
	
	/**
	 * Don't call this method from outside this class.
	 */
	@Override
	public void run() {
		System.out.println("run()");
		move();
	}
	
	private void plan(int x1, int y1, int x2, int y2) {
		System.out.println("plan(...)");
		if (!queue.isEmpty()) {
			queue.clear();
		}
		double slope = Math.abs((y2 - y1) / ((double) x2 - x1));
		while (x1 != x2 || y1 != y2) {
			if (Math.abs((y2 - y1) / ((double) x2 - x1)) < slope) {
				x1 += ((int) Math.signum(x2 - x1));
			}
			else {
				y1 += ((int) Math.signum(y2 - y1));
			}
			queue.add(new Point(x1, y1));
		}
	}
	
	private void move() {
		System.out.println("move()");
		Point p = null;
		while (!queue.isEmpty()) {
			p = queue.poll();
			setLocation(p);
			sleep();
		}
	}
	
	private void setLocation(Point p) {
		if (p != null) { // Don't throw me a NullPointer, mate...
			setX(p.x);
			setY(p.y);
		}
	}
	
	protected abstract void setX(int x);
	protected abstract void setY(int y);
	
	protected abstract int getX();
	protected abstract int getY();
	
	private void sleep() {
		try {
			Thread.sleep((long) (1000 / getSpeed()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
