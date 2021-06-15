package Whiteboard;

import javax.swing.SwingUtilities;

public class AnimationManager implements Runnable {
	double x, y, r, V, T, Eef, v, theta, nthet, vr, vx, vy;

	public AnimationManager(TrajectoryManager trajectory)  {
		this.trajectory = trajectory;
		cons = trajectory.cons;
	}


		public void run() {
	
			getCons().newfi += getCons().getL()/getCons().mi/getCons().newr/getCons().newr*0.001;
			getCons().newr = (getCons().P/(1 + getCons().epsilon * Math.cos(getCons().newfi - getCons().fi_p)));
			x = getCons().newr*Math.cos(getCons().newfi);
			y = getCons().newr*Math.sin(getCons().newfi);
			getCons().frame.getWhiteboardPanel().x = x; //here
			getCons().frame.getWhiteboardPanel().y = y; //and here new coordinates of blue dot get out
			r = getCons().newr;
			V = -getCons().alpha/r;
			T = getCons().E - V;
			v = Math.sqrt(2/getCons().mi*T);
			vr = getCons().getL()/getCons().mi/r/r*getCons().P*getCons().epsilon*Math.sin(getCons().newfi-getCons().fi_p)/(1 + getCons().epsilon * Math.cos(getCons().newfi - getCons().fi_p))/(1 + getCons().epsilon * Math.cos(getCons().newfi - getCons().fi_p));
			vx = vr*Math.cos(getCons().newfi)-getCons().getL()/getCons().mi/r*Math.sin(getCons().newfi);
			Eef = getCons().getL()*getCons().getL()/2/getCons().mi/r/r + V;
			if(vx>0) {
			theta = Math.asin(getCons().getL()/getCons().mi/r/v*(Math.cos(getCons().newfi)+getCons().P*getCons().epsilon*Math.sin(getCons().newfi-getCons().fi_p)*Math.sin(getCons().newfi)/(1 + getCons().epsilon * Math.cos(getCons().newfi - getCons().fi_p))/(1 + getCons().epsilon * Math.cos(getCons().newfi - getCons().fi_p))/r));
			}
			else {
				theta = -Math.asin(getCons().getL()/getCons().mi/r/v*(Math.cos(getCons().newfi)+getCons().P*getCons().epsilon*Math.sin(getCons().newfi-getCons().fi_p)*Math.sin(getCons().newfi)/(1 + getCons().epsilon * Math.cos(getCons().newfi - getCons().fi_p))/(1 + getCons().epsilon * Math.cos(getCons().newfi - getCons().fi_p))/r))+Math.PI;
			}
			vy = v * Math.sin(theta);
			SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run() {			
					
					//this updates labels in frame
					getCons().frame.getWhiteboardPanel().repaint();
					getCons().frame.getInputPanel().getxValueInput().setText(Double.toString(x)); 
					getCons().frame.getInputPanel().getyValueInput().setText(Double.toString(y)); 
					getCons().frame.getDataPanel().getCurrentDistance().setLabel(Double.toString(r)); 
					getCons().frame.getDataPanel().getCurrentPotential().setLabel(Double.toString(V)); 
					getCons().frame.getDataPanel().getCurrentKineticEnergy().setLabel(Double.toString(T)); 
					getCons().frame.getDataPanel().getCurrentEffectivePotential().setLabel(Double.toString( Eef));
					getCons().frame.getDataPanel().getCurrentVelocity().setLabel(Double.toString(v)); 
					getCons().frame.getInputPanel().getVelocityValueInput().setText(Double.toString(v)); 
					getCons().frame.getInputPanel().getVelocityDirectionInput().setText(Double.toString(180/Math.PI*theta)); 
					
					//this collect data for exporting
					String newLine = String.valueOf(x)+","+String.valueOf(y)+","+String.valueOf(v)+","
								+String.valueOf(180/Math.PI*theta)+","+String.valueOf(T)+","+String.valueOf(V)+String.valueOf(Eef)+"\n";
					trajectory.stringWriter.write(newLine);
				}
			});
		}
	
	

	public Constants getCons() {
			return cons;
		}



	TrajectoryManager trajectory;
	Constants cons;
	
	

}
