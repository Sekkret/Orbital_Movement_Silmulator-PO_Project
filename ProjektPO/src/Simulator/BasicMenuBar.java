package Simulator;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BasicMenuBar extends JMenuBar {
	public BasicMenuBar() {
		
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
		englishItem = new JMenuItem("english");
		settingsMenu.add(languageMenu);
		settingsMenu.add(colorItem);
		languageMenu.add(polishItem);
		languageMenu.add(englishItem);
		
		this.add(fileMenu);
		this.add(helpMenu);
		this.add(settingsMenu);
	}
	
		
	public JMenu getFileMenu() {
		return fileMenu;
	}
	public JMenuItem getNewItem() {
		return newItem;
	}
	public JMenuItem getSaveItem() {
		return saveItem;
	}
	public JMenuItem getWriteItem() {
		return writeItem;
	}
	public JMenu getHelpMenu() {
		return helpMenu;
	}
	public JMenuItem getManualItem() {
		return manualItem;
	}
	public JMenu getSettingsMenu() {
		return settingsMenu;
	}
	public JMenu getLanguageMenu() {
		return languageMenu;
	}
	public JMenuItem getColorItem() {
		return colorItem;
	}
	public JMenuItem getAboutItem() {
		return aboutItem;
	}
	public JMenuItem getEnglishItem() {
		return englishItem;
	}
	public JMenuItem getPolishItem() {
		return polishItem;
	}


	JMenu fileMenu;
	JMenuItem newItem;
	JMenuItem saveItem;
	JMenuItem writeItem;
	JMenu helpMenu;
	JMenuItem manualItem;
	JMenu settingsMenu;
	JMenu languageMenu;
	JMenuItem colorItem;
	JMenuItem aboutItem;
	JMenuItem englishItem;
	JMenuItem polishItem;
}

