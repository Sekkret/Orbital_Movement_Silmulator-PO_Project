package Simulator;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TitledTextField extends JPanel {

	public TitledTextField(String frontText, String insideText) {
		this.setLayout(new GridLayout(2,1));
				
		title = new JLabel(frontText);
		this.add(title);
		textField = new JTextField(insideText);
		this.add(textField);
	}
	public TitledTextField(String frontText) {
		this.setLayout(new GridLayout(2,1));
		
		title = new JLabel(frontText);
		this.add(title);
		textField = new JTextField();
		this.add(textField);
	}
	String getText() {
		return textField.getText();
	}
	
	public void setTitle(String text) {
		title.setText(text);
	}
	
	JLabel title;
	JTextField textField;
	
}
