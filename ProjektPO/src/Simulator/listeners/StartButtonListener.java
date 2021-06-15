package Simulator.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


import Simulator.MainFrame;
import Whiteboard.Constants;

public class StartButtonListener implements ActionListener {

	public StartButtonListener(MainFrame frame) {
		reset = true;
		this.frame=frame;
		error="";
		whatHappened="";
		thetaError="";
		notOrbital="";
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(getReset()) {
			try {
				M=Float.parseFloat(frame.inputPanel.getCentralMassInput().getText());
				m=Float.parseFloat(frame.inputPanel.getOrbitingMassInput().getText());
				x=Float.parseFloat(frame.inputPanel.getxValueInput().getText());
				theta=Float.parseFloat(frame.inputPanel.getVelocityDirectionInput().getText());
				y=Float.parseFloat(frame.inputPanel.getyValueInput().getText());
				v=Float.parseFloat(frame.inputPanel.getVelocityValueInput().getText());
				fi_0 = (x>=0)?Math.atan(y/x): Math.atan(y/x)+ Math.PI;
				System.out.println(Math.PI/180*theta);
				System.out.println(fi_0);
				if(M!=0 && m!=0 && (x!=0 || y!=0) && v!=0 && theta!=Math.toDegrees(fi_0) && theta!=(Math.toDegrees(fi_0)+180) && theta!=(Math.toDegrees(fi_0)-180)) {
					if(theta>=-90 && theta<=270) {
						frame.getWhiteboardPanel().refresh();
						frame.getWhiteboardPanel().repaint();
						reset = false;
						frame.getStartButton().setText("STOP");
						frame.getExportItemListener().setAnimationRan(true);
						}
					else {
						JOptionPane.showMessageDialog(frame, thetaError,error,JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, notOrbital,error,JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(frame, whatHappened,error,JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			frame.getStartButton().setText("START");
			frame.getWhiteboardPanel().getScheduler().shutdown();
			reset = true;
		}
	}
	
	public boolean getReset() {
		return reset;
	}
	public void setReset(boolean reset) {
		this.reset = reset;
	}
	public void setThetaError(String thetaError) {
		this.thetaError = thetaError;
	}

	public void setWhatHappened(String whatHappened) {
		this.whatHappened = whatHappened;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public void setNotOrbital(String notOrbital) {
		this.notOrbital = notOrbital;
	}
	

	MainFrame frame;
	boolean reset;
	String error,whatHappened,thetaError,notOrbital;
	float theta,M,m,x,y,v;
	double fi_0;
	
}
	

