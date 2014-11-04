package me.drewhoener.compsci.advanced.snake;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SnakeMain {

	public static void main(String[] args) {

		Runnable r = new Runnable() {
			@Override
			public void run() {

				JFrame mainFrame = new JFrame();

				SnakeGame game = new SnakeGame();
				mainFrame.add(game);

				game.addKeyListener(game.mainListener);

				game.setFocusable(true);
				game.requestFocusInWindow();

				mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainFrame.pack();
				mainFrame.setTitle("Snake (Swing Version)");
				mainFrame.setResizable(false);
				mainFrame.setLocationRelativeTo(null);
				mainFrame.setVisible(true);

				int delay = 200; //milliseconds

				ActionListener taskPerformer = evt -> game.repaint();

				new Timer(delay, taskPerformer).start();


			}
		};

		SwingUtilities.invokeLater(r);

		/*int delay = 500; //milliseconds

		ActionListener taskPerformer = evt -> game.repaint();

		new Timer(delay, taskPerformer).start();
		*/

	}
}
