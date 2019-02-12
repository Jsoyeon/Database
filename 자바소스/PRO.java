package DB_PRODUCT;

import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PRO extends JFrame {
	public PRO() {
		JPanel PRO_panel = new JPanel();
		PRO_panel.setLayout(null);
		
		JTextArea txt_area2 = new JTextArea();
		txt_area2.setText("Code\tType\tName\t\tPrice");
		txt_area2.setSize(440,550);
		txt_area2.setLocation(0,0);
		
		JPanel PRO_Bpanel = new JPanel();
		PRO_Bpanel.setLayout(new FlowLayout());

		JButton PRO_1 = new JButton ("검색");
		JButton PRO_2 = new JButton ("추가");
		JButton PRO_3 = new JButton ("삭제");
		JButton PRO_4 = new JButton ("변경");
		
		PRO_Bpanel.add(PRO_1);
		PRO_Bpanel.add(PRO_2);
		PRO_Bpanel.add(PRO_3);
		PRO_Bpanel.add(PRO_4);
		
		PRO_Bpanel.setSize(300,100);
		PRO_Bpanel.setLocation(70,550);
	
		PRO_panel.add(txt_area2);
		
		PRO_panel.add(PRO_Bpanel);
		PRO_panel.setSize(450, 650);
		PRO_panel.setLocation(480,20);
	}
	
	public static void main(String[] args) {
		new PRO();
	}
}
