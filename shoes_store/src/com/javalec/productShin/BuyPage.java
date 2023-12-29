package com.javalec.productShin;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.javalec.cart.Cart;
import com.javalec.sale.SaleDao;
import com.javalec.sale.SaleDto;
import com.javalec.util.ShareVar;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private JTextField tfCount;
	private JComboBox cbSize;
	private JComboBox cbColor;
	private Container container;

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
		getContentPane().add(getTfCount());

	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("이미지");
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
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnCartClicked();
				}
			});
			btnNewButton.setBounds(775, 353, 121, 52);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("뒤로가기");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clickedBackIcon();
				}
			});
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
	private JTextField getTfCount() {
		if (tfCount == null) {
			tfCount = new JTextField();
			tfCount.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if((e.getKeyChar() >= '0' && e.getKeyChar() <= '9' ) || e.getKeyCode() == KeyEvent.VK_CAPS_LOCK ||
						e.getKeyCode() == KeyEvent.VK_ENTER) {
					} else {
						JFrame jframe = new JFrame();
						jframe.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(jframe, "숫자만 입력하세요.");
					}
					
				}
			});
			
			tfCount.setHorizontalAlignment(SwingConstants.TRAILING);
			tfCount.setColumns(10);
			tfCount.setBounds(815, 230, 91, 21);
		}
		return tfCount;
	}
	
	//---------------- function -------------------------
	
	//SearchPage에서 브랜드 상품명 가격을 가지고 창이 열릴 때 정보 뿌려주는 메소드 
	public void selectByinfo(List<String> list) {
		
		SearchPage page = new SearchPage();
		
		tfBrand.setText(list.get(0));
		tfName.setText(list.get(1));
		tfPrice.setText(list.get(2));
		
		String filePath = Integer.toString(ShareVar.filename);
		if(!filePath.equals("0")) {
			lblImage.setText("");
			lblImage.setIcon(new ImageIcon(filePath));
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		getBrandSize(list.get(0), list.get(1));
		getBrandColor(list.get(0), list.get(1));
		
	}
	
	//브랜드명, 제품명을 가지고 그 해당 제품의 사이즈 가져오기
	public void getBrandSize(String brand, String name) {

		ProductDAO dao = new ProductDAO();
		ArrayList <ProductDTO> dtoList = dao.getBrandSize(brand, name);
		
		String[] qTxt = new String[dtoList.size()];
		for(int i = 0; i < dtoList.size(); i++) {
			qTxt[i] = Integer.toString(dtoList.get(i).getSize());
		}
		
		//cbSize comboBox 설정 
		container = this.getContentPane();
		container.setLayout(null);
		cbSize = null;
		if(cbSize == null) {
			cbSize = new JComboBox(qTxt);
			cbSize.setBounds(658, 228, 100, 27);
		}
		
		container.add(cbSize);
	}
	
	//브랜드와 제품의 색상 가져오기
	public void getBrandColor(String brand, String name) {

		ProductDAO dao = new ProductDAO(); 
		ArrayList <ProductDTO> dtoList = dao.getBrandColor(brand, name);
		
		String[] qTxt = new String[dtoList.size()];
		for(int i = 0; i < dtoList.size(); i++) {
			qTxt[i] = dtoList.get(i).getColor();
		}
		
		//cbColor comboBox 설정 
		container = this.getContentPane();
		container.setLayout(null);
		cbColor = null;
		if(cbColor == null) {
			cbColor = new JComboBox(qTxt);
			cbColor.setBounds(658, 278, 100, 27);
		}
		
		container.add(cbColor);
	}
	
	//뒤로가기 버튼 클릭 메소드 
	private void clickedBackIcon() {
		this.dispose();
		SearchPage page = new SearchPage();
		page.setVisible(true);
	}
	
	//장바구니 버튼 클릭했을 떼 
	private void btnCartClicked() {
		
		if(checkField() == true) {
			getAllInfo();
			this.dispose();
			Cart cart = new Cart();
			cart.setVisible(true);
		} 
		return;
	}
	
	//field 체크 메소드 
	private boolean checkField() {
		JFrame jframe = new JFrame();
		jframe.setAlwaysOnTop(true);
		
		final String REX = "^[0-9]*$";
		
		if(tfCount.getText().length() != 0) {
			if(Pattern.matches(REX, tfCount.getText())) {
				return true;
			}
			JOptionPane.showMessageDialog(jframe, "숫자만 입력하세요.");
			tfCount.setText("");
			tfCount.requestFocus();
		}
		JOptionPane.showMessageDialog(jframe , "수량을 입력해주세요!");
		tfCount.requestFocus();
		return false;
	}
	
	//입력된 모든 정보 가져오기 
//	public void getAllInfo() {
//		
//		String brand = tfBrand.getText();
//		String name = tfName.getText();
//		int price = Integer.parseInt(tfPrice.getText());
//		int size = (Integer) cbSize.getSelectedItem();
//		int cnt = Integer.parseInt(tfCount.getText());
//		String color = (String) cbColor.getSelectedItem();
//
//		ProductDAO dao = new ProductDAO(brand, name, price, size, cnt, color);
//		ArrayList <ProductDTO> dtoList = dao.getAllInfo();
//		ShareVar.prodList.add(dtoList);
//		
//	}

	
	public List<String> getAllInfo() {
		String brand = tfBrand.getText();
		String name = tfName.getText();
		int price = Integer.parseInt(tfPrice.getText());
		int size = Integer.parseInt(cbSize.getSelectedItem().toString());
		int cnt = Integer.parseInt(tfCount.getText());
		String color = cbColor.getSelectedItem().toString();
		

		ProductDAO dao = new ProductDAO(brand, name, price, size, cnt, color);
		
		/**********************************************************************************
		 * 
		 * 나중에 지워줘야함~!~!!~!~!~!~!~!~!
		 * 
		 *********************************************************************************/
		
		int cartBtnClickedBySeq = dao.getAllInfo();
		
		//list에 product의 pseq와 입력한 수량을 넣어줌 
		List<String> list = new ArrayList<>();
		list.add(0, Integer.toString(cartBtnClickedBySeq));
		list.add(1, Integer.toString(cnt));
		
		
		System.out.println("BuyPage[dto.getSeqno] : "+ cartBtnClickedBySeq);
		
		//cart객체 insertActionByCartBtnClicked메소드가 list를 가지고 실행 
		Cart cart = new Cart();
		cart.insertActionByCartBtnClicked(list);
		
		return list;
	}
		
	
}
