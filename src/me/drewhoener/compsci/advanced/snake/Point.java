package me.drewhoener.compsci.advanced.snake;

import java.util.Random;

public class Point {

	private int x;
	private int y;

	public Point() {
		this(0, 0);
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public static Point randomPoint(int minX, int maxX, int minY, int maxY) {

		Random r = new Random();

		return new Point(14 * (r.nextInt(maxX) + minX), 14 * (r.nextInt(maxY) + minY));
	}

	public String toString() {

		return "{ " + this.x + ", " + this.y + " }";
	}

	public Point clone() {

		return new Point(this.x, this.y);

	}
}
