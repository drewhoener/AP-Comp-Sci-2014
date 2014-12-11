package me.drewhoener.compsci.advanced.hourofcode;

import javax.swing.*;
import java.awt.*;

public class BallPanel extends JPanel {

	public CirclePoint ball = new CirclePoint(new Point(21, 21), Color.RED, Direction.randomDir(), Direction.randomDir());

	public BallPanel() {

		this.setPreferredSize(new Dimension(400, 400));

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		this.drawRedraw((Graphics2D) g);
	}

	public void drawRedraw(Graphics2D g) {

		ball.drawPoint(g);

		if (ball.closeEnough(400, 400) == 3) {

			ball.moveWithDir();

		} else {

			switch (ball.closeEnough(400, 400)) {

				case 1:
					ball.setPrimaryDir(Direction.actualOpposite(ball.getPrimaryDir()));
					break;
				case 2:
					ball.setSecondaryDir(Direction.actualOpposite(ball.getSecondaryDir()));
					break;


			}

		}

	}

}
