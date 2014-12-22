package me.drewhoener.compsci.advanced;

import javax.swing.*;
import java.awt.*;

public class TrippyPanel extends JPanel {

	int color = 1;

	public void paintComponent(Graphics g) {

		switch (color) {

			case 1:
				this.setBackground(Color.RED);
				break;
			case 2:
				this.setBackground(Color.BLUE);
				break;
			case 3:
				this.setBackground(Color.BLACK);
				break;
			case 4:
				this.setBackground(Color.GREEN);
				break;
			case 5:
				this.setBackground(Color.YELLOW);
				break;
			case 6:
				this.setBackground(Color.WHITE);
				break;
			case 7:
				this.setBackground(Color.ORANGE);
				break;
			case 8:
				this.setBackground(Color.CYAN);
				break;
			case 9:
				this.setBackground(Color.DARK_GRAY);
				break;
			case 10:
				this.setBackground(Color.PINK);
				break;
			case 11:
				this.setBackground(Color.GREEN);
				break;
			case 12:
				color = 1;
				break;

		}

		color++;


		this.repaint();
	}

}
