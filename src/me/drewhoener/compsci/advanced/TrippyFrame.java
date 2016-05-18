package me.drewhoener.compsci.advanced;

import javax.swing.*;
import java.awt.*;

public class TrippyFrame {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {

			JFrame frame = new JFrame("What the hell.");
			TrippyPanel t = new TrippyPanel();

			t.setPreferredSize(new Dimension(500, 500));
			frame.add(t);

			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

			frame.pack();
			frame.setVisible(true);


		});

	}

}
