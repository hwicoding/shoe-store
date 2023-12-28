package com.javalec.product;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BuyPage extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblImage;
	private JLabel lblNewLabel_1;
	private JTextField tfBrand;
	private JLabel lblNewLabel_1_1;
	private JTextField tfName;
	private JLabel lblNewLabel_1_1_1;
	private JTextField tfPrice;
	private JLabel lblNewLabel_1_1_1_1;
	private JLabel lblNewLabel_1_1_1_1_1;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1_1_1_1_2;
	private JTextField tfSize;
	private JTextField tfCount;
	private JTextField tfColor;
	private JLabel lblNewLabel;
	private JTextField tfSeqno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyPage dialog = new BuyPage();
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
	public BuyPage() {
		getContentPane().setEnabled(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				//selectByinfo( );
				
			}
		});
		setTitle("구매 페이지");
		setBounds(100, 100, 973, 489);
		getContentPane().setLayout(null);
		getContentPane().add(getLblImage());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getTfBrand());
		getContentPane().add(getLblNewLabel_1_1());
		getContentPane().add(getTfName());
		getContentPane().add(getLblNewLabel_1_1_1());
		getContentPane().add(getTfPrice());
		getContentPane().add(getLblNewLabel_1_1_1_1());
		getContentPane().add(getLblNewLabel_1_1_1_1_1());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_1_1_1_1_2());
		getContentPane().add(getTfSize());
		getContentPane().add(getTfCount());
		getContentPane().add(getTfColor());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getTfSeqno());

	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("이미지");
			lblImage.setEnabled(false);
			lblImage.setBackground(new Color(255, 128, 64));
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setBounds(42, 80, 535, 340);
		}
		return lblImage;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("브랜드");
			lblNewLabel_1.setBounds(602, 85, 61, 21);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfBrand() {
		if (tfBrand == null) {
			tfBrand = new JTextField();
			tfBrand.setEnabled(false);
			tfBrand.setBounds(658, 85, 248, 21);
			tfBrand.setColumns(10);
		}
		return tfBrand;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("상품명");
			lblNewLabel_1_1.setBounds(602, 130, 61, 21);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setEnabled(false);
			tfName.setColumns(10);
			tfName.setBounds(658, 130, 248, 21);
		}
		return tfName;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("가격");
			lblNewLabel_1_1_1.setBounds(602, 181, 61, 21);
		}
		return lblNewLabel_1_1_1;
	}
	private JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setEnabled(false);
			tfPrice.setColumns(10);
			tfPrice.setBounds(658, 181, 91, 21);
		}
		return tfPrice;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("사이즈");
			lblNewLabel_1_1_1_1.setBounds(602, 230, 61, 21);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1 = new JLabel("수량");
			lblNewLabel_1_1_1_1_1.setBounds(770, 231, 44, 21);
		}
		return lblNewLabel_1_1_1_1_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("장바구니 담기");
			btnNewButton.setBounds(775, 353, 121, 52);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("뒤로가기");
			btnNewButton_2.setBounds(40, 23, 80, 42);
		}
		return btnNewButton_2;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("로고");
			lblNewLabel_2.setBounds(328, 34, 165, 31);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_1_1_1_1_2() {
		if (lblNewLabel_1_1_1_1_2 == null) {
			lblNewLabel_1_1_1_1_2 = new JLabel("색상");
			lblNewLabel_1_1_1_1_2.setBounds(602, 280, 61, 21);
		}
		return lblNewLabel_1_1_1_1_2;
	}
	private JTextField getTfSize() {
		if (tfSize == null) {
			tfSize = new JTextField();
			tfSize.setEnabled(false);
			tfSize.setBounds(658, 230, 91, 21);
			tfSize.setColumns(10);
		}
		return tfSize;
	}
	private JTextField getTfCount() {
		if (tfCount == null) {
			tfCount = new JTextField();
			tfCount.setEnabled(false);
			tfCount.setColumns(10);
			tfCount.setBounds(815, 230, 91, 21);
		}
		return tfCount;
	}
	private JTextField getTfColor() {
		if (tfColor == null) {
			tfColor = new JTextField();
			tfColor.setEnabled(false);
			tfColor.setColumns(10);
			tfColor.setBounds(658, 280, 91, 21);
		}
		return tfColor;
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("번호");
			lblNewLabel.setBounds(602, 42, 52, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTfSeqno() {
		if (tfSeqno == null) {
			tfSeqno = new JTextField();
			tfSeqno.setEnabled(false);
			tfSeqno.setBounds(658, 39, 33, 21);
			tfSeqno.setColumns(10);
		}
		return tfSeqno;
	}
	
	public void selectByinfo(int wkSequence) {
		
		ProductDAO dao = new ProductDAO(wkSequence);
		ProductDTO dto = dao.tableClick();
		
		tfSeqno.setText(Integer.toString(dto.getSeqno()));
		tfBrand.setText(dto.getBrand());
		tfName.setText(dto.getName	());
		tfPrice.setText(Integer.toString(dto.getPrice()));
		tfCount.setText(Integer.toString(dto.getCount()));
		tfColor.setText(dto.getColor());
		
		
	}

}
