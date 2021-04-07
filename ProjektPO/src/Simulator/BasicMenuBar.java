package Simulator;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BasicMenuBar extends JMenuBar {

	public BasicMenuBar() {
		
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
		
		languageItem = new JMenuItem("Język");
		colorItem = new JMenuItem("Kolor");
		settingsMenu = new JMenu("Ustawienia");
		settingsMenu.add(languageItem);
		settingsMenu.add(colorItem);
		
		this.add(fileMenu);
		this.add(helpMenu);
		this.add(settingsMenu);
	}

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
