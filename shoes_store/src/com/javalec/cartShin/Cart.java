package com.javalec.cartShin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.product.BuyPage;
import com.javalec.product.ProductDAO;
import com.javalec.product.ProductDTO;
import com.javalec.util.ShareVar;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.WindowEvent;

public class Cart extends JDialog {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTable innertable;

//	outerTable 생성
	private final DefaultTableModel outerTable = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart dialog = new Cart();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Cart() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});

		setTitle("장바구니");
		setBounds(100, 100, 730, 519);
		getContentPane().setLayout(null);
		getContentPane().add(getScrollPane());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getTextField());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());

	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(36, 27, 617, 238);
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
					// tableClick();
				}
			});
			innertable.setFillsViewportHeight(true);
			innertable.setBorder(new LineBorder(new Color(0, 0, 0)));
			innertable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innertable.setModel(outerTable);
		}
		return innertable;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("결제금액");
			lblNewLabel.setBounds(36, 360, 50, 15);
		}
		return lblNewLabel;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(111, 357, 96, 21);
			textField.setColumns(10);
		}
		return textField;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("주문하기");
			btnNewButton.setBounds(477, 423, 91, 23);
		}
		return btnNewButton;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("삭제하기");
			btnNewButton_1.setBounds(591, 423, 91, 23);
		}
		return btnNewButton_1;
	}

//---	Function  ---

//	Table 초기화 하기
	private void tableInit() {
		outerTable.addColumn("NO");
		outerTable.addColumn("브랜드명");
		outerTable.addColumn("제품명");
		outerTable.addColumn("사이즈");
		outerTable.addColumn("가격");
		outerTable.addColumn("수량");
		outerTable.setColumnCount(6);

//		Table Column 크기 정하기
		int colNo = 0;
		TableColumn col = innertable.getColumnModel().getColumn(colNo);
		int width = 30;
		col.setPreferredWidth(width);

		colNo = 1;
		col = innertable.getColumnModel().getColumn(colNo);
		width = 150;
		col.setPreferredWidth(width);

		colNo = 2;
		col = innertable.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);

		colNo = 4;
		col = innertable.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);

		colNo = 5;
		col = innertable.getColumnModel().getColumn(colNo);
		width = 30;
		col.setPreferredWidth(width);

		innertable.setAutoResizeMode(innertable.AUTO_RESIZE_OFF);

		// Table 내용 지우기
		int i = outerTable.getRowCount();
		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}
	}

	
	//BuyPage에서 메소드 호출되야하므로 public 
	// BuyPage에서 장바구니 버튼 눌렀을 때, cart테이블에 정보 insert 처리
	public void insertActionByCartBtnClicked(List<String> list) {

		CartDao dao = new CartDao();
		
		int seq = Integer.parseInt(list.get(0));
		int cnt = Integer.parseInt(list.get(1));
		
		if (dao.insertActionByCartBtnClicked(seq, cnt) == true) {
			System.out.println("성공성");

			// insert후에 insert 된 데이터로 테이블에 조회처리
			//searchAction();
		} else {
			System.out.println("실패실패 ");
		}
	}
	
	//테이블에 조회되도록
	public void searchAction() {
		CartDao dao = new CartDao();
		//cartnum, obrand, oname, osize, oprice, cnt를 불러와야
		ArrayList<CartDto> dtoList = dao.selecList();
		
		System.out.println("Cart[searchAction] dtoList.get(0).getCartNum() :" + dtoList.get(0).getCartNum());
		System.out.println("접속2");
		
		System.out.println("Cart[searchAction] dtoList.get(0).getCartCount() :" + dtoList.get(0).getCartCount());
		
		for(int i = 0; i < dtoList.size(); i++) {
			String tmCartNum = Integer.toString(dtoList.get(i).getCartNum());
			String tmSize = Integer.toString(dtoList.get(i).getSize());
			String tmPrice = Integer.toString(dtoList.get(i).getPrice());
			String tmCartCount = Integer.toString(dtoList.get(i).getCartCount());
			
			String[] qTxt = { tmCartNum, dtoList.get(i).getBrand(), dtoList.get(i).getName(), tmSize, tmPrice, tmCartCount };
			outerTable.addRow(qTxt);
		}
		
	}
	
	
}
