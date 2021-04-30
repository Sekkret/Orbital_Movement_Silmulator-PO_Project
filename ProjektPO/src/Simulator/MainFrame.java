package Simulator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import BundleLanguages.BundleLanguages;
import Simulator.listeners.*;
import Whiteboard.WhiteboardPanel;

public class MainFrame extends JFrame {

	public MainFrame() throws HeadlessException {
		
		this.setSize(960, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Symulacja BETA");
		
		languageS = "pl";
		countryS = "PL";
		BundleLanguages bundle = new BundleLanguages(this);
		
		
		whiteboardPanel = new WhiteboardPanel();
		
		dataPanel = new DataPanel();
		
		leftSidePanel = new JPanel();
		leftSidePanel.setLayout(new BorderLayout());
		leftSidePanel.add(whiteboardPanel, BorderLayout.CENTER);
		leftSidePanel.add(dataPanel, BorderLayout.SOUTH);
		

		
		inputPanel = new InputPanel();
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
		rightSidePanel.setPreferredSize(new Dimension(240,600));
		
		
		
		menuBar = new BasicMenuBar();
		
		
		
		this.add(rightSidePanel, BorderLayout.EAST);
		this.add(leftSidePanel, BorderLayout.CENTER);
	 	this.setJMenuBar(menuBar);
	 	
	 	//listeners:
	 	zoomSliderListener = new OptionPanelSliderListener(this);
	 	optionPanel.zoomSlider.addChangeListener(zoomSliderListener);
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
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

		//tmpAxisManager = new AxisManager();
		//tmpAxisManager.paint(whiteboardPanel.getDrawingSpace());
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
	
	//public BasicMenuBar getMenuBar() {
	//	return menuBar;
	//}
	//****CZEMU TO NIE DZIAŁA?!!!****//

	public String getCountryS() {
		return countryS;
	}

	public String getLanguageS() {
		return languageS;
	}




	JPanel rightSidePanel;
	JPanel upperRightPanel;
	InputPanel inputPanel;
	JButton startButton;
	OptionPanel optionPanel;
	
	JPanel leftSidePanel;
	WhiteboardPanel whiteboardPanel;
	//https://docstore.mik.ua/orelly/java-ent/jfc/ch04_03.htm
	DataPanel dataPanel;
	
	BasicMenuBar menuBar;
	String countryS;
	String languageS;
	
	
	//listeners:
	OptionPanelSliderListener zoomSliderListener;
	
	



}
