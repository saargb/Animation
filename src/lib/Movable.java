package lib;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.Queue;

public abstract class Movable implements Runnable {
	
	private double initialSpeed;
	
	private double speed;
	private Thread movement;
	private double acceleration;
	Queue<VelocityPoint> queue;
	
	private int xDestination;
	private int yDestination;
	
	public Movable(double speed, double acceleration) {
		this.speed = speed;
		initialSpeed = speed;
		this.acceleration = acceleration;
		movement = new Thread(this);
		queue = new LinkedList<VelocityPoint>();
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
			queue.add(new VelocityPoint(x1, y1, Math.sqrt(Math.pow(initialSpeed, 2) +
									2 * acceleration * (distance(x1, y1, xDestination, yDestination)))));
		}
	}
	
	private void move() {
		System.out.println("move()");
		VelocityPoint p = null;
		while (!queue.isEmpty()) {
			System.out.println("Is moving bro");
			p = queue.poll();
			if (p != null) { // Don't throw me a NullPointer, mate...
				setLocation(p);
				sleep(p.velocity);
			}
		}
	}
	
	private void setLocation(Point2D p) {
		setX((int) p.getX());
		setY((int) p.getY());
	}
	
	private static double distance(int x1, int y1, int x2, int y2) {
		return new Point(x1, y1).distance(x2, y2);
	}
	
	protected abstract void setX(int x);
	protected abstract void setY(int y);
	
	protected abstract int getX();
	protected abstract int getY();
	
	private void sleep(double speed) {
		try {
			Thread.sleep((long) (1000 / Math.abs(speed)));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
