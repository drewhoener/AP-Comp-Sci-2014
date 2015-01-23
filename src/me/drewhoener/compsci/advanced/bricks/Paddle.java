package me.drewhoener.compsci.advanced.bricks;

import java.awt.*;

public class Paddle {

	public Point corner;
	public int height;
	public int width;

	public Paddle() {

		this(new Point(BrickBreak.WIDTH / 3, BrickBreak.HEIGHT - 15));

	}

	public Paddle(Point corner) {

		this(corner, 15, 100);

	}

	public Paddle(Point corner, int height, int width) {

		this.corner = corner;
		this.height = height;
		this.width = width;

	}

	public void drawPaddle(Graphics2D g) {

		g.setColor(Color.WHITE);
		g.fillRect(this.corner.getX(), this.corner.getY(), this.width, this.height);

	}

	/**
	 * @param point  The point that is near colliding
	 * @param offset How far to check from the point for collision
	 * @returns What direction to ricochet: 0 - Do Nothing, 1 - Hit Left, 2 - Hit Right, 3 - Hit Top, 4 - Hit Bottom
	 */
	public int pointCollide(Point point, int offset) {

		if ((point.getX() + offset >= this.corner.getX() && point.getX() < this.corner.getX() && (point.getY() > this.corner.getY() && point.getY() < this.corner.getY() + this.height))) {

			return 1;

		}

		if ((point.getX() - offset <= this.corner.getX() + this.width && point.getX() > this.corner.getX() + this.width && (point.getY() > this.corner.getY() && point.getY() < this.corner.getY() + this.height))) {

			return 2;

		}

		if ((point.getY() + offset >= this.corner.getY() && point.getY() <= this.corner.getY() && (point.getX() > this.corner.getX() && point.getX() < this.corner.getX() + this.width))) {

			return 3;

		}

		if ((point.getY() - offset <= this.corner.getY() + this.height && point.getY() >= this.corner.getY() + this.height && (point.getX() > this.corner.getX() && point.getX() < this.corner.getX() + this.width))) {

			return 4;

		}


		return 0;
	}

	public void moveLeft() {

		if (this.corner.getX() >= 30) {
			this.corner.translate(-30, 0);
		}

	}

	public void moveRight() {

		if (this.corner.getX() <= BrickBreak.WIDTH - 30) {
			this.corner.translate(30, 0);
		}

	}

}
