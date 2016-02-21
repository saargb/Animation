package lib;

import java.awt.Point;
import static java.lang.Math.*;

public class Vector {
	
	private int x;
	private int y;
	
	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector(Point point) {
		x = point.x;
		y = point.y;
	}

	public Vector(double angle, double magnitude) {
		x = (int) (cos(angle) * magnitude);
		y = (int) (sin(angle) * magnitude);
	}

	public int getX() {
		return x;
	}

//	public void setX(int x) {
//		this.x = x;
//	}

	public int getY() {
		return y;
	}

//	public void setY(int y) {
//		this.y = y;
//	}

	public double getAngle() {
		return ((int) y) / x;
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