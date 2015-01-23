package me.drewhoener.compsci.advanced.bricks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BrickBreak extends JPanel {

	public static int WIDTH = 600;
	public static int HEIGHT = 800;
	private int sleep = 50;

	private Paddle paddle;
	private Ball ball;
	private List<BrickPiece> bricks = new CopyOnWriteArrayList<>();

	public BrickBreak() {

		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.BLACK);
		this.addKeyListener(listener);
		this.ball = new Ball(Color.RED);
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

		this.ball.drawBall(g);
		this.paddle.drawPaddle(g);

		for (BrickPiece piece : this.bricks) {
			piece.drawBrick(g);
		}

		this.interact();

		this.ball.moveBall();


	}

	public void remove(BrickPiece piece) {

		if (this.bricks.contains(piece)) {
			this.bricks.remove(piece);
		}

	}

	public void interact() {

		if (!this.bricks.isEmpty()) {
			for (BrickPiece piece : this.bricks) {

				if (piece.pointCollide(this.ball.getCenter(), this.ball.getDiameter()) == 1) {
					this.ball.getCenter().translate(-2, 0);
					this.ball.reverseX();
					this.remove(piece);
				} else if (piece.pointCollide(this.ball.getCenter(), this.ball.getRadius()) == 2) {
					this.ball.getCenter().translate(2, 0);
					this.ball.reverseX();
					this.remove(piece);
				} else if (piece.pointCollide(this.ball.getCenter(), this.ball.getDiameter()) == 3) {
					this.ball.getCenter().translate(0, -2);
					this.ball.reverseY();
					this.remove(piece);
				} else if (piece.pointCollide(this.ball.getCenter(), this.ball.getRadius()) == 4) {
					this.ball.getCenter().translate(0, 3);
					this.ball.reverseY();
					this.remove(piece);
				}

			}
		}

		if (this.paddle.pointCollide(this.ball.getCenter(), this.ball.getDiameter()) == 1) {
			this.ball.getCenter().translate(-2, 0);
			this.ball.reverseX();
		} else if (this.paddle.pointCollide(this.ball.getCenter(), this.ball.getDiameter()) == 2) {
			this.ball.getCenter().translate(2, 0);
			this.ball.reverseX();
		} else if (this.paddle.pointCollide(this.ball.getCenter(), this.ball.getDiameter()) == 3) {
			this.ball.getCenter().translate(0, -2);
			this.ball.reverseY();
		} else if (this.paddle.pointCollide(this.ball.getCenter(), this.ball.getDiameter()) == 4) {
			this.ball.getCenter().translate(0, 2);
			this.ball.reverseY();
		}

		if (this.ball.getCenter().getX() - this.ball.getRadius() < 0 || this.ball.getCenter().getX() + this.ball.getDiameter() >= WIDTH) {
			this.ball.reverseX();
		}

		if (this.ball.getCenter().getY() - this.ball.getRadius() < 0 || this.ball.getCenter().getY() + this.ball.getDiameter() >= HEIGHT) {
			this.ball.reverseY();
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
