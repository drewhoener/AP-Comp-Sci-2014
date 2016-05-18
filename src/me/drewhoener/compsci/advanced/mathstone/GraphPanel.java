package me.drewhoener.compsci.advanced.mathstone;

import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {

	public static final int HEIGHT = 800;
	public static final int WIDTH = 950;

	public static final int GRAPHX = 15;
	public static int GRAPHY = 10;

	private GraphMethods.IncrementableMethod method = null;

	private final GraphMain main;

	public GraphPanel(GraphMain main) {
		super();
		this.main = main;
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.BLACK);

	}


	private void drawRedraw(Graphics2D graphics) {


	}

	public void resetMethods() {

		this.method = null;

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
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.drawRedraw(((Graphics2D) g));
	}

	enum CalculationMethods {
		BABYLONIAN,
		DIGIT,
		BAKHSHALI;
	}

}
