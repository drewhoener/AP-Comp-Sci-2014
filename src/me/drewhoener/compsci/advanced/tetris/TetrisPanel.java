package me.drewhoener.compsci.advanced.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TetrisPanel extends JPanel implements KeyListener, Runnable {

	Thread updateThread;
	private boolean isRunning = false;
	private BufferedImage image;

	public static final int RENDERING_HEIGHT = 779;
	public static final int ACTUAL_HEIGHT = 780;
	public static final int PLAY_WIDTH = 960;
	public static final int ACTUAL_WIDTH = 961;
	public static final int SIDEBAR_WIDTH = (int) (.18 * PLAY_WIDTH);
	public static final int PIXEL_SIZE = PLAY_WIDTH / 16;

	public static final int SLEEP_TIME = 10;
	public static final int ROW_SCAN = 30;
	public List<Rectangle> scanRects = new ArrayList<>();

	private BasicStroke dividerStroke = new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);

	public List<JoinedPiece> settledPieces = new ArrayList<>();
	public JoinedPiece activePiece;

	public TetrisPanel() {
		super(true);
		this.setPreferredSize(new Dimension(ACTUAL_WIDTH, ACTUAL_HEIGHT));

		JoinedPiece piece = new JoinedPiece(TetrisPiece.LONG_U);
		piece.setPosition(2 * PIXEL_SIZE, 2 * PIXEL_SIZE - 1);
		this.activePiece = piece;
		for (int i = 30; i < PLAY_WIDTH; i += 60) {
			Rectangle temp = new Rectangle(i - 1, RENDERING_HEIGHT - ROW_SCAN - 1, 2, 2);
			this.scanRects.add(temp);
		}

	}

	public void addNotify() {
		super.addNotify();
		if (this.updateThread == null) {
			this.isRunning = true;
			this.updateThread = new Thread(this);
			this.addKeyListener(this);
			this.updateThread.start();
			this.requestFocusInWindow();
		}
	}

	@Override
	public void run() {

		long timer = JoinedPiece.PIECE_DELAY;

		this.image = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage(ACTUAL_WIDTH, ACTUAL_HEIGHT);
		Graphics2D imageGraphics = ((Graphics2D) this.image.getGraphics());

		while (this.isRunning) {

			if (timer <= 0) {
				this.updatePieces();
				timer = JoinedPiece.PIECE_DELAY;
			}

			imageGraphics.setColor(Color.BLACK);
			imageGraphics.fillRect(0, 0, ACTUAL_WIDTH, ACTUAL_HEIGHT);
			this.drawToImage(imageGraphics);
			this.drawImage();
			imageGraphics.dispose();
			imageGraphics = ((Graphics2D) this.image.getGraphics());

			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			timer -= SLEEP_TIME;
		}
	}

	public void drawToImage(Graphics2D g) {

		this.activePiece.drawObject(g);

		for (JoinedPiece piece : this.settledPieces) {
			piece.drawObject(g);
		}

		for (Rectangle rect : this.scanRects) {
			g.setColor(Color.GREEN);
			g.fill(rect);
		}
		//g.drawLine(PLAY_WIDTH - SIDEBAR_WIDTH, 0, PLAY_WIDTH - SIDEBAR_WIDTH, ACTUAL_HEIGHT);

		g.dispose();

	}

	public void updatePieces() {

		for (JoinedPiece piece : this.settledPieces) {

			for (Rectangle rect1 : piece.getPieces()) {
				for (Rectangle rect2 : this.activePiece.getIncrementedPieces(Direction.DOWN)) {

					if (rect2.intersects(rect1)) {
						this.settledPieces.add(this.activePiece);
						this.spawnNewPiece();
						return;
					}

				}
			}

		}

		if (this.activePiece.getIncrementedY() > ACTUAL_HEIGHT) {
			this.settledPieces.add(this.activePiece);
			this.spawnNewPiece();
			return;
		}

		this.activePiece.translate(0, PIXEL_SIZE);

	}

	public void updateSettledAbove(int yVal) {

		//noinspection Convert2streamapi
		for (JoinedPiece piece : this.settledPieces) {
			//System.out.println(piece.getMaxY());
			if (piece.getMaxY() <= yVal && piece.getIncrementedY() <= ACTUAL_HEIGHT) {
				piece.translate(0, PIXEL_SIZE);
			}
		}
	}

	public void calculateRows() {

		List<Rectangle> toRemove = new ArrayList<>();

		for (Rectangle scanner : this.scanRects) {

			for (JoinedPiece piece : Collections.unmodifiableCollection(this.settledPieces)) {

				for (Rectangle rect : piece.getPieces()) {
					if (rect.contains(scanner)) {
						toRemove.add(rect);
					}
				}

			}

		}

		if (toRemove.size() == this.scanRects.size()) {

			//noinspection Convert2streamapi
			for (JoinedPiece piece : new ArrayList<>(this.settledPieces)) {
				if (piece.removeParts(toRemove)) {
					this.settledPieces.remove(piece);
				}
			}
			//System.out.println((int) (this.scanRects.get(0).getMinY() - ROW_SCAN));
			this.updateSettledAbove((int) (this.scanRects.get(0).getMinY() - (ROW_SCAN - 1)));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.calculateRows();

		}

	}

	public void spawnNewPiece() {

		for (int i = RENDERING_HEIGHT; i > 0; i -= PIXEL_SIZE) {

			this.calculateRows();
			for (Rectangle rectangle : this.scanRects) {
				rectangle.translate(0, -PIXEL_SIZE);
			}

		}

		this.scanRects.clear();

		for (int i = 30; i < PLAY_WIDTH; i += 60) {
			Rectangle temp = new Rectangle(i - 1, RENDERING_HEIGHT - ROW_SCAN - 1, 2, 2);
			this.scanRects.add(temp);
		}

		Random rand = new Random();
		this.activePiece = new JoinedPiece(TetrisPiece.values()[rand.nextInt(TetrisPiece.values().length)]);
		//this.activePiece = new JoinedPiece(TetrisPiece.LONG_PIECE);
		int x = rand.nextInt(PLAY_WIDTH / PIXEL_SIZE + 1);
		this.activePiece.setPosition(PIXEL_SIZE * x, -(this.activePiece.getPixelHeight() * PIXEL_SIZE + 1));
		while (this.activePiece.getMaxX() > PLAY_WIDTH) {
			this.activePiece.translate(-TetrisPanel.PIXEL_SIZE, 0);
		}

	}

	public boolean doesIntersectActive() {
		for (JoinedPiece piece : this.settledPieces) {
			for (Rectangle rect1 : piece.getPieces()) {
				for (Rectangle rect2 : this.activePiece.getPieces()) {
					if (rect1.intersects(rect2)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean doesIntersectActiveNext(Direction direction) {
		for (JoinedPiece piece : this.settledPieces) {
			for (Rectangle rect1 : piece.getPieces()) {
				for (Rectangle rect2 : this.activePiece.getIncrementedPieces(direction)) {
					if (rect1.intersects(rect2)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void drawImage() {
		Graphics paneGraphics = this.getGraphics();
		paneGraphics.drawImage(this.image, 0, 0, ACTUAL_WIDTH, ACTUAL_HEIGHT, null);
		paneGraphics.dispose();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_SHIFT:
			case KeyEvent.VK_ENTER:
			case KeyEvent.VK_R:
				this.activePiece.rotateShape();
				//Make sure that we aren't going over the sides
				while (this.activePiece.getMaxX() > PLAY_WIDTH) {
					this.activePiece.translate(-TetrisPanel.PIXEL_SIZE, 0);
				}
				while (this.activePiece.getMinX() < 0) {
					this.activePiece.translate(TetrisPanel.PIXEL_SIZE, 0);
				}
				while (this.activePiece.getMinY() < 0) {
					this.activePiece.translate(0, PIXEL_SIZE);
				}
				break;
			case KeyEvent.VK_RIGHT:
				//Simple check to make sure we can't override the boundary
				if (this.activePiece.getMaxX() <= PLAY_WIDTH - PIXEL_SIZE && !this.doesIntersectActive() && !this.doesIntersectActiveNext(Direction.RIGHT))
					this.activePiece.translate(TetrisPanel.PIXEL_SIZE, 0);
				break;
			case KeyEvent.VK_LEFT:
				//Another Simple Check
				if (this.activePiece.getMinX() >= PIXEL_SIZE && !this.doesIntersectActive() && !this.doesIntersectActiveNext(Direction.LEFT))
					this.activePiece.translate(-TetrisPanel.PIXEL_SIZE, 0);
				break;
			case KeyEvent.VK_DOWN:
				if (this.activePiece.getIncrementedY() < RENDERING_HEIGHT && !this.doesIntersectActiveNext(Direction.DOWN))
					this.activePiece.translate(0, PIXEL_SIZE);
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	public enum Direction {

		LEFT,
		RIGHT,
		DOWN

	}

}
