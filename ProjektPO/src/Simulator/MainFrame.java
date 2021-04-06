package Simulator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

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
		
		languageS = "pl";
		countryS = "PL";
		BundleLanguages bundle = new BundleLanguages();
		
		
		newItem = new JMenuItem();
		saveItem = new JMenuItem();
		writeItem = new JMenuItem();
		fileMenu = new JMenu();
		fileMenu.add(newItem);
		fileMenu.add(saveItem);
		fileMenu.add(writeItem);
		
		manualItem = new JMenuItem();
		aboutItem = new JMenuItem();
		helpMenu = new JMenu();
		helpMenu.add(manualItem);
		helpMenu.add(aboutItem);
		
		languageMenu = new JMenu();
		colorItem = new JMenuItem();
		settingsMenu = new JMenu();
		polishItem = new JMenuItem("polski");
		englishItem = new JMenuItem("english");;
		settingsMenu.add(languageMenu);
		settingsMenu.add(colorItem);
		languageMenu.add(polishItem);
		languageMenu.add(englishItem);
		
		menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		menuBar.add(settingsMenu);
		
		WhiteBoardPanel = new JPanel();
		WhiteBoardPanel.setBackground(Color.WHITE);
		
		currentVelocity = new TitledLabel("","0");
		currentAngularMomentum = new TitledLabel("","0");
		currentKineticEnergy = new TitledLabel("","0");
		currentPotential = new TitledLabel("","0");
		currentEffectivePotential = new TitledLabel("","0");
		currentDistance = new TitledLabel("","0");
		currentEnergy = new TitledLabel("","0");
		currentReductedMass = new TitledLabel("","0");
		
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
		
		centralMassInput = new TitledTextField("", "100");
		orbitingMassInput = new TitledTextField("", "20");
		xValueInput = new TitledTextField("x", "0");
		yValueInput = new TitledTextField("y", "0");
		velocityValueInput = new TitledTextField("", "0");
		velocityDirectionInput = new TitledTextField("", "0");
		
		inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(4,2));
		inputPanel.add(centralMassInput);
		inputPanel.add(orbitingMassInput);
		inputPanel.add(xValueInput);
		inputPanel.add(yValueInput);
		inputPanel.add(velocityValueInput);
		inputPanel.add(velocityDirectionInput);
		
		startButton = new JButton();
		
		upperRightPanel = new JPanel();
		upperRightPanel.setLayout(new BorderLayout());
		upperRightPanel.add(inputPanel, BorderLayout.CENTER);
		upperRightPanel.add(startButton, BorderLayout.SOUTH);
		
		axisDisplay = new JCheckBox();
		trajectoryDisplay = new JCheckBox();
		animationDisplay = new JCheckBox();
		velocityDisplay = new JCheckBox();
		velocityComponentsDisplay = new JCheckBox();
		zoomSliderLabel = new JLabel();
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
		rightSidePanel.setPreferredSize(new Dimension(240,600));
		this.add(leftSidePanel, BorderLayout.CENTER);
		this.setJMenuBar(menuBar);
		
		bundle.changeLanguage();
		
		ActionListener englishLanguageListener= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				languageS = "en";
				countryS = "US";
				bundle.changeLanguage();

			}	
		};
		englishItem.addActionListener(englishLanguageListener );
		
		ActionListener polishLanguageListener  = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				languageS = "pl";
				countryS = "PL";
				bundle.changeLanguage();

			}	
		};
		polishItem.addActionListener(polishLanguageListener );
		
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
	static TitledTextField centralMassInput;
	static TitledTextField orbitingMassInput;
	TitledTextField xValueInput;
	TitledTextField yValueInput;
	static TitledTextField velocityValueInput;
	static TitledTextField velocityDirectionInput;
	
	static JButton startButton;
	
	JPanel settingsPanel;
	static JCheckBox axisDisplay;
	static JCheckBox trajectoryDisplay;
	static JCheckBox animationDisplay;
	static JCheckBox velocityDisplay;
	static JCheckBox velocityComponentsDisplay;
	static JLabel zoomSliderLabel;
	JSlider zoomSlider;
	
	JPanel leftSidePanel;
	JPanel WhiteBoardPanel;
	JPanel statsPanel;
	static TitledLabel currentVelocity;
	static TitledLabel currentAngularMomentum;
	static TitledLabel currentKineticEnergy;
	static TitledLabel currentPotential;
	static TitledLabel currentEffectivePotential;
	static TitledLabel currentDistance;
	static TitledLabel currentEnergy;
	static TitledLabel currentReductedMass;
	
	JMenuBar menuBar;
	static JMenu fileMenu;
	static JMenuItem newItem;
	static JMenuItem saveItem;
	static JMenuItem writeItem;
	static JMenu helpMenu;
	static JMenuItem manualItem;
	static JMenu settingsMenu;
	static JMenu languageMenu;
	static JMenuItem colorItem;
	static JMenuItem aboutItem;
	JMenuItem polishItem;
	JMenuItem englishItem;
	
	static String languageS;
	static String countryS;
	Locale language;
	ResourceBundle rBundle;
	
	
}
