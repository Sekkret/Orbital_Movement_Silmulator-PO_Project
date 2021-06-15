package Simulator.listeners.menuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Simulator.MainFrame;
//B.Baur
public class SaveItemListener implements ActionListener{

	public SaveItemListener(MainFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(frame.getStartListener().getReset()==false) {
			frame.getStartButton().doClick(1);
		}
		
		
		JFileChooser chooser = new JFileChooser();
		chooser.setSelectedFile(new File("newSave.oms"));
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Orbital Movement Simulatotor", "oms", "txt");
		    chooser.setFileFilter(filter);
	    int returnVal = chooser.showSaveDialog(frame.getWhiteboardPanel());
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       
	    	
	    	File saveFile = chooser.getSelectedFile();
	    	try {
				FileWriter fileWriter = new FileWriter(saveFile);
				fileWriter.write(frame.getInputPanel().getCentralMassInput().getText()+"\n");
				fileWriter.write(frame.getInputPanel().getOrbitingMassInput().getText()+"\n");
				fileWriter.write(frame.getInputPanel().getxValueInput().getText()+"\n");
				fileWriter.write(frame.getInputPanel().getyValueInput().getText()+"\n");
				fileWriter.write(frame.getInputPanel().getVelocityValueInput().getText()+"\n");
				fileWriter.write(frame.getInputPanel().getVelocityDirectionInput().getText());
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
	
	MainFrame frame;

}
