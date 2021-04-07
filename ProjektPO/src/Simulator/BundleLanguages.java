package Simulator;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundleLanguages {
//Bartosz Skura
	public BundleLanguages(MainFrame frame) {
		main = frame;
	}
	
	public void changeLanguage() {
		Locale language = new Locale(main.languageS,main.countryS);
		ResourceBundle rBundle = ResourceBundle.getBundle("Simulator/Bundle",language);
        main.newItem.setText(rBundle.getString("new"));
        main.saveItem.setText(rBundle.getString("save"));
        main.writeItem.setText(rBundle.getString("write"));
        main.fileMenu.setText(rBundle.getString("file"));
        main.helpMenu.setText(rBundle.getString("help"));
        main.aboutItem.setText( rBundle.getString("about"));
        main.manualItem.setText(rBundle.getString("manual"));
        main.colorItem.setText(rBundle.getString("color"));
        main.languageMenu.setText(rBundle.getString("language"));
        main.settingsMenu.setText(rBundle.getString("settings"));
        main.currentVelocity.setTitle(rBundle.getString("currentVelocity"));
        main.currentKineticEnergy.setTitle(rBundle.getString("currentKineticEnergy"));
        main.currentPotential.setTitle(rBundle.getString("currentPotential"));
        main.currentEffectivePotential.setTitle(rBundle.getString("currentEffectivePotential"));
        main.currentDistance.setTitle(rBundle.getString("currentDistance"));
        main.currentEnergy.setTitle(rBundle.getString("currentEnergy"));
        main.currentReductedMass.setTitle(rBundle.getString("currentReductedMass"));
        main.currentAngularMomentum.setTitle(rBundle.getString("currentAngularMomentum"));
        main.centralMassInput.setTitle(rBundle.getString("centralMassInput"));
        main.orbitingMassInput.setTitle(rBundle.getString("orbitingMassInput"));
        main.velocityValueInput.setTitle(rBundle.getString("velocityValueInput"));
        main.velocityDirectionInput.setTitle(rBundle.getString("velocityDirectionInput"));
        main.axisDisplay.setText( rBundle.getString("axisDisplay"));
        main.startButton.setText( rBundle.getString("startButton"));
        main.trajectoryDisplay.setText( rBundle.getString("trajectoryDisplay"));
        main.animationDisplay.setText( rBundle.getString("animationDisplay"));
        main.velocityDisplay.setText( rBundle.getString("velocityDisplay"));
        main.velocityComponentsDisplay.setText( rBundle.getString("velocityComponentsDisplay"));
        main.zoomSliderLabel.setText( rBundle.getString("zoomSliderLabel"));
	}
	MainFrame main;
}
