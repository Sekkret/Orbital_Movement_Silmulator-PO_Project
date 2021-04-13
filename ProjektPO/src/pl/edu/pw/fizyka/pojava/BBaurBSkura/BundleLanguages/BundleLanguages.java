//Bartosz Skura
package pl.edu.pw.fizyka.pojava.BBaurBSkura.BundleLanguages;

import java.util.Locale;
import java.util.ResourceBundle;

import pl.edu.pw.fizyka.pojava.BBaurBSkura.Simulator.Getters;
import pl.edu.pw.fizyka.pojava.BBaurBSkura.Simulator.MainFrame;

public class BundleLanguages {
//Bartosz Skura
	public BundleLanguages(MainFrame frame) {
		main = frame;
		get = new Getters(main);
		}
	
	public void changeLanguage() {
		Locale language = new Locale(get.getLanguageS(),get.getCountryS());
		ResourceBundle rBundle = ResourceBundle.getBundle("pl.edu.pw.fizyka.pojava.BBaurBSkura.BundleLanguages/Bundle",language);
        get.getNewItem().setText(rBundle.getString("new"));
        get.getSaveItem().setText(rBundle.getString("save"));
        get.getWriteItem().setText(rBundle.getString("write"));
        get.getFileMenu().setText(rBundle.getString("file"));
        get.getHelpMenu().setText(rBundle.getString("help"));
        get.getAboutItem().setText( rBundle.getString("about"));
        get.getManualItem().setText(rBundle.getString("manual"));
        get.getColorItem().setText(rBundle.getString("color"));
        get.getLanguageMenu().setText(rBundle.getString("language"));
        get.getSettingsMenu().setText(rBundle.getString("settings"));
        get.getStartButton().setText( rBundle.getString("startButton"));
        get.getAxisDisplay().setText( rBundle.getString("axisDisplay"));
        get.getTrajectoryDisplay().setText( rBundle.getString("trajectoryDisplay"));
        get.getVelocityDisplay().setText( rBundle.getString("velocityDisplay"));
        get.getVelocityComponentsDisplay().setText( rBundle.getString("velocityComponentsDisplay"));
        get.getZoomSliderLabel().setText(rBundle.getString("zoomSliderLabel"));
        get.getCentralMassInput().setText(rBundle.getString("centralMassInput"));
        get.getOrbitingMassInput().setText(rBundle.getString("orbitingMassInput"));
        get.getVelocityValueInput().setText(rBundle.getString("velocityValueInput"));
        get.getVelocityDirectionInput().setText(rBundle.getString("velocityDirectionInput"));
        get.getCurrentVelocity().setText(rBundle.getString("currentVelocity"));
        get.getCurrentKineticEnergy().setText(rBundle.getString("currentKineticEnergy"));
        get.getCurrentPotential().setText(rBundle.getString("currentPotential"));
        get.getCurrentEffectivePotential().setText(rBundle.getString("currentEffectivePotential"));
        get.getCurrentDistance().setText(rBundle.getString("currentDistance"));
        get.getCurrentEnergy().setText(rBundle.getString("currentEnergy"));
        get.getCurrentReductedMass().setText(rBundle.getString("currentReductedMass"));
        get.getCurrentAngularMomentum().setText(rBundle.getString("currentAngularMomentum"));
	}
	MainFrame main;
	Getters get;
}