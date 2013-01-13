package p2;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class E_1_checkbox extends JFrame implements ActionListener {

	public E_1_checkbox() {
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(15, 20)));

        JCheckBox checkbox = new JCheckBox("Show Title", true);
        checkbox.setFocusable(false);
        checkbox.addActionListener(this);
        add(checkbox);

        setSize(280, 200);
        setTitle("JCheckBox example");
        setLocationRelativeTo(null);
//        setResizable(false);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        JCheckBox source = (JCheckBox) e.getSource();
        boolean state = source.isSelected();

        if (state) {
            this.setTitle("JCheckbox example");
        } else {
            this.setTitle("");
        }

    }
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

            public void run() {
            	E_1_checkbox ex = new E_1_checkbox();
                ex.setVisible(true);
            }
        });
	}
}
