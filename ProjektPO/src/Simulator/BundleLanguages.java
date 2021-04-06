package Simulator;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundleLanguages {
//Bartosz Skura
	public BundleLanguages() {

	}
	
	public void changeLanguage() {
		Locale language = new Locale(MainFrame.languageS,MainFrame.countryS);
		ResourceBundle rBundle = ResourceBundle.getBundle("Simulator/Bundle",language);
        MainFrame.newItem.setText(rBundle.getString("new"));
        MainFrame.saveItem.setText(rBundle.getString("save"));
        MainFrame.writeItem.setText(rBundle.getString("write"));
        MainFrame.fileMenu.setText(rBundle.getString("file"));
        MainFrame.helpMenu.setText(rBundle.getString("help"));
        MainFrame.aboutItem.setText( rBundle.getString("about"));
        MainFrame.manualItem.setText(rBundle.getString("manual"));
        MainFrame.colorItem.setText(rBundle.getString("color"));
        MainFrame.languageMenu.setText(rBundle.getString("language"));
        MainFrame.settingsMenu.setText(rBundle.getString("settings"));
        MainFrame.currentVelocity.setTitle(rBundle.getString("currentVelocity"));
        MainFrame.currentKineticEnergy.setTitle(rBundle.getString("currentKineticEnergy"));
        MainFrame.currentPotential.setTitle(rBundle.getString("currentPotential"));
        MainFrame.currentEffectivePotential.setTitle(rBundle.getString("currentEffectivePotential"));
        MainFrame.currentDistance.setTitle(rBundle.getString("currentDistance"));
        MainFrame.currentEnergy.setTitle(rBundle.getString("currentEnergy"));
        MainFrame.currentReductedMass.setTitle(rBundle.getString("currentReductedMass"));
        MainFrame.currentAngularMomentum.setTitle(rBundle.getString("currentAngularMomentum"));
        MainFrame.centralMassInput.setTitle(rBundle.getString("centralMassInput"));
        MainFrame.orbitingMassInput.setTitle(rBundle.getString("orbitingMassInput"));
        MainFrame.velocityValueInput.setTitle(rBundle.getString("velocityValueInput"));
        MainFrame.velocityDirectionInput.setTitle(rBundle.getString("velocityDirectionInput"));
        MainFrame.axisDisplay.setText( rBundle.getString("axisDisplay"));
        MainFrame.startButton.setText( rBundle.getString("startButton"));
        MainFrame.trajectoryDisplay.setText( rBundle.getString("trajectoryDisplay"));
        MainFrame.animationDisplay.setText( rBundle.getString("animationDisplay"));
        MainFrame.velocityDisplay.setText( rBundle.getString("velocityDisplay"));
        MainFrame.velocityComponentsDisplay.setText( rBundle.getString("velocityComponentsDisplay"));
        MainFrame.zoomSliderLabel.setText( rBundle.getString("zoomSliderLabel"));
	}
	
}
