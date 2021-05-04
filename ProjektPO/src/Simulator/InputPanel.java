package Simulator;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class InputPanel extends JPanel {

	public InputPanel() {
		centralMassInput = new TitledTextField("", "10000000000000");
		orbitingMassInput = new TitledTextField("", "20000000000000000");
		xValueInput = new TitledTextField("x [m]", "100");
		yValueInput = new TitledTextField("y [m]", "-10");
		velocityValueInput = new TitledTextField("", "100");
		velocityDirectionInput = new TitledTextField("", "90");

		this.setLayout(new GridLayout(4,2));
		this.add(centralMassInput);
		this.add(orbitingMassInput);
		this.add(xValueInput);
		this.add(yValueInput);
		this.add(velocityValueInput);
		this.add(velocityDirectionInput);		
	}
	
	
	
	public TitledTextField getCentralMassInput() {
		return centralMassInput;
	}
	public TitledTextField getOrbitingMassInput() {
		return orbitingMassInput;
	}
	public TitledTextField getxValueInput() {
		return xValueInput;
	}
	public TitledTextField getyValueInput() {
		return yValueInput;
	}
	public TitledTextField getVelocityValueInput() {
		return velocityValueInput;
	}
	public TitledTextField getVelocityDirectionInput() {
		return velocityDirectionInput;
	}



	TitledTextField centralMassInput;
	TitledTextField orbitingMassInput;
	TitledTextField xValueInput;
	TitledTextField yValueInput;
	TitledTextField velocityValueInput;
	TitledTextField velocityDirectionInput;
}
