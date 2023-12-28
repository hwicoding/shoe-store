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

import com.javalec.purchase.OrderPage;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class SearchPage extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JComboBox cbSelection;
	private JTextField tfSelection;
	private JButton btnQuery;
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
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		setTitle("검색창");
		setBounds(100, 100, 658, 880);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getCbSelection());
		getContentPane().add(getTfSelection());
		getContentPane().add(getBtnQuery());
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
			btnNewButton_1.setBounds(479, 38, 147, 49);
		}
		return btnNewButton_1;
	}
	private JComboBox getCbSelection() {
		if (cbSelection == null) {
			cbSelection = new JComboBox();
			cbSelection.setEditable(true);
			cbSelection.setModel(new DefaultComboBoxModel(new String[] {"브랜드", "제품명", "사이즈"}));
			cbSelection.setBounds(23, 143, 95, 23);
		}
		return cbSelection;
	}
	private JTextField getTfSelection() {
		if (tfSelection == null) {
			tfSelection = new JTextField();
			tfSelection.setBounds(144, 144, 343, 21);
			tfSelection.setColumns(10);
		}
		return tfSelection;
	}
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton("검색");
			btnQuery.setBounds(531, 143, 95, 23);
		}
		return btnQuery;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setEnabled(false);
			scrollPane.setBounds(23, 201, 603, 525);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
				}
			});
			innerTable.setFillsViewportHeight(true);
			innerTable.setBorder(new LineBorder(new Color(0, 0, 0)));
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
		}
		return innerTable;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("장바구니 현황");
			btnNewButton_3.setBounds(327, 775, 142, 49);
		}
		return btnNewButton_3;
	}
	private JButton getBtnNewButton_3_1() {
		if (btnNewButton_3_1 == null) {
			btnNewButton_3_1 = new JButton("주문 내역");
			btnNewButton_3_1.setBounds(484, 775, 142, 49);
		}
		return btnNewButton_3_1;
	}
	
//---	Function  ---
	
	
//	Table 초기화 하기
	private void tableInit() {
		outerTable.addColumn("NO");
		outerTable.addColumn("브랜드");
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
		width = 200;
		col.setPreferredWidth(width);
		
		colNo = 2;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 200;
		col.setPreferredWidth(width);
		
		colNo = 3;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 200;
		col.setPreferredWidth(width);
		
		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
		
		
		
// Table 내용 지우기
		int i = outerTable.getRowCount();
		for(int j = 0; j<i; j++) {
			outerTable.removeRow(0);
		}
	}
	
//	검색	
	private void searchAction() {
		ProductDAO dao = new ProductDAO();
		ArrayList<ProductDTO> dtoList = dao.selecList();
		
		int listCount = dtoList.size();
		
		for(int i = 0; i < listCount; i++) {
			String temp = Integer.toString(dtoList.get(i).getSeqno());
			String[] qTxt = {temp,
									 dtoList.get(i).getBrand(),
									 dtoList.get(i).getName(),
									 Integer.toString(dtoList.get(i).getPrice())};
			outerTable.addRow(qTxt);
		}
	}

	
//	Table 에서 Row 를 click 했을 경우
	private void tableClick() {
		int i = innerTable.getSelectedRow();
		String tkSequence = (String)innerTable.getValueAt(i, 0);
		int wkSequence = Integer.parseInt(tkSequence);
		
		ProductDAO dao = new ProductDAO(wkSequence);
		ProductDTO dto = dao.tableClick();
		
		closeWindow();
		
		BuyPage buyPage = new BuyPage();
		buyPage.selectByinfo(wkSequence);
		
		
		//buyPage(wkSequence);	
		
	}
	
	private void closeWindow( ) {
		dispose();
		
		BuyPage buyPage = new BuyPage();
		buyPage.setVisible(true);
	}
	
//	private void buyPage(int seq) {
//		
//		System.out.println(seq);
//		
//	}
	

	
}
