package gui;

import javax.swing.JFrame;

public class Frame {
	
	public static JFrame frame;	
	
	public static void main(String[] args) {
		frame = new JFrame("My JFrame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.add(new GUI());
		frame.setVisible(true);
	}
	
}
