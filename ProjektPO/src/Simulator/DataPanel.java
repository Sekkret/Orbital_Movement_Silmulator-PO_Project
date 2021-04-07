package Simulator;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class DataPanel extends JPanel {

	public DataPanel() {
		currentVelocity = new TitledLabel("Szybkość ciała","0");
		currentAngularMomentum = new TitledLabel("Moment Pędu","0");
		currentKineticEnergy = new TitledLabel("Energia Kinetyczna","0");
		currentPotential = new TitledLabel("Potencjał","0");
		currentEffectivePotential = new TitledLabel("Potencjał Efektywny","0");
		currentDistance = new TitledLabel("Dystans między ciałami","0");
		currentEnergy = new TitledLabel("Energia całkowita","0");
		currentReductedMass = new TitledLabel("Masa zredukowana","0");
		
		this.setLayout(new GridLayout(2,4));
		this.add(currentVelocity);
		this.add(currentAngularMomentum);
		this.add(currentKineticEnergy);
		this.add(currentPotential);
		this.add(currentEffectivePotential);
		this.add(currentDistance);
		this.add(currentEnergy);
		this.add(currentReductedMass);
	}
	
	public TitledLabel currentVelocity;
	public TitledLabel currentAngularMomentum;
	public TitledLabel currentKineticEnergy;
	public TitledLabel currentPotential;
	public TitledLabel currentEffectivePotential;
	public TitledLabel currentDistance;
	public TitledLabel currentEnergy;
	public TitledLabel currentReductedMass;
}
