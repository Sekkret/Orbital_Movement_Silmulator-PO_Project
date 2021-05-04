package Whiteboard;

import java.awt.Graphics2D;

public class AxesManager {
	
	public AxesManager() {
		this.zoom=1;
	}
	public AxesManager(int zoom) {
		this.zoom = zoom;
	}
	
	public void paintAxes(Graphics2D g, int width, int height) {

		g.drawLine(-width/2, 0, width/2, 0);
		g.drawLine(0, -height/2, 0, height/2);
		g.drawLine((width/2)-(width/50), height/50, width/2, 0);
		g.drawLine((width/2)-(width/50), -height/50, width/2, 0);
		g.drawLine(0, height/2, -width/80, (height/2)-(height/50)); 
		g.drawLine(0, height/2, width/80, (height/2)-(height/50)); 
		
		g.scale(1, -1);
		g.drawString("X", width/2-20, -height/20);
		g.drawString("[m]"+"*10^"+String.valueOf(zoom), width/2-80, height/20);
		g.drawString("Y", -20, -height/2+10);
		g.drawString("[m]"+"*10^"+String.valueOf(zoom), 20, -height/2+10);

		for(int i=-4; i<5; i++) {
			g.drawLine(i*width/10, 10, i*width/10, -10);
			g.drawLine(10, i*height/10, -10, i*height/10);
			if(i!=0) {
				g.drawString(String.valueOf((double)i/2), i*width/10-5, -18);
				g.drawString(String.valueOf((double)-i/2), 15, i*height/10);
			}
		}
		g.drawString("0", 5, -5);
		g.scale(1,  -1);
		
		
		
	}
	
	public void setZoom(double zoom) {
		this.zoom = zoom;
	}
	
	public double getZoom() {
		return zoom;
	}
	double zoom;
}
