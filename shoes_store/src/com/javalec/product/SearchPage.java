package com.javalec.product;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SearchPage extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JComboBox comboBox;
	private JTextField textField;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private JButton btnNewButton_3;
	private JButton btnNewButton_3_1;
	
//	outerTable 생성
	private final DefaultTableModel outerTable = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPage dialog = new SearchPage();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public SearchPage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
			}
		});
		setTitle("검색창");
		setBounds(100, 100, 715, 1021);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getComboBox());
		getContentPane().add(getTextField());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnNewButton_3());
		getContentPane().add(getBtnNewButton_3_1());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("로고 이미지");
			lblNewLabel.setBounds(246, 25, 165, 49);
		}
		return lblNewLabel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Log-out");
			btnNewButton.setBounds(23, 51, 95, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("회원정보 정보 버튼");
			btnNewButton_1.setBounds(520, 38, 147, 49);
		}
		return btnNewButton_1;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setEditable(true);
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"브랜드", "제품명", "사이즈"}));
			comboBox.setBounds(23, 143, 95, 23);
		}
		return comboBox;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(144, 144, 375, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("검색");
			btnNewButton_2.setBounds(572, 143, 95, 23);
		}
		return btnNewButton_2;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(23, 201, 645, 525);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
		}
		return innerTable;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("장바구니 현황");
			btnNewButton_3.setBounds(363, 773, 142, 49);
		}
		return btnNewButton_3;
	}
	private JButton getBtnNewButton_3_1() {
		if (btnNewButton_3_1 == null) {
			btnNewButton_3_1 = new JButton("주문 내역");
			btnNewButton_3_1.setBounds(520, 773, 142, 49);
		}
		return btnNewButton_3_1;
	}
	
//---	Function  ---
	
	
//	Table 초기화 하기
	private void tableInit() {
		outerTable.addColumn("NO");
		outerTable.addColumn("상품사진");
		outerTable.addColumn("상품명");
		outerTable.addColumn("가격");
		outerTable.setColumnCount(4);
		
		
	//	Table Column 크기 정하기
		int colNo = 0;
		TableColumn col = innerTable.getColumnModel().getColumn(colNo);
		int width = 50;
		col.setPreferredWidth(width);
	
		colNo = 1;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 250;
		col.setPreferredWidth(width);
		
		colNo = 2;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 250;
		col.setPreferredWidth(width);
		
		colNo = 3;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		
		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
		
		
		
	//	Table 내용 지우기
		int i = outerTable.getRowCount();
		for(int j = 0; j<i; j++) {
			outerTable.removeRow(0);
		}
	}

	
}
