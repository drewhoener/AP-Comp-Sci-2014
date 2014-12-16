package me.drewhoener.compsci.advanced.pong;

import java.awt.*;

public class Ball {

	private Color color;
	private Point center;
	private int diameter = 20;
	private int yMovement = 2;
	private int xMovement = 2;

	public Ball(Color color) {

		this.center = new Point(PongPanel.WIDTH / 2, PongPanel.HEIGHT / 2);
		this.color = color;

	}

	public int getDiameter() {
		return this.diameter;
	}

	public void setCenter(Point p) {

		this.center = p;

	}

	public int getRadius() {
		return this.diameter / 2;
	}


	public void drawBall(Graphics2D g) {
		g.setColor(this.color);
		g.fillOval(this.center.getX(), this.center.getY(), this.diameter, this.diameter);

	}

	public void moveBall() {

		this.center.translate(this.xMovement, this.yMovement);

	}

	public void reverseX() {
		this.xMovement *= -1;
	}

	public void reverseY() {
		this.yMovement *= -1;
	}

	public Point getCenter() {
		return this.center;
	}


}
