package me.drewhoener.compsci;

import javax.swing.*;

public class VeroniMain {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {

			JFrame mainFrame = new JFrame("Voroniz");
			mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			mainFrame.add(new VeroniPanel());
			mainFrame.pack();
			mainFrame.setVisible(true);

		});

	}


}
