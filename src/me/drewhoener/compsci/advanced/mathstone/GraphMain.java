package me.drewhoener.compsci.advanced.mathstone;

import javax.swing.*;
import java.awt.*;

public class GraphMain {


	GraphPanel panel1;
	ButtonPanel panel2;
	JFrame frame = new JFrame("Graph Visualizer");
	Timer timer;

	public static GraphMain instance = null;


	public static void main(String[] args) {

		GraphMain main = new GraphMain();
		main.init();

	}

	public void init() {

		instance = GraphMain.this;

		panel1 = new GraphPanel(instance);
		panel2 = new ButtonPanel(instance);

		SwingUtilities.invokeLater(() -> {

			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

			frame.add(panel1, BorderLayout.CENTER);

			frame.add(panel2, BorderLayout.EAST);

			frame.pack();
			frame.setVisible(true);

			this.panel2.requestFocusInWindow();

		});

		this.timer = new Timer(50, e -> this.getPanel1().repaint());
		this.timer.start();

	}

	public GraphPanel getPanel1() {
		return panel1;
	}

	public ButtonPanel getPanel2() {
		return panel2;
	}

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Determines if a string is an integer
	 *
	 * @param str The string to check
	 * @return If it is a valid integer
	 */
	public static boolean isInteger(String str) {
		if (str == null) {
			return false;
		}
		int length = str.length();
		if (length == 0) {
			return false;
		}
		int i = 0;
		if (str.charAt(0) == '-') {
			if (length == 1) {
				return false;
			}
			i = 1;
		}
		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c <= '/' || c >= ':') {
				return false;
			}
		}
		return true;
	}

}
