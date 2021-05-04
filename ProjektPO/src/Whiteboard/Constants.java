package Whiteboard;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import Simulator.MainFrame;

public class Constants {
	ScheduledExecutorService scheduler;
	AnimationManager animation;
	double mi, m, M, alpha, L, r_p, v, fi_0, x, y, theta, v_fi, v_r, E, epsilon, P, newfi, newr, fi_p;
	final static double G = 6.6743015 * Math.pow(10, -11);
	MainFrame frame;
	
	public Constants(MainFrame f) {
	frame = f;
	
	} 
	public void calculate() {
		 m = Double.parseDouble(frame.getInputPanel().getOrbitingMassInput().getText()); 
    	 M = Double.parseDouble(frame.getInputPanel().getCentralMassInput().getText()); 
    	 v = Double.parseDouble(frame.getInputPanel().getVelocityValueInput().getText()); 
    	 theta = Math.PI/180*Double.parseDouble(frame.getInputPanel().getVelocityDirectionInput().getText());  
    	 x = Double.parseDouble(frame.getInputPanel().getxValueInput().getText()); 
    	 y = Double.parseDouble(frame.getInputPanel().getyValueInput().getText()); 
    	 alpha = M*m*G;
    	 
    	 fi_0 = (x>=0)?Math.atan(y/x): Math.atan(y/x)+ Math.PI;
    	 mi = M*m/(m+M);
    	 v_fi = v * (-Math.cos(theta) * Math.sin(fi_0) + Math.cos(fi_0) * Math.sin(theta));
    	 v_r = v * (Math.cos(theta) * Math.cos(fi_0) + Math.sin(fi_0) * Math.sin(theta));
    	 r_p = Math.sqrt(x*x + y*y);
    	 L = mi * v_fi * r_p;
    	 E = mi/2 * ( v_r*v_r + v_fi*v_fi) - alpha/r_p;
    	 epsilon = Math.sqrt(1 + 2 * E * L * L /mi /alpha /alpha);
    	 P = L * L /mi /alpha;
    	 fi_p = Math.acos((P-r_p)/epsilon/r_p)-fi_0;
    	 
    	 newfi = fi_0;
    	 newr = r_p;
    	 
    	 frame.getDataPanel().getCurrentReductedMass().setLabel(Double.toString(mi));
    	 frame.getDataPanel().getCurrentEnergy().setLabel(Double.toString(E));
    	 frame.getDataPanel().getCurrentAngularMomentum().setLabel(Double.toString(L));
    	 
    	animation = new AnimationManager(this);
    	scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(animation, 0, 1, MILLISECONDS);
        

	}
	public AnimationManager getAnimationManager(){
		return animation;
	}
	
	public ScheduledExecutorService getScheduler(){
		return scheduler;
	}

	

}
