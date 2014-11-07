package me.drewhoener.compsci.advanced.snake;

public enum Direction {

	UP(new Point(0, -2), 40, 38, 87, 83, new Point(0, -14)), DOWN(new Point(0, 2), 38, 40, 83, 87, new Point(0, 14)), LEFT(new Point(-2, 0), 39, 37, 65, 68, new Point(-14, 0)), RIGHT(new Point(2, 0), 37, 39, 68, 65, new Point(14, 0));

	private Point movement;
	private Point normalMovement;
	private int opposite;
	private int key;
	private int p2key;
	private int p2opposite;

	Direction(Point p, int opposite, int key, int p2key, int p2opposite, Point normalMovement) {
		this.movement = p;
		this.opposite = opposite;
		this.key = key;
		this.p2key = p2key;
		this.p2opposite = p2opposite;
		this.normalMovement = normalMovement;
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

	public Point getNormalMovement() {
		return this.normalMovement;
	}

	public static Direction getAdjacentPoint(CirclePoint point1, CirclePoint secondPoint) {

		if (secondPoint.getCenter().getX() > point1.getCenter().getX()) {
			return Direction.LEFT;
		} else if (secondPoint.getCenter().getX() < point1.getCenter().getX()) {
			return Direction.RIGHT;
		} else if (secondPoint.getCenter().getY() < point1.getCenter().getY()) {
			return Direction.DOWN;
		} else {
			return Direction.UP;
		}


	}

	public static Direction actualOpposite(Direction primary) {

		switch (primary) {

			case DOWN:
				return UP;
			case UP:
				return DOWN;
			case LEFT:
				return RIGHT;
			case RIGHT:
				return LEFT;
			default:
				return UP;


		}

	}

}
