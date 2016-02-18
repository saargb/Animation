package lib;

import java.awt.geom.Point2D;

public class VelocityPoint extends Point2D {
	
	public int x;
	public int y;
	public double velocity;
	
	public VelocityPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public VelocityPoint(int x, int y, double velocity) {
		this(x, y);
		this.velocity = velocity;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setLocation(double x, double y) {
		this.x = (int) x;
		this.y = (int) y;
	}

}
