package Whiteboard;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.io.StringWriter;

import Simulator.MainFrame;

public class TrajectoryManager {
	MainFrame frame;
	Constants cons;
	int[] x;
	int[] y;
	double[] r;
	StringWriter stringWriter;
	
	public TrajectoryManager(MainFrame frame) {
		this.frame = frame;
		x = new int[62832];
		y = new int[62832];	
		r = new double[62832];	
		cons = new Constants(frame);
		stringWriter = new StringWriter();
		
	}
	
	public void calculateTrajectory() {
		cons.calculate();
		for(double ii = 0; ii < 62832; ii++) {
			getR()[(int) ii] = cons.P/(1 + cons.epsilon * Math.cos(ii/10000 - cons.fi_p));
			getX()[(int) ii] = (int) (getR()[(int) ii]  * Math.cos(ii/10000));
			getY()[(int) ii] = (int) (getR()[(int) ii] * Math.sin(ii/10000));
		}
		
	}
	
	
	//here i prepare to save data. I create StringRiderto hold history of animation.
	public void prepareStringReader() {
		stringWriter.flush();
		stringWriter.getBuffer().setLength(0);
		System.out.println(stringWriter.toString());
		stringWriter.write("Orbital Movement Simulator for PO project \n");
		stringWriter.write("Central mass: ");
		stringWriter.write(String.valueOf(cons.M));
		stringWriter.write("\nOrbiting mass: ");
		stringWriter.write(String.valueOf(cons.m));
		stringWriter.write("\nAngular momentum: ");
		stringWriter.write(String.valueOf(cons.L));
		stringWriter.write("\nOrbit parameters: P=");
		stringWriter.write(String.valueOf(cons.P));
		stringWriter.write(", epsilon=");
		stringWriter.write(String.valueOf(cons.epsilon));
		stringWriter.write("\n----------------------------\n");
		stringWriter.write("x,y,v,theta,T,V,Veff\n");
	}
	
	 public void draw(Graphics2D g2d) { 
		 for(int ii = 0; ii < 62832	; ii++) {
			 g2d.setColor(Color.black);
			 if(ii>0) {
				 if(getR()[(int) ii]<0 ||getR()[(int) ii-1]<0) {
					 continue;
				 }
				 g2d.draw(new Line2D.Float(getX()[ii], getY()[ii], getX()[ii-1], getY()[ii-1]));
			 }
		}

     }
	 public Constants getConstants() {
		 return cons;
	 }

	public double[] getR() {
		return r;
	}

	public int[] getY() {
		return y;
	}

	public int[] getX() {
		return x;
	}

	public StringWriter getStringWriter() {
		return stringWriter;
	}

	public void setStringWriter(StringWriter stringWriter) {
		this.stringWriter = stringWriter;
	}
	

	 

}
