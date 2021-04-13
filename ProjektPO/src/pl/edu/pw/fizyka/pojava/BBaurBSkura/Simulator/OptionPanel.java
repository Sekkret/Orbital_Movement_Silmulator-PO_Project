//Bartłomiej Baur
package pl.edu.pw.fizyka.pojava.BBaurBSkura.Simulator;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class OptionPanel extends JPanel {

	public OptionPanel() {
		axisDisplay = new JCheckBox();
		trajectoryDisplay = new JCheckBox();
		velocityDisplay = new JCheckBox();
		velocityComponentsDisplay = new JCheckBox();
		zoomSliderLabel = new JLabel("",JLabel.CENTER);
		zoomSlider = new JSlider();
		
		this.setLayout(new GridLayout(8,1));
		this.add(axisDisplay);
		this.add(trajectoryDisplay);
		this.add(velocityDisplay);
		this.add(velocityComponentsDisplay);
		this.add(zoomSliderLabel);
		this.add(zoomSlider);
	}

	JCheckBox axisDisplay;
	JCheckBox trajectoryDisplay;
	JCheckBox velocityDisplay;
	JCheckBox velocityComponentsDisplay;
	JLabel zoomSliderLabel;
	JSlider zoomSlider;

}
