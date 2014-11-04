package me.drewhoener.compsci.advanced.snake;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SnakeGame extends JPanel {

	public static final int WIDTH = 700;
	public static final int HEIGHT = 700;

	private CirclePoint randomPoint;
	private Thread gameThread;
	private boolean running = true;
	private Snake snake1;
	private Snake snake2;


	public SnakeGame() {
		this.gameThread = new Thread();
		this.setPreferredSize(new Dimension(WIDTH - 5, HEIGHT - 5));
		this.setBackground(Color.BLACK);

		try {
			BufferedImage image = ImageIO.read(this.getClass().getResourceAsStream("/resources/appleTrans.png"));
			snake1 = new Snake(new Point(14, 14), image, Color.ORANGE);
			snake2 = new Snake(new Point(70, 70), image, Color.CYAN);

		} catch (IOException e) {

			snake1 = new Snake(new Point(14, 14));
			snake2 = new Snake(new Point(70, 70), Color.BLUE, Color.CYAN);

		}

		randomPoint = new CirclePoint(Point.randomPoint(1, 49, 1, 49), Color.GREEN);
		this.gameThread.start();

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

			if (e.getKeyCode() != snake2.getCurDirection().getP2key() && e.getKeyCode() != snake2.getCurDirection().getP2Opposite()) {

				if (e.getKeyCode() == KeyEvent.VK_W) {

					snake2.setCurDirection(Direction.UP);

				} else if (e.getKeyCode() == KeyEvent.VK_S) {

					snake2.setCurDirection(Direction.DOWN);

				} else if (e.getKeyCode() == KeyEvent.VK_A) {

					snake2.setCurDirection(Direction.LEFT);

				} else if (e.getKeyCode() == KeyEvent.VK_D) {

					snake2.setCurDirection(Direction.RIGHT);

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

		if (running) {

			this.randomPoint.drawPoint(graphics);


			if (this.snake1.isWithinLimits() && this.snake1.canPlay()) {

				this.snake1.updateMovement();
				this.snake1.drawPoints(graphics);

				if (this.snake1.interact(randomPoint)) {
					randomPoint.setCenter(Point.randomPoint(1, 49, 1, 49));
				}

				this.snake1.crashWithOther(this.snake2.getPointList());

			} else {
				this.snake1.setCanPlay(false);
				this.snake1.setColorAll(graphics, Color.RED);
				//Write Game Over Screen
			}

			if (this.snake2.isWithinLimits() && this.snake2.canPlay()) {

				this.snake2.updateMovement();
				this.snake2.drawPoints(graphics);

				if (this.snake2.interact(randomPoint)) {
					randomPoint.setCenter(Point.randomPoint(1, 49, 1, 49));
				}

				this.snake2.crashWithOther(this.snake1.getPointList());

			} else {
				this.snake2.setCanPlay(false);
				this.snake2.setColorAll(graphics, Color.BLUE);
				//Write Game Over Screen
			}

			if (!this.snake1.canPlay() && !this.snake2.canPlay()) {
				this.running = false;
			}

		} else {

			//graphics.

		}

	}


}
