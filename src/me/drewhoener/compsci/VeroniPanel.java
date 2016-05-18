package me.drewhoener.compsci;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VeroniPanel extends JPanel implements MouseListener {


	JButton button = new JButton("Testing");

	public VeroniPanel() {
		super();
		this.setBackground(Color.YELLOW);
		this.setPreferredSize(new Dimension(300, 300));
		init();
	}

	public void init() {

		this.addMouseListener(this);

		//"this" being a panel class currently
		this.add(button);
		button.addActionListener(e -> {

			//this button displays an image
			//I'd keep the thing that will change in a separate panel from the buttons
			// and then panel.removeAll() or something like that
			//add the new content
			//frame.revalidate();
			//use this action listener method for every button to do a different thing

		});


	}


	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Clicked");
		this.getGraphics().setColor(Color.BLACK);
		this.getGraphics().fillRect(e.getX(), e.getY(), 1, 1);
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
