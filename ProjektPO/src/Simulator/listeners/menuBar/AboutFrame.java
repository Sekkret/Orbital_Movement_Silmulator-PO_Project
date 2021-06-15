package Simulator.listeners.menuBar;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

//B.Baur
@SuppressWarnings("serial")
public class AboutFrame extends JFrame implements ActionListener {

	public AboutFrame() throws HeadlessException {
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("About");
		this.setResizable(false);
		
		this.setLayout(new GridLayout(3,1));
		this.add(new JLabel("Orbital Movement Simulator"));
		this.add(new JLabel("Bart³omiej Baur & Bartosz Skura"));
		this.add(new JLabel("GNU General Public License v3.0"));
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.setVisible(true);

	}

}
