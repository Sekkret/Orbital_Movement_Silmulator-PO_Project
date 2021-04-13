//Bartłomiej Baur
package pl.edu.pw.fizyka.pojava.BBaurBSkura.Simulator;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class InputPanel extends JPanel {

	public InputPanel() {
		centralMassInput = new TitledTextField("", "100");
		orbitingMassInput = new TitledTextField("", "20");
		xValueInput = new TitledTextField("x", "0");
		yValueInput = new TitledTextField("y", "0");
		velocityValueInput = new TitledTextField("", "0");
		velocityDirectionInput = new TitledTextField("", "0");

		this.setLayout(new GridLayout(4,2));
		this.add(centralMassInput);
		this.add(orbitingMassInput);
		this.add(xValueInput);
		this.add(yValueInput);
		this.add(velocityValueInput);
		this.add(velocityDirectionInput);		
	}
	
	TitledTextField centralMassInput;
	TitledTextField orbitingMassInput;
	TitledTextField xValueInput;
	TitledTextField yValueInput;
	TitledTextField velocityValueInput;
	TitledTextField velocityDirectionInput;
}
