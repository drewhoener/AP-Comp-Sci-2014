package me.drewhoener.compsci.advanced.bricks;

import java.awt.*;

public class BrickPiece {

	public Point corner;
	public static final int GENERIC_WIDTH = 12;
	public static final int GENERIC_HEIGHT = 9;


	public BrickPiece(Point corner) {

		this.corner = corner;

	}

	public void drawBrick(Graphics2D g) {

		g.setColor(Color.GREEN);
		g.fillRect(this.corner.getX(), this.corner.getY(), GENERIC_WIDTH, GENERIC_HEIGHT);

	}

	/**
	 * @param point  The point that is near colliding
	 * @param offset How far to check from the point for collision
	 * @returns What direction to ricochet: 0 - Do Nothing, 1 - Hit Left, 2 - Hit Right, 3 - Hit Top, 4 - Hit Bottom
	 */
	public int pointCollide(Point point, int offset) {

		if ((point.getX() + offset >= this.corner.getX() && point.getX() < this.corner.getX() && (point.getY() > this.corner.getY() && point.getY() < this.corner.getY() + GENERIC_HEIGHT))) {

			return 1;

		}

		if (((point.getX() - offset) <= (this.corner.getX() + GENERIC_WIDTH) && point.getX() > (this.corner.getX() + GENERIC_WIDTH) && (point.getY() > this.corner.getY() && point.getY() < this.corner.getY() + GENERIC_HEIGHT))) {


			//System.out.println(point.getX() - offset + " : " + this.corner.getX());
			//System.out.println(point.getX() + " : " + (this.corner.getX() + GENERIC_WIDTH));

			return 2;

		}

		if ((point.getY() + offset >= this.corner.getY() && point.getY() < this.corner.getY() && (point.getX() > this.corner.getX() && point.getX() < this.corner.getX() + GENERIC_WIDTH))) {

			return 3;

		}

		if ((point.getY() - offset <= this.corner.getY() + GENERIC_HEIGHT && point.getY() > this.corner.getY() + GENERIC_HEIGHT && (point.getX() > this.corner.getX() && point.getX() < this.corner.getX() + GENERIC_WIDTH))) {

			/*
			System.out.println(point);

			System.out.println();
			System.out.println("Point y: " + point.getY());
			System.out.println("Corner Y: " + this.corner.getY());
			System.out.println("Point X: " + point.getX());
			System.out.println("Corner X: " + this.corner.getX());
			System.out.println("Offset: " + offset);
			System.out.println();
			*/

			return 4;

		}


		return 0;
	}

}
