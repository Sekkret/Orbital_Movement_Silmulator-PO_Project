package Equations;

import java.awt.Color;
import java.awt.Graphics2D;

public class Trajectory {
	Constans cons;
	int[] x, y;
	
	public Trajectory(Constans c) {
		x = new int[6283];
		y =new int[6283];		
		cons = c;
		
	}
	
	public void trajectory() {
		for(double ii = 0; ii < 6283; ii++) {
			x[(int) ii] = (int) (cons.P/(1 + cons.epsilon * Math.cos(ii/1000 + Math.acos((cons.P-cons.r_p)/cons.epsilon/cons.r_p)-cons.fi_0)) * Math.cos(ii/1000));
			y[(int) ii] = (int) (cons.P/(1 + cons.epsilon * Math.cos(ii/1000 + Math.acos((cons.P-cons.r_p)/cons.epsilon/cons.r_p)-cons.fi_0)) * Math.sin(ii/1000));
		}
		
	}
	
	 public void draw(Graphics2D g2d) { 
		 for(int ii = 0; ii < 6283	; ii++) {
			 if(ii>0) {
				 g2d.setColor(Color.black);
         	 g2d.drawLine(x[ii], y[ii], x[ii-1], y[ii-1]);
         
			 }
		}

     }

}
