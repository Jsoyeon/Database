package DB_CUSTOMER;

import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CUS extends JFrame{
	public CUS() {
		JPanel CUS_panel = new JPanel();
		CUS_panel.setLayout(null);
		
		JTextArea txt_area1 = new JTextArea();
		txt_area1.setText("Code\tName\tAddress\t\tPhone");
		txt_area1.setSize(460,550);
		txt_area1.setLocation(0,0);
		
		JPanel CUS_Bpanel = new JPanel();
		CUS_Bpanel.setLayout(new FlowLayout());

		JButton CUS_1 = new JButton ("검색");
		JButton CUS_2 = new JButton ("추가");
		JButton CUS_3 = new JButton ("삭제");
		JButton CUS_4 = new JButton ("변경");
		
		CUS_Bpanel.add(CUS_1);
		CUS_Bpanel.add(CUS_2);
		CUS_Bpanel.add(CUS_3);
		CUS_Bpanel.add(CUS_4);
		
		CUS_Bpanel.setSize(300,100);
		CUS_Bpanel.setLocation(80,550);
	
		CUS_panel.add(txt_area1);
		
		CUS_panel.add(CUS_Bpanel);
		CUS_panel.setSize(460, 650);
		CUS_panel.setLocation(10,20);
	}
	
	public static void main(String[] args) {
		new CUS();
	}
}