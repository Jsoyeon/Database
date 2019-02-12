package DB_RECIPE;

import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RECI extends JFrame{
	public RECI() {
		JPanel RECI_panel = new JPanel();
		RECI_panel.setLayout(null);
		
		JTextArea txt_area3 = new JTextArea();
		txt_area3.setText("Code\tMenu\tName");
		txt_area3.setSize(370,550);
		txt_area3.setLocation(0,0);
		
		JPanel RECI_Bpanel = new JPanel();
		RECI_Bpanel.setLayout(new FlowLayout());

		JButton RECI_1 = new JButton ("검색");
		JButton RECI_2 = new JButton ("추가");
		JButton RECI_3 = new JButton ("삭제");
		JButton RECI_4 = new JButton ("변경");
		
		RECI_Bpanel.add(RECI_1);
		RECI_Bpanel.add(RECI_2);
		RECI_Bpanel.add(RECI_3);
		RECI_Bpanel.add(RECI_4);
		
		RECI_Bpanel.setSize(300,100);
		RECI_Bpanel.setLocation(40,550);
	
		RECI_panel.add(txt_area3);
		
		RECI_panel.add(RECI_Bpanel);
		RECI_panel.setSize(370, 650);
		RECI_panel.setLocation(930,20);
	}
	
	public static void main(String[] args) {
		new RECI();
	}
}
