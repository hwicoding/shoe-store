package com.javalec.product;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class BuyPage extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JLabel lblNewLabel_1_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_1_1_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_1_1_1_1;
	private JLabel lblNewLabel_1_1_1_1_1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_2;

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
		setTitle("구매 페이지");
		setBounds(100, 100, 973, 489);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getTextField());
		getContentPane().add(getLblNewLabel_1_1());
		getContentPane().add(getTextField_1());
		getContentPane().add(getLblNewLabel_1_1_1());
		getContentPane().add(getTextField_2());
		getContentPane().add(getLblNewLabel_1_1_1_1());
		getContentPane().add(getLblNewLabel_1_1_1_1_1());
		getContentPane().add(getComboBox());
		getContentPane().add(getComboBox_1());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getLblNewLabel_2());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("이미지");
			lblNewLabel.setEnabled(false);
			lblNewLabel.setBackground(new Color(255, 128, 64));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(42, 80, 535, 340);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("브랜드");
			lblNewLabel_1.setBounds(643, 83, 61, 21);
		}
		return lblNewLabel_1;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(699, 83, 152, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("상품명");
			lblNewLabel_1_1.setBounds(643, 128, 61, 21);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(699, 128, 152, 21);
		}
		return textField_1;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("가격");
			lblNewLabel_1_1_1.setBounds(643, 179, 61, 21);
		}
		return lblNewLabel_1_1_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(699, 179, 152, 21);
		}
		return textField_2;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("사이즈");
			lblNewLabel_1_1_1_1.setBounds(643, 228, 61, 21);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1 = new JLabel("수량");
			lblNewLabel_1_1_1_1_1.setBounds(643, 287, 61, 21);
		}
		return lblNewLabel_1_1_1_1_1;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(699, 227, 91, 23);
		}
		return comboBox;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setBounds(699, 286, 91, 23);
		}
		return comboBox_1;
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
}
