package lib;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import static java.lang.Math.*;

public abstract class Movable implements Runnable {
	
	private double acceleration;
	private double xSpeed;
	private double ySpeed;
	private Thread movement;
	Queue<VectorPoint> queue;
	
	private int xDestination;
	private int yDestination;
	
	public Movable(double xSpeed, double ySpeed, double acceleration) {
		this.acceleration = acceleration;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		movement = new Thread();
		queue = new LinkedList<VectorPoint>();
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
		plan(new VectorPoint(getX(), getY(), xSpeed, ySpeed),
				new Point(xDestination, yDestination));
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
	
	private void plan(VectorPoint start, Point end) {
		System.out.println("plan(...)");
		if (!queue.isEmpty()) {
			queue.clear();
		}
		int x1 = start.x, x2 = end.x, y1 = start.y, y2 = end.y;
		double slope = abs((x2 - x1) / ((double) x2 - x1));
		while (x1 != x2 || y1 != y2) {
			if (abs((y2 - y1) / ((double) x2 - x1)) < slope) {
				x1 += ((int) signum(x2 - x1));
			}
			else {
				y1 += ((int) signum(y2 - y1));
			}
			queue.add(new VectorPoint(x1, y1,
					sqrt(pow(start.getVX(), 2) + 2 * acceleration * (x1 - start.x)),
					sqrt(pow(start.getVY(), 2) + 2 * acceleration * (y1 - start.y))));
			
		}
	}
	
	private void move() {
		System.out.println("move()");
		VectorPoint p = null;
		while (!queue.isEmpty()) {
			p = queue.poll();
			setLocation(p);
			sleep(Math.max(p.getVX(), p.getVY()));
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
	
	private void sleep(double speed) {
		try {
			Thread.sleep((long) (1000 / speed));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
