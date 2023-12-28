package com.javalec.customer;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFileChooser;

import com.javalec.util.ShareVar;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import java.awt.JobAttributes;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mypage extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblPw;
	private JLabel lblPw_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfPhone;
	private JPasswordField pfPw;
	private JPasswordField pfPw2;
	private JButton btncheck;
	private JButton btnCheckpw;
	private JButton btnEdit;
	private JButton btnFile;
	private JTextField tfFilepath;
	private JLabel lblImage;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mypage dialog = new Mypage();
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
	public Mypage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				action1();
			}
		});
		setBounds(100, 100, 617, 443);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblPw());
		getContentPane().add(getLblPw_1());
		getContentPane().add(getLblNewLabel_1_1());
		getContentPane().add(getLblNewLabel_1_1_1());
		getContentPane().add(getTfId());
		getContentPane().add(getTfName());
		getContentPane().add(getTfPhone());
		getContentPane().add(getPfPw());
		getContentPane().add(getPfPw2());
		getContentPane().add(getBtncheck());
		getContentPane().add(getBtnCheckpw());
		getContentPane().add(getBtnEdit());
		getContentPane().add(getBtnFile());
		getContentPane().add(getTfFilepath());
		getContentPane().add(getLblImage());
		getContentPane().add(getBtnNewButton());

	}
	
	private void action1() {
		tfId.setText(ShareVar.userid);
		pfPw.setText(ShareVar.password);
		tfName.setText(ShareVar.name);
		tfPhone.setText(ShareVar.phone);
		String filepath = Integer.toString(ShareVar.filename);
		tfFilepath.setText(filepath);
		lblImage.setIcon(new ImageIcon(filepath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		File file = new File(filepath);
	
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("ID:");
			lblNewLabel.setFont(new Font("Gulim", Font.PLAIN, 16));
			lblNewLabel.setBounds(39, 62, 57, 25);
		}
		return lblNewLabel;
	}
	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("PW:");
			lblPw.setFont(new Font("Gulim", Font.PLAIN, 16));
			lblPw.setBounds(39, 109, 57, 25);
		}
		return lblPw;
	}
	private JLabel getLblPw_1() {
		if (lblPw_1 == null) {
			lblPw_1 = new JLabel("PW 확인:");
			lblPw_1.setFont(new Font("Gulim", Font.PLAIN, 16));
			lblPw_1.setBounds(39, 161, 75, 25);
		}
		return lblPw_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("이름:");
			lblNewLabel_1_1.setFont(new Font("Gulim", Font.PLAIN, 16));
			lblNewLabel_1_1.setBounds(39, 208, 57, 25);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("전화번호:");
			lblNewLabel_1_1_1.setFont(new Font("Gulim", Font.PLAIN, 16));
			lblNewLabel_1_1_1.setBounds(39, 264, 75, 25);
		}
		return lblNewLabel_1_1_1;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(166, 63, 131, 25);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setEditable(false);
			tfName.setColumns(10);
			tfName.setBounds(166, 208, 106, 25);
		}
		return tfName;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setEditable(false);
			tfPhone.setColumns(10);
			tfPhone.setBounds(166, 264, 180, 25);
		}
		return tfPhone;
	}
	private JPasswordField getPfPw() {
		if (pfPw == null) {
			pfPw = new JPasswordField();
			pfPw.setEditable(false);
			pfPw.setBounds(166, 109, 152, 25);
		}
		return pfPw;
	}
	private JPasswordField getPfPw2() {
		if (pfPw2 == null) {
			pfPw2 = new JPasswordField();
			pfPw2.setEditable(false);
			pfPw2.setBounds(166, 161, 152, 25);
		}
		return pfPw2;
	}
	private JButton getBtncheck() {
		if (btncheck == null) {
			btncheck = new JButton("중복체크");
			btncheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					check1();
				}
			});
			btncheck.setBounds(339, 62, 91, 25);
		}
		return btncheck;
	}
	private JButton getBtnCheckpw() {
		if (btnCheckpw == null) {
			btnCheckpw = new JButton("비밀번호 확인");
			btnCheckpw.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pwcheck();
				}
			});
			btnCheckpw.setBounds(339, 111, 106, 25);
		}
		return btnCheckpw;
	}
	private JButton getBtnEdit() {
		if (btnEdit == null) {
			btnEdit = new JButton("수정 완료");
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					update();
				}
			});
			btnEdit.setBounds(227, 357, 91, 25);
		}
		return btnEdit;
	}
	private JButton getBtnFile() {
		if (btnFile == null) {
			btnFile = new JButton("파일경로");
			btnFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Filepath();
				}
				}
			);
			btnFile.setBounds(448, 339, 91, 25);
		}
		return btnFile;}
	
	private JTextField getTfFilepath() {
		if (tfFilepath == null) {
			tfFilepath = new JTextField();
			tfFilepath.setEditable(false);
			tfFilepath.setBounds(379, 374, 224, 21);
			tfFilepath.setColumns(10);
		}
		return tfFilepath;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setBounds(379, 167, 212, 164);
		}
		return lblImage;
	}
	private void check1() {
		String id = tfId.getText();
		char[] pw = pfPw.getPassword();
		String pass = new String(pw);
		char[] pw1 = pfPw2.getPassword();
		String pass2 = new String(pw1);
		String name = tfName.getText();
		String phone =tfPhone.getText();
		String login ="";
		Dao dao = new Dao(id, pass);
		boolean result = dao.check();
		
		if(id==ShareVar.userid) {
			JOptionPane.showMessageDialog(null, "이전 아이디와 동일합니다");
		}
		else if(result==false) {
			JOptionPane.showMessageDialog(null, "중복입니다");
		}else {
			JOptionPane.showMessageDialog(null, "사용가능합니다");
			pfPw.setEditable(true);
			pfPw2.setEditable(true);
		}	
		}
	private void pwcheck() {
		char[] pw = pfPw.getPassword();
		String pass = new String(pw);
		char[] pw1 = pfPw2.getPassword();
		String pass2 = new String(pw1);
		
		if(pass.length()==0||pass2.length()==0) {
			JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
		}
		
		else if(pass.equals(pass2)) {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치합니다");
			tfName.setEditable(true);
			tfPhone.setEditable(true);
			
		}else {
			JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다");
		}
	}
	private void update() {
		String id =tfId.getText();
		char[] pass =pfPw.getPassword();
		String pw=new String(pass);
		char[] pass1=pfPw2.getPassword();
		String pw1 =  new String(pass1);
		String name= tfName.getText();
		String phone = tfPhone.getText();

		FileInputStream input = null;
		File file = new File(tfFilepath.getText());
		try {
			input= new FileInputStream(file);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Dao dao = new Dao(id,pw,name,phone,input);
		boolean result = dao.updateAction();
		if(result==true) {
			JOptionPane.showMessageDialog(null, tfName.getText()+"님의 수정이 완료되었습니다.");
			
		}else {
			JOptionPane.showMessageDialog(null, "잘못된 부분이 없는지 확인하세요");
		}}
		private void Filepath() {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG","PNG","BMP", "jpg","png","bmp");
			chooser.setFileFilter(filter);
			
			int ret = chooser.showOpenDialog(null);
			if(ret !=JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.");
				return;
			}
			String filepath = chooser.getSelectedFile().getPath();// 파일경로 가져오기
			tfFilepath.setText(filepath);
			lblImage.setIcon(new ImageIcon(filepath));
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("아이디 변경X");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					change();
				}
			});
			btnNewButton.setBounds(442, 62, 131, 25);
		}
		return btnNewButton;
	}
	private void change() {
		String id =tfId.getText();
		char[] pass =pfPw.getPassword();
		String pw=new String(pass);
		char[] pass1=pfPw2.getPassword();
		String pw1 =  new String(pass1);
		String name= tfName.getText();
		String phone = tfPhone.getText();
		
		tfId.setEditable(false);
		pfPw.setEditable(true);
		pfPw2.setEditable(true);
	}
	
		}