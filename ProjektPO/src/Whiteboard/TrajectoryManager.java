package Whiteboard;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import Simulator.MainFrame;

public class TrajectoryManager {
	MainFrame frame;
	Constants cons;
	int[] x, y;
	double[] r;
	
	public TrajectoryManager(MainFrame frame) {
		this.frame = frame;
		x = new int[62832];
		y = new int[62832];	
		r = new double[62832];	
		cons = new Constants(frame);
		
	}
	
	public void calculateTrajectory() {
		cons.calculate();
		for(double ii = 0; ii < 62832; ii++) {
			r[(int) ii] = cons.P/(1 + cons.epsilon * Math.cos(ii/10000 + Math.acos((cons.P-cons.r_p)/cons.epsilon/cons.r_p)-cons.fi_0));
			x[(int) ii] = (int) (r[(int) ii]  * Math.cos(ii/10000));
			y[(int) ii] = (int) (r[(int) ii] * Math.sin(ii/10000));
		}
		
	}
	
	 public void draw(Graphics2D g2d) { 
		 for(int ii = 0; ii < 62832	; ii++) {
			 g2d.setColor(Color.black);
			 if(ii>0) {
				 if(r[(int) ii]<0 ||r[(int) ii-1]<0) {
					 continue;
				 }
				 g2d.draw(new Line2D.Float(x[ii], y[ii], x[ii-1], y[ii-1]));
			 }
		}

     }
	 public Constants getConstans() {
		 return cons;
	 }
	 

}
