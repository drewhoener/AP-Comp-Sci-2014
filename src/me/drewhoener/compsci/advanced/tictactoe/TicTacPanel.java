package me.drewhoener.compsci.advanced.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TicTacPanel extends JPanel {

	public static int WIDTH = 500;
	public static int HEIGHT = 500;

	public TicTacPanel() {

		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.BLACK);
		this.addKeyListener(listener);

		this.setFocusable(true);
		this.requestFocusInWindow();

	}

	public KeyListener listener = new KeyListener() {
		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {

		}
	};

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		this.drawRedraw((Graphics2D) g);

		this.repaint();

	}

	public void drawRedraw(Graphics2D g) {

		g.setColor(Color.WHITE);
		g.drawLine((WIDTH / 3), 0, (WIDTH / 3), HEIGHT);
		g.drawLine((WIDTH - (WIDTH / 3)), 0, (WIDTH - (WIDTH / 3)), HEIGHT);
		g.drawLine(0, HEIGHT / 3, WIDTH, HEIGHT / 3);
		g.drawLine(0, (HEIGHT - (HEIGHT / 3)), WIDTH, (HEIGHT - (HEIGHT / 3)));

	}

}
