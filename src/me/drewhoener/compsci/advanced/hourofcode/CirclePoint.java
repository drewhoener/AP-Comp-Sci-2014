package me.drewhoener.compsci.advanced.hourofcode;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class CirclePoint {

	private Point center;
	private Color color;
	private int diameter = 20;
	private BufferedImage image;

	private Direction primaryDir;
	private Direction secondaryDir;

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

	public CirclePoint(Point p, Color c, Direction dir1) {

		this.center = p;
		this.color = c;
		this.primaryDir = dir1;

	}

	public CirclePoint(Point p, Color c, Direction dir1, Direction dir2) {

		this.center = p;
		this.color = c;
		this.primaryDir = dir1;
		this.secondaryDir = dir2;

	}

	public CirclePoint(Point p, BufferedImage image) {
		this.center = p;
		this.color = null;
		this.image = image;

	}

	public void setPrimaryDir(Direction curDir) {
		this.primaryDir = curDir;
	}

	public void setSecondaryDir(Direction lastDir) {
		this.secondaryDir = lastDir;
	}

	public Direction getPrimaryDir() {
		return this.primaryDir;
	}

	public Direction getSecondaryDir() {
		return this.secondaryDir;
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

	public void resetPrimary() {

		this.primaryDir = Direction.randomDir();

	}

	public void resetSecondary() {

		this.secondaryDir = Direction.randomDir();

	}

	public void translatePoint(Point p) {

		if (this.color != Color.RED) {

			System.out.println("To Move: " + p.toString());
		}

		this.center.setX(this.center.getX() + p.getX());
		this.center.setY(this.center.getY() + p.getY());

	}

	//0 - No room on either, 1 - no room on x, 2 - no room on y, 3 - all good
	public int closeEnough(int xMax, int yMax) {

		if ((0 + (this.diameter * 2)) < this.center.getX() && (xMax - (this.diameter * 2)) > this.center.getX()) {

			if ((0 + (this.diameter * 2)) < this.center.getY() && (yMax - (this.diameter * 2)) > this.center.getY()) {

				return 3;

			} else {

				return 2;

			}

		} else {

			return 1;

		}


	}

	public void moveWithDir() {

		this.translatePoint(this.primaryDir.getMovement());

		if (this.secondaryDir != this.primaryDir && this.secondaryDir != Direction.actualOpposite(this.primaryDir)) {
			this.translatePoint(this.secondaryDir.getMovement());
		}

	}


}
