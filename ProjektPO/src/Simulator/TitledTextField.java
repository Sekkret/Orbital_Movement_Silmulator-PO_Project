package Simulator;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class TitledTextField extends JPanel {

	public TitledTextField(String frontText, String insideText) {
		this.setLayout(new GridLayout(2,1));
				
		title = new JLabel(frontText);
		title.setBorder(new LineBorder(Color.black ,1));
		this.add(title);
		textField = new JTextField(insideText);
		textField.setBorder(new LineBorder(Color.black ,1));
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
