package me.drewhoener.compsci.advanced.hourofcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class BallPanel extends JPanel {

	public CirclePoint ball = new CirclePoint(new Point(42, 21), Color.RED, Direction.RIGHT, Direction.DOWN);
	private Thread gameThread;

	public BallPanel() {

		this.gameThread = new Thread();
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(1000, 700));
		this.gameThread.start();
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		this.drawRedraw((Graphics2D) g);
	}

	public void drawRedraw(Graphics2D g) {

		int random = new Random().nextInt(300);

		ball.drawPoint(g);

		if (ball.closeEnough(1000, 700) == 5) {

			ball.moveWithDir();

		} else {

			System.out.println(ball.closeEnough(1000, 700));

			switch (ball.closeEnough(1000, 700)) {

				case 1:
					//System.out.println("Switching X Direction: Current = " + ball.getPrimaryDir());
					if (this.ball.getPrimaryDir() == Direction.LEFT) {
						this.ball.setPrimaryDir(Direction.actualOpposite(this.ball.getPrimaryDir()));
						this.ball.translatePoint(this.ball.getPrimaryDir().getMovement());
					} else {
						this.ball.setSecondaryDir(Direction.actualOpposite(this.ball.getSecondaryDir()));
						this.ball.translatePoint(this.ball.getSecondaryDir().getMovement());
					}
					break;
				case 2:
					//System.out.println("Switching X Direction: Current = " + ball.getPrimaryDir());
					if (this.ball.getPrimaryDir() == Direction.UP) {
						this.ball.setPrimaryDir(Direction.actualOpposite(this.ball.getPrimaryDir()));
						this.ball.translatePoint(this.ball.getPrimaryDir().getMovement());
					} else {
						this.ball.setSecondaryDir(Direction.actualOpposite(this.ball.getSecondaryDir()));
						this.ball.translatePoint(this.ball.getSecondaryDir().getMovement());
					}
					break;
				case 3:
					//System.out.println("Switching X Direction: Current = " + ball.getPrimaryDir());
					if (this.ball.getPrimaryDir() == Direction.RIGHT) {
						this.ball.setPrimaryDir(Direction.actualOpposite(this.ball.getPrimaryDir()));
						this.ball.translatePoint(this.ball.getPrimaryDir().getMovement());
					} else {
						this.ball.setSecondaryDir(Direction.actualOpposite(this.ball.getSecondaryDir()));
						this.ball.translatePoint(this.ball.getSecondaryDir().getMovement());
					}
					break;
				case 4:
					//System.out.println("Switching X Direction: Current = " + ball.getPrimaryDir());
					if (this.ball.getPrimaryDir() == Direction.DOWN) {
						this.ball.setPrimaryDir(Direction.actualOpposite(this.ball.getPrimaryDir()));
						this.ball.translatePoint(this.ball.getPrimaryDir().getMovement());
					} else {
						this.ball.setSecondaryDir(Direction.actualOpposite(this.ball.getSecondaryDir()));
						this.ball.translatePoint(this.ball.getSecondaryDir().getMovement());
					}
					break;


			}

		}

		if (random == 17) {
			//ball.randomChange();
		}

	}

}
