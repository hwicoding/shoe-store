package com.javalec.customer;

import java.awt.EventQueue;

import javax.swing.JDialog;

import com.javalec.util.ShareVar;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lobby extends JDialog {

	private static final long serialVersionUID = 1L;
	private JButton btnSetting;
	private JLabel lblName;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lobby dialog = new Lobby();
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
	public Lobby() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				checkstatus();
			}
		});
		setBounds(100, 100, 617, 443);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnSetting());
		getContentPane().add(getLblName());
		getContentPane().add(getBtnNewButton());

	}
	private JButton getBtnSetting() {
		if (btnSetting == null) {
			btnSetting = new JButton("");
			btnSetting.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkpage();
				}
			});
			btnSetting.setIcon(new ImageIcon("C:\\Users\\qazxd\\Downloads\\cogwheel_114848 (1).png"));
			btnSetting.setBounds(544, 0, 59, 48);
		}
		return btnSetting;
	}
	
	private void checkstatus() {
		lblName.setText(ShareVar.name+"님 환영합니다.");
	
		
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("");
			lblName.setBounds(379, 10, 153, 21);
		}
		return lblName;
	}
	
	private void checkpage() {
		customerCheck user = new customerCheck();
		user.setVisible(true);
		
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("로그아웃");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					logout();
				}
			});
			btnNewButton.setBounds(512, 49, 91, 23);
		}
		return btnNewButton;
	}
	
	private void logout() {
		int result=JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
		if(result==JOptionPane.CLOSED_OPTION) {
			JOptionPane.showMessageDialog(null, "잘못된 입력입니다.");
		}else if(result==JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "로그아웃이 완료되었습니다.");
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "로그인 상태입니다.");
		}
		
	}
}
