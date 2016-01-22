package me.drewhoener.compsci.advanced.tetris;

import javax.swing.*;

public class MainUnit {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {

			JFrame frame = new JFrame("Tetris");
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			TetrisPanel panel = new TetrisPanel();
			frame.setContentPane(panel);
			frame.pack();
			frame.setVisible(true);

		});

	}

}
