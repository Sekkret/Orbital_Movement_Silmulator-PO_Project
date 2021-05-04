package Simulator;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class DataPanel extends JPanel {

	public DataPanel() {
		currentVelocity = new TitledLabel("","0");
		currentAngularMomentum = new TitledLabel("","0");
		currentKineticEnergy = new TitledLabel("","0");
		currentPotential = new TitledLabel("","0");
		currentEffectivePotential = new TitledLabel("","0");
		currentDistance = new TitledLabel("","0");
		currentEnergy = new TitledLabel("","0");
		currentReductedMass = new TitledLabel("","0");
		
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
	
	
	
	public TitledLabel getCurrentVelocity() {
		return currentVelocity;
	}
	public TitledLabel getCurrentAngularMomentum() {
		return currentAngularMomentum;
	}
	public TitledLabel getCurrentKineticEnergy() {
		return currentKineticEnergy;
	}
	public TitledLabel getCurrentPotential() {
		return currentPotential;
	}
	public TitledLabel getCurrentEffectivePotential() {
		return currentEffectivePotential;
	}
	public TitledLabel getCurrentDistance() {
		return currentDistance;
	}
	public TitledLabel getCurrentEnergy() {
		return currentEnergy;
	}
	public TitledLabel getCurrentReductedMass() {
		return currentReductedMass;
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
