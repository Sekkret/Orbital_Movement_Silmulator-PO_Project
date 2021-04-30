package Equations;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.JColorChooser;
import javax.swing.SwingUtilities;

import Simulator.MainFrame;

public class Constans {
	double mi, m, M, alpha, L, r_p, v, fi_0, x, y, theta, v_fi, v_r, E, epsilon, P, newfi, newr;
	MainFrame frame;
	public ActionListener startListener;
	public Trajectory t;
	
	public Constans(MainFrame f) {
		
	frame = f;
	t = new Trajectory(this);	
		
		startListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 m = Double.parseDouble(frame.getInputPanel().getOrbitingMassInput().getText());
	        	 M = Double.parseDouble(frame.getInputPanel().getCentralMassInput().getText());
	        	 v = Double.parseDouble(frame.getInputPanel().getVelocityValueInput().getText());  
	        	 theta = Double.parseDouble(frame.getInputPanel().getVelocityDirectionInput().getText()); 
	        	 x = Double.parseDouble(frame.getInputPanel().getxValueInput().getText()); 
	        	 y = Double.parseDouble(frame.getInputPanel().getyValueInput().getText()); 
	        	 alpha = M*m*6.67*Math.pow(10, -11);
	        	 
	        	 
	        	 fi_0 = (x>=0)?Math.atan(y/x): Math.atan(y/x)+ Math.PI;
	        	 mi = M*m/(m+M);
	        	 v_fi = v * (-Math.cos(theta) * Math.sin(fi_0) + Math.cos(fi_0) * Math.sin(theta));
	        	 v_r = v * (Math.cos(theta) * Math.cos(fi_0) + Math.sin(fi_0) * Math.sin(theta));
	        	 r_p = Math.sqrt(x*x + y*y);
	        	 L = mi * v_fi * r_p;
	        	 E = mi/2 * ( v_r*v_r + v_fi*v_fi) - alpha/r_p;
	        	 epsilon = Math.sqrt(1 + 2 * E * L * L /mi /alpha /alpha);
	        	 P = L * L /mi /alpha;
	        	 
	        	 
	        	 newfi = fi_0;
	        	 newr = r_p;
	        	 
	        	 
	        	 frame.getDataPanel().getCurrentReductedMass().setLabel(Double.toString(mi));
	        	 frame.getDataPanel().getCurrentAngularMomentum().setLabel(Double.toString(L));  
	        	 frame.getDataPanel().getCurrentEnergy().setLabel(Double.toString(E));
	        	 
	        	 t.trajectory();
	        	 frame.getWhiteboardPanel().setDrawTrajectory(true);
	        	 frame.getWhiteboardPanel().repaint();
	        	
	        
	        	
			}	
		};
		
		
	} 
	
	
	
	
	
	

}
