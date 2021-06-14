package Whiteboard;

import java.awt.Color;
import java.awt.Graphics2D;

import Simulator.MainFrame;

public class BlueDotManager {

	public BlueDotManager(MainFrame frame) {
		this.frame = frame;
	}
	
	public void drawDot(Graphics2D g, double x, double y) {
		
		
		int width = frame.getWhiteboardPanel().getWidth();
		int height = frame.getWhiteboardPanel().getHeight();
		int zoom = (int) frame.getWhiteboardPanel().getAxes().getZoom();
		g.scale((width/5)/Math.pow(10, zoom), (height/5)/Math.pow(10, zoom));
		g.setColor(Color.blue);
		g.fillOval((int)( x- Math.pow(10, zoom)/20) ,(int)( y- Math.pow(10, zoom)/20), (int) Math.pow(10, zoom)/10, (int) Math.pow(10, zoom)/10);
	}
	
	
	MainFrame frame;

}
