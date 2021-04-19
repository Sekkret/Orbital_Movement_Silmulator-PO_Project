package Whiteboard;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class AxesManager {
	
	public AxesManager() {
		this.zoom=1;
		basicStroke = new BasicStroke(2);
	}
	public AxesManager(int zoom) {
		this.zoom = zoom;
	}
	
	public void paintAxes(Graphics2D g, int width, int height) {
		g.translate(width/2, height/2);
		g.scale(1, -1);
		g.setColor(Color.BLACK);

		g.setStroke(basicStroke);
		g.drawLine(-width/2, 0, width/2, 0);
		g.drawLine(0, -height/2, 0, height/2);
		g.drawLine((width/2)-(width/50), height/50, width/2, 0);
		g.drawLine((width/2)-(width/50), -height/50, width/2, 0);
		g.drawLine(0, height/2, -width/80, (height/2)-(height/50)); 
		g.drawLine(0, height/2, width/80, (height/2)-(height/50)); 
		g.drawString("X", width/2-20, height/20);
		g.scale(1, -1);
		g.drawString("Y", width/30, -height/2+10);
		g.scale(1, -1);
		
		g.drawLine((width/2)/(10*zoom), height/50, (width/2)/(10*zoom), -height/50);
	}
	
	public void setZoom(int zoom) {
		this.zoom = zoom;
	}
	
	public int getZoom() {
		return zoom;
	}
	int zoom;
	BasicStroke basicStroke;
}
