package com.javalec.cart;

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
	
	int seqno;
	String name;
	String price;
	String size;
	String color;
	String count;
	
	
	// Constructor
	
	public CartDao() {
		
	}
	
	public CartDao(int seqno) {
		super();
		this.seqno = seqno;
	}

	public CartDao(int seqno, String name, String price, String size, String color, String count) {
		super();
		this.seqno = seqno;
		this.name = name;
		this.price = price;
		this.size = size;
		this.color = color;
		this.count = count;
	}

	
	
	// Method

	public ArrayList<CartDao> selectList(){
	 ArrayList<CartDto> cartdtoList = new ArrayList<CartDto>();
	 String whereDefault = "select seqno, name, price, size, color, count from product";
	
	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql  = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			
			while(rs.next()) {
				
				int wkSeq = rs.getInt(1);
				String wkName = rs.getString(2);
				String wkPrice = rs.getString(3);
				String wkSize = rs.getString(4);
				String wkColor = rs.getString(5);
				String wkCount = rs.getString(6);
				
				CartDto cartDto = new CartDto(wkSeq, wkName, wkPrice, wkSize, wkColor, wkCount);
				cartdtoList.add(cartDto);

				
			}
			conn_mysql.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartdtoList;
	}
}

	
	
	


