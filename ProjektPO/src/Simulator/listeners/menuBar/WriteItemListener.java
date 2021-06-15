package Simulator.listeners.menuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Simulator.MainFrame;
//B.Baur
public class WriteItemListener implements ActionListener {

	public WriteItemListener(MainFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(frame.getStartListener().getReset()==false) {
			frame.getStartButton().doClick(1);
		}
		
		
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Orbital Movement Simulatotor", "oms", "txt");
		    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(frame.getWhiteboardPanel());
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       
	    	
	    	File readFile = chooser.getSelectedFile();
	    	try {
				BufferedReader reader= new BufferedReader(new FileReader(readFile));
				frame.getInputPanel().getCentralMassInput().setText(reader.readLine());
				frame.getInputPanel().getOrbitingMassInput().setText(reader.readLine());
				frame.getInputPanel().getxValueInput().setText(reader.readLine());
				frame.getInputPanel().getyValueInput().setText(reader.readLine());
				frame.getInputPanel().getVelocityValueInput().setText(reader.readLine());
				frame.getInputPanel().getVelocityDirectionInput().setText(reader.readLine());
				
				
				reader.close();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(frame.getWhiteboardPanel(),
					    "IO Exeption",
					    "ERROR",
					    JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
	    }
		
	}
	
	MainFrame frame;
}
