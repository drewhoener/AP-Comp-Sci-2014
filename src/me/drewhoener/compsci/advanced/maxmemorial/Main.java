package me.drewhoener.compsci.advanced.maxmemorial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

	private static Main instance;
	JFrame mainFrame;

	public static void main(String[] args) {

		Main main = new Main();

	}

	public Main() {

		SwingUtilities.invokeLater(() -> {
			GraphicsDevice mainDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
			mainFrame = new JFrame();
			JPanel mainPanel = new MemorialPanel();
			mainFrame.setContentPane(mainPanel);
			mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			mainFrame.pack();
			//mainFrame.setVisible(true);
			mainDevice.setFullScreenWindow(mainFrame);
			mainPanel.addKeyListener(new KeyListener() {
				@Override
				public void keyTyped(KeyEvent e) {

				}

				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_Q)
						System.exit(0);
				}

				@Override
				public void keyReleased(KeyEvent e) {

				}
			});
			mainPanel.requestFocusInWindow();

			//mainFrame.setCursor(mainFrame.getToolkit().createCustomCursor(
			//new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), null));
		});
	}

	public static Main getInstance() {
		return instance;
	}
}
