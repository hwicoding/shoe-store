package com.javalec.order;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.util.ShareVar;

public class OrderDao {

	private final String url = ShareVar.dbName;
	private final String id = ShareVar.dbUser;
	private final String pw = ShareVar.dbPass;
	
	int oseq;
	String obrand;
	String oname;
	int oprice;
	int ocnt;
	int osize;
	String ocolor;
	Date odate;
	
	
	public OrderDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public OrderDao(int oseq) {
		super();
		this.oseq = oseq;
	}
	
	

	public OrderDao(String obrand, String oname, int oprice, int ocnt, int osize, String ocolor) {
		super();
		this.obrand = obrand;
		this.oname = oname;
		this.oprice = oprice;
		this.ocnt = ocnt;
		this.osize = osize;
		this.ocolor = ocolor;
	}


	public OrderDao(int oseq, String obrand, String oname, int oprice, int osize, int ocnt, String ocolor) {
		super();
		this.oseq = oseq;
		this.obrand = obrand;
		this.oname = oname;
		this.oprice = oprice;
		this.osize = osize;
		this.ocnt = ocnt;
		this.ocolor = ocolor;
	}


	public ArrayList<OrderDto> searchAction() {
		ArrayList<OrderDto> dtoList = new ArrayList<OrderDto>();
		String query = "select oseq, obrand, oname, oprice, ocnt, osize, ocolor from orderProd order by obrand";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				int wkSeq = rs.getInt(1);
				String weBrand = rs.getString(2);
				String wkName = rs.getString(3);
				int wkPrice = rs.getInt(4);
				int wkCnt = rs.getInt(5);
				int wkSize = rs.getInt(6);
				String wkColor = rs.getString(7);
				
				OrderDto dto = new OrderDto(wkSeq, weBrand, wkName, wkPrice, wkCnt, wkSize, wkColor);
				dtoList.add(dto);
			}
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	public OrderDto cellClicked() {
		OrderDto dto = null;
		String query = "select oseq, obrand, oname, oprice, ocnt, osize, ocolor from orderProd where oseq ="+oseq;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				int wkSeq = rs.getInt(1);
				String weBrand = rs.getString(2);
				String wkName = rs.getString(3);
				int wkPrice = rs.getInt(4);
				int wkCnt = rs.getInt(5);
				int wkSize = rs.getInt(6);
				String wkColor = rs.getString(7);
				
				 dto = new OrderDto(wkSeq, weBrand, wkName, wkPrice, wkCnt, wkSize, wkColor);
			}
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public boolean insertAction() {
		PreparedStatement ps = null;
		String query = "insert into orderProd( obrand, oname, osize, ocnt, ocolor, oprice ) ";
		String query1 = " values(?,?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			ps = conn.prepareStatement(query + query1);
			
			ps.setString(1, obrand);
			ps.setString(2, oname);
			ps.setInt(3, osize);
			ps.setInt(4, ocnt);
			ps.setString(5, ocolor);
			ps.setInt(6, oprice);
			
			ps.executeUpdate();
			
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateAction() {
		PreparedStatement ps = null;
		String query = "update orderProd set  obrand=?, oname=?, osize=?, ocnt=?, ocolor=?, oprice=? where oseq = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			ps = conn.prepareStatement(query);
			
			ps.setString(1, obrand);
			ps.setString(2, oname);
			ps.setInt(3, osize);
			ps.setInt(4, ocnt);
			ps.setString(5, ocolor);
			ps.setInt(6, oprice);
			ps.setInt(7, oseq);
			
			ps.executeUpdate();
			
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteAction() {
		PreparedStatement ps = null;
		String query = "delete from orderProd where oseq = "+oseq;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			ps = conn.prepareStatement(query);
			
			ps.executeUpdate();
			
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
