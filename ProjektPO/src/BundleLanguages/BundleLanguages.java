package BundleLanguages;

import java.util.Locale;
import java.util.ResourceBundle;

import Simulator.Getters;
import Simulator.MainFrame;

public class BundleLanguages {
//Bartosz Skura
	public BundleLanguages(MainFrame frame) {
		main = frame;
		get = new Getters(main);
		}
	
	public void changeLanguage() {
		Locale language = new Locale(main.getLanguageS(),main.getCountryS());
		ResourceBundle rBundle = ResourceBundle.getBundle("BundleLanguages/Bundle",language);
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
        main.getStartButton().setText( rBundle.getString("startButton"));
        main.getOptionPanel().getAxisDisplay().setText(rBundle.getString("axisDisplay"));
        main.getOptionPanel().getTrajectoryDisplay().setText( rBundle.getString("trajectoryDisplay"));
        main.getOptionPanel().getVelocityDisplay().setText( rBundle.getString("velocityDisplay"));
        main.getOptionPanel().getVelocityComponentsDisplay().setText( rBundle.getString("velocityComponentsDisplay"));
        main.getOptionPanel().getZoomSliderLabel().setText(rBundle.getString("zoomSliderLabel"));
        main.getInputPanel().getCentralMassInput().setTitle(rBundle.getString("centralMassInput"));
        main.getInputPanel().getOrbitingMassInput().setTitle(rBundle.getString("orbitingMassInput"));
        main.getInputPanel().getVelocityValueInput().setTitle(rBundle.getString("velocityValueInput"));
        main.getInputPanel().getVelocityDirectionInput().setTitle(rBundle.getString("velocityDirectionInput"));
        main.getDataPanel().getCurrentVelocity().setTitle(rBundle.getString("currentVelocity"));
        main.getDataPanel().getCurrentKineticEnergy().setTitle(rBundle.getString("currentKineticEnergy"));
        main.getDataPanel().getCurrentPotential().setTitle(rBundle.getString("currentPotential"));
        main.getDataPanel().getCurrentEffectivePotential().setTitle(rBundle.getString("currentEffectivePotential"));
        main.getDataPanel().getCurrentDistance().setTitle(rBundle.getString("currentDistance"));
        main.getDataPanel().getCurrentEnergy().setTitle(rBundle.getString("currentEnergy"));
        main.getDataPanel().getCurrentReductedMass().setTitle(rBundle.getString("currentReductedMass"));
        main.getDataPanel().getCurrentAngularMomentum().setTitle(rBundle.getString("currentAngularMomentum"));
	}
	MainFrame main;
	Getters get;
}