package me.drewhoener.compsci.advanced.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PongGame extends JPanel {

	private Paddle paddle1;
	private Paddle paddle2;
	private CirclePoint ball;

	public static int WIDTH = 600;
	public static int HEIGHT = 400;

	public PongGame() {

		this.paddle1 = new Paddle(new Rectangle(5, 5, 12, 90), Color.BLUE);
		this.paddle2 = new Paddle(new Rectangle(WIDTH - 17, 5, 12, 90), Color.GREEN);
		this.ball = new CirclePoint(new Point(WIDTH / 2, HEIGHT / 2), Color.WHITE);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.BLACK);

	}

	public KeyListener mainListener = new KeyListener() {
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


	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		this.drawRedraw((Graphics2D) graphics);

	}

	public void drawRedraw(Graphics2D graphics) {

		this.paddle1.drawPaddle(graphics);
		this.paddle2.drawPaddle(graphics);

		this.ball.drawPoint(graphics);


	}


}
