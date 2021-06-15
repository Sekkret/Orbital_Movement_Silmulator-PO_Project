package Simulator.listeners.menuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import Simulator.MainFrame;

public class NewItemListener implements ActionListener{

	public NewItemListener(MainFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(frame.getStartListener().getReset()==false) {
			frame.getStartButton().doClick(1);
		}
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				frame.getInputPanel().getxValueInput().setText("160");
				frame.getInputPanel().getyValueInput().setText("30");
				frame.getInputPanel().getCentralMassInput().setText("10000000000000");
				frame.getInputPanel().getOrbitingMassInput().setText("20000000000000000");
				frame.getInputPanel().getVelocityValueInput().setText("80");
				frame.getInputPanel().getVelocityDirectionInput().setText("57");	
				frame.getDataPanel().currentDistance.setLabel("0");
				frame.getDataPanel().currentEffectivePotential.setLabel("0");
				frame.getDataPanel().currentEnergy.setLabel("0");					
				frame.getDataPanel().currentKineticEnergy.setLabel("0");
				frame.getDataPanel().currentPotential.setLabel("0");
				frame.getDataPanel().currentReductedMass.setLabel("0");
				frame.getDataPanel().currentVelocity.setLabel("0");
				frame.getDataPanel().currentAngularMomentum.setLabel("0");
				
				for(double ii = 0; ii < 62832; ii++) {
					frame.getWhiteboardPanel().getTrajectory().getR()[(int) ii] =0;
					frame.getWhiteboardPanel().getTrajectory().getX()[(int) ii] = 0;
					frame.getWhiteboardPanel().getTrajectory().getY()[(int) ii] = 0;
				}
				frame.getWhiteboardPanel().setBlueDotX(160);
				frame.getWhiteboardPanel().setBlueDotY(30);
				frame.getWhiteboardPanel().repaint();
				
			}
		});
	}
	
	MainFrame frame;	

}

	
