package Simulator.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Simulator.MainFrame;

public class OptionPanelCheckboxShowVelocityComponents implements ActionListener {

	public OptionPanelCheckboxShowVelocityComponents(MainFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand()=="True") {
			frame.getWhiteboardPanel().setDrawVelocityComponets(false);
			frame.getOptionPanel().getVelocityComponentsDisplay().setActionCommand("False");
			
			
			
		}
		if(arg0.getActionCommand()=="False") {
			frame.getWhiteboardPanel().setDrawVelocityComponets(true);
			frame.getOptionPanel().getVelocityComponentsDisplay().setActionCommand("True");
		}
		frame.getWhiteboardPanel().repaint();
	}
	
	MainFrame frame;
}
