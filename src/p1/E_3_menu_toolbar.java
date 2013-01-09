package p1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class E_3_menu_toolbar extends JFrame {

	public E_3_menu_toolbar() {
		
		initUI();
		
		
	}
	
	private void initUI() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		// Buttons
		JButton btn = initUI_buttons();
		
		panel.add(btn);
		
		// Menues
		JMenuBar menubar = initUI_menues(this);
		
		setJMenuBar(menubar);
		
		panel.setLayout(null);

		initUI_frame(this);
		
	}//private void initUI()

	private JMenuBar initUI_menues(JFrame frame) {
		// TODO Auto-generated method stub
		JMenuBar menubar = new JMenuBar();
        ImageIcon icon = new ImageIcon(getClass().getResource("11081943572312-png_50x37.png"));
        
        // Menu
        JMenu file = new JMenu("File(F)");
        file.setMnemonic(KeyEvent.VK_F);
        
        // Menu item
        JMenuItem eMenuItem = new JMenuItem("Exit(C)", icon);
        eMenuItem.setMnemonic(KeyEvent.VK_C);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }

        });
        
        // Add item to menu
        file.add(eMenuItem);
        
        menubar.add(file);
        
        return menubar;
	}

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
				
				E_3_menu_toolbar ex = new E_3_menu_toolbar();
				
				ex.setVisible(true);
				
			}//public void run()
		});//SwingUtilities.invokeLater
	}

}
