package p1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class E2 extends JFrame {

	public E2() {
		
		initUI();
		
		
	}
	
	private void initUI() {
		// TODO Auto-generated method stub
//		setTitle("E2");
//		
//		this.setSize(300, 200);
//		
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		JButton btn = initUI_buttons();
		
		panel.add(btn);
		
		panel.setLayout(null);

		initUI_frame(this);
		
	}//private void initUI()

	private void initUI_frame(JFrame frame) {
		// TODO Auto-generated method stub
		setTitle("E2");
		
		frame.setSize(300, 200);
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	private JButton initUI_buttons() {
		// TODO Auto-generated method stub
		JButton quitButton = new JButton("Quit");
		
		quitButton.setBounds(50, 60, 80, 30);
		
		quitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
			
				System.exit(0);
				
			}
		});
		
		return quitButton;
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				
				E2 ex = new E2();
				
				ex.setVisible(true);
				
			}//public void run()
		});//SwingUtilities.invokeLater
	}

}
