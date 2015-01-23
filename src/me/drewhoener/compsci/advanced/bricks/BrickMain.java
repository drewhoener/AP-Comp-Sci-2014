package me.drewhoener.compsci.advanced.bricks;

import javax.swing.*;

public class BrickMain {


	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {

			JFrame frame = new JFrame("Brick Break (Swing)");

			BrickBreak panel = new BrickBreak();

			frame.add(panel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			frame.pack();
			//frame.setTitle("Pong (Swing)");

			frame.setVisible(true);


		});

	}

}
