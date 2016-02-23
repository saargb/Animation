package lib;

import java.awt.Point;
import static java.lang.Math.*;

public class Vector {
	
	private double x;
	private double y;
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector(Point point) {
		x = point.x;
		y = point.y;
	}

	public double getX() {
		return x;
	}

//	public void setX(int x) {
//		this.x = x;
//	}

	public double getY() {
		return y;
	}

//	public void setY(int y) {
//		this.y = y;
//	}

	public double getAngle() {
		return ((double) y) / x;
	}

//	public void setAngle(double angle) {
//		double magnitude = getMagnitude();
//		x = (int)(cos(angle) * magnitude);
//		y = (int)(sin(angle) * magnitude);
//	}

	public double getMagnitude() {
		return sqrt(pow(x, 2) + pow(y, 2));
	}
	
}