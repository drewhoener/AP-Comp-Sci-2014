package me.drewhoener.compsci.plainclass;

public class Point {

	private double pointX;
	private double pointY;

	public Point() {
		this.pointX = 0;
		this.pointY = 0;
	}

	public Point(double x, double y) {
		this.pointX = x;
		this.pointY = y;
	}

	public double getPointX() {
		return pointX;
	}

	public double getPointY() {
		return pointY;
	}

	public void setLocation(double x, double y) {
		this.pointX = x;
		this.pointY = y;
	}

	public void translatePoint(double x, double y) {
		this.pointX += x;
		this.pointY += y;
	}

	public double distFromOrigin() {
		double originX = 0;
		double originY = 0;

		return Math.sqrt(Math.pow((this.pointX - originX), 2) + Math.pow((this.pointY - originY), 2));
	}
}
