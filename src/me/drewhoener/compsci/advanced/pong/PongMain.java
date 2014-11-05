package me.drewhoener.compsci.advanced.pong;


import javax.swing.*;
import java.awt.event.ActionListener;

public class PongMain {

	public static void main(String[] args) {


		SwingUtilities.invokeLater(() -> {

					JFrame mainFrame = new JFrame();

					PongGame game = new PongGame();
					mainFrame.add(game);

					game.addKeyListener(game.mainListener);

					game.setFocusable(true);
					game.requestFocusInWindow();

					mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					mainFrame.pack();
					mainFrame.setTitle("Pong (Swing Version)");
					mainFrame.setResizable(false);
					mainFrame.setLocationRelativeTo(null);
					mainFrame.setVisible(true);

					int delay = 200; //milliseconds

					ActionListener taskPerformer = evt -> game.repaint();


					new Timer(delay, taskPerformer).start();

				}
		);


	}

}
