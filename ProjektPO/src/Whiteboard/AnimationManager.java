package Whiteboard;

import javax.swing.SwingUtilities;

public class AnimationManager implements Runnable {
	double x, y, r, V, T, Eef, v;

	public AnimationManager(Constants constants)  {
		cons = constants;
	}


		public void run() {
	
			cons.newfi += cons.L/cons.mi/cons.newr/cons.newr*0.001;
			cons.newr = (cons.P/(1 + cons.epsilon * Math.cos(cons.newfi + cons.fi_p)));
			cons.frame.getWhiteboardPanel().x =cons.newr*Math.cos(cons.newfi);
			cons.frame.getWhiteboardPanel().y =cons.newr*Math.sin(cons.newfi);	
			x = cons.newr*Math.cos(cons.newfi);
			y = cons.newr*Math.sin(cons.newfi);
			r = cons.newr;
			V = -cons.alpha/r;
			T = cons.E - V;
			v = Math.sqrt(2/cons.mi*T);
			Eef = cons.L*cons.L/2/cons.mi/r/r + V;
			SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run() {
					cons.frame.getWhiteboardPanel().repaint();
					cons.frame.getInputPanel().getxValueInput().setText(Double.toString(x)); 
					cons.frame.getInputPanel().getyValueInput().setText(Double.toString(y)); 
					cons.frame.getDataPanel().getCurrentDistance().setLabel(Double.toString(r)); 
					cons.frame.getDataPanel().getCurrentPotential().setLabel(Double.toString(V)); 
					cons.frame.getDataPanel().getCurrentKineticEnergy().setLabel(Double.toString(T)); 
					cons.frame.getDataPanel().getCurrentEffectivePotential().setLabel(Double.toString( Eef));
					cons.frame.getDataPanel().getCurrentVelocity().setLabel(Double.toString(v)); 
					cons.frame.getInputPanel().getVelocityValueInput().setText(Double.toString(v)); 
					
				}
			});
		}
	
	


	Constants cons;
	
	

}
