package Simulator;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OptionPanel extends JPanel {

	public OptionPanel() {
		axisDisplay = new JCheckBox();
		trajectoryDisplay = new JCheckBox();
		velocityDisplay = new JCheckBox();
		velocityComponentsDisplay = new JCheckBox();
		zoomSliderLabel = new JLabel("",JLabel.CENTER);
		zoomSlider = new JSlider();
		zoomSlider.setMinimum(1);
		zoomSlider.setMaximum(100);
		zoomSlider.setMajorTickSpacing(1);
		zoomSlider.setMinorTickSpacing(1);
		zoomSlider.setPaintTicks(true);
		zoomSlider.setPaintLabels(true);
		
		this.setLayout(new GridLayout(8,1));
		this.add(axisDisplay);
		this.add(trajectoryDisplay);
		this.add(velocityDisplay);
		this.add(velocityComponentsDisplay);
		this.add(zoomSliderLabel);
		this.add(zoomSlider);
		
	}
	
	

	public JLabel getZoomSliderLabel() {
		return zoomSliderLabel;
	}
	public void setZoomSliderLabel(JLabel zoomSliderLabel) {
		this.zoomSliderLabel = zoomSliderLabel;
	}
	public JCheckBox getAxisDisplay() {
		return axisDisplay;
	}
	public JCheckBox getTrajectoryDisplay() {
		return trajectoryDisplay;
	}
	public JCheckBox getVelocityDisplay() {
		return velocityDisplay;
	}
	public JCheckBox getVelocityComponentsDisplay() {
		return velocityComponentsDisplay;
	}
	public JSlider getZoomSlider() {
		return zoomSlider;
	}



	JCheckBox axisDisplay;
	JCheckBox trajectoryDisplay;
	JCheckBox velocityDisplay;
	JCheckBox velocityComponentsDisplay;
	JLabel zoomSliderLabel;
	JSlider zoomSlider;
	
}
