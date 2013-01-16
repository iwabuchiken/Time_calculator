package p3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import javax.swing.DefaultListModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ScrollPaneLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JList;

public class TC extends JFrame {

	/*********************************
	 * Component: General
	 *********************************/
	private static JPanel contentPane;
	private static JMenuBar menuBar;
	
	private static JScrollPane timeDiffPane;
	private static JScrollPane timeListPane;
	
	private static Panel buttonPanel;
	private static Panel viewPanel;

	private static JButton btnGetTime;
	private static JButton btnCalc;
	private static JButton btnClear;

	/*********************************
	 * Component: List-related
	 *********************************/
//	private static JList<String> timeList;
	private static CheckBoxList timeList;
	
	private static JList<String> timeDiffList;
//	private static DefaultListModel<JPanel> timeModel;
//	private static CheckBoxList timeModel;
	private static DefaultListModel<String> diffModel;
	
	/*********************************
	 * Others
	 *********************************/
	private static HashMap<String, String> map;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TC frame = new TC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TC() {

		init_map();
		
		init_ui_1_frame();

		init_ui_2_pane();
		
		init_ui_3_menues();
		
		init_ui_4_components();
	}

	private void init_ui_4_components() {
		
		init_ui_4_components_1_panels();
		
//		/*********************************
//		 * Panels
//		 *********************************/
//		// Button panel
//		buttonPanel = new Panel();
//		
//		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
//		buttonPanel.setBackground(Color.orange);
//		
//		getContentPane().add(buttonPanel);
//
//		// View panel
//		viewPanel = new Panel();
//		viewPanel.setLayout(new GridLayout(2, 1, 0, 0));
//		
//		viewPanel.setBackground(Color.DARK_GRAY);
//		
//		getContentPane().add(viewPanel);

		init_ui_4_components_2_buttons();
		
//		/*********************************
//		 * Buttons: To button panel
//		 *********************************/
//		// Button: Get time
//		btnGetTime = new JButton("Get time");
//		buttonPanel.add(btnGetTime);
//		
//		btnGetTime.addActionListener(new ButtonActionListener());
//		
//		// Button: Calculate
//		JButton btnCalc = new JButton("Calculate");
//		btnCalc.addActionListener(new ButtonActionListener());
//		buttonPanel.add(btnCalc);
//		
//		// Button: Clear
//		btnClear = new JButton("Clear");
//		btnClear.addActionListener(new ButtonActionListener());
//		buttonPanel.add(btnClear);
		
		init_ui_4_components_3_scroll_panes();
		
//		/*********************************
//		 * Scroll panes: To view panel
//		 *********************************/
//		// Time list pane
//		timeListPane = new JScrollPane();
//		timeListPane.setBorder(new LineBorder(new Color(0, 0, 255), 4));
//		timeListPane.setBackground(Color.YELLOW);
//		timeListPane.setLayout(new ScrollPaneLayout());
//		
//		viewPanel.add(timeListPane);
//		
//		// Time diff pane
//		timeDiffPane = new JScrollPane();
//		timeDiffPane.setBorder(new LineBorder(new Color(130, 135, 144), 4));
//		timeDiffPane.setBackground(Color.GRAY);
//		
//		timeListPane.setLayout(new ScrollPaneLayout());
		
		init_ui_4_components_4_lists();
		
//		/*********************************
//		 * Lists
//		 *********************************/
//		timeList = new JList();
//		timeListPane.setViewportView(timeList);
//		
//		viewPanel.add(timeDiffPane);
//		
//		timeDiffList = new JList();
//		timeDiffPane.setViewportView(timeDiffList);
	}

	private void init_ui_4_components_4_lists() {
		// TODO Auto-generated method stub
		/*********************************
		 * Lists
		 *********************************/
		// Time list
//		timeModel = new DefaultListModel();
//		timeList = new JList(timeModel);
		timeList = new CheckBoxList();
		
//		timeList.dlm.addElement("string");
		
		timeListPane.setViewportView(timeList);
		
//		viewPanel.add(timeDiffPane);
		
		// Time diff list
		diffModel = new DefaultListModel();
		timeDiffList = new JList(diffModel);
		
		timeDiffPane.setViewportView(timeDiffList);

	}//private void init_ui_4_components_4_lists()

