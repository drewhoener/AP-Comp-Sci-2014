package me.drewhoener.compsci.advanced.snake;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class CirclePoint {

	private Point center;
	private Color color;
	private int diameter = 10;
	private BufferedImage image;

	private Direction curDir;
	private Direction lastDir;

	public CirclePoint() {
		this(new Point(), Color.GREEN);
	}

	public CirclePoint(Point p) {
		this(p, Color.GREEN);
	}

	public CirclePoint(Point p, Color color) {
		this.center = p;
		this.color = color;
		this.image = null;
	}

	public CirclePoint(Point p, BufferedImage image) {
		this.center = p;
		this.color = null;
		this.image = image;

	}

	public void setCurDir(Direction curDir) {
		this.curDir = curDir;
	}

	public void setLastDir(Direction lastDir) {
		this.lastDir = lastDir;
	}

	public Direction getCurDir() {
		return curDir;
	}

	public Direction getLastDir() {
		return lastDir;
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

		if (this.color != null) {
			Ellipse2D.Double circle = new Ellipse2D.Double(this.center.getX(), this.center.getY(), this.diameter, this.diameter);
			g2d.setColor(this.color);

			g2d.fill(circle);
			return;
		}

		if (this.image != null) {

			g2d.drawImage(this.image, this.center.getX() - 3, this.center.getY() - 5, null);

		}

	}

	public CirclePoint translatePoint(Point p) {


		if (this.image != null) {
			return new CirclePoint(new Point(this.center.getX() + (p.getX() * 7), this.center.getY() + (p.getY() * 7)), this.image);
		}

		return new CirclePoint(new Point(this.center.getX() + (p.getX() * 7), this.center.getY() + (p.getY() * 7)), this.color);

	}

	public CirclePoint translatePointNormal(Point p) {


		if (this.image != null) {
			return new CirclePoint(new Point(this.center.getX() + (p.getX()), this.center.getY() + p.getY()), this.image);
		}

		return new CirclePoint(new Point(this.center.getX() + (p.getX()), this.center.getY() + (p.getY())), this.color);

	}

}
