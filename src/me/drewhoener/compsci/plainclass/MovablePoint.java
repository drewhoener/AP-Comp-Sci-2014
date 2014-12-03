package me.drewhoener.compsci.plainclass;

public class MovablePoint implements IMovable {

	private int x;
	private int y;

	public MovablePoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void moveUp() {

		y++;

	}

	@Override
	public void moveDown() {

		y--;

	}

	@Override
	public void moveLeft() {

		x--;

	}

	@Override
	public void moveRight() {

		x++;

	}

	public String toString() {

		return "MovablePoint : { " + this.x + " : " + this.y + " }";

	}
}