	private void init_ui_4_components_3_scroll_panes() {
		// TODO Auto-generated method stub
		/*********************************
		 * Scroll panes: To view panel
		 *********************************/
		// Time list pane
		timeListPane = new JScrollPane();
		timeListPane.setBorder(new LineBorder(new Color(0, 0, 255), 4));
		timeListPane.setBackground(Color.YELLOW);
		timeListPane.setLayout(new ScrollPaneLayout());
		
		viewPanel.add(timeListPane);
		
		// Time diff pane
		timeDiffPane = new JScrollPane();
		timeDiffPane.setBorder(new LineBorder(new Color(130, 135, 144), 4));
		timeDiffPane.setBackground(Color.GRAY);
		
		timeDiffPane.setLayout(new ScrollPaneLayout());
		
		viewPanel.add(timeDiffPane);

	}//private void init_ui_4_components_3_scroll_panes()

	private void init_ui_4_components_2_buttons() {
		// TODO Auto-generated method stub
		/*********************************
		 * Buttons: To button panel
		 *********************************/
		// Button: Get time
		btnGetTime = new JButton("Get time");
		buttonPanel.add(btnGetTime);
		
		btnGetTime.addActionListener(new ButtonActionListener());
		
		// Button: Calculate
		JButton btnCalc = new JButton("Calculate");
		btnCalc.addActionListener(new ButtonActionListener());
		buttonPanel.add(btnCalc);
		
		// Button: Clear
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ButtonActionListener());
		buttonPanel.add(btnClear);

	}//private void init_ui_4_components_2_buttons()

	private void init_ui_4_components_1_panels() {
		// TODO Auto-generated method stub
		/*********************************
		 * Panels
		 *********************************/
		// Button panel
		buttonPanel = new Panel();
		
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.setBackground(Color.orange);
		
		getContentPane().add(buttonPanel);

		// View panel
		viewPanel = new Panel();
		viewPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		viewPanel.setBackground(Color.DARK_GRAY);
		
		getContentPane().add(viewPanel);

	}//private void init_ui_4_components_1_panels()

	private void init_ui_3_menues() {
		// TODO Auto-generated method stub
		menuBar = new JMenuBar();
		
		// Menu: File
		JMenu mnFile = new JMenu("File");
		
		mnFile.setMnemonic(KeyEvent.VK_F);
		
		// Exit
		JMenuItem mntmExit = new JMenuItem("Exit");
		
		mntmExit.setMnemonic(KeyEvent.VK_E);

		mntmExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }

        });
				
		mnFile.add(mntmExit);

		// Menu: Others
		JMenu mnOptions = new JMenu("Others");
		
		mnOptions.setMnemonic(KeyEvent.VK_O);

		// Add to menu bar
		menuBar.add(mnFile);
		menuBar.add(mnOptions);
		
		// Add menu bar to frame
//		contentPane.add(menuBar);
		setJMenuBar(menuBar);

	}

	private void init_ui_2_pane() {
		// TODO Auto-generated method stub
		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 2));

	}

	private void init_ui_1_frame() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
	}

	private static void init_map() {
		
		map = new HashMap<String, String>();
		
		map.put("gt", "Get time");
		map.put("cal", "Calculate");
		map.put("cl", "Clear");
		
	}//private static void init_map()

	public static String get_time_Label(long millSec) {
		
		 SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy ");
		 
		return sdf1.format(new Date(millSec));
		
	}//public static String get_time_Label(long millSec)

	public static long get_millsec_now() {
		
		Calendar cal = Calendar.getInstance();
		
		return cal.getTime().getTime();
		
	}//public static long get_millsec_now()

	class ButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton o = (JButton) e.getSource();
			
			String label = o.getText();
			
			if (label.equals(map.get("gt"))) {
				
				actionPerformed_get_time(e);
				
			} else if (label.equals(map.get("cal"))) {//if (label.equals(map.get("gt")))

				actionPerformed_cal();
				
			} else if (label.equals(map.get("cl"))) {//if (label.equals(map.get("gt")))
				
				actionPerformed_clear(e);
				
			}//if (label.equals(map.get("gt")))

		}

		private void actionPerformed_clear(ActionEvent e) {
			// TODO Auto-generated method stub
			TC.timeListPane.removeAll();
		}

		private void actionPerformed_cal() {
			// TODO Auto-generated method stub
			
		}

		private void actionPerformed_get_time(ActionEvent e) {
			// TODO Auto-generated method stub

			timeList.dlm.addElement("string");
			
//			TimeItem ti = new TimeItem();
//			
//			String timeLabel = TC.get_time_Label(TC.get_millsec_now());
//			
//			ti.label.setText(timeLabel);
//			
//			TC.timeModel.addElement(ti);
//			TC.timeModel.addElement(ti.getTimeItem());
			
//			TC.timeModel.addElement("hi");
			
			
		}
		
	}	

}
