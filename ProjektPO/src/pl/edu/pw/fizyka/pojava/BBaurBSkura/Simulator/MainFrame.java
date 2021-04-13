//Bartłomiej Baur
package pl.edu.pw.fizyka.pojava.BBaurBSkura.Simulator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import pl.edu.pw.fizyka.pojava.BBaurBSkura.BundleLanguages.BundleLanguages;

public class MainFrame extends JFrame {

	public MainFrame() throws HeadlessException {
		
		this.setSize(960, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Symulacja BETA");
		
		languageS = "pl";
		countryS = "PL";
		BundleLanguages bundle = new BundleLanguages(this);
		
		
		WhiteBoardPanel = new JPanel();
		WhiteBoardPanel.setBackground(Color.WHITE);
		
		dataPanel = new DataPanel();
		
		leftSidePanel = new JPanel();
		leftSidePanel.setLayout(new BorderLayout());
		leftSidePanel.add(WhiteBoardPanel, BorderLayout.CENTER);
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
	InputPanel inputPanel;
	JButton startButton;
	OptionPanel optionPanel;
	
	JPanel leftSidePanel;
	JPanel WhiteBoardPanel;
	DataPanel dataPanel;
	
	BasicMenuBar menuBar;
	String countryS;
	String languageS;
	



}
