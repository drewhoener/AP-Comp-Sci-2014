package me.drewhoener.compsci.advanced.tictactoe;

import javax.swing.*;

public class TicTacFrame {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {

			JFrame frame = new JFrame("Pong (Swing)");

			TicTacPanel panel = new TicTacPanel();

			frame.add(panel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			frame.pack();
			//frame.setTitle("Pong (Swing)");

			frame.setVisible(true);

		});

	}

}
