package me.drewhoener.compsci.plainclass;

public class MovableCircle implements IMovable {

	private MovablePoint center;
	private int radius;

	public MovableCircle(int x, int y, int radius) {

		this.center = new MovablePoint(x, y);
		this.radius = radius;

	}

	@Override
	public void moveUp() {

		this.center.moveUp();

	}

	@Override
	public void moveDown() {

		this.center.moveDown();

	}

	@Override
	public void moveLeft() {

		this.center.moveLeft();

	}

	@Override
	public void moveRight() {

		this.center.moveRight();

	}

	public String toString() {
		return "Center: " + this.center + ", Radius: " + this.radius;
	}
}
