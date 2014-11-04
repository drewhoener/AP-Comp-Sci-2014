package me.drewhoener.compsci.advanced.snake;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CirclePoint {

	private Point center;
	private Color color;
	private int diameter = 10;

	public CirclePoint() {
		this(new Point(), Color.GREEN);
	}

	public CirclePoint(Point p) {
		this(p, Color.GREEN);
	}

	public CirclePoint(Point p, Color color) {
		this.center = p;
		this.color = color;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public Point getCenter() {
		return center;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void drawPoint(Graphics2D g2d) {

		Ellipse2D.Double circle = new Ellipse2D.Double(this.center.getX(), this.center.getY(), this.diameter, this.diameter);
		g2d.setColor(this.color);

		g2d.fill(circle);

	}

	public CirclePoint translatePoint(Point p) {

		return new CirclePoint(new Point(this.center.getX() + p.getX(), this.center.getY() + p.getY()), this.color);

	}
}
