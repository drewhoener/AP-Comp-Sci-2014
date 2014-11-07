package me.drewhoener.compsci.advanced.snake;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Snake {

	private int length;
	private List<CirclePoint> pointList = new ArrayList<>();
	private Direction curDirection;
	private boolean canPlay = true;
	private Color headColor;
	private Color bodyColor;
	private BufferedImage image = null;

	public Snake() {
		this(new Point());
	}

	public Snake(Point p) {

		this(p, Color.RED, Color.GREEN);

	}

	public Snake(Point p, Color headColor, Color bodyColor) {
		this.headColor = headColor;
		this.bodyColor = bodyColor;
		this.curDirection = Direction.RIGHT;
		pointList.clear();
		CirclePoint head = new CirclePoint(p, this.headColor);
		head.setCurDir(this.curDirection);
		pointList.add(head);
		this.length = 1;
	}

	public Snake(Point p, BufferedImage image, Color bodyColor) {
		this.image = image;
		this.bodyColor = bodyColor;
		pointList.clear();
		CirclePoint head = new CirclePoint(p, this.image);
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


			System.out.println("Direction: " + this.curDirection.toString());
			this.pointList.get(0).translatePointNormal(this.curDirection.getMovement());
			this.pointList.get(0).setColor(this.headColor);

			if (this.pointList.size() > 1) {

				for (int i = 1; i < this.pointList.size(); i++) {

					this.pointList.get(i).translatePointNormal(this.pointList.get(i).toMoveAdjacent(this.pointList.get(i - 1)).getMovement());
					this.pointList.get(i).setColor(this.bodyColor);

					}

				/*
				tempPoint = this.pointList.get(1);
				tempPoint.setColor(this.bodyColor);
				this.pointList.set(1, new CirclePoint(this.pointList.get(0).getCenter(), this.bodyColor));

				for (int i = 2; i < this.pointList.size(); i++) {
					CirclePoint temp2 = this.pointList.get(i);
					this.pointList.set(i, tempPoint);
					tempPoint = temp2;
					tempPoint.setColor(this.bodyColor);

					this.pointList.get(i).setColor(this.bodyColor);

				}*/
			}
		}

	}

	public void setColorAll(Graphics2D g, Color c) {

		for (CirclePoint cp : this.pointList) {
			cp.setColor(c);
		}

		forceDraw(g);

	}

	public boolean interact(CirclePoint cp) {

		if (Math.abs(cp.getCenter().getX() - this.getHead().getX()) <= 5 && Math.abs(cp.getCenter().getY() - this.getHead().getY()) <= 5) {
			System.out.println("add the point?");
			CirclePoint beforePoint = this.pointList.get(this.pointList.size() - 1);

			CirclePoint addPoint = new CirclePoint(beforePoint.getCenter().clone(), this.bodyColor);
			addPoint.translatePointNormal(new Point(getOptimalCoords().getNormalMovement().getX(), getOptimalCoords().getNormalMovement().getY()));
			this.pointList.add(addPoint);
			this.pointList.get(this.pointList.size() - 1).setCurDir(this.curDirection);
			System.out.println("New Point Center: " + this.pointList.get(this.pointList.size() - 1).getCenter().toString());
			System.out.println(this.pointList.size());
			return true;

		}

		for (int i = 1; i < this.pointList.size(); i++) {

			if (this.getHead().getX() == this.pointList.get(i).getCenter().getX() && this.getHead().getY() == this.pointList.get(i).getCenter().getY()) {
				this.canPlay = false;
			}

		}

		return false;

	}

	public void crashWithOther(List<CirclePoint> pointsOther) {

		for (int i = 0; i < pointsOther.size(); i++) {

			if (this.getHead().getX() == pointsOther.get(i).getCenter().getX() && this.getHead().getY() == pointsOther.get(i).getCenter().getY()) {
				this.canPlay = false;
			}

		}

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
			System.out.println("Drawing: " + cp.getCenter().toString());

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

	public boolean isWithinLimits() {

		//System.out.println("" + this.snake1.getTrueEdge().getX() + " : " + (WIDTH - 20));

		return (this.getTrueEdge().getX() <= SnakeGame.WIDTH - 14) && (this.getTrueEdge().getX() >= 14) && (this.getTrueEdge().getY() <= SnakeGame.HEIGHT - 14) && (this.getTrueEdge().getY() >= 14);

	}


}
