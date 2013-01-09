package p1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Example extends JFrame {

	public Example() {
		
		setTitle("Hello");
		
		this.setSize(300, 200);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				
				Example ex = new Example();
				
				ex.setVisible(true);
				
			}//public void run()
		});//SwingUtilities.invokeLater
	}
	
}
