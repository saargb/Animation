package lib;

import java.awt.Point;
import static java.lang.Math.*;

public class Vector {
	
	private int x;
	private int y;
	
	private double angle; // radians
	private double magnitude;
	
	public Vector(int x, int y, double angle, double length) {
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.magnitude = length;
	}
	
	public Vector(Point start, Point end) {
		x = start.x;
		y = start.y;
		angle = atan(((double) start.y - end.y) / (start.x - end.x));
		if (start.y > end.y) {
			angle += PI;
		}
		magnitude = start.distance(end);
	}

	public Vector(int x1, int y1, int x2, int y2) {
		x = x1;
		y = y1;
		angle = atan(((double) y1 - y2) / (x1 - x2));
		if (y1 > y2) {
			angle += PI;
		}
		magnitude = new Point(x1, y1).distance(y1, y2);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(double magnitude) {
		this.magnitude = magnitude;
	}
	
	public int getX2() {
		return (int) (x + (acos(angle) / magnitude));
	}
	
	public void setX2(int x2) {
		int y2 = getY2();
		angle = atan(((double) y - y2) / (x - x2));
		magnitude = new Point(x, y).distance(x2, y2);
	}
	
	public int getY2() {
		return (int) (y + (asin(angle) / magnitude));
	}
	
	public void setY2(int y2) {
		angle = atan(((double) y - y2) / (x - getX2()));
		if (y2 > y2) {
			angle += PI;
		}
		magnitude = new Point(x, y).distance(getX2(), y2);
	}
	
}