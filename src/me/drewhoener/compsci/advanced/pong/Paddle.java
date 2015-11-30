package me.drewhoener.compsci.advanced.pong;

import java.awt.*;

public class Paddle {

	private Point corner;

	int width;
	int height;
	Color color;

	public Paddle() {

		this(15, 160, Color.BLACK);

	}

	public Paddle(Point corner) {

		this.height = 160;
		this.width = 15;
		this.color = Color.BLACK;
		this.corner = corner;

	}

	public Paddle(int width, int height, Color color) {

		this.height = height;
		this.width = width;
		this.color = color;
		this.corner = new Point(45, 30);

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

	public void drawPaddle(Graphics2D g) {

		g.setColor(Color.WHITE);
		g.fillRect(this.corner.getX(), this.corner.getY(), this.width, this.height);

	}

	public Point getCorner() {
		return this.corner;
	}

	public void moveUp() {
		if (this.corner.getY() > 0)
			this.corner.translate(0, -45);

	}

	public void moveDown() {
		if (this.corner.getY() < PongPanel.HEIGHT - this.height)
			this.corner.translate(0, 45);

	}




}
