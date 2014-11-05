package me.drewhoener.compsci.advanced;

import javax.swing.*;
import java.awt.*;

public class SimpleSwingFrame {


	public static void main(String[] args) {

		JFrame mainFrame = new JFrame();
		JPanel firstPanel = new JPanel();
		JPanel secondPanel = new JPanel();
		JPanel thirdPanel = new JPanel();

		firstPanel.setBackground(Color.BLUE);
		secondPanel.setBackground(Color.RED);
		thirdPanel.setBackground(Color.CYAN);

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setPreferredSize(new Dimension(200, 200));

		mainFrame.add(firstPanel, BorderLayout.EAST);
		mainFrame.add(secondPanel, BorderLayout.CENTER);
		mainFrame.add(thirdPanel, BorderLayout.WEST);
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setFocusable(true);


	}


}
