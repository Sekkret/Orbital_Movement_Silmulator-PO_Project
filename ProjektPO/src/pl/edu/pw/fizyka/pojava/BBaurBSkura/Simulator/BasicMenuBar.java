//Bartłomiej Baur
package pl.edu.pw.fizyka.pojava.BBaurBSkura.Simulator;

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

	JMenuBar menuBar;
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
