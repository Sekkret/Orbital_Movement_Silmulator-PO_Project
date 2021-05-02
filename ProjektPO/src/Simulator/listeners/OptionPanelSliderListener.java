package Simulator.listeners;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Simulator.MainFrame;

public class OptionPanelSliderListener implements ChangeListener {

	public OptionPanelSliderListener(MainFrame source) {
		this.source = source;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		source.getWhiteboardPanel().getAxes().setZoom( (double) source.getOptionPanel().getZoomSlider().getValue()/2   );
		source.getWhiteboardPanel().repaint();
	}
	
	MainFrame source;
}
