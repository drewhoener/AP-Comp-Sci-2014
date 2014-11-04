package me.drewhoener.compsci.advanced.snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {

	private int length;
	private List<CirclePoint> pointList = new ArrayList<>();
	private Direction curDirection;
	private boolean canPlay = true;

	public Snake() {
		this(new Point());
	}

	public Snake(Point p) {
		pointList.clear();
		CirclePoint head = new CirclePoint(p, Color.RED);
		pointList.add(head);
		this.length = 1;
		this.curDirection = Direction.RIGHT;
	}

	public List<CirclePoint> getPointList() {
		return this.pointList;
	}

	public void updateMovement() {

		CirclePoint tempPoint;

		if (this.canPlay) {

			if (this.pointList.size() > 1) {

				tempPoint = this.pointList.get(1);
				tempPoint.setColor(Color.GREEN);
				this.pointList.set(1, new CirclePoint(this.pointList.get(0).getCenter(), Color.GREEN));

				for (int i = 2; i < this.pointList.size(); i++) {
					CirclePoint temp2 = this.pointList.get(i);
					this.pointList.set(i, tempPoint);
					tempPoint = temp2;
					tempPoint.setColor(Color.GREEN);

					this.pointList.get(i).setColor(Color.GREEN);

				}
			}

			CirclePoint first = this.pointList.get(0).translatePoint(this.curDirection.getMovement());
			first.setColor(Color.RED);

			this.pointList.set(0, first);
		}

	}

	public void setColorAll(Graphics2D g, Color c) {

		for (CirclePoint cp : this.pointList) {
			cp.setColor(c);
		}

		forceDraw(g);

	}

	public boolean interact(CirclePoint cp) {

		if (cp.getCenter().getX() == this.getHead().getX() && cp.getCenter().getY() == this.getHead().getY()) {


			System.out.println("add the point?");
			this.pointList.add(this.pointList.get(this.pointList.size() - 1).translatePoint(getOptimalCoords().getMovement()));
			System.out.println(this.pointList.size());
			return true;

		}

		return false;

	}

	public Point getTrueEdge() {

		return new Point(this.pointList.get(0).getCenter().getX() + this.curDirection.getMovement().getX(), this.pointList.get(0).getCenter().getY() + this.curDirection.getMovement().getY());

	}

	public Direction getCurDirection() {
		return this.curDirection;
	}

	public Point getHead() {

		return this.pointList.get(0).getCenter();

	}

	public void setCurDirection(Direction dir) {
		this.curDirection = dir;
	}

	public void setCanPlay(boolean state) {
		this.canPlay = state;
	}

	public boolean canPlay() {
		return canPlay;
	}

	public void drawPoints(Graphics2D graphics2D) {

		if (this.canPlay) {

			for (CirclePoint cp : this.pointList) {

				cp.drawPoint(graphics2D);
				System.out.println("Drawing: " + cp.getCenter().toString());

			}

			System.out.println();
			System.out.println();
			System.out.println();
		}

	}

	public void forceDraw(Graphics2D graphics2D) {


		for (CirclePoint cp : this.pointList) {

			cp.drawPoint(graphics2D);
			System.out.println("Drawing: " + cp.toString());

		}

	}


	public Direction getOptimalCoords() {

		if (this.curDirection == Direction.DOWN) {
			return Direction.UP;
		} else if (this.curDirection == Direction.UP) {
			return Direction.DOWN;
		} else if (this.curDirection == Direction.LEFT) {
			return Direction.RIGHT;
		} else {
			return Direction.LEFT;
		}


	}


}
