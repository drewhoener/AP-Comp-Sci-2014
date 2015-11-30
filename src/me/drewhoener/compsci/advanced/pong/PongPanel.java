package me.drewhoener.compsci.advanced.pong;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;

public class PongPanel extends JPanel {

	public static int WIDTH = 1200;
	public static int HEIGHT = 600;

	public int leftPlayerScore = 0;
	public int rightPlayerScore = 0;

	Clip soundClip = null;

	//init ball
	public Ball pongBall;
	//init paddles
	public Paddle leftPaddle;
	public Paddle rightPaddle;

	public URL blipUrl;

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

	public void playSound() {

		blipUrl = this.getClass().getResource("/resources/blip.wav");
		System.out.println("File: " + blipUrl.getFile());

		try {

			AudioInputStream ais = AudioSystem.getAudioInputStream(blipUrl);
			soundClip = AudioSystem.getClip();
			soundClip.open(ais);

			soundClip.start();

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void stopSound() {

		if (!soundClip.isRunning())
			soundClip.close();

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
			Thread.sleep(3);
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


		if (this.leftPaddle.pointCollide(pongBall.getCenter(), pongBall.getDiameter()) == 1) {
			pongBall.getCenter().translate(-2, 0);
			pongBall.reverseX();
		} else if (this.leftPaddle.pointCollide(pongBall.getCenter(), pongBall.getRadius() / 2) == 2) {
			pongBall.getCenter().translate(2, 0);
			pongBall.reverseX();
		} else if (this.leftPaddle.pointCollide(pongBall.getCenter(), pongBall.getDiameter()) == 3) {
			pongBall.getCenter().translate(0, -2);
			pongBall.reverseY();
		} else if (this.leftPaddle.pointCollide(pongBall.getCenter(), pongBall.getDiameter()) == 4) {
			pongBall.getCenter().translate(0, 2);
			pongBall.reverseY();
		}

		if (this.rightPaddle.pointCollide(pongBall.getCenter(), pongBall.getDiameter()) == 1) {
			pongBall.getCenter().translate(-2, 0);
			pongBall.reverseX();
		} else if (this.rightPaddle.pointCollide(pongBall.getCenter(), pongBall.getDiameter()) == 2) {
			pongBall.getCenter().translate(2, 0);
			pongBall.reverseX();
		} else if (this.rightPaddle.pointCollide(pongBall.getCenter(), pongBall.getDiameter()) == 3) {
			pongBall.getCenter().translate(0, -2);
			pongBall.reverseY();
		} else if (this.rightPaddle.pointCollide(pongBall.getCenter(), pongBall.getDiameter()) == 4) {
			pongBall.getCenter().translate(0, 2);
			pongBall.reverseY();
		}

		if (pongBall.getCenter().getY() - pongBall.getRadius() <= 0 || pongBall.getCenter().getY() + pongBall.getDiameter() >= HEIGHT) {
			pongBall.reverseY();
		}


		if (this.pongBall.getCenter().getX() < 37) {

			this.pongBall.setCenter(new Point(WIDTH / 2, HEIGHT / 2));
			this.rightPlayerScore++;

			try {
				Thread.sleep(180);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


		}

		if (this.pongBall.getCenter().getX() > (WIDTH - 37)) {

				this.pongBall.setCenter(new Point(WIDTH / 2, HEIGHT / 2));
				this.leftPlayerScore++;

			try {
				Thread.sleep(180);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


		}


		if (this.pongBall.getCenter().getY() > (HEIGHT - this.pongBall.getDiameter())) {
			this.pongBall.reverseY();
		}

		if (this.pongBall.getCenter().getY() < this.pongBall.getRadius()) {
			this.pongBall.reverseY();
		}


	}


}
