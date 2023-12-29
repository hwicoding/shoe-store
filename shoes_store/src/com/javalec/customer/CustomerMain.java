package com.javalec.customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.JobAttributes;

import javax.swing.JTextField;

import com.javalec.util.ShareVar;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CustomerMain {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblPw;
	private JTextField tfId;
	private JButton btnLogin;
	private JButton btnRegis;
	private JPasswordField pfPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMain window = new CustomerMain();
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
	public CustomerMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 617, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblPw());
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getBtnLogin());
		frame.getContentPane().add(getBtnRegis());
		frame.getContentPane().add(getPfPass());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("ID");
			lblNewLabel.setFont(new Font("Gulim", Font.PLAIN, 20));
			lblNewLabel.setBounds(110, 217, 50, 29);
		}
		return lblNewLabel;
	}
	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("PW");
			lblPw.setFont(new Font("Gulim", Font.PLAIN, 20));
			lblPw.setBounds(110, 280, 50, 29);
		}
		return lblPw;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(197, 217, 186, 29);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("로그인");
			btnLogin.addKeyListener(new KeyAdapter() {
				KeyListener listener = new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						int code =  e.getKeyCode();
						if(code==KeyEvent.VK_ENTER) {
							login();
						}
						
					}
				};
			});
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					login();
				}
			});
			btnLogin.setBounds(415, 222, 91, 23);
		}
		return btnLogin;
	}
	private JButton getBtnRegis() {
		if (btnRegis == null) {
			btnRegis = new JButton("회원가입");
			btnRegis.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					userRegistration();
				}
			});
			btnRegis.setBounds(415, 255, 91, 54);
		}
		return btnRegis;
	}
	private JPasswordField getPfPass() {
		if (pfPass == null) {
			pfPass = new JPasswordField();
			pfPass.setBounds(197, 280, 186, 29);
		}
		return pfPass;
	}
	
	private void login() {
		String id = tfId.getText();
		String pass = new String(pfPass.getPassword());
		
		if(tfId.getText().trim().length()==0) {
			JOptionPane.showMessageDialog(null, "아이디 입력필수");
			tfId.requestFocus();
			return;
		}else if(pass.trim().length()==0) {
			JOptionPane.showMessageDialog(null, "패스워드 입력 필수");
			pfPass.requestFocus();
			
		}else {
			confirm();
		}
		
	}
	private void userRegistration() {
		UserRegistration user = new UserRegistration();
		user.setVisible(true);
		
		
	}
	
	private void confirm() {
		String inputID = tfId.getText();
		char[] pw = pfPass.getPassword();
		String inputPw = new String(pw);
		
	
		
		String login="";
		Dao dao = new Dao();
		dao.confirm(inputID, inputPw);
		ArrayList<Dto> dtoList1 = dao.confirm(inputID, inputPw);
		dtoList1.size();
	if(inputID.equals("admin")) {
		if(dtoList1.size()>0) {
			if(inputID.equals(dtoList1.get(0).getUserid()) && inputPw.equals(dtoList1.get(0).getUserpw())) {
				JOptionPane.showMessageDialog(null, "관리자 로그인 성공" );
				System.out.println(dtoList1.get(0).userid);
				ShareVar.userid=dtoList1.get(0).getUserid();
				ShareVar.password=dtoList1.get(0).getUserpw();
				ShareVar.name = dtoList1.get(0).getUsername();
				ShareVar.phone=dtoList1.get(0).getUserphone();
				String filepath = Integer.toString(ShareVar.filename);
				//Lobby();
			} else {
				JOptionPane.showMessageDialog(null, "로그인 실패");	}
		}else {
			JOptionPane.showMessageDialog(null, "로그인 실패");}
	}else {if(dtoList1.size()>0) {
		if(inputID.equals(dtoList1.get(0).getUserid()) && inputPw.equals(dtoList1.get(0).getUserpw())) {
			JOptionPane.showMessageDialog(null, "로그인 성공" );
			ShareVar.userid=dtoList1.get(0).getUserid();
			ShareVar.password=dtoList1.get(0).getUserpw();
			ShareVar.name = dtoList1.get(0).getUsername();
			ShareVar.phone=dtoList1.get(0).getUserphone();
			String filepath = Integer.toString(ShareVar.filename);
			Lobby();
		} else {
			JOptionPane.showMessageDialog(null, "로그인 실패");	}
	}else {
		JOptionPane.showMessageDialog(null, "로그인 실패");}
			
		}
	}
	

	

	
	private void Lobby() {
			Lobby user = new Lobby();
			user.setVisible(true);
			CustomerMain main = new CustomerMain();
			
			
			
			
	}
	

		}
		


