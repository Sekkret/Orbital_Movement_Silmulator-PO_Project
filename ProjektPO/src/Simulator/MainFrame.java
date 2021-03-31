package Simulator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {

	public MainFrame() throws HeadlessException {
		
		this.setSize(960, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Symulacja BETA");
		
		
		newItem = new JMenuItem("Nowy");
		saveItem = new JMenuItem("Zapisz");
		writeItem = new JMenuItem("Wczytaj");
		fileMenu = new JMenu("Plik");
		fileMenu.add(newItem);
		fileMenu.add(saveItem);
		fileMenu.add(writeItem);
		
		manualItem = new JMenuItem("Instrukcja");
		aboutItem = new JMenuItem("O programie");
		helpMenu = new JMenu("Pomoc");
		helpMenu.add(manualItem);
		helpMenu.add(aboutItem);
		
		languageItem = new JMenuItem("Jêzyk");
		colorItem = new JMenuItem("Kolor");
		settingsMenu = new JMenu("Ustawienia");
		settingsMenu.add(languageItem);
		settingsMenu.add(colorItem);
		
		menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		menuBar.add(settingsMenu);
		
		WhiteBoardPanel = new JPanel();
		WhiteBoardPanel.setBackground(Color.WHITE);
		
		currentVelocity = new TitledLabel("Szybkoœæ cia³a","0");
		currentAngularMomentum = new TitledLabel("Moment Pêdu","0");
		currentKineticEnergy = new TitledLabel("Energia Kinetyczna","0");
		currentPotential = new TitledLabel("Potencja³","0");
		currentEffectivePotential = new TitledLabel("Potencja³ Efektywny","0");
		currentDistance = new TitledLabel("Dystans miêdzy cia³ami","0");
		currentEnergy = new TitledLabel("Energia ca³kowita","0");
		currentReductedMass = new TitledLabel("Masa zredukowana","0");
		
		statsPanel = new JPanel();
		statsPanel.setLayout(new GridLayout(2,4));
		statsPanel.add(currentVelocity);
		statsPanel.add(currentAngularMomentum);
		statsPanel.add(currentKineticEnergy);
		statsPanel.add(currentPotential);
		statsPanel.add(currentEffectivePotential);
		statsPanel.add(currentDistance);
		statsPanel.add(currentEnergy);
		statsPanel.add(currentReductedMass);
		
		leftSidePanel = new JPanel();
		leftSidePanel.setLayout(new BorderLayout());
		leftSidePanel.add(WhiteBoardPanel, BorderLayout.CENTER);
		leftSidePanel.add(statsPanel, BorderLayout.SOUTH);
		
		
		
		
		
		centralMassInput = new TitledTextField("Masa centralna", "100");
		orbitingMassInput = new TitledTextField("Masa orbituj¹ca", "20");
		xValueInput = new TitledTextField("x", "0");
		yValueInput = new TitledTextField("y", "0");
		velocityValueInput = new TitledTextField("wartoœæ prêdkoœci", "0");
		velocityDirectionInput = new TitledTextField("kierunek prêdkoœci", "0");
		
		inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(4,2));
		inputPanel.add(centralMassInput);
		inputPanel.add(orbitingMassInput);
		inputPanel.add(xValueInput);
		inputPanel.add(yValueInput);
		inputPanel.add(velocityValueInput);
		inputPanel.add(velocityDirectionInput);
		
		startButton = new JButton("START");
		
		upperRightPanel = new JPanel();
		upperRightPanel.setLayout(new BorderLayout());
		upperRightPanel.add(inputPanel, BorderLayout.CENTER);
		upperRightPanel.add(startButton, BorderLayout.SOUTH);
		
		axisDisplay = new JCheckBox("osie");
		trajectoryDisplay = new JCheckBox("tor ruchu");
		animationDisplay = new JCheckBox("animacja");
		velocityDisplay = new JCheckBox("wektor prêdkoœci");
		velocityComponentsDisplay = new JCheckBox("sk³adowe wektora");
		zoomSliderLabel = new JLabel("Powiêkszenie:");
		zoomSlider = new JSlider();
		settingsPanel = new JPanel();
		settingsPanel.setLayout(new GridLayout(8,1));
		settingsPanel.add(axisDisplay);
		settingsPanel.add(trajectoryDisplay);
		settingsPanel.add(animationDisplay);
		settingsPanel.add(velocityDisplay);
		settingsPanel.add(velocityComponentsDisplay);
		settingsPanel.add(zoomSliderLabel);
		settingsPanel.add(zoomSlider);
		
		rightSidePanel = new JPanel();
		rightSidePanel.setLayout(new BorderLayout());
		rightSidePanel.add(upperRightPanel, BorderLayout.CENTER);
		rightSidePanel.add(settingsPanel, BorderLayout.SOUTH);
		
		this.add(rightSidePanel, BorderLayout.EAST);
		this.add(leftSidePanel, BorderLayout.CENTER);
		this.setJMenuBar(menuBar);
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						MainFrame mainFrame = new MainFrame();
						mainFrame.setVisible(true);
					}
				}
		);

	}
	
	JPanel rightSidePanel;
	
	JPanel upperRightPanel;
	JPanel inputPanel;
	TitledTextField centralMassInput;
	TitledTextField orbitingMassInput;
	TitledTextField xValueInput;
	TitledTextField yValueInput;
	TitledTextField velocityValueInput;
	TitledTextField velocityDirectionInput;
	
	JButton startButton;
	
	JPanel settingsPanel;
	JCheckBox axisDisplay;
	JCheckBox trajectoryDisplay;
	JCheckBox animationDisplay;
	JCheckBox velocityDisplay;
	JCheckBox velocityComponentsDisplay;
	JLabel zoomSliderLabel;
	JSlider zoomSlider;
	
	JPanel leftSidePanel;
	JPanel WhiteBoardPanel;
	JPanel statsPanel;
	TitledLabel currentVelocity;
	TitledLabel currentAngularMomentum;
	TitledLabel currentKineticEnergy;
	TitledLabel currentPotential;
	TitledLabel currentEffectivePotential;
	TitledLabel currentDistance;
	TitledLabel currentEnergy;
	TitledLabel currentReductedMass;
	
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem newItem;
	JMenuItem saveItem;
	JMenuItem writeItem;
	JMenu helpMenu;
	JMenuItem manualItem;
	JMenu settingsMenu;
	JMenuItem languageItem;
	JMenuItem colorItem;
	JMenuItem aboutItem;
	

}
