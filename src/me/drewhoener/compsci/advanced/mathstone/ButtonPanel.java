package me.drewhoener.compsci.advanced.mathstone;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class ButtonPanel extends JPanel {

	private static Font areaFont = new Font("Ariel", Font.TRUETYPE_FONT, 20);
	private static Font dontUseFont = new Font("Comic Sans MS", Font.TRUETYPE_FONT, 20);

	public static final Random rand = new Random();
	private ButtonGroup methodGroup = new ButtonGroup();

	private JTextField inputArea = new JTextField(10);
	private JTextField secondNumberArea = new JTextField(10);

	private JButton progressionButton = new JButton("Progress Simulation");
	private JButton resetButton = new JButton("Reset Simulation");

	private JRadioButton babylonianMethod = new JRadioButton("Babylonian Method");
	private JRadioButton digitMethod = new JRadioButton("Digit by Digit Method");
	private JRadioButton bakhshaliMethod = new JRadioButton("Bakhshali Method");

	private JButton startButton = new JButton("Start Simulation");

	private JLabel originalNumber = new JLabel("");
	private JLabel currentProgression = new JLabel("");
	private JLabel usedEquation = new JLabel("");
	private JLabel explanation = new JLabel("");

	JLabel inputLabel = new JLabel("Input Number: ");
	JLabel secondaryLabel = new JLabel("Secondary Number: ");

	public static final int WIDTH = 250;
	public static final int HEIGHT = 100;

	private GridBagLayout layout = new GridBagLayout();

	private GraphMain main;

	public ButtonPanel(GraphMain main) {
		super();
		this.setLayout(layout);
		this.main = main;
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		init();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//this.setBackground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
	}

	public void init() {

		this.originalNumber.setFont(dontUseFont);
		this.currentProgression.setFont(dontUseFont);
		this.usedEquation.setFont(dontUseFont);
		this.explanation.setFont(dontUseFont);

		this.startButton.addActionListener(e -> {
			if (this.inputArea.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this.main.getFrame(), "Enter a number and choose a method with the buttons below!", "Error: Invalid", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (!GraphMain.isInteger(this.inputArea.getText())) {
				JOptionPane.showMessageDialog(this.main.getFrame(), "HA! YOU THOUGHT!\nThat number is NOT a number", "Error: Invalid", JOptionPane.WARNING_MESSAGE);
				this.inputArea.setText("");
				this.secondNumberArea.setText("");
				return;
			}
			this.startButton.setEnabled(false);

			this.startSimulation();

			this.originalNumber.setText("Getting Root For: " + this.inputArea.getText());
			this.inputArea.setText("");
			this.secondNumberArea.setText("");

		});

		this.secondNumberArea.setFont(areaFont);
		this.secondNumberArea.setAutoscrolls(true);
		this.secondNumberArea.setBorder(new EtchedBorder(Color.BLACK, Color.GRAY));
		this.secondNumberArea.addActionListener(e -> {
			this.startButton.doClick();
		});

		this.inputArea.setFont(areaFont);
		this.inputArea.setAutoscrolls(true);
		this.inputArea.setBorder(new EtchedBorder(Color.BLACK, Color.GRAY));
		this.inputArea.addActionListener(e -> {
			this.startButton.doClick();
		});
		this.inputArea.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("Text: " + ButtonPanel.this.inputArea.getText());
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					if (ButtonPanel.this.inputArea.getText().length() == 1) {
						ButtonPanel.this.startButton.setFocusable(false);
						ButtonPanel.this.startButton.setEnabled(false);
					}
				} else {
					if (ButtonPanel.this.inputArea.getText().length() == 0) {
						if (ButtonPanel.this.babylonianMethod.isSelected()) {
							if (ButtonPanel.this.secondNumberArea.getText().length() > 0) {
								ButtonPanel.this.startButton.setEnabled(true);
								ButtonPanel.this.startButton.setFocusable(true);
							}
						} else {
							ButtonPanel.this.startButton.setEnabled(true);
							ButtonPanel.this.startButton.setFocusable(true);
						}
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
		this.secondNumberArea.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("Text: " + ButtonPanel.this.inputArea.getText());
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					if (ButtonPanel.this.babylonianMethod.isSelected()) {
						if (ButtonPanel.this.secondNumberArea.getText().length() == 1) {
							ButtonPanel.this.startButton.setEnabled(false);
							ButtonPanel.this.startButton.setFocusable(false);
						}
					}
				} else {
					if (ButtonPanel.this.secondNumberArea.getText().length() == 0) {
						if (ButtonPanel.this.babylonianMethod.isSelected()) {
							if (ButtonPanel.this.inputArea.getText().length() > 0) {
								ButtonPanel.this.startButton.setEnabled(true);
								ButtonPanel.this.startButton.setFocusable(true);
							}
						}
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

		inputLabel.setFont(new Font("Ariel", Font.TRUETYPE_FONT, 10));
		secondaryLabel.setFont(new Font("Ariel", Font.TRUETYPE_FONT, 10));
		this.add(inputLabel, new GBConstraints(0, 0).weight(0, 0).fill(GridBagConstraints.HORIZONTAL).anchor(GridBagConstraints.PAGE_START).insets(new Insets(8, 5, 0, 5)).create());
		this.add(inputArea, new GBConstraints(0, 1).weight(0, 0).fill(GridBagConstraints.HORIZONTAL).anchor(GridBagConstraints.PAGE_START).insets(new Insets(3, 5, 0, 5)).create());
		this.add(secondaryLabel, new GBConstraints(0, 2).weight(0, 0).fill(GridBagConstraints.HORIZONTAL).insets(new Insets(8, 5, 0, 5)).create());
		this.add(secondNumberArea, new GBConstraints(0, 3).weight(0, 0).fill(GridBagConstraints.HORIZONTAL).anchor(GridBagConstraints.PAGE_START).insets(new Insets(3, 5, 5, 5)).create());


		this.methodGroup.add(this.babylonianMethod);
		this.methodGroup.add(this.digitMethod);
		this.methodGroup.add(this.bakhshaliMethod);

		this.babylonianMethod.addChangeListener(l -> {
			if (this.babylonianMethod.isSelected()) {
				this.secondNumberArea.setVisible(true);
			} else {
				this.secondNumberArea.setVisible(false);
			}
		});

		this.babylonianMethod.setSelected(true);

		this.add(this.babylonianMethod, new GBConstraints(0, 4).weight(.1, 0).fill(GridBagConstraints.HORIZONTAL).create());
		this.add(this.digitMethod, new GBConstraints(0, 5).weight(.1, 0).fill(GridBagConstraints.HORIZONTAL).create());
		this.add(this.bakhshaliMethod, new GBConstraints(0, 6).weight(.1, 0).fill(GridBagConstraints.HORIZONTAL).create());

		this.add(Box.createVerticalGlue(), new GBConstraints(0, 7).weight(.1, .1).fill(GridBagConstraints.HORIZONTAL).create());

		this.add(this.originalNumber, new GBConstraints(0, 8).weight(1, 0).fill(GridBagConstraints.REMAINDER).insets(new Insets(0, 5, 0, 5)).create());

		this.add(Box.createVerticalGlue(), new GBConstraints(0, 9).weight(.1, .4).fill(GridBagConstraints.HORIZONTAL).create());

		this.add(this.startButton, new GBConstraints(0, 10).weight(.1, 0).ipad(0, 40).fill(GridBagConstraints.HORIZONTAL).anchor(GridBagConstraints.PAGE_END).insets(new Insets(0, 4, 0, 4)).create());
		this.add(this.progressionButton, new GBConstraints(0, 11).weight(.1, 0).fill(GridBagConstraints.HORIZONTAL).anchor(GridBagConstraints.PAGE_END).create());

		this.resetButton.addActionListener(e -> {
			this.inputArea.setText("");
			this.secondNumberArea.setText("");
			this.originalNumber.setText("");
			this.startButton.setEnabled(true);
			this.babylonianMethod.setEnabled(true);
			this.digitMethod.setEnabled(true);
			this.bakhshaliMethod.setEnabled(true);
			this.startButton.setEnabled(false);
			this.progressionButton.setEnabled(false);
			this.main.getPanel1().resetMethods();
		});
		this.add(resetButton, new GBConstraints(0, 12).weight(.1, 0).fill(GridBagConstraints.HORIZONTAL).anchor(GridBagConstraints.PAGE_END).create());

		this.startButton.setEnabled(false);
		this.progressionButton.setEnabled(false);
	}

	public void startSimulation() {

		GraphMethods.IncrementableMethod method = null;
		if (this.babylonianMethod.isSelected())
			method = new GraphMethods.BabylonianMethod(Integer.parseInt(this.inputArea.getText()), Integer.parseInt(this.secondNumberArea.getText()));
		else if (this.digitMethod.isSelected()) ;
			//method = GraphPanel.CalculationMethods.DIGIT;
		else if (this.bakhshaliMethod.isSelected()) ;
			//method = GraphPanel.CalculationMethods.BAKHSHALI;
		else
			JOptionPane.showMessageDialog(this.main.getFrame(), "Welp...Bet you didn't see this coming\nIn fact this message should never appear!", "Error: Ya Done Screwed Up", JOptionPane.ERROR_MESSAGE);

		this.babylonianMethod.setEnabled(false);
		this.digitMethod.setEnabled(false);
		this.bakhshaliMethod.setEnabled(false);

		this.progressionButton.setEnabled(true);

		GraphMain.instance.getPanel1().start(method);


	}

}
