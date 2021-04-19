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
		source.getWhiteboardPanel().getAxes().setZoom(  source.getOptionPanel().getZoomSlider().getValue()   );
		source.getWhiteboardPanel().repaint();
	}
	
	MainFrame source;
}
