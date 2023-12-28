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
	 String whereDefault = "select seqno, name, telno, relation from userinfo";
	

	
	
	


