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
