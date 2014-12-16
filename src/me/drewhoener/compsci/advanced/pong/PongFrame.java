package me.drewhoener.compsci.advanced.pong;

import javax.swing.*;

public class PongFrame {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {


			JFrame frame = new JFrame("Pong (Swing)");

			PongPanel panel = new PongPanel();

			frame.add(panel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			frame.pack();
			//frame.setTitle("Pong (Swing)");

			frame.setVisible(true);


		});


	}


}
