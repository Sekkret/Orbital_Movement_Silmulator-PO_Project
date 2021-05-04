package Whiteboard;

import javax.swing.SwingUtilities;

public class AnimationManager implements Runnable {

	public AnimationManager(Constants constants)  {
		cons = constants;
	}


		public void run() {
			SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run() {
					System.out.println(cons.newfi);
					cons.newfi += cons.L/cons.mi/cons.newr/cons.newr*100;
					cons.newr = (cons.P/(1 + cons.epsilon * Math.cos(cons.newfi + Math.acos((cons.P-cons.r_p)/cons.epsilon/cons.r_p)-cons.fi_0)));
					cons.frame.getWhiteboardPanel().x =cons.newr*Math.cos(cons.newfi);
					cons.frame.getWhiteboardPanel().y =cons.newr*Math.sin(cons.newfi);	
					cons.frame.getWhiteboardPanel().repaint();
				}
			});
		}
	
	
	 

	Constants cons;
	
	

}
