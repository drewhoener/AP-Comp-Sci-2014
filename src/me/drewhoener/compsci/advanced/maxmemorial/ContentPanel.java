package me.drewhoener.compsci.advanced.maxmemorial;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ContentPanel extends JPanel {
	private static final String STATISTICS = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus in imperdiet massa. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nunc mollis mi venenatis, tempus nunc eu, luctus tortor. Nunc ornare, felis ut faucibus malesuada, eros ligula facilisis dolor, finibus pretium dui ipsum in eros. Pellentesque eu dolor vitae ex aliquet fringilla quis venenatis ipsum. Integer nunc nunc, hendrerit ac est id, finibus consequat massa. Donec venenatis porttitor dolor eu congue. Nam vel sapien efficitur, dictum diam eget, rutrum mauris. Cras semper laoreet tellus. Curabitur quis condimentum arcu. Nunc nec nisl ut purus pellentesque congue sit amet a metus. Integer quis tempus nisl. Aliquam sit amet efficitur dolor. Curabitur sed egestas lectus. Pellentesque ut faucibus tortor, et pulvinar risus. Nulla dignissim pulvinar eros, nec congue ex convallis id.";
	private static final String BEGINNINGS = "Beginnings here";
	private static final String COMBATANTS = "Combatants here";

	private BufferedImage map;

	private JTextPane textPane = new JTextPane();
	private JScrollPane scrollPane;
	private final Document paneDocument;
	private final StyledDocument paneStyle;

	//To change the height of the scrollpane/other components in this frame, edit the second param of the ipad
	private GridBagConstraints genericConstraints = new GBConstraints(0, 0).ipad(0, 600).weight(1, 1).fill(GridBagConstraints.HORIZONTAL).anchor(GridBagConstraints.CENTER).create();

	public ContentPanel() {

		this.setLayout(new GridBagLayout());

		try {
			this.map = ImageIO.read(new File("res/Syrian_civil_war.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.paneDocument = this.textPane.getDocument();
		this.paneStyle = this.textPane.getStyledDocument();


		this.textPane.setEditable(false);
		this.textPane.setBackground(Color.WHITE);
		this.textPane.setForeground(Color.BLACK);
		this.textPane.setFont(new Font("Gill Sans", Font.PLAIN, 24));
		this.textPane.setAutoscrolls(true);


		this.scrollPane = new JScrollPane(this.textPane);
		this.scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		this.scrollPane.getViewport().setBackground(Color.WHITE);
		this.scrollPane.setAutoscrolls(true);
		this.scrollPane.setForeground(Color.BLACK);
		this.scrollPane.setBorder(null);
		//this.scrollPane.setPreferredSize(new Dimension(1150, 550));

		this.changeContent("Statistics");
	}

	public void changeContent(String c) {
		this.removeAll();
		if (c.equals("Map"))
			this.add(new JLabel(new ImageIcon(map)));
		else if (c.equals("Statistics")) {
			this.add(scrollPane, genericConstraints);
			this.setString(STATISTICS);
		}
		this.revalidate();
		this.repaint();
	}

	public void appendString(String string) {

		try {

			this.paneStyle.insertString(this.paneStyle.getLength(), string + "\n", null);
			SimpleAttributeSet centerAlign = new SimpleAttributeSet();
			StyleConstants.setAlignment(centerAlign, StyleConstants.ALIGN_CENTER);
			this.paneStyle.setParagraphAttributes(0, this.paneStyle.getLength(), centerAlign, false);

		} catch (BadLocationException e) {
			e.printStackTrace();
		}

	}

	public void setString(String string) {

		this.textPane.setText("");
		this.appendString(string);

	}

}