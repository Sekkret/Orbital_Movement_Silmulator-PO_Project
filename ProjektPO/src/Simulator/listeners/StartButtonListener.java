package Simulator.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Simulator.MainFrame;

public class StartButtonListener implements ActionListener {

	public StartButtonListener(MainFrame frame) {
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.getWhiteboardPanel().refresh();
		frame.getWhiteboardPanel().repaint();
	}
	
	MainFrame frame;
}
