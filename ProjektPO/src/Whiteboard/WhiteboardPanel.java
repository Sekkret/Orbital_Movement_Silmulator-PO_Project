package Whiteboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class WhiteboardPanel extends JPanel {

	public WhiteboardPanel() {
		//drawingSpace = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		drawingSpace = null;
		axes = new AxesManager();
	}
	
	public void paintComponent(Graphics g) {
		drawingSpace = (BufferedImage) this.createImage(this.getWidth(), this.getHeight());
		Graphics2D gc = drawingSpace.createGraphics();
		gc.translate(this.getWidth()/2, this.getHeight()/2);
		gc.scale(1,  -1);
	    gc.setColor(Color.CYAN);
	    gc.fillRect(-this.getWidth()/2, -this.getHeight()/2, this.getWidth(), this.getHeight());
	    gc.setColor(Color.BLACK);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(drawingSpace, 0, 0, this);
		axes.paintAxes(g2d, this.getWidth(), this.getHeight());
	}
	
	
	public BufferedImage getDrawingSpace() {
		return drawingSpace;
	}
	
	public void setDrawingSpace(BufferedImage newSpace) {
		drawingSpace = newSpace;
	}
	public AxesManager getAxes() {
		return axes;
	}
	
	public BufferedImage drawingSpace;
	AxesManager axes;

}
