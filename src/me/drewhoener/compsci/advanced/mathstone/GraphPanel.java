package me.drewhoener.compsci.advanced.mathstone;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class GraphPanel extends JPanel {

	public static final int HEIGHT = 800;
	public static final int WIDTH = 950;

	private static int WORKING_WIDTH = WIDTH - 150;
	private static int WORKING_HEIGHT = HEIGHT - 150;

	private double maxY = Integer.MIN_VALUE;
	private double minY = Integer.MAX_VALUE;

	static DecimalFormat numberFormat = new DecimalFormat("#.000");


	private GraphMethods.IncrementableMethod method = null;

	private List<Point.Double> pointList = new ArrayList<>();

	private final GraphMain main;

	public GraphPanel(GraphMain main) {
		super();
		this.main = main;
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.BLACK);

	}


	private void drawRedraw(Graphics2D graphics) {

		graphics.setColor(Color.WHITE);
		graphics.drawLine(70, 70, 70, WORKING_HEIGHT + 90);
		graphics.drawLine(70, WORKING_HEIGHT + 90, WORKING_WIDTH + 80, WORKING_HEIGHT + 90);

		for (int i = 0; i < this.pointList.size(); i++) {

			Point2D.Double p = this.pointList.get(i);

			double xVal = this.getXValue(i);
			double yVal = this.getYValue(p.getY());

			graphics.drawString(numberFormat.format(p.getY()), (float) xVal - 3, (float) yVal - 10);

			graphics.setColor(Color.RED);
			graphics.drawOval((int) xVal, (int) yVal, 10, 10);
			graphics.setColor(Color.GRAY);
			graphics.fillOval((int) xVal, (int) yVal, 10, 10);

			if ((i + 1) < this.pointList.size()) {

				Point2D.Double p2 = this.pointList.get(i + 1);
				double xVal2 = this.getXValue(i + 1) + 5;
				double yVal2 = this.getYValue(p2.getY()) + 5;
				graphics.setColor(Color.GRAY);
				graphics.drawLine(((int) xVal) + 5, (int) yVal + 5, (int) xVal2, (int) yVal2);

			}

		}


	}

	public void resetMethods() {

		this.method = null;
		this.pointList.clear();
		maxY = Integer.MIN_VALUE;
		minY = Integer.MAX_VALUE;

	}

	public void start(GraphMethods.IncrementableMethod method) {
		this.method = method;
	}

	public void drawNextPoint() {
		if (this.method == null) {
			JOptionPane.showMessageDialog(this.main.getFrame(), "Enter a number and choose a method first", "Error: Invalid", JOptionPane.WARNING_MESSAGE);
			this.resetMethods();
			return;
		}
		double d = 10;
		try {
			d = this.method.getNextIncrement();
		} catch (StackOverflowError e) {
			JOptionPane.showMessageDialog(this.main.getFrame(), "Your graph seems to have converged too much!", "Error: OVERFLOW", JOptionPane.ERROR_MESSAGE);
			return;
		}
		this.pointList.add(new Point.Double(0, d));
		this.recalculateAllPoints();

	}

	private void recalculateAllPoints() {

		for (Point.Double p : this.pointList) {
			if (p.getY() > this.maxY) {
				maxY = p.getY();
			}
			if (p.getY() < this.minY) {
				minY = p.getY();
			}
		}
		System.out.println("------------------------------------------------------");
		for (Point.Double p : this.pointList)
			System.out.println("Point: " + p.toString() + " | " + this.getYValue(p.getY()));

	}

	private double getYValue(double pointY) {

		double range = maxY - minY;
		double percentage = ((pointY - minY) / range);
		if (range == 0)
			return WORKING_HEIGHT;

		return WORKING_HEIGHT - (percentage * WORKING_HEIGHT) + 75;
	}

	public double getXValue(int index) {

		return (WORKING_WIDTH / this.pointList.size()) * index + 75;

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.drawRedraw(((Graphics2D) g));
	}

}
