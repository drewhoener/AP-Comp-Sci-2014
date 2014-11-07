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

	public void translatePoint(Point p) {


		this.center.setX(this.center.getX() + (p.getX() * 7));
		this.center.setY(this.center.getY() + (p.getY() * 7));


	}

	public void translatePointNormal(Point p) {

		if (this.color != Color.RED) {

			System.out.println("To Move: " + p.toString());
		}

		this.center.setX(this.center.getX() + p.getX());
		this.center.setY(this.center.getY() + p.getY());

	}

	public Direction toMoveAdjacent(CirclePoint beforePoint) {

		if (this.curDir == beforePoint.getCurDir()) {

			System.out.println("Directions Equal");
			System.out.println(this.curDir.toString());
			System.out.println(beforePoint.curDir.toString());

			return this.curDir;

		} else {

			if (this.center.getX() == beforePoint.getCenter().getX() || this.center.getY() == beforePoint.getCenter().getY()) {

				System.out.println("Points on axis, making directions equal");

				this.lastDir = this.curDir;
				this.curDir = beforePoint.getCurDir();

				return this.curDir;
			} else {

				System.out.println("Points not on axis, moving " + beforePoint.getLastDir().toString());

				this.lastDir = this.curDir;
				this.curDir = beforePoint.getLastDir();
				return this.curDir;
			}

		}

	}

	public void updateDir(Direction dir) {
		this.lastDir = this.curDir;
		this.curDir = dir;
	}


}
