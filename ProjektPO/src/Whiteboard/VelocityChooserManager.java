package Whiteboard;

import java.awt.Graphics2D;

import Simulator.MainFrame;

public class VelocityChooserManager {

	public VelocityChooserManager(MainFrame frame) {
		this.frame = frame;
	}
	
	public void drawVector(Graphics2D g2d, double x1, double y1, double x2, double y2) {

		g2d.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
		//se g2d.drawLine((int) x2, (int) y2, (int) x2-20, (int) y2-20);
	}
	
	MainFrame frame;
}
