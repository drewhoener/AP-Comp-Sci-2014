package me.drewhoener.compsci.advanced.maxmemorial;

import me.drewhoener.compsci.advanced.mathstone.GBConstraints;

import javax.swing.*;
import java.awt.*;

public class MemorialPanel extends JPanel {
	ContentPanel contentPanel;
	JButton mapButton, statsButton, startButton, combatantsButton;

	public MemorialPanel() {
		//this.setBackground(Color.BLACK);
		//Just for the purposes of this monitor, you'll have to adjust it to yours
		//you should be able to leave it at default
		this.setPreferredSize(new Dimension(500, 500));

		this.setLayout(new GridBagLayout());

		this.initUI();
	}


	//To change the height of the scrollpane/other components in this frame, edit the second param of the ipad
	public void initUI() {
		this.contentPanel = new ContentPanel();
		//this.contentPanel.setBorder(BorderFactory.createEtchedBorder(Color.GREEN, Color.GREEN));
		this.add(this.contentPanel, new GBConstraints(0, 0).gridSize(1, 4).fill(GridBagConstraints.HORIZONTAL).weight(.8, .9).anchor(GridBagConstraints.FIRST_LINE_START).create());
		//this.contentPanel.setBounds(160, 30, 620, 420);

		this.mapButton = new JButton("Map");
		this.add(mapButton, new GBConstraints(1, 0).fill(GridBagConstraints.HORIZONTAL).ipad(0, 100).weight(.2, 0).anchor(GridBagConstraints.PAGE_START).create());
		//this.mapButton.setBounds(20, 30, 120, 90);
		mapButton.addActionListener(e -> {
			contentPanel.changeContent("Map");
		});

		this.statsButton = new JButton("Statistics");
		this.add(statsButton, new GBConstraints(1, 1).fill(GridBagConstraints.HORIZONTAL).ipad(0, 100).weight(.2, 0).create());
		//this.statsButton.setBounds(20, 140, 120, 90);
		statsButton.addActionListener(e -> {
			contentPanel.changeContent("Statistics");
		});

		this.startButton = new JButton("Beginnings");
		this.add(startButton, new GBConstraints(1, 2).fill(GridBagConstraints.HORIZONTAL).ipad(0, 100).weight(.2, 0).create());
		startButton.addActionListener(e -> contentPanel.changeContent("Beginnings"));
		//this.startButton.setBounds(20, 250, 120, 90);

		this.combatantsButton = new JButton("Combatants");
		this.add(combatantsButton, new GBConstraints(1, 3).fill(GridBagConstraints.HORIZONTAL).ipad(0, 100).weight(.2, .1).create());
		startButton.addActionListener(e -> contentPanel.changeContent("Combatants"));
		//this.combatantsButton.setBounds(20, 360, 120, 90);
	}
}