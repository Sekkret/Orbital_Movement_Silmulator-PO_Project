package Simulator.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Simulator.MainFrame;

public class OptionPanelCheckboxShowVelocity implements ActionListener {

	public OptionPanelCheckboxShowVelocity(MainFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand()=="True") {
			frame.getWhiteboardPanel().setDrawVelocity(false);
			frame.getOptionPanel().getVelocityDisplay().setActionCommand("False");
			
			
			
		}
		if(arg0.getActionCommand()=="False") {
			frame.getWhiteboardPanel().setDrawVelocity(true);
			frame.getOptionPanel().getVelocityDisplay().setActionCommand("True");
		}
		frame.getWhiteboardPanel().repaint();
	}
	
	MainFrame frame;
}
