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
				
		title = new JLabel(frontText,JLabel.CENTER);
		this.add(title);
		textField = new JTextField(insideText);
		this.add(textField);
		this.setBorder(new LineBorder(Color.BLACK ,1));
	}
	
	
	public TitledTextField(String frontText) {
		this.setLayout(new GridLayout(2,1));
		
		title = new JLabel(frontText);
		this.add(title);
		textField = new JTextField();
		this.add(textField);
	}
	
	public String getTitle() {
		return title.getText();
	}
	
	String getText() {
		return textField.getText();
	}
	
	
	public void setTitle(String title) {
		this.title.setText(title);
	}


	public void setText(String textField) {
		this.textField.setText(textField);
	}


	JLabel title;
	JTextField textField;
	
}
