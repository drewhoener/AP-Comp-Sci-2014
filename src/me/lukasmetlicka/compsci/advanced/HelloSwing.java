package me.lukasmetlicka.compsci.advanced;
import javax.swing.*;
import java.awt.*;

/**
 * Created by LukasMetlicka on 11/5/14.
 */
public class HelloSwing {

    public static void main(String[] args){

        JFrame frame = new JFrame("TestWindow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,1200);
        JButton b = new JButton("Click!");
        frame.add(b);
        frame.setBackground(Color.black);
        frame.setVisible(true);


	    //Make Frame
	    //Make Panel
	    //Make button
	    //set size of panel, colors, etc.
	    //add button to panel
	    //add panel to frame.
	    //Don't set the background of the frame itself. Always change the panel background


    }

}
