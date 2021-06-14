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
		newColor=Color.WHITE;
		this.frame = frame;
		drawingSpace = null;
		
		axes = new AxesManager(2);
		trajectory = new TrajectoryManager(frame);
		blueDot = new BlueDotManager(frame);
		velocityChooser = new VelocityChooserManager(frame);
		
		mouseManager = new MouseManagement(frame);
		this.addMouseListener(mouseManager); //listener for choosing coordinates an velocity by mouse
		this.addMouseMotionListener(mouseManager);
		
		basicStroke = new BasicStroke(2);
		x =Integer.parseInt(frame.getInputPanel().getxValueInput().getText());
		y = Integer.parseInt(frame.getInputPanel().getyValueInput().getText());
	}
	
	public void paintComponent(Graphics g) {
		//Here drawing workspace creates
		drawingSpace = (BufferedImage) this.createImage(this.getWidth(), this.getHeight());
		Graphics2D gc = drawingSpace.createGraphics();
		gc.translate(this.getWidth()/2, this.getHeight()/2);
		gc.scale(1,  -1);
	    gc.setColor(newColor);
	    gc.fillRect(-this.getWidth()/2, -this.getHeight()/2, this.getWidth(), this.getHeight());
	    gc.setColor(Color.BLACK);
	    
		
	    //And here we set coordinates system and basic settings to Stroke
	    Graphics2D g2d = (Graphics2D) g;
	   
		g2d.drawImage(drawingSpace, 0, 0, this);
		g2d.translate(this.getWidth()/2, this.getHeight()/2);
		g2d.scale(1, -1);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(basicStroke);
		
		//we need center mass. This is Sun.
		g2d.setColor(Color.ORANGE);
		g2d.fillOval(-this.getWidth()/30, -this.getHeight()/30, this.getWidth()/15, this.getHeight()/15);
		g2d.setColor(Color.BLACK);
		
		//Finally, here all managers work if they're allowed to.
		if (drawAxes)
			axes.paintAxes(g2d, this.getWidth(), this.getHeight());
		
		if(drawTrajectory){		
			g2d.scale((this.getWidth()/5)/Math.pow(10, axes.getZoom()), (this.getHeight()/5)/Math.pow(10, axes.getZoom()));
			//well, thats complicated. on big zooms, it means slider is on the left side, drawn line was THICK
			g2d.setStroke(new BasicStroke((int) (3/((this.getWidth()/5)/Math.pow(10, axes.getZoom())))));
			trajectory.draw(g2d);
			g2d.scale(1/((this.getWidth()/5)/Math.pow(10, axes.getZoom())), 1/((this.getHeight()/5)/Math.pow(10, axes.getZoom())));

		}
		//drawing moving object
		blueDot.drawDot(g2d, x, y);
		
		if(drawAnimation) {
			//g2d.scale((this.getWidth()/5)/Math.pow(10, axes.getZoom()), (this.getHeight()/5)/Math.pow(10, axes.getZoom()));
			//g2d.setColor(Color.blue);			
			//g2d.fillOval((int)( x- Math.pow(10, axes.getZoom())/20) ,(int)( y- Math.pow(10, axes.getZoom())/20), (int) Math.pow(10, axes.getZoom())/10, (int) Math.pow(10, axes.getZoom())/10);
			//now using BlueDotManager:
			
			
			if(drawVelocityComponets) {
				g2d.setColor(Color.green);
				g2d.drawLine((int) x, (int) y,(int)(x+trajectory.cons.animation.vx),(int)y);
				g2d.drawLine((int) x, (int) y,(int) x,(int)(y+trajectory.cons.animation.vy));
			}
			if(drawVelocity) {
				g2d.setColor(Color.red);
				g2d.drawLine((int) x, (int) y,(int)(x+trajectory.cons.animation.vx),(int)(y+trajectory.cons.animation.vy));
			}
			
		}
		
		if(drawVelocityChooser) {
			g2d.setColor(Color.CYAN);
			velocityChooser.drawVector(g2d, x, y, xv, yv);
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
	
	public void setDrawVelocityComponets(boolean drawVelocityComponets) {
		this.drawVelocityComponets = drawVelocityComponets;
	}
	
	public void setDrawVelocity(boolean drawVelocity) {
		this.drawVelocity = drawVelocity;
	}
	
	public BlueDotManager getBlueDot() {
		return blueDot;
	}

	public void setBlueDot(BlueDotManager blueDot) {
		this.blueDot = blueDot;
	}

	public void setNewColor(Color newColor) {
		this.newColor = newColor;
	}
	public void setDrawVelocityChooser(boolean drawVelocityChooser) {
		this.drawVelocityChooser = drawVelocityChooser;
	}




	MainFrame frame;

	BufferedImage drawingSpace;
	AxesManager axes;
	TrajectoryManager trajectory;
	BlueDotManager blueDot; //blue dot manager is for the moving object
	VelocityChooserManager velocityChooser;
	
	MouseManagement mouseManager;
	
	boolean drawTrajectory  = false;
	boolean drawAnimation  = false;
	boolean drawAxes = true;
	boolean drawVelocityComponets = false;
	boolean drawVelocity = false;
	boolean drawVelocityChooser = false;
	double x,y; //for blue dot
	Color newColor;
	
	double xv, yv; //for mouse interaction with whiteboardPanel
	
	BasicStroke basicStroke;

}
