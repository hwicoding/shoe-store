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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lobby extends JDialog {

	private static final long serialVersionUID = 1L;
	private JButton btnSetting;
	private JLabel lblName;

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
}
