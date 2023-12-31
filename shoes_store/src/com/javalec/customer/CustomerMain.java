package com.javalec.customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Image;
import java.awt.JobAttributes;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import com.javalec.base.Main;
import com.javalec.util.ShareVar;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTable;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.zone.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.security.KeyStore;

public class CustomerMain extends JFrame{
	

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblPw;
	private JTextField tfId;
	private JButton btnLogin;
	private JButton btnRegis;
	private JPasswordField pfPass;
	private JLabel lblimage;

	/**
	 * Launch the application.
	 */
	
	private int index;
	private static final String[] IMAGES= {
			"/com/javalec/images/신발가게.jpg"
	};
	
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
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				icon();
			}
		});
		frame.setBounds(100, 100, 617, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblPw());
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getBtnLogin());
		frame.getContentPane().add(getBtnRegis());
		frame.getContentPane().add(getPfPass());
		frame.getContentPane().add(getLblimage());
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
			
	
			/*Action ok = new AbstractAction() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					login();
					
				}
			};
			KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,false);
			JTextField tf = new JTextField();
			tf.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
			tf.getActionMap().put("ENTER", ok);*/
			
			JTextField textField = new JTextField()
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
		
		LocalDate now = LocalDate.now();
		
		LocalDate SeoulNow = LocalDate.now(ZoneId.of("Asia/Seoul"));
	
		
		String login="";
		Dao dao = new Dao();
		dao.confirm(inputID, inputPw);
		ArrayList<Dto> dtoList1 = dao.confirm(inputID, inputPw);
		dtoList1.size();
		
		
	if(inputID.equals("admin")) {
		if(dtoList1.size()>0) {
			if(inputID.equals(dtoList1.get(0).getUserid()) && inputPw.equals(dtoList1.get(0).getUserpw())) {
				JOptionPane.showMessageDialog(null, SeoulNow+" 관리자 로그인 성공" );
				ShareVar.userid=dtoList1.get(0).getUserid();
				ShareVar.password=dtoList1.get(0).getUserpw();
				ShareVar.name = dtoList1.get(0).getUsername();
				ShareVar.phone=dtoList1.get(0).getUserphone();
				String filepath = dtoList1.get(0).getFilepath();
				//Lobby();
			} else {
				JOptionPane.showMessageDialog(null, "로그인 실패");	}
		}else {
			JOptionPane.showMessageDialog(null, "로그인 실패");}
	}else {if(dtoList1.size()>0) {
		if(inputID.equals(dtoList1.get(0).getUserid()) && inputPw.equals(dtoList1.get(0).getUserpw())) {
			JOptionPane.showMessageDialog(null, SeoulNow+" 로그인 성공" );
			ShareVar.userid=dtoList1.get(0).getUserid();
			System.out.println(dtoList1.get(0).userid);
			ShareVar.password=dtoList1.get(0).getUserpw();
			ShareVar.name = dtoList1.get(0).getUsername();
			ShareVar.phone=dtoList1.get(0).getUserphone();
			String filepath = dtoList1.get(0).getFilepath();
			System.out.println(filepath);
			clearcolumn();
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
	private void clearcolumn() {

		tfId.setText("");
		pfPass.setText("");
	}
	private JLabel getLblimage() {
		if (lblimage == null) {
			lblimage = new JLabel("");
			lblimage.setBounds(0, 0, 603, 376);
		}
		return lblimage;
	}
	
	private void icon() {
		ImageIcon icon =  new ImageIcon(IMAGES[0]);
		Image i = icon.getImage();
		Image s = i.getScaledInstance(603,376, java.awt.Image.SCALE_SMOOTH);
		ImageIcon icons =  new ImageIcon(s);
		lblimage.setIcon(icons);
		lblimage.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblimage);	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

		}
		


