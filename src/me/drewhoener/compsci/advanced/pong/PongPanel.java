package me.drewhoener.compsci.advanced.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PongPanel extends JPanel {

	public static int WIDTH = 1200;
	public static int HEIGHT = 600;

	public int leftPlayerScore = 0;
	public int rightPlayerScore = 0;

	//init ball
	public Ball pongBall;
	//init paddles
	public Paddle leftPaddle;
	public Paddle rightPaddle;

	public PongPanel() {

		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.BLACK);
		this.addKeyListener(listener);
		this.pongBall = new Ball(Color.RED);
		this.leftPaddle = new Paddle();
		this.rightPaddle = new Paddle(new Point(WIDTH - 16 - 45, 30));
		this.setFocusable(true);
		this.requestFocusInWindow();
	}

	public KeyListener listener = new KeyListener() {
		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode() == KeyEvent.VK_W) {
				leftPaddle.moveUp();
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				leftPaddle.moveDown();
			}

			if (e.getKeyCode() == KeyEvent.VK_UP) {
				rightPaddle.moveUp();
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				rightPaddle.moveDown();
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {

		}
	};

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		this.drawRedraw((Graphics2D) g);
		try {
			Thread.sleep(4);
		} catch (InterruptedException e) {

			e.printStackTrace();

		}
		this.repaint();

	}


	public void drawRedraw(Graphics2D g) {


		g.setColor(Color.WHITE);
		g.drawLine(WIDTH / 2 + 10, 0, WIDTH / 2 + 10, HEIGHT);

		g.drawOval(WIDTH / 2 - 5, HEIGHT / 2 - 5, 30, 30);

		g.drawString("" + this.leftPlayerScore, 80, 15);
		g.drawString("" + this.rightPlayerScore, WIDTH - 80, 15);


		this.pongBall.drawBall(g);
		this.leftPaddle.drawPaddle(g);
		this.rightPaddle.drawPaddle(g);

		this.interact();

		this.pongBall.moveBall();


	}

	public void interact() {


		if (this.pongBall.getCenter().getX() < this.pongBall.getRadius()) {
			this.pongBall.reverseX();
		}

		if (this.pongBall.getCenter().getX() < (this.leftPaddle.getCorner().getX() + this.leftPaddle.width + this.pongBall.getRadius() - 3)) {

			if (this.pongBall.getCenter().getY() > this.leftPaddle.getCorner().getY() &&
					this.pongBall.getCenter().getY() < this.leftPaddle.getCorner().getY() + this.leftPaddle.height) {

				this.pongBall.reverseX();

			}

		}

		if (this.pongBall.getCenter().getX() > (this.rightPaddle.getCorner().getX() - this.pongBall.getDiameter() - 2)) {

			if (this.pongBall.getCenter().getY() > this.rightPaddle.getCorner().getY() &&
					this.pongBall.getCenter().getY() < this.rightPaddle.getCorner().getY() + this.rightPaddle.height) {

				this.pongBall.reverseX();

			}

		}

		if (this.pongBall.getCenter().getX() < (this.pongBall.getDiameter() + 5)) {

			if (!(this.pongBall.getCenter().getY() > this.leftPaddle.getCorner().getY() &&
					this.pongBall.getCenter().getY() < this.leftPaddle.getCorner().getY() + this.leftPaddle.height)) {

				this.pongBall.setCenter(new Point(WIDTH / 2, HEIGHT / 2));
				this.rightPlayerScore++;

			}

		}

		if (this.pongBall.getCenter().getX() > (WIDTH - this.pongBall.getDiameter() - 5)) {

			if (!(this.pongBall.getCenter().getY() > this.rightPaddle.getCorner().getY() &&
					this.pongBall.getCenter().getY() < this.rightPaddle.getCorner().getY() + this.rightPaddle.height)) {

				this.pongBall.setCenter(new Point(WIDTH / 2, HEIGHT / 2));
				this.leftPlayerScore++;

			}

		}

		if (this.pongBall.getCenter().getX() > (WIDTH - this.pongBall.getDiameter())) {
			this.pongBall.reverseX();
		}

		if (this.pongBall.getCenter().getY() > (HEIGHT - this.pongBall.getDiameter())) {
			this.pongBall.reverseY();
		}

		if (this.pongBall.getCenter().getY() < this.pongBall.getRadius()) {
			this.pongBall.reverseY();
		}


	}


}
