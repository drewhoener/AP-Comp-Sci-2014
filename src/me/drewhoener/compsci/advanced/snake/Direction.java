package me.drewhoener.compsci.advanced.snake;

public enum Direction {

	UP(new Point(0, -14), 40, 38), DOWN(new Point(0, 14), 38, 40), LEFT(new Point(-14, 0), 39, 37), RIGHT(new Point(14, 0), 37, 39);

	private Point movement;
	private int opposite;
	private int key;

	Direction(Point p, int opposite, int key) {
		this.movement = p;
		this.opposite = opposite;
		this.key = key;
	}

	public int getOpposite() {
		return opposite;
	}

	public int getKey() {
		return key;
	}

	public Point getMovement() {
		return movement;
	}

}
