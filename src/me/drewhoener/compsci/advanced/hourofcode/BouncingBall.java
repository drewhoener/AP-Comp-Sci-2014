package me.drewhoener.compsci.advanced.hourofcode;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BouncingBall {

	public static void main(String[] args) {

		Runnable r = () -> {


			JFrame mainFrame = new JFrame("Bouncing Ball");

			BallPanel panel = new BallPanel();

			mainFrame.add(panel);

			panel.setFocusable(true);
			panel.requestFocusInWindow();

			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.pack();
			mainFrame.setLocationRelativeTo(null);
			mainFrame.setVisible(true);

			int delay = 5; //milliseconds

			ActionListener taskPerformer = evt -> panel.repaint();


			new Timer(delay, taskPerformer).start();

		};


		SwingUtilities.invokeLater(r);

	}

}
