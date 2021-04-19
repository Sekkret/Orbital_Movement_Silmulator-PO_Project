package Simulator;

import java.awt.Frame;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSlider;

import Whiteboard.WhiteboardPanel;

public class Getters { //Poprzenosiłem gettery do róznych klas. Nie ma ich nawału w MainFrame, ale też nie kole mnie w oko xdd
	MainFrame main; //Nie wiem, dlaczego getter dla BasicMenuBar nie działa prawidłowo

	public Getters(MainFrame frame) {
		main = frame;
	}

	public JMenuItem getNewItem() {
		return main.menuBar.newItem;
	}
	public JMenuItem getSaveItem() {
		return main.menuBar.saveItem;
	}
	public JMenuItem getWriteItem() {
		return main.menuBar.writeItem;
	}
	public JMenuItem getAboutItem() {
		return main.menuBar.aboutItem;
	}
	public JMenuItem getColorItem() {
		return main.menuBar.colorItem;
	}
	public JMenuItem getManualItem() {
		return main.menuBar.manualItem;
	}
	
	public JMenu getLanguageMenu() {
		return main.menuBar.languageMenu;
	}
	public JMenu getFileMenu() {
		return main.menuBar.fileMenu;
	}
	public JMenu getHelpMenu() {
		return main.menuBar.helpMenu;
	}
	public JMenu getSettingsMenu() {
		return main.menuBar.settingsMenu;
	}
	
}
