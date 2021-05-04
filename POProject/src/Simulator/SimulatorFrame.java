package Simulator;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimulatorFrame extends JFrame {

	public SimulatorFrame() throws HeadlessException {
		
		leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		whiteBoardPanel = new JPanel();
		leftPanel.add(whiteBoardPanel, BorderLayout.CENTER);
		measurementsPanel = new JPanel();
		leftPanel.add(measurementsPanel, BorderLayout.SOUTH);
		
		rightPanel = new JPanel();
		
		
		this.add(leftPanel, BorderLayout.CENTER);
		this.add(rightPanel, BorderLayout.EAST);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	JPanel leftPanel;
	JPanel rightPanel;
	JPanel whiteBoardPanel;
	JPanel measurementsPanel;
	JPanel upSetPanel;
	JPanel downSetPanel;
}
