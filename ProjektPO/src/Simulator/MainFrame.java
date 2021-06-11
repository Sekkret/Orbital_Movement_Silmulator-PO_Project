package Simulator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import BundleLanguages.BundleLanguages;
import Simulator.listeners.OptionPanelCheckboxShowAxisListener;
import Simulator.listeners.OptionPanelCheckboxShowTrajectoryListener;
import Simulator.listeners.OptionPanelCheckboxShowVelocity;
import Simulator.listeners.OptionPanelCheckboxShowVelocityComponents;
import Simulator.listeners.OptionPanelSliderListener;
import Simulator.listeners.StartButtonListener;
import Whiteboard.TrajectoryManager;
import Whiteboard.WhiteboardPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	public MainFrame() throws HeadlessException {
		
		this.setSize(960, 600);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setTitle("Symulacja BETA");
		this.addWindowListener(new WindowAdapter(){
			@Override
		    public void windowClosing(WindowEvent windowEvent) {
				if(startButton.getText()=="RESET")
					whiteboardPanel.getTrajectory().getConstants().getScheduler().shutdown();
				System.exit(0);
		    }
		});
		
		languageS = "pl";
		countryS = "PL";
		BundleLanguages bundle = new BundleLanguages(this);
		
		
		
		dataPanel = new DataPanel();
		
		leftSidePanel = new JPanel();
		leftSidePanel.setLayout(new BorderLayout());
	
		leftSidePanel.add(dataPanel, BorderLayout.SOUTH);
		

		
		inputPanel = new InputPanel();
		
		whiteboardPanel = new WhiteboardPanel(this);
		leftSidePanel.add(whiteboardPanel, BorderLayout.CENTER);
		
		startButton = new JButton("START");
		upperRightPanel = new JPanel();
		upperRightPanel.setLayout(new BorderLayout());
		upperRightPanel.add(inputPanel, BorderLayout.CENTER);
		upperRightPanel.add(startButton, BorderLayout.SOUTH);
		
		optionPanel = new OptionPanel();
		
		rightSidePanel = new JPanel();
		rightSidePanel.setLayout(new BorderLayout());
		rightSidePanel.add(upperRightPanel, BorderLayout.CENTER);
		rightSidePanel.add(optionPanel, BorderLayout.SOUTH);
		
		
		
		
		menuBar = new BasicMenuBar();
		
		
		
		this.add(rightSidePanel, BorderLayout.EAST);
		this.add(leftSidePanel, BorderLayout.CENTER);
	 	this.setJMenuBar(menuBar);
	 	
	 	//listeners:
	 	optionPanel.zoomSlider.addChangeListener(new OptionPanelSliderListener(this));
	 	optionPanel.axisDisplay.addActionListener(new OptionPanelCheckboxShowAxisListener(this));
	 	optionPanel.trajectoryDisplay.addActionListener(new OptionPanelCheckboxShowTrajectoryListener(this));
	 	optionPanel.velocityComponentsDisplay.addActionListener(new OptionPanelCheckboxShowVelocityComponents(this));
	 	optionPanel.velocityDisplay.addActionListener(new OptionPanelCheckboxShowVelocity(this));
	 	startListener = new StartButtonListener(this);
	 	startButton.addActionListener(getStartListener());
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	//languages management:
	 	
	 	bundle.changeLanguage();
	 	
	 	ActionListener englishLanguageListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				languageS = "en";
				countryS = "US";
				bundle.changeLanguage();

			}	
		};
		menuBar.englishItem.addActionListener(englishLanguageListener );
		
		ActionListener polishLanguageListener  = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				languageS = "pl";
				countryS = "PL";
				bundle.changeLanguage();
			}
		};
		menuBar.polishItem.addActionListener(polishLanguageListener );
		
		ActionListener colorListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				whiteboardPanel.setNewColor(JColorChooser.showDialog(null, "Hello", Color.blue));
				whiteboardPanel.repaint();
			}	
		};
		menuBar.colorItem.addActionListener(colorListener);
		
		ActionListener newListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(startListener.getReset()==false) {
					startButton.doClick(1);
				}
				SwingUtilities.invokeLater(new Runnable(){
					@Override
					public void run() {
						inputPanel.xValueInput.setText("160");
						inputPanel.yValueInput.setText("30");
						inputPanel.centralMassInput.setText("10000000000000");
						inputPanel.orbitingMassInput.setText("20000000000000000");
						inputPanel.velocityValueInput.setText("80");
						inputPanel.velocityDirectionInput.setText("57");	
						dataPanel.currentDistance.setLabel("0");
						dataPanel.currentEffectivePotential.setLabel("0");
						dataPanel.currentEnergy.setLabel("0");					
						dataPanel.currentKineticEnergy.setLabel("0");
						dataPanel.currentPotential.setLabel("0");
						dataPanel.currentReductedMass.setLabel("0");
						dataPanel.currentVelocity.setLabel("0");
						dataPanel.currentAngularMomentum.setLabel("0");
						whiteboardPanel.setDrawAnimation(false);
						
						for(double ii = 0; ii < 62832; ii++) {
							whiteboardPanel.getTrajectory().getR()[(int) ii] =0;
							whiteboardPanel.getTrajectory().getX()[(int) ii] = 0;
							whiteboardPanel.getTrajectory().getY()[(int) ii] = 0;
						}
						whiteboardPanel.repaint();
						}
					});
				
				}
			
		};
		menuBar.newItem.addActionListener(newListener);
		
		
		//startButton.addActionListener(constants.startListener);
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
	
	


	public InputPanel getInputPanel() {
		return inputPanel;
	}

	public JButton getStartButton() {
		return startButton;
	}

	public OptionPanel getOptionPanel() {
		return optionPanel;
	}

	public WhiteboardPanel getWhiteboardPanel() {
		return whiteboardPanel;
	}

	public DataPanel getDataPanel() {
		return dataPanel;
	}
	
	public BasicMenuBar getBasicMenuBar() {
		return menuBar;
	}

	public String getCountryS() {
		return countryS;
	}

	public String getLanguageS() {
		return languageS;
	}




	public StartButtonListener getStartListener() {
		return startListener;
	}




	JPanel rightSidePanel;
	JPanel upperRightPanel;
	public InputPanel inputPanel;
	JButton startButton;
	OptionPanel optionPanel;
	
	JPanel leftSidePanel;
	WhiteboardPanel whiteboardPanel;
	//https://docstore.mik.ua/orelly/java-ent/jfc/ch04_03.htm
	DataPanel dataPanel;
	
	BasicMenuBar menuBar;
	String countryS;
	String languageS;
	StartButtonListener startListener;
	
	



}
