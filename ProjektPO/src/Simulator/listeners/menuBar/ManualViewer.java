package Simulator.listeners.menuBar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Simulator.MainFrame;

@SuppressWarnings("serial")
public class ManualViewer extends JFrame implements ActionListener {

	public ManualViewer(MainFrame frame) throws HeadlessException {
		this.frame = frame;
		
		//setting the frame:
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("OMS Manual");
		this.setResizable(false);
		
		background = new JPanel();
		this.add(background, BorderLayout.CENTER);
		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		
		scrollPane = new JScrollPane(editorPane);
	    scrollPane.setPreferredSize(new Dimension(this.getWidth(),this.getHeight())); 
		
		background.add(scrollPane);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			String language = frame.getLanguageS();
			String man = null;
			if(language.equals("pl")) {
				man = "manual_pl.html";
			}
			if(language.equals("en")) {
				man = "manual_en.htm";
				
			}
			URL url = ManualViewer.class.getResource(man);
			editorPane.setPage(url);
			this.setVisible(true);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame ,
				    "Something gone wrong with loading manual",
				    "ERROR",
				    JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		
		
	}
	
	
	MainFrame frame;
	
	JEditorPane editorPane;
	JPanel background;
	JScrollPane scrollPane;
	
}
