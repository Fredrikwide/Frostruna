package Frost;

import java.awt.Color;
import javax.swing.JFrame;

public class FrostRun {

	public static void main (String args[]) {
		FrostFrame frame = new FrostFrame("Frostruna");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.BLACK);
	}
}