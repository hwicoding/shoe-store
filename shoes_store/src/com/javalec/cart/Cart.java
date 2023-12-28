package com.javalec.cart;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cart {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable innertable;
	private JLabel lblPay;
	private JTextField tfPay;
	private JButton btnOrder;
	private JButton btnDelete;
	private JComboBox cbSelection;
	private JTextField tfSelection;
	private JButton btnQuery;
	
	// -- Database & Table//
			private final DefaultTableModel outer_Table = new DefaultTableModel();
			private final String url_mysql = "jdbc:mysql://127.0.0.1/useraddress?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
			private final String id_mysql = "root";
			private final String pw_mysql = "qwer1234";
			private JTable inner_Table;
			private JButton btnPrevious;
			private JButton btnPay;
			private JTable table;
			
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart window = new Cart();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cart() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		frame.setTitle("장바구니");
		frame.setBounds(100, 100, 625, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblPay());
		frame.getContentPane().add(getTfPay());
		frame.getContentPane().add(getBtnOrder());
		frame.getContentPane().add(getBtnDelete());
		frame.getContentPane().add(getCbSelection());
		frame.getContentPane().add(getTfSelection());
		frame.getContentPane().add(getBtnQuery());
	}
	private JComboBox getCbSelection() {
		if (cbSelection == null) {
			cbSelection = new JComboBox();
			cbSelection.setModel(new DefaultComboBoxModel(new String[] {"상품명 ", "가격 ", "사이즈 ", "색깔 ", "수량"}));
			cbSelection.setBounds(31, 32, 73, 23);
		}
		return cbSelection;
	}
	private JTextField getTfSelection() {
		if (tfSelection == null) {
			tfSelection = new JTextField();
			tfSelection.setBounds(146, 33, 271, 21);
			tfSelection.setColumns(10);
		}
		return tfSelection;
	}
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton("검색");
			btnQuery.setBounds(477, 32, 91, 23);
		}
		return btnQuery;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(31, 80, 537, 248);
			scrollPane.setViewportView(getInnertable());
		}
		return scrollPane;
	}
	private JTable getInnertable() {
		if (innertable == null) {
			innertable = new JTable();
			innertable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if(e.getButton()==1) {
						
					}
				
				
				}
			});
			inner_Table.setSelectionMode(ListSelectionModel	.SINGLE_SELECTION);
			inner_Table.setModel(outer_Table);
		}
		return innertable;
	}
	private JLabel getLblPay() {
		if (lblPay == null) {
			lblPay = new JLabel("결제금액");
			lblPay.setBounds(31, 373, 50, 15);
		}
		return lblPay;
	}
	private JTextField getTfPay() {
		if (tfPay == null) {
			tfPay = new JTextField();
			tfPay.setBounds(111, 370, 96, 21);
			tfPay.setColumns(10);
		}
		return tfPay;
	}
	private JButton getBtnOrder() {
		if (btnOrder == null) {
			btnOrder = new JButton("주문하기");
			btnOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					order();
				}
			});
			btnOrder.setBounds(369, 414, 91, 23);
		}
		return btnOrder;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제하기");
			btnDelete.setBounds(477, 414, 91, 23);
		}
		return btnDelete;
	}
	
	// ------ Function
	// Table의 컬럼을 정의하고 Data 내용을 초기화시킨다. 
	private void tableInit() {
		outer_Table.addColumn("순서");
		outer_Table.addColumn("이름");
		outer_Table.addColumn("가격");
		outer_Table.addColumn("사이즈");
		outer_Table.addColumn("수량");
		outer_Table.setColumnCount(5);
		
		// 순서
		int colNo = 0;
		TableColumn col = inner_Table.getColumnModel().getColumn(colNo);
		int width = 30;
		col.setPreferredWidth(width);
				
		// 이름
		colNo = 1;
		col = inner_Table.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
						
		// 가격
		colNo = 2;
		col = inner_Table.getColumnModel().getColumn(colNo);
		width = 150;
		col.setPreferredWidth(width);
						
		// 사이즈
		colNo = 3;
		col = inner_Table.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		
		// 수량
		colNo = 4;
		col = inner_Table.getColumnModel().getColumn(colNo);
		width = 100;
	    col.setPreferredWidth(width);
						
		// 초기화시키기
		int i = outer_Table.getRowCount();
		for(int j=0; j<i; j++) {
		outer_Table.removeRow(0);
		}
						
		inner_Table.setAutoResizeMode(inner_Table.AUTO_RESIZE_OFF);

	}

		private void searchAction() {
			
			String query = "sekect seqno, name, price, size, color, count ";
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				
				ResultSet rs = stmt_mysql.executeQuery(query);
				while(rs.next()) {
					
					String[] qTxt = { Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4)};
					outer_Table.addRow(qTxt);
				}
			
				conn_mysql.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		
	
		private void order() {
			orderAction();
			tableInit();
			clearColumn();
			searchAction();
		}
		
		private void delete() {
			deleteAction();
			tableInit();
			clearColumn();
			searchAction();
			
		}
		
		
		private void orderAction () {
			
		}
		
		private void deleteAction() {
			
		}
	}	
	

