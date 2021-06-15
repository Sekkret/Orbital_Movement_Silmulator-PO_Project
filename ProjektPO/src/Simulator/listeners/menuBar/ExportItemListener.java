package Simulator.listeners.menuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Simulator.MainFrame;

public class ExportItemListener implements ActionListener{

	public ExportItemListener(MainFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(animationRan==false) {
	    	JOptionPane.showMessageDialog(frame.getWhiteboardPanel(),
				    "No data generated yet.",
				    "ERROR",
				    JOptionPane.ERROR_MESSAGE);
	    }
		else
			if(frame.getStartListener().getReset()==false) {
				frame.getStartButton().doClick(1);
			}
			JFileChooser chooser = new JFileChooser();
		    int returnVal = chooser.showSaveDialog(frame.getWhiteboardPanel());
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		       
		    	File exportFile = chooser.getSelectedFile();
		    	try {
					FileWriter fileWriter = new FileWriter(exportFile);
					fileWriter.write(frame.getWhiteboardPanel().getTrajectory().getStringWriter().toString());
					fileWriter.flush();
					fileWriter.close();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(frame.getWhiteboardPanel(),
						    "IO Exeption",
						    "ERROR",
						    JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				}
		    }
		    
	}


	
	
	public boolean isAnimationRan() {
		return animationRan;
	}

	public void setAnimationRan(boolean animationRan) {
		this.animationRan = animationRan;
	}




	MainFrame frame;
	boolean animationRan = false;

}
