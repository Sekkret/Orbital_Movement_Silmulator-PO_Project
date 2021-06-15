package Whiteboard;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Simulator.MainFrame;

public class MouseManagement extends MouseAdapter {

	public MouseManagement(MainFrame frame) {
		this.frame = frame;
	}
	
	public void mousePressed(MouseEvent e) {
		//in first step we get x1 and y1 from mouse pointer coords.
		//we instantly transform coors do the system with the beginning in the center of whiteboardPanel
		//but still they are in pixels
		int width = frame.getWhiteboardPanel().getWidth();
		int height = frame.getWhiteboardPanel().getHeight();
		x1 = (e.getX()-width/2);
		y1 = -(e.getY()-height/2);
		//now we transform value in pixels to value in meters
		//according to currend zoom on zoomSlider
		int zoom = frame.getOptionPanel().getZoomSlider().getValue();
		//each axis is divided on 10 parts but one [meter * 10^zoom] is 2 parts
		//divide by width/2 or height/2 to remove pixels as unit
		//muliply by 2.5 because one full value is 2.5 [meters*10^zoom]
		//expression simplified
		x1 = (5 * x1/width) * Math.pow(10,zoom);
		y1 = (5 * y1/height) * Math.pow(10,zoom);
		
		//now we have the initial position of moving object
		//we'll need x1 and y1 later after release of the mouse button for velocity 
		frame.getInputPanel().getxValueInput().setText(String.valueOf(x1));
		frame.getInputPanel().getyValueInput().setText(String.valueOf(y1));
		
		//drawing blue dot
		frame.getWhiteboardPanel().x = x1;
		frame.getWhiteboardPanel().y = y1;
		frame.getWhiteboardPanel().repaint();
		frame.getWhiteboardPanel().setDrawVelocityChooser(true);
	}
	
	public void mouseDragged(MouseEvent e) {
		int width = frame.getWhiteboardPanel().getWidth();
		int height = frame.getWhiteboardPanel().getHeight();
		double x = (e.getX()-width/2);
		double y = -(e.getY()-height/2);
		int zoom = frame.getOptionPanel().getZoomSlider().getValue();
		x = (5 * x/width) * Math.pow(10,zoom);
		y = (5 * y/height) * Math.pow(10,zoom);
		
		frame.getWhiteboardPanel().xv = x;
		frame.getWhiteboardPanel().yv = y;
		frame.getWhiteboardPanel().repaint();
	}
	
	public void mouseReleased(MouseEvent e) {
		//we need to transform x2 and y2 in the same way - to meters in centered coordinate system
		int width = frame.getWhiteboardPanel().getWidth();
		int height = frame.getWhiteboardPanel().getHeight();
		x2 = (e.getX()-width/2);
		y2 = -(e.getY()-height/2);
		int zoom = frame.getOptionPanel().getZoomSlider().getValue();
		x2 = (5 * x2/width) * Math.pow(10,zoom);
		y2 = (5 * y2/height) * Math.pow(10,zoom);
		
		//now we calculate velocity
		// one meter of movement will be one meter per second
		
		v = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
		
		//theta is more tricky, because it is arctan(dx/dy)
		//but arctan has values from -90 deg to 90 deg
		//thats why we need do many "if" instructions
		if(x2>x1 && y2>=y1) { // theta in [0, 90 deg)
			theta = Math.toDegrees( Math.atan((y2-y1)/(x2-x1)) );
		}
		else if(x2==x1 && y2>y1) { //theta=90 deg
			theta = 90;
		}
		else if(x2<x1 && y2>=y1) { //theta in (90 deg, 180 deg]
			theta = 180 - Math.toDegrees( Math.atan((y2-y1)/(x1-x2)) ); //note inverted x1 with x2
		}
		else if(x2<x1 && y2<y1) { //theta in (180 deg, 270 deg)
			theta = 270 - Math.toDegrees( Math.atan((y1-y2)/(x1-x2)) ); //note inverted x1 with x2 and y1 with y2
		}
		else if(x2==x1 && y2<y1) { //theta=270 deg
			theta = 270;
		}
		else if(x2>x1 && y2<y1) { //theta in (270 deg, 360 deg)
			theta = 360 - Math.toDegrees( Math.atan((y1-y2)/(x2-x1)) ); //note inverted y1 with y2
		}
		else if(x2==x1 && y2==y1) { //an extreme case to deal with
			theta = 0; //only to avoid bugs
		}
		
		//finally we can update text areas
		frame.getInputPanel().getVelocityValueInput().setText(String.valueOf(v));
		frame.getInputPanel().getVelocityDirectionInput().setText(String.valueOf(theta));
		frame.getWhiteboardPanel().setDrawVelocityChooser(false);
	}
	
	
	MainFrame frame;
	double x1;
	double y1;
	double x2;
	double y2;
	double v;
	double theta;
	
}
