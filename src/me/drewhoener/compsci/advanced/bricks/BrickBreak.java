package me.drewhoener.compsci.advanced.bricks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class BrickBreak extends JPanel {

	public static int WIDTH = 600;
	public static int HEIGHT = 800;
	private int sleep = 8;

	private Paddle paddle;
	private List<BrickPiece> bricks = new CopyOnWriteArrayList<>();
	private List<Ball> balls = new CopyOnWriteArrayList<>();

	public BrickBreak() {

		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.BLACK);
		this.addKeyListener(listener);
		this.balls.add(new Ball(Color.RED));
		this.paddle = new Paddle(new Point(WIDTH / 3, HEIGHT - 20));
		this.setFocusable(true);
		this.requestFocusInWindow();

		this.setupBricks();

	}

	public KeyListener listener = new KeyListener() {
		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				paddle.moveLeft();
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				paddle.moveRight();
			}
			if (e.getKeyCode() == KeyEvent.VK_Q && sleep > 0) {
				sleep -= 5;
			}
			if (e.getKeyCode() == KeyEvent.VK_W && sleep < 100) {
				sleep += 5;
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

			Thread.sleep(sleep);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

		this.repaint();

	}

	public void drawRedraw(Graphics2D g) {

		for (Ball ball : this.balls) {
			ball.drawBall(g);
		}
		this.paddle.drawPaddle(g);

		for (BrickPiece piece : this.bricks) {
			piece.drawBrick(g);
		}

		this.interact();

		for (Ball ball : this.balls) {

			ball.moveBall();

		}


	}

	public void remove(BrickPiece piece) {

		if (this.bricks.contains(piece)) {
			Random r = new Random();
			this.bricks.remove(piece);
			if (r.nextInt(10) == 3)
				this.balls.add(new Ball(new Point(r.nextInt(WIDTH), r.nextInt(HEIGHT / 2) + HEIGHT / 2 - 10), Color.RED));

		}

	}

	public void interact() {

		for (Ball ball : this.balls) {

			if (!this.bricks.isEmpty()) {
				for (BrickPiece piece : this.bricks) {

					if (piece.pointCollide(ball.getCenter(), ball.getDiameter()) == 1) {
						ball.getCenter().translate(-2, 0);
						ball.reverseX();
						this.remove(piece);
					} else if (piece.pointCollide(ball.getCenter(), ball.getRadius()) == 2) {
						ball.getCenter().translate(2, 0);
						ball.reverseX();
						this.remove(piece);
					} else if (piece.pointCollide(ball.getCenter(), ball.getDiameter()) == 3) {
						ball.getCenter().translate(0, -2);
						ball.reverseY();
						this.remove(piece);
					} else if (piece.pointCollide(ball.getCenter(), ball.getRadius()) == 4) {
						ball.getCenter().translate(0, 3);
						ball.reverseY();
						this.remove(piece);
					}

				}
			}

			if (this.paddle.pointCollide(ball.getCenter(), ball.getDiameter()) == 1) {
				ball.getCenter().translate(-2, 0);
				ball.reverseX();
			} else if (this.paddle.pointCollide(ball.getCenter(), ball.getDiameter()) == 2) {
				ball.getCenter().translate(2, 0);
				ball.reverseX();
			} else if (this.paddle.pointCollide(ball.getCenter(), ball.getDiameter()) == 3) {
				ball.getCenter().translate(0, -2);
				ball.reverseY();
			} else if (this.paddle.pointCollide(ball.getCenter(), ball.getDiameter()) == 4) {
				ball.getCenter().translate(0, 2);
				ball.reverseY();
			}

			if (ball.getCenter().getX() - ball.getRadius() < 0 || ball.getCenter().getX() + ball.getDiameter() >= WIDTH) {
				ball.reverseX();
			}

			if (ball.getCenter().getY() - ball.getRadius() < 0 || ball.getCenter().getY() + ball.getDiameter() >= HEIGHT) {
				ball.reverseY();
			}
		}

	}

	public void setupBricks() {


		for (int i = 50; i < 530; i += 14) {

			for (int j = 50; j < 260; j += 11) {

				this.bricks.add(new BrickPiece(new Point(i, j)));

			}

		}

	}

}
