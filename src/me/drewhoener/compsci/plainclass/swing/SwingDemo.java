package me.drewhoener.compsci.plainclass.swing;

import javax.swing.*;
import java.awt.*;

public class SwingDemo {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {

			JFrame mainFrame = new JFrame("A Simple JFrame");

			JPanel mainPanel = new JPanel();

			mainPanel.setBackground(Color.CYAN);
			mainPanel.setPreferredSize(new Dimension(400, 300));

			JLabel label = new JLabel("Hello World");
			label.setLocation(10, 10);

			mainPanel.add(label);

			mainFrame.add(mainPanel);
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			mainFrame.pack();

			mainFrame.setVisible(true);

		});

	}

}
