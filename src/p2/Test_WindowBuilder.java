package p2;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;


public class Test_WindowBuilder extends JFrame implements ActionListener {

	// Components
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	
	//
    private static HashMap<String, String> map;
    private JButton btnGetTime;
    private JButton btnCalculate;
    private JPanel panel;
    private JButton btnNewButton;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test_WindowBuilder frame = new Test_WindowBuilder();
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
	public Test_WindowBuilder() {
		
		init_ui();
	}

	private void init_ui() {
		// TODO Auto-generated method stub

		init_ui_1_frame();

		init_ui_2_pane();

		init_ui_3_menu();
		

		
	}

	private void init_ui_3_menu() {

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

	}//private void init_ui_3_menu()

	private void init_ui_2_pane() {
		// TODO Auto-generated method stub
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(30, 30));
		
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		btnGetTime = new JButton("Get time");
		panel.add(btnGetTime);
		btnGetTime.setHorizontalAlignment(SwingConstants.LEFT);
		
		btnCalculate = new JButton("Calculate");
		panel.add(btnCalculate);
		
		btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
		// TODO Auto-generated method stub
		

	}

	private void init_ui_1_frame() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 394);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	private static void init_map() {
		
		map = new HashMap<String, String>();
		
		map.put("ex", "Exit");
		
	}//private static void init_map()

}
