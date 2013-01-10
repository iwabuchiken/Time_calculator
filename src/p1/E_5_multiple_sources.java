package p1;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class E_5_multiple_sources extends JFrame implements ActionListener {

	private JList<String> list;
    private DefaultListModel<String> model;
	private JList<String> list_diff;
    private DefaultListModel<String> model_diff;

    private JButton btn_time;
    private JButton btn_clear;
    private JButton btn_calculate;

    private static HashMap<String, String> map;
    
	public E_5_multiple_sources() {
		
		initUI();
		
		
	}
	
	private void initUI() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		// Buttons
		panel = initUI_1_buttons(panel);
		
		// Menues
		JMenuBar menubar = initUI_2_menues(this);
		
		setJMenuBar(menubar);
		
		// List
		initUI_3_list(panel);
		
//		panel.add(list);
		
		//
		panel.setLayout(null);

		initUI_frame(this);
		
	}//private void initUI()

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initUI_3_list(JPanel panel) {
		// TODO Auto-generated method stub
		// List for time labels
		model = new DefaultListModel();
        list = new JList(model);
        list.setBounds(200, 30, 220, 150);
        
        // List for diff labels
		model_diff = new DefaultListModel();
        list_diff = new JList(model_diff);
        list_diff.setBounds(200, 200, 220, 100);
        
        // Listener
        list_diff.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				String item = (String) list_diff.getSelectedValue();
				
				Toolkit kit = Toolkit.getDefaultToolkit();
				Clipboard clip = kit.getSystemClipboard();
				
				StringSelection ss = new StringSelection(item);
				
				clip.setContents(ss, ss);
				
				model_diff.addElement(item);
				
			}});
        
        // Add to panel
        panel.add(list);
        panel.add(list_diff);
	}

	private JMenuBar initUI_2_menues(JFrame frame) {
		// TODO Auto-generated method stub
		JMenuBar menubar = new JMenuBar();
        ImageIcon icon = new ImageIcon(getClass().getResource("icon_menu_file_50x37.png"));
        
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

	private JPanel initUI_1_buttons(JPanel panel) {
		
		// Get time
		btn_time = new JButton(map.get("gt"));
		
		btn_time.setBounds(50, 60, 130, 50);
		
		btn_time.addActionListener(this);
		
		// Calculate the duration
		btn_calculate = new JButton(map.get("cal"));
		
		btn_calculate.setBounds(50, 120, 130, 50);
		
		btn_calculate.addActionListener(this);
		
		// Clear the labels
		
		btn_clear = new JButton(map.get("cl"));
		
		btn_clear.setBounds(50, 180, 130, 50);
		
		btn_clear.addActionListener(this);
		
		// Add to panel
		panel.add(btn_time);
		panel.add(btn_calculate);
		panel.add(btn_clear);
		
//		// Clear
//		btn_clear = new JButton("Clear");
//		btn_clear.setBounds(50, 120, 130, 50);
//		
//		this.add(btn_clear);
		
		return panel;
	}

	public static void main(String[] args) {

		init_map();
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				
				E_5_multiple_sources ex = new E_5_multiple_sources();
				
				ex.setVisible(true);
				
			}//public void run()
		});//SwingUtilities.invokeLater
	}


	private static void init_map() {
		
		map = new HashMap<String, String>();
		
		map.put("gt", "Get time");
		map.put("cal", "Calculate");
		map.put("cl", "Clear");
		
	}//private static void init_map()
	

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton o = (JButton) e.getSource();
		
		String label = o.getText();
		
		if (label.equals(map.get("gt"))) {
			
			actionPerformed_get_time(e);
			
		} else if (label.equals(map.get("cal"))) {//if (label.equals(map.get("gt")))

			actionPerformed_cal();
			
		} else if (label.equals(map.get("cl"))) {//if (label.equals(map.get("gt")))
			
			actionPerformed_clear(e);
			
		}//if (label.equals(map.get("gt")))
		
	}//public void actionPerformed(ActionEvent arg0)

	private void actionPerformed_cal() {
		
		long duration = 0;
		
		if (model.getSize() < 4) {
			
			return;
			
		}//if (model.getSize() == condition)
		
		//
//		String[] start_time = model.get(1).split(" ")[1].split(":");
		String[] start_time = model.get(1).split(" ")[2].split(":");
		
		String[] end_time = model.get(3).split(" ")[2].split(":");
		
//		model.addElement(model.get(1).split(" ")[2]);
//		model.addElement(start_time[0]);
//		model.addElement(model.get(0));
		
		
		Calendar c_start = Calendar.getInstance();
		c_start.set(2013, 1, 10,
				Integer.parseInt(start_time[0]),
				Integer.parseInt(start_time[1]),
				Integer.parseInt(start_time[2])
		);
		
		long s_time = c_start.getTimeInMillis();

		// End time
		Calendar c_end = Calendar.getInstance();
		c_end.set(2013, 1, 10,
				Integer.parseInt(end_time[0]),
				Integer.parseInt(end_time[1]),
				Integer.parseInt(end_time[2])
		);
		
		long e_time = c_end.getTimeInMillis();

		
//		model.addElement(String.valueOf(s_time));
//		model.addElement(String.valueOf(e_time));
		model_diff.addElement(String.valueOf(e_time));
		
	}//private void actionPerformed_cal(ActionEvent e)

	private void actionPerformed_clear(ActionEvent e) {
		// TODO Auto-generated method stub
		
		model.clear();
		
	}//private void actionPerformed_clear(ActionEvent e)

	private void actionPerformed_get_time(ActionEvent e) {
		// TODO Auto-generated method stub
		Locale locale = Locale.getDefault();
		
        Date date = new Date(e.getWhen());
        
        String s = DateFormat.getTimeInstance(DateFormat.LONG,
                locale).format(date);
        
        if (!model.isEmpty()) {
        	
        	int num = model.getSize();
        	
        	if (num >= 4) {
				
        		model.remove(0);
        		model.remove(0);
        		
			}//if (num == condition)
        	
//            model.clear();
        }
        
    	String message = " Event Id: ACTION_PERFORMED ("
    					+ String.valueOf(e.getID()
    					+ ")");
        	
        model.addElement(message);
        
        model.addElement(" Time: " + s);
		
	}//private void actionPerformed_get_time()

}
