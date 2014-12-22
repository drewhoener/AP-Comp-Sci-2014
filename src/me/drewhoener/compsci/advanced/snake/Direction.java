package me.drewhoener.compsci.advanced.snake;

public enum Direction {

	UP(new Point(0, -14), 40, 38, 87, 83), DOWN(new Point(0, 14), 38, 40, 83, 87), LEFT(new Point(-14, 0), 39, 37, 65, 68), RIGHT(new Point(14, 0), 37, 39, 68, 65);

	private Point movement;
	private int opposite;
	private int key;
	private int p2key;
	private int p2opposite;

	Direction(Point p, int opposite, int key, int p2key, int p2opposite) {
		this.movement = p;
		this.opposite = opposite;
		this.key = key;
		this.p2key = p2key;
		this.p2opposite = p2opposite;
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

	public void setP2key(int p2key) {
		this.p2key = p2key;
	}

	public int getP2key() {
		return p2key;
	}

	public void setP2Opposite(int p2opposite) {
		this.p2opposite = p2opposite;
	}

	public int getP2Opposite() {
		return p2opposite;
	}
}