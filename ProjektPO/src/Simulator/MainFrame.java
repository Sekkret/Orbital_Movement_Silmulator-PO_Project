package Simulator;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {

	public MainFrame() throws HeadlessException {
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						
					}
				}
		);

	}

}
