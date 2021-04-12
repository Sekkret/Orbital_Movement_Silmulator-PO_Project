package Simulator;

import java.awt.Frame;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSlider;

public class Getters {
	MainFrame main;

	public Getters(MainFrame frame) {
		main = frame;
	}
	
	public String getLanguageS() {
		return main.languageS;
	}

	public String getCountryS() {
		return main.countryS;
	}
	
	public JButton getStartButton() {
		return main.startButton;
	}

	public JMenuItem getNewItem() {
		return main.menuBar.newItem;
	}
	public JMenuItem getSaveItem() {
		return main.menuBar.saveItem;
	}
	public JMenuItem getWriteItem() {
		return main.menuBar.writeItem;
	}
	public JMenuItem getAboutItem() {
		return main.menuBar.aboutItem;
	}
	public JMenuItem getColorItem() {
		return main.menuBar.colorItem;
	}
	public JMenuItem getManualItem() {
		return main.menuBar.manualItem;
	}
	
	public JMenu getLanguageMenu() {
		return main.menuBar.languageMenu;
	}
	public JMenu getFileMenu() {
		return main.menuBar.fileMenu;
	}
	public JMenu getHelpMenu() {
		return main.menuBar.helpMenu;
	}
	public JMenu getSettingsMenu() {
		return main.menuBar.settingsMenu;
	}
	

	public JCheckBox getAxisDisplay() {
		return main.optionPanel.axisDisplay;
	}
	public JCheckBox getTrajectoryDisplay() {
		return main.optionPanel.trajectoryDisplay;
	}
	public JCheckBox getVelocityDisplay() {

		return main.optionPanel.velocityDisplay;
	}
	public JCheckBox getVelocityComponentsDisplay() {
		return main.optionPanel.velocityComponentsDisplay;
	}

	public JLabel getZoomSliderLabel() {
		return main.optionPanel.zoomSliderLabel;
	}

	public JLabel getCentralMassInput() {
		return main.inputPanel.centralMassInput.title;
	}

	public JLabel  getOrbitingMassInput() {
		return main.inputPanel.orbitingMassInput.title;
	}

	public JLabel  getVelocityValueInput() {

		return main.inputPanel.velocityValueInput.title;
	}

	public JLabel  getVelocityDirectionInput() {

		return main.inputPanel.velocityDirectionInput.title;
	}

	public JLabel getCurrentVelocity() {
		return main.dataPanel.currentVelocity.title;
	}

	public JLabel getCurrentPotential() {
		return main.dataPanel.currentPotential.title;
	}

	public JLabel getCurrentKineticEnergy() {
		return main.dataPanel.currentKineticEnergy.title;
	}
 
	public JLabel getCurrentDistance() {
		return main.dataPanel.currentDistance.title;
	}

	public JLabel getCurrentEnergy() {
		return main.dataPanel.currentEnergy.title;
	}

	public JLabel getCurrentReductedMass() {
		return main.dataPanel.currentReductedMass.title;
	}

	public JLabel getCurrentAngularMomentum() {	
		return main.dataPanel.currentAngularMomentum.title;
	}

	public JLabel getCurrentEffectivePotential() {
		return main.dataPanel.currentEffectivePotential.title;
	}
}
