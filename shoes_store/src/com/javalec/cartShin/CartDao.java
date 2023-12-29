package com.javalec.cartShin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.product.ProductDTO;
import com.javalec.util.ShareVar;

public class CartDao {

//	Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String ps_mysql = ShareVar.dbPass;
	
	int seqno, size, count, price;
	String brand, name, color;
	int cartNum;
	int cartCount;
	
//	constructor
	
	public CartDao() {
		// TODO Auto-generated constructor stub
	}

	public CartDao(int seqno) {
		super();
		this.seqno = seqno;
	}

	public CartDao(int seqno, String name, String brand, int size, int price, int count) {
		super();
		this.seqno = seqno;
		this.name = name;
		this.brand = brand;
		this.size = size;
		this.price = price;
		this.count = count;
	}
	

	//BuyPage에서 장바구니 버튼 눌렀을 때, cart테이블에 정보 insert 처리 
	public boolean insertActionByCartBtnClicked(int seq, int inputCnt) {
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
			
			String query = "insert into cart (cartcount, userid, pseq) values (?,?,?)";
			
			ps = conn.prepareStatement(query);
			
			System.out.println("ShareVar.userId : "+ShareVar.userid);
			
			ps.setInt(1, inputCnt);
			ps.setString(2, ShareVar.userid);
			ps.setInt(3, seq);
			
			
			ps.executeUpdate();
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	//테이블에 정보조회되도록 select
	public ArrayList<CartDto> selecList() {
		ArrayList<CartDto> dtoList = new ArrayList<CartDto>();
		
		//cartnum, obrand, oname, osize, oprice, cnt를 불러와야
		String query = "select c.cartnum, o.obrand, o.oname, o.osize, o.oprice, c.cartcount from cart c, product p , orderProd o where c.userid='"+ShareVar.userid+"' and c.pseq = p.pseq and p.oseq = o.oseq";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				
				int wkCartNum = rs.getInt(1);
				String wkBrand = rs.getString(2);
				String wkName = rs.getString(3);
				int wkSize = rs.getInt(4);
				int wkPrice = rs.getInt(5);
				int wkCartCount = rs.getInt(6);
				
				CartDto dto = new CartDto(wkCartNum, wkBrand, wkName, wkSize, wkPrice, wkCartCount);
				dtoList.add(dto);
			}
			conn_mysql.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	
	//	Table 에서 Row 를 click 했을 경우
	public CartDto tableclick() {
		
		CartDto dto = null;
		
		String where1 = "select seq, name, brand, size, price, count, pfile " ;
		String where2 = "from product " ;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(where1 + where2);
			
			if(rs.next()) {
				int wkSeqno = rs.getInt(1);
				String wkName = rs.getString(2);
				String wkBrand = rs.getString(3);
				int wkSize = rs.getInt(4);
				int wkPrice = rs.getInt(5);
				int wkCount = rs.getInt(6);
				
//				file
				ShareVar.filename = ShareVar.filename + 1;
				File file = new File(Integer.toString(ShareVar.filename));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(8);
				byte[] buffer = new byte[1024];
				
				while(input.read(buffer)>0) {
					output.write(buffer);
				}
				
				dto = new CartDto(wkSeqno, wkName, wkBrand, wkSize, wkPrice, wkCount);
			}
			
			conn_mysql.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
		
	}
	
	
	

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
