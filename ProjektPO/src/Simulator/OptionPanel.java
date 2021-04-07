package Simulator;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class OptionPanel extends JPanel {

	public OptionPanel() {
		axisDisplay = new JCheckBox("osie");
		trajectoryDisplay = new JCheckBox("tor ruchu");
		animationDisplay = new JCheckBox("animacja");
		velocityDisplay = new JCheckBox("wektor prędkości");
		velocityComponentsDisplay = new JCheckBox("składowe wektora");
		zoomSliderLabel = new JLabel("Powiększenie:");
		zoomSlider = new JSlider();
		
		this.setLayout(new GridLayout(8,1));
		this.add(axisDisplay);
		this.add(trajectoryDisplay);
		this.add(animationDisplay);
		this.add(velocityDisplay);
		this.add(velocityComponentsDisplay);
		this.add(zoomSliderLabel);
		this.add(zoomSlider);
	}

	JCheckBox axisDisplay;
	JCheckBox trajectoryDisplay;
	JCheckBox animationDisplay;
	JCheckBox velocityDisplay;
	JCheckBox velocityComponentsDisplay;
	JLabel zoomSliderLabel;
	JSlider zoomSlider;

}
