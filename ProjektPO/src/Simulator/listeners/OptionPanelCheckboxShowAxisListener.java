package Simulator.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Simulator.MainFrame;

public class OptionPanelCheckboxShowAxisListener implements ActionListener {

	public OptionPanelCheckboxShowAxisListener(MainFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand()=="True") {
			frame.getWhiteboardPanel().setDrawAxes(false);
			frame.getOptionPanel().getAxisDisplay().setActionCommand("False");
		}
		if(arg0.getActionCommand()=="False") {
			frame.getWhiteboardPanel().setDrawAxes(true);
			frame.getOptionPanel().getAxisDisplay().setActionCommand("True");
		}
		frame.getWhiteboardPanel().repaint();
	}
	MainFrame frame;
}
