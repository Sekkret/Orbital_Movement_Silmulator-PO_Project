package Whiteboard;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import Simulator.MainFrame;

public class TrajectoryManager {
	MainFrame frame;
	Constants cons;
	int[] x, y;
	
	public TrajectoryManager(MainFrame frame) {
		this.frame = frame;
		x = new int[6283];
		y =new int[6283];		
		cons = new Constants(frame);
		
	}
	
	public void calculateTrajectory() {
		cons.calculate();
		for(double ii = 0; ii < 6283; ii++) {
			x[(int) ii] = (int) (cons.P/(1 + cons.epsilon * Math.cos(ii/1000 + Math.acos((cons.P-cons.r_p)/cons.epsilon/cons.r_p)-cons.fi_0)) * Math.cos(ii/1000));
			y[(int) ii] = (int) (cons.P/(1 + cons.epsilon * Math.cos(ii/1000 + Math.acos((cons.P-cons.r_p)/cons.epsilon/cons.r_p)-cons.fi_0)) * Math.sin(ii/1000));
		}
		
	}
	
	 public void draw(Graphics2D g2d) { 
		 for(int ii = 0; ii < 6283	; ii++) {
			 g2d.setColor(Color.black);
			 if(ii>0) {
				 //g2d.drawLine(x[ii], y[ii], x[ii-1], y[ii-1]);
				 //https://stackoverflow.com/questions/2839508/java2d-increase-the-line-width
				 g2d.draw(new Line2D.Float(x[ii], y[ii], x[ii-1], y[ii-1]));
			 }
		}

     }

}
