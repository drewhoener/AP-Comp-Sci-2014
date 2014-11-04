package me.drewhoener.compsci.advanced.snake;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeGame extends JPanel {

	public static final int WIDTH = 700;
	public static final int HEIGHT = 700;

	private Snake snake1 = new Snake(new Point(14, 14));
	private CirclePoint randomPoint;
	private Thread gameThread;

	public SnakeGame() {
		this.gameThread = new Thread();
		this.setPreferredSize(new Dimension(WIDTH - 5, HEIGHT - 5));
		this.setBackground(Color.BLACK);
		randomPoint = new CirclePoint(Point.randomPoint(1, 49, 1, 49), Color.GREEN);
		this.gameThread.start();

	}

	public boolean isWithinLimits(Point p) {

		//System.out.println("" + this.snake1.getTrueEdge().getX() + " : " + (WIDTH - 20));

		return (this.snake1.getTrueEdge().getX() <= WIDTH - 14) && (this.snake1.getTrueEdge().getX() >= 14) && (this.snake1.getTrueEdge().getY() <= HEIGHT - 14) && (this.snake1.getTrueEdge().getY() >= 14);

	}

	public KeyListener mainListener = new KeyListener() {
		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {

			System.out.println("KEY: " + e.getKeyCode());

			if (e.getKeyCode() != snake1.getCurDirection().getKey() && e.getKeyCode() != snake1.getCurDirection().getOpposite()) {

				if (e.getKeyCode() == KeyEvent.VK_UP) {

					snake1.setCurDirection(Direction.UP);

				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

					snake1.setCurDirection(Direction.DOWN);

				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

					snake1.setCurDirection(Direction.LEFT);

				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

					snake1.setCurDirection(Direction.RIGHT);

				}

			}

		}

		@Override
		public void keyReleased(KeyEvent e) {

		}
	};

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		this.drawRedraw((Graphics2D) g);


	}

	public void drawRedraw(Graphics2D graphics) {


		this.randomPoint.drawPoint(graphics);


		if (isWithinLimits(this.snake1.getTrueEdge()) && this.snake1.canPlay()) {
			if (this.snake1.interact(randomPoint)) {
				randomPoint.setCenter(Point.randomPoint(1, 49, 1, 49));
			}
			this.snake1.updateMovement();
			this.snake1.drawPoints(graphics);
		} else {
			this.snake1.setCanPlay(false);
			this.snake1.setColorAll(graphics, Color.RED);
			//Write Game Over Screen
		}

	}


}
