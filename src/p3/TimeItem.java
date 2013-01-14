package p3;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Checkbox;
import javax.swing.JLabel;

public class TimeItem extends JPanel {

	/*********************************
	 * Components
	 *********************************/
	Checkbox checkbox;
	JLabel label;
	
	/**
	 * Create the panel.
	 */
	public TimeItem() {

		build_gui();
		
	}

	private void build_gui() {
		// TODO Auto-generated method stub
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		checkbox = new Checkbox("");
		add(checkbox);
		
		label = new JLabel("");
		add(label);
		
	}//private void build_gui()

	public JPanel getTimeItem(){
		
		return this;
	}
}
