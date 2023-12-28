package com.javalec.cart;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.util.ShareVar;

public class CartDao {

	
	// Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;
	
	int seqno, size, count, price;
	String brnad, name, color;
	FileInputStream file;
	
	
	// Constructor
	
	public CartDao() {
		
	}
	
	public CartDao(int seqno) {
		super();
		this.seqno = seqno;
	}

	
	public CartDao(String brand, String name, int size, int price, int count) {
		super();
		this.size = size;
		this.count = count;
		this.price = price;
		this.brnad = brnad;
		this.name = name;
	}

	
	// Method

	public ArrayList<CartDao> selectList(){
	 ArrayList<CartDto> dtoList = new ArrayList<CartDto>();
	 String whereDefault = "select brand, name, size, price, count from product";
	
	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql  = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			
			while(rs.next()) {
				
				String wkBrand = rs.getString(1);
				String wkName = rs.getString(2);
				int wkSize = rs.getInt(3);
				int wkPrice = rs.getInt(4);
				int wkCount = rs.getInt(5);
				
				
				CartDto dto = new CartDto(wkBrand, wkName, wkSize, wkPrice, wkCount);
				dtoList.add(dto);

				
			}
			conn_mysql.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
//	Table 을 Click 하였을 경우
	public CartDto tableClick() {
		
		cartd dto = null;
		
		String where1 = "select seqno, name, telno, address, email, relation, file from userinfo";
		String where2 = " where seqno = " + seqno;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
			Statement stmt_mysql  = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(where1 + where2);
			
			if(rs.next()) {
				
				int wkSeq = rs.getInt(1);
				String wkName = rs.getString(2);
				String wkTelno = rs.getString(3);
				String wkAddress = rs.getString(4);
				String wkEmail = rs.getString(5);
				String wkRelation = rs.getString(6);
				
//				file
				ShareVar.filename = ShareVar.filename + 1;
				File file = new File(Integer.toString(ShareVar.filename));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(7);
				byte[] buffer = new byte[1024];
				
				while(input.read(buffer) > 0) {
					output.write(buffer);
				}

				dto = new Dto(wkSeq, wkName, wkTelno, wkAddress, wkEmail, wkRelation);

		
			}
			conn_mysql.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
		
	}
}

	
	//
	


