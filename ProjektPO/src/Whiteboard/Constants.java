package Whiteboard;

//import static java.util.concurrent.TimeUnit.MILLISECONDS;

//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;

import Simulator.MainFrame;

public class Constants {
	//ScheduledExecutorService scheduler;
	//AnimationManager animation;
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
    	 v_fi = v * (-Math.cos(theta) * Math.sin(getFi_0()) + Math.cos(getFi_0()) * Math.sin(theta));
    	 v_r = v * (Math.cos(theta) * Math.cos(getFi_0()) + Math.sin(getFi_0()) * Math.sin(theta));
    	 r_p = Math.sqrt(x*x + y*y);
    	 L = mi * v_fi * r_p;
    	 E = mi/2 * ( v_r*v_r + v_fi*v_fi) - alpha/r_p;
    	 epsilon = Math.sqrt(1 + 2 * E * getL() * getL() /mi /alpha /alpha);
    	 P = getL() * getL() /mi /alpha;
    	 if((180/Math.PI*getFi_0()>= 0 && 180/Math.PI*getFi_0()< 90)) {
    		 if((180/Math.PI*theta>= (180/Math.PI*getFi_0()-90) && 180/Math.PI*theta<180/Math.PI*getFi_0())||(180/Math.PI*theta>= (180/Math.PI*getFi_0()+90) && 180/Math.PI*theta<180/Math.PI*getFi_0()+180)){
    			 fi_p = Math.acos((P-r_p)/epsilon/r_p)+getFi_0();
    		 }
    		 else {
    			 fi_p = -Math.acos((P-r_p)/epsilon/r_p)+getFi_0() ;
    		 }
    	 }
    	 else if((180/Math.PI*getFi_0()>= 90 && 180/Math.PI*getFi_0()<180)) {
    		 if((180/Math.PI*theta>= -90 && 180/Math.PI*theta<180/Math.PI*getFi_0()-180)||(180/Math.PI*theta>=180/Math.PI*getFi_0()-90 && 180/Math.PI*theta<180/Math.PI*getFi_0())||(180/Math.PI*theta>=180/Math.PI*getFi_0()+90 && 180/Math.PI*theta<=270)){
    			 fi_p = Math.acos((P-r_p)/epsilon/r_p)+getFi_0();
    		 }
    		 else {
    			 fi_p = -Math.acos((P-r_p)/epsilon/r_p)+getFi_0() ;
    		 }
    	 }
    	 else if((180/Math.PI*getFi_0()>=180 && 180/Math.PI*getFi_0()<270)) {
    		 if((180/Math.PI*theta>= 180/Math.PI*getFi_0()-270 && 180/Math.PI*theta<180/Math.PI*getFi_0()-180)||(180/Math.PI*theta>=180/Math.PI*getFi_0()-90 && 180/Math.PI*theta<180/Math.PI*getFi_0())){
    			 fi_p = Math.acos((P-r_p)/epsilon/r_p)+getFi_0();
    		 }
    		 else {
    			 fi_p = -Math.acos((P-r_p)/epsilon/r_p)+getFi_0() ;
    		 }
    	 }
    	 else if((180/Math.PI*getFi_0()>= -90 && 180/Math.PI*getFi_0()<0)) {
    		 if((180/Math.PI*theta>= -90 && 180/Math.PI*theta<180/Math.PI*getFi_0())||(180/Math.PI*theta>=180/Math.PI*getFi_0()+90 && 180/Math.PI*theta<180/Math.PI*getFi_0()+180)||(180/Math.PI*theta>=180/Math.PI*getFi_0()+270 && 180/Math.PI*theta<=270)){
    			 fi_p = Math.acos((P-r_p)/epsilon/r_p)+getFi_0();
    		 }
    		 else {
    			 fi_p = -Math.acos((P-r_p)/epsilon/r_p)+getFi_0() ;
    		 }
    	 }
    	 newfi = getFi_0();
    	 newr = r_p;
    	 
    	 frame.getDataPanel().getCurrentReductedMass().setLabel(Double.toString(mi));
    	 frame.getDataPanel().getCurrentEnergy().setLabel(Double.toString(E));
    	 frame.getDataPanel().getCurrentAngularMomentum().setLabel(Double.toString(L));
	}
    
	public double getL() {
		return L;
	}
	public double getFi_0() {
		return fi_0;
	}

	

}
