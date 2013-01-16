package p3;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class E1_test_cell_renderer extends JFrame{

	/*********************************
	 * Components
	 *********************************/
	JPanel p;
	
	/*********************************
	 * List-related
	 *********************************/
	protected static JList<String> list;
	protected static DefaultListModel<String> model;
	

	E1_test_cell_renderer(String title){
		// Title
		setTitle(title);

		init_ui_1_initial_data();
		
		/* CellRendererÇê›íËÇ∑ÇÈ */
		MyCellRenderer renderer = new MyCellRenderer();
		list.setCellRenderer(renderer);

		init_ui_2_set_scroll_pane();
		
		init_ui_3_set_listener_to_list();
		
//		JScrollPane sp = new JScrollPane();
//		sp.getViewport().setView(list);
//		sp.setPreferredSize(new Dimension(200, 80));
//
//		JPanel p = new JPanel();
//		p.add(sp);

		getContentPane().add(p, BorderLayout.CENTER);
	}
	
	private void init_ui_3_set_listener_to_list() {
		// TODO Auto-generated method stub
	    list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int index = E1_test_cell_renderer.list.locationToIndex(e.getPoint());
				
				if (index != -1) {
					Object obj = E1_test_cell_renderer.list.getModel().getElementAt(index);
					
					if (obj instanceof JCheckBox) {
						JCheckBox checkbox = (JCheckBox) obj;

						checkbox.setSelected(!checkbox.isSelected());
						repaint();
					}
				}//if (index != -1)
			}//public void mousePressed(MouseEvent e)
		});

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}//private void init_ui_3_set_listener_to_list()

	private void init_ui_2_set_scroll_pane() {
		// TODO Auto-generated method stub
		JScrollPane sp = new JScrollPane();
		sp.getViewport().setView(list);
		sp.setPreferredSize(new Dimension(200, 80));

		p = new JPanel();
		p.add(sp);

	}//private void init_ui_2_set_scroll_pane()

	private void init_ui_1_initial_data() {
		// TODO Auto-generated method stub
		String[] initData = {"Blue", "Green", "Red", "Whit", "Black"};
		
		model = new DefaultListModel();
		
		for (int i = 0; i < initData.length; i++) {
			
			model.addElement(initData[i]);
			
		}//for (int i = 0; i < initData.length; i++)
		
		list = new JList(initData);

	}//private void init_ui_1_initial_data()

	public static void main(String[] args){
		E1_test_cell_renderer test = new E1_test_cell_renderer("E1_test_cell_renderer");

		/* èIóπèàóùÇïœçX */
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		test.setBounds( 10, 10, 250, 130);
		test.setVisible(true);
	}


	class MyCellRenderer extends JCheckBox implements ListCellRenderer{
		public MyCellRenderer() {
		}

		public Component getListCellRendererComponent(
			JList list,
			Object value,
			int index,
			boolean isSelected,
			boolean cellHasFocus){

			setText(value.toString());

			return this;
		}
	}
	
}//public class E1_test_cell_renderer extends JFrame
