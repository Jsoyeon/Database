import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import DB_CUSTOMER.CUS;
import DB_PRODUCT.PRO;
import DB_RECIPE.RECI;


public class MainDB extends JFrame{

	public MainDB() {
		setTitle("★쿠키베베 데이터베이스 관리 시스템 :)");
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);

		JLabel csta = CONNECT();
		
		csta.setSize(350,10);
		csta.setLocation(6,6);
		
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
		
		CUS_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","COMPANY", "db20164260").createStatement();
					ResultSet rset = stmt.executeQuery("select * from CUSTOMER");
					System.out.println("Code\tName\tAddress\t\tPhone");
					txt_area1.setText("\n");
					while (rset.next()){
						for (int i=1; i<5; i++) {
							System.out.print(rset.getString(i) +"\t");
							txt_area1.setText(txt_area1.getText()+ rset.getString(i) +"     \t");	//한 레코드
						}
						System.out.println();
						txt_area1.setText(txt_area1.getText() + "\n");
						csta.setText("The result has been successfully loaded!");
					}
				} catch (SQLException a) {
					a.printStackTrace();
					csta.setText("An Error Occured While Reading Database.");
				}
			}
		});
		
		CUS_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = JOptionPane.showInputDialog("코드 입력");
				String name = JOptionPane.showInputDialog("이름 입력");
				String address = JOptionPane.showInputDialog("주소 입력");
				String phone = JOptionPane.showInputDialog("전화번호 입력");
				try {
					Statement stmt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","COMPANY", "db20164260").createStatement();
					String sql = "INSERT INTO CUSTOMER VALUES ("+ code +",\'"+name+"\',\'"+ address +"\',\'"+ phone +"\')";
					stmt.executeUpdate(sql);	
				} catch (SQLException a) {
					a.printStackTrace();
					csta.setText("An Error Occured While Reading Database.");
				}	
			}
		});
		
		CUS_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = JOptionPane.showInputDialog("회원 코드");
				try {
					Statement stmt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","COMPANY", "db20164260").createStatement();
					String sql = "DELETE from CUSTOMER where CUS_Code = "+code;
					stmt.executeUpdate(sql);
				} catch (SQLException a) {
					a.printStackTrace();
					csta.setText("An Error Occured While Reading Database.");
				}
			}
		});
		
		CUS_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = JOptionPane.showInputDialog("회원 코드");
				String name = JOptionPane.showInputDialog("이름 변경");
				String address = JOptionPane.showInputDialog("주소 변경");
				String phone = JOptionPane.showInputDialog("전화번호 변경");
				try {
					Statement stmt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","COMPANY", "db20164260").createStatement();
					String sql = "UPDATE CUSTOMER SET CUS_Name= '" + name +"\', CUS_Address= '"+ address+"\', CUS_Phone= \'"+ phone +"\' where CUS_Code = "+code;
					stmt.executeUpdate(sql);
				} catch (SQLException a) {
					a.printStackTrace();
					csta.setText("An Error Occured While Reading Database.");
				}
			}
		});
		
		CUS_panel.add(CUS_Bpanel);
		CUS_panel.setSize(460, 650);
		CUS_panel.setLocation(10,20);
	
		
		JPanel PRO_panel = new JPanel();
		PRO_panel.setLayout(null);
		
		JTextArea txt_area2 = new JTextArea();
		txt_area2.setText("Code\tType\tName\tPrice");
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
		
		PRO_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","COMPANY", "db20164260").createStatement();
					ResultSet rset = stmt.executeQuery("select * from PRODUCT");
					System.out.println("Code\tType\tName\tPrice");
					txt_area2.setText("\n");
					while (rset.next()){
						for (int i=1; i<5; i++) {
							System.out.print(rset.getString(i) +"\t");
							txt_area2.setText(txt_area2.getText()+ rset.getString(i) +"\t");	//한 레코드
						}
						System.out.println();
						txt_area2.setText(txt_area2.getText() + "\n");
						csta.setText("The result has been successfully loaded!");
					}
				} catch (SQLException b) {
					b.printStackTrace();
					csta.setText("An Error Occured While Reading Database.");
				}
			}
		});
		
		PRO_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = JOptionPane.showInputDialog("코드 입력");
				String type = JOptionPane.showInputDialog("타입 입력");
				String name = JOptionPane.showInputDialog("이름 입력");
				String price = JOptionPane.showInputDialog("가격 입력");
				try {
					Statement stmt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","COMPANY", "db20164260").createStatement();
					String sql = "INSERT INTO PRODUCT VALUES ('"+ code +"\',\'"+type+"\',\'"+ name +"\',"+ price +")";
					stmt.executeUpdate(sql);	
				} catch (SQLException b) {
					b.printStackTrace();
					csta.setText("An Error Occured While Reading Database.");
				}	
			}
		});
		
		PRO_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = JOptionPane.showInputDialog("제품 코드");
				try {
					Statement stmt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","COMPANY", "db20164260").createStatement();
					String sql = "DELETE from PRODUCT where PRO_Code = '"+code+"\'";
					stmt.executeUpdate(sql);
				} catch (SQLException b) {
					b.printStackTrace();
					csta.setText("An Error Occured While Reading Database.");
				}
			}
		});
		
		PRO_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = JOptionPane.showInputDialog("제품 코드");
				String type = JOptionPane.showInputDialog("타입 변경");
				String name = JOptionPane.showInputDialog("제품명 변경");
				String price = JOptionPane.showInputDialog("가격 변경");
				try {
					Statement stmt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","COMPANY", "db20164260").createStatement();
					String sql = "UPDATE PRODUCT SET PRO_Type= '" + type +"\', PRO_Name= '"+ name +"\', PRO_Price= "+ price +" where PRO_Code = '"+code+"\'";
					stmt.executeUpdate(sql);
				} catch (SQLException a) {
					a.printStackTrace();
					csta.setText("An Error Occured While Reading Database.");
				}
			}
		});
		
		PRO_panel.add(PRO_Bpanel);
		PRO_panel.setSize(450, 650);
		PRO_panel.setLocation(480,20);
		

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
		
		RECI_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","COMPANY", "db20164260").createStatement();
					ResultSet rset = stmt.executeQuery("select * from RECIPE");
					System.out.println("Code\tMenu\tName");
					txt_area3.setText("\n");
					while (rset.next()){
						for (int i=1; i<4; i++) {
							System.out.print(rset.getString(i) +"\t");
							txt_area3.setText(txt_area3.getText()+ rset.getString(i) +"     \t");	//한 레코드
						}
						System.out.println();
						txt_area3.setText(txt_area3.getText() + "\n");
						csta.setText("The result has been successfully loaded!");
					}
				} catch (SQLException c) {
					c.printStackTrace();
					csta.setText("An Error Occured While Reading Database.");
				}
			}
		});
		
		RECI_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = JOptionPane.showInputDialog("코드 입력");
				String menu = JOptionPane.showInputDialog("종류 입력");
				String name = JOptionPane.showInputDialog("메뉴명 입력");
				try {
					Statement stmt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","COMPANY", "db20164260").createStatement();
					String sql = "INSERT INTO RECIPE VALUES ('"+ code +"\',\'"+menu+"\',\'"+name +"\')";
					stmt.executeUpdate(sql);	
				} catch (SQLException a) {
					a.printStackTrace();
					csta.setText("An Error Occured While Reading Database.");
				}	
			}
		});
		
		RECI_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = JOptionPane.showInputDialog("레시피 코드");
				try {
					Statement stmt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","COMPANY", "db20164260").createStatement();
					String sql = "DELETE from RECIPE where RECI_Code = '"+code+"\'";
					stmt.executeUpdate(sql);
				} catch (SQLException b) {
					b.printStackTrace();
					csta.setText("An Error Occured While Reading Database.");
				}
			}
		});
		
		RECI_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = JOptionPane.showInputDialog("레시피 코드");
				String menu = JOptionPane.showInputDialog("종류 변경");
				String name = JOptionPane.showInputDialog("메뉴명 변경");
				try {
					Statement stmt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","COMPANY", "db20164260").createStatement();
					String sql = "UPDATE RECIPE SET RECI_Menu= '" + menu +"\', RECI_Name= '"+ name +"\' where RECI_Code = '"+code+"\'";
					stmt.executeUpdate(sql);
				} catch (SQLException a) {
					a.printStackTrace();
					csta.setText("An Error Occured While Reading Database.");
				}
			}
		});
		
		RECI_panel.add(RECI_Bpanel);
		RECI_panel.setSize(370, 650);
		RECI_panel.setLocation(930,20);
		
		c.add(csta);
		c.add(CUS_panel);
		c.add(PRO_panel);
		c.add(RECI_panel);
		
		setSize(1330, 650);
		setVisible(true);
	}
	
	JLabel CONNECT() {
		JLabel state = new JLabel();
		state.setText("Load Data From Oracle Server");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","COMPANY", "db20164260");
			System.out.println("DB has been connected.");
			state.setText("Successfully Connected :)");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			state.setText("Could not find the drive.\n" + e.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			state.setText("Could not find the database.\n" + e.toString());
		}
		return state;
	}
	
	public static void main (String[] args) {
		new MainDB();
	}
}


