package Simulator.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Simulator.MainFrame;

public class OptionPanelCheckboxShowTrajectoryListener implements ActionListener {

	public OptionPanelCheckboxShowTrajectoryListener(MainFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand()=="True") {
			frame.getWhiteboardPanel().setDrawTrajectory(false);
			frame.getOptionPanel().getTrajectoryDisplay().setActionCommand("False");
		}
		if(arg0.getActionCommand()=="False") {
			frame.getWhiteboardPanel().setDrawTrajectory(true);
			frame.getOptionPanel().getTrajectoryDisplay().setActionCommand("True");
		}
		frame.getWhiteboardPanel().repaint();
	}
	
	MainFrame frame;
}
