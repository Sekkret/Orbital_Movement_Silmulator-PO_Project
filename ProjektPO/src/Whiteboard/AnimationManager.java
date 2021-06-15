package Whiteboard;

import javax.swing.SwingUtilities;

public class AnimationManager implements Runnable {
	double x, y, r, V, T, Eef, v, theta, nthet, vr, vx, vy;

	public AnimationManager(TrajectoryManager trajectory)  {
		this.trajectory = trajectory;
		cons = trajectory.cons;
	}


		public void run() {
	
			cons.newfi += cons.L/cons.mi/cons.newr/cons.newr*0.001;
			cons.newr = (cons.P/(1 + cons.epsilon * Math.cos(cons.newfi - cons.fi_p)));
			x = cons.newr*Math.cos(cons.newfi);
			y = cons.newr*Math.sin(cons.newfi);
			cons.frame.getWhiteboardPanel().x = x; //here
			cons.frame.getWhiteboardPanel().y = y; //and here new coordinates of blue dot get out
			r = cons.newr;
			V = -cons.alpha/r;
			T = cons.E - V;
			v = Math.sqrt(2/cons.mi*T);
			vr = cons.L/cons.mi/r/r*cons.P*cons.epsilon*Math.sin(cons.newfi-cons.fi_p)/(1 + cons.epsilon * Math.cos(cons.newfi - cons.fi_p))/(1 + cons.epsilon * Math.cos(cons.newfi - cons.fi_p));
			vx = vr*Math.cos(cons.newfi)-cons.L/cons.mi/r*Math.sin(cons.newfi);
			Eef = cons.L*cons.L/2/cons.mi/r/r + V;
			if(vx>0) {
			theta = Math.asin(cons.L/cons.mi/r/v*(Math.cos(cons.newfi)+cons.P*cons.epsilon*Math.sin(cons.newfi-cons.fi_p)*Math.sin(cons.newfi)/(1 + cons.epsilon * Math.cos(cons.newfi - cons.fi_p))/(1 + cons.epsilon * Math.cos(cons.newfi - cons.fi_p))/r));
			}
			else {
				theta = -Math.asin(cons.L/cons.mi/r/v*(Math.cos(cons.newfi)+cons.P*cons.epsilon*Math.sin(cons.newfi-cons.fi_p)*Math.sin(cons.newfi)/(1 + cons.epsilon * Math.cos(cons.newfi - cons.fi_p))/(1 + cons.epsilon * Math.cos(cons.newfi - cons.fi_p))/r))+Math.PI;
			}
			vy = v * Math.sin(theta);
			SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run() {			
					
					//this updates labels in frame
					cons.frame.getWhiteboardPanel().repaint();
					cons.frame.getInputPanel().getxValueInput().setText(Double.toString(x)); 
					cons.frame.getInputPanel().getyValueInput().setText(Double.toString(y)); 
					cons.frame.getDataPanel().getCurrentDistance().setLabel(Double.toString(r)); 
					cons.frame.getDataPanel().getCurrentPotential().setLabel(Double.toString(V)); 
					cons.frame.getDataPanel().getCurrentKineticEnergy().setLabel(Double.toString(T)); 
					cons.frame.getDataPanel().getCurrentEffectivePotential().setLabel(Double.toString( Eef));
					cons.frame.getDataPanel().getCurrentVelocity().setLabel(Double.toString(v)); 
					cons.frame.getInputPanel().getVelocityValueInput().setText(Double.toString(v)); 
					cons.frame.getInputPanel().getVelocityDirectionInput().setText(Double.toString(180/Math.PI*theta)); 
					
					//this collect data for exporting
					String newLine = String.valueOf(x)+","+String.valueOf(y)+","+String.valueOf(v)+","
								+String.valueOf(180/Math.PI*theta)+","+String.valueOf(T)+","+String.valueOf(V)+String.valueOf(Eef)+"\n";
					trajectory.stringWriter.write(newLine);
				}
			});
		}
	
	

	TrajectoryManager trajectory;
	Constants cons;
	
	

}
