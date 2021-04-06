package Simulator;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TitledLabel extends JPanel {

	public TitledLabel(String up, String down) {
		this.setBorder(new LineBorder(Color.black ,1));
		title = new JLabel(up);
		label = new JLabel(down);
		
		this.setLayout(new GridLayout(2,1));
		this.add(title);
		this.add(label);
	}

	public TitledLabel(String up) {
		title = new JLabel(up);
		label = new JLabel("");
		
		this.setLayout(new GridLayout(2,1));
		this.add(title);
		this.add(label);
	}
		
	public void setTitle(String text) {
		title.setText(text);
		
	}
	
	public void setLabel(String text) {
		label.setText(text);
		
	}
	
	JLabel title;
	JLabel label;
}
