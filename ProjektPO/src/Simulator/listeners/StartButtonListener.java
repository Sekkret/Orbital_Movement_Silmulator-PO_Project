package Simulator.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Simulator.MainFrame;

public class StartButtonListener implements ActionListener {

	public StartButtonListener(MainFrame frame) {
		reset = true;
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(getReset()) {
			
			frame.getWhiteboardPanel().setDrawAnimation(true);
			frame.getWhiteboardPanel().refresh();
			frame.getWhiteboardPanel().repaint();
			reset = false;
			frame.getStartButton().setText("STOP");
		}
		else {
			frame.getStartButton().setText("START");
			frame.getWhiteboardPanel().getTrajectory().getConstants().getScheduler().shutdown();
			reset = true;
		}
	}
	
	public boolean getReset() {
		return reset;
	}
	

	MainFrame frame;
	boolean reset;
	
}
