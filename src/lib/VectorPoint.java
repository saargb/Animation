package lib;

import java.awt.Point;

public class VectorPoint extends Point {
	
	private static final long serialVersionUID = -3730996496346249917L;
	
	private Vector vector;
	
	public VectorPoint(int x, int y, double vx, double vy) {
		super(x, y);
		vector = new Vector(vx, vy);
	}

	public double getVX() {
		return vector.getX();
	}

	public double getVY() {
		return vector.getY();
	}

	public double getAngle() {
		return vector.getAngle();
	}

	public double getMagnitude() {
		return vector.getMagnitude();
	}

}
