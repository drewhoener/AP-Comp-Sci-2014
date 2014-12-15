package me.drewhoener.compsci.advanced.hourofcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Direction {

	UP(new Point(0, -1)), DOWN(new Point(0, 1)), LEFT(new Point(-1, 0)), RIGHT(new Point(1, 0));

	private Point movement;

	Direction(Point p) {
		this.movement = p;

	}

	public Point getMovement() {
		return this.movement;
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

		System.out.println(primary.name());

		switch (primary) {

			case DOWN:
				return Direction.UP;
			case UP:
				return DOWN;
			case LEFT:
				return Direction.RIGHT;
			case RIGHT:
				return Direction.LEFT;
			default:
				return Direction.UP;


		}

	}

	public static Direction randomDir() {

		List<Direction> directionList = Collections.unmodifiableList(Arrays.asList(Direction.values()));

		Random random = new Random();

		return directionList.get(random.nextInt(directionList.size()));


	}

}
