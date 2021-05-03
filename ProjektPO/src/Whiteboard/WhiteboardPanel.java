package Whiteboard;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import Simulator.MainFrame;

@SuppressWarnings("serial")
public class WhiteboardPanel extends JPanel {

	
	public WhiteboardPanel(MainFrame frame) {
		this.frame = frame;
		drawingSpace = null;
		axes = new AxesManager(2);
		trajectory = new TrajectoryManager(frame);		
		basicStroke = new BasicStroke(2);
		x =100;
		y = Integer.parseInt(frame.getInputPanel().getyValueInput().getText());
	}
	
	public void paintComponent(Graphics g) {
		//Here drawing workspace creates
		drawingSpace = (BufferedImage) this.createImage(this.getWidth(), this.getHeight());
		Graphics2D gc = drawingSpace.createGraphics();
		gc.translate(this.getWidth()/2, this.getHeight()/2);
		gc.scale(1,  -1);
	    gc.setColor(Color.WHITE);
	    gc.fillRect(-this.getWidth()/2, -this.getHeight()/2, this.getWidth(), this.getHeight());
	    gc.setColor(Color.BLACK);
		
	    //And here we set coordinates system and basic settings to Stroke
	    Graphics2D g2d = (Graphics2D) g;
	   
		g2d.drawImage(drawingSpace, 0, 0, this);
		g2d.translate(this.getWidth()/2, this.getHeight()/2);
		g2d.scale(1, -1);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(basicStroke);
		
		//Finally, here all managers work if they're allowed to.
		if (drawAxes)
			axes.paintAxes(g2d, this.getWidth(), this.getHeight());
		
		if(drawTrajectory){
			
			g2d.scale((this.getWidth()/5)/Math.pow(10, axes.getZoom()), (this.getHeight()/5)/Math.pow(10, axes.getZoom()));
			//well, thats complicated. on big zooms, it means slider is on the lef side, drawn line was THICK
			g2d.setStroke(new BasicStroke((int) (3/((this.getWidth()/5)/Math.pow(10, axes.getZoom())))));
			trajectory.draw(g2d);
			g2d.scale(1/((this.getWidth()/5)/Math.pow(10, axes.getZoom())), 1/((this.getHeight()/5)/Math.pow(10, axes.getZoom())));

		}
		if(drawAnimation) {
			g2d.scale((this.getWidth()/5)/Math.pow(10, axes.getZoom()), (this.getHeight()/5)/Math.pow(10, axes.getZoom()));
			g2d.setColor(Color.blue);
			g2d.fillOval((int)( x- Math.pow(10, axes.getZoom())/20) ,(int)( y- Math.pow(10, axes.getZoom())/20), (int) Math.pow(10, axes.getZoom())/10, (int) Math.pow(10, axes.getZoom())/10);
		}

	}
	//This function runs for example after clicking the start button. It update data in WhiteboarPanel, e.g:
	public void refresh() {
		trajectory.calculateTrajectory(); //recalculate the trajectory
	}
	

	
	
	public BufferedImage getDrawingSpace() {
		return drawingSpace;
	}
	
	public TrajectoryManager getTrajectory() {
		return trajectory;
	}
	
	public void setDrawingSpace(BufferedImage newSpace) {
		drawingSpace = newSpace;
	}
	public AxesManager getAxes() {
		return axes;
	}
	 
	public void setDrawTrajectory(boolean b) {
		drawTrajectory = b;
	}
	public boolean isDrawAxes() {
		return drawAxes;
	}

	public void setDrawAxes(boolean drawAxes) {
		this.drawAxes = drawAxes;
	}

	
	public void setDrawAnimation(boolean drawAnimation) {
		this.drawAnimation = drawAnimation;
	}


	MainFrame frame;

	public BufferedImage drawingSpace;
	AxesManager axes;
	TrajectoryManager trajectory;
	
	boolean drawTrajectory  = false;
	boolean drawAnimation  = false;
	boolean drawAxes = true;
	public double x,y;
	
	BasicStroke basicStroke;

}
