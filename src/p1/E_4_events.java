package p1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class E_4_events extends JFrame implements ActionListener {

	private JList list;
    private DefaultListModel model;
	
    private JButton btn_clear;
    
	public E_4_events() {
		
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
		
		// List
		initUI_3_list();
		
		panel.add(list);
		
		//
		panel.setLayout(null);

		initUI_frame(this);
		
	}//private void initUI()

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initUI_3_list() {
		// TODO Auto-generated method stub
		model = new DefaultListModel();
        list = new JList(model);
        list.setBounds(200, 30, 220, 150);
	}

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
		
		frame.setSize(600, 400);
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	private JButton initUI_buttons() {
		// TODO Auto-generated method stub
		JButton quitButton = new JButton("Get time");
		
		quitButton.setBounds(50, 60, 130, 50);
		
		quitButton.addActionListener(this);
		
//		// Clear
//		btn_clear = new JButton("Clear");
//		btn_clear.setBounds(50, 120, 130, 50);
//		
//		this.add(btn_clear);
		
		return quitButton;
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				
				E_4_events ex = new E_4_events();
				
				ex.setVisible(true);
				
			}//public void run()
		});//SwingUtilities.invokeLater
	}


	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Locale locale = Locale.getDefault();
        Date date = new Date(e.getWhen());
        String s = DateFormat.getTimeInstance(DateFormat.LONG,
                locale).format(date);
        
        if (!model.isEmpty()) {
        	
        	int num = model.getSize();
        	
        	if (num > 6) {
				
        		model.remove(0);
        		model.remove(0);
        		
			}//if (num == condition)
        	
//            model.clear();
        }
        
        if (e.getID() == ActionEvent.ACTION_PERFORMED) {
        	String message = " Event Id: ACTION_PERFORMED ("
        					+ String.valueOf(e.getID()
        					+ ")");
        	
            model.addElement(message);
        }
        
        model.addElement(" Time: " + s);
		
        
	}//public void actionPerformed(ActionEvent arg0)

}
