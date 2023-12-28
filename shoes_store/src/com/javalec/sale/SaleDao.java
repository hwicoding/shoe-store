package com.javalec.sale;

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

public class SaleDao {

	private final String url = ShareVar.dbName;
	private final String id = ShareVar.dbUser;
	private final String pw = ShareVar.dbPass;
	
	int pcnt;
	String pdate;
	int oprice;
	int pseq;
	int oseq;
	String brand;
	

	public SaleDao() {
		// TODO Auto-generated constructor stub
	}

	
	public SaleDao(String pdate) {
		super();
		this.pdate = pdate;
	}

	public SaleDao(String pdate, String brand) {
		super();
		this.pdate = pdate;
		this.brand = brand;
	}


	public ArrayList<SaleDto> searchAction() {
		ArrayList<SaleDto> dtoList = new ArrayList<SaleDto>();
		
		String query ="select pur.pdate, (select sum(pcnt) from purchase pp where pur.pdate = pp.pdate group by pdate) ,sum(pur.pcnt * o.oprice) from purchase pur inner join product prod on prod.pseq = pur.pseq inner join orderProd o on o.oseq = prod.oseq where pur.pseq = prod.pseq and o.oseq = prod.oseq group by pur.pdate";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String date = rs.getString(1);
				int wkTotalSale = rs.getInt(3);
				int wkToalCnt = rs.getInt(2);
				
				SaleDto dto = new SaleDto(date, wkTotalSale,  wkToalCnt);
				dtoList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	

	
	//테이블 선택했을 때 
	public SaleDto cellClicked() {
		SaleDto dto = null; 
		
		String query = "select pur.pdate ,sum(pur.pcnt * o.oprice) , sum(pur.pcnt)  from purchase pur inner join product prod on prod.pseq = pur.pseq inner join orderProd o on o.oseq = prod.oseq where pur.pseq = prod.pseq and o.oseq = prod.oseq and pur.pdate = '"+pdate+"'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				String date = rs.getString(1);
				int wkTotalSale = rs.getInt(2);
				int wkTotalCnt = rs.getInt(3);
				
				dto = new SaleDto(date, wkTotalSale, wkTotalCnt);
			}
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	//브랜드 값 가져오기 
	public  ArrayList<SaleDto> selectCbValue() {
		ArrayList<SaleDto> dtoList = new ArrayList<SaleDto>();
		
		String query = "select obrand from orderProd group by obrand";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String wkBrand = rs.getString(1);
				
				SaleDto dto = new SaleDto(wkBrand);
				dtoList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
		
	}
	
	
	//브랜드 별 매출액, 판매수량 
	public ArrayList<SaleDto>  selectSaleByBrand() {
		ArrayList<SaleDto> dtoList = new ArrayList<SaleDto>();
		
		String query = "select pcnt, o.obrand , (pcnt*o.oprice) from purchase pur, product prod, orderProd o where o.oseq = prod.oseq and prod.pseq = pur.pseq and o.obrand like '%"+brand+"%' and pur.pdate ='"+pdate+"'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				int	wkTotalCnt  = rs.getInt(1);
				String  wkBrand = rs.getString(2);
				int wkTotalSale = rs.getInt(3);
				
				SaleDto dto = new SaleDto(wkTotalCnt, wkBrand ,wkTotalSale);
				dtoList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	public ArrayList<SaleDto> btnSearchClicked(String date) {
		ArrayList<SaleDto> dtoList = new ArrayList<SaleDto>();
		
		String query = "select pur.pdate, (select sum(pcnt) from purchase pp where pur.pdate = pp.pdate group by pdate) ,sum(pur.pcnt * o.oprice) from purchase pur inner join product prod on prod.pseq = pur.pseq inner join orderProd o on o.oseq = prod.oseq where pur.pseq = prod.pseq and o.oseq = prod.oseq and pdate  like '%"+date+"%' group by pur.pdate";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String wkDate = rs.getString(1);
				int wkTotalSale = rs.getInt(3);
				int wkToalCnt = rs.getInt(2);
				
				SaleDto dto = new SaleDto(wkDate, wkTotalSale,  wkToalCnt);
				dtoList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	//입력했을 때 
//	public boolean insertAction() {
//		PreparedStatement ps = null;
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn = DriverManager.getConnection(url, id, pw);
//			
//			String query1 = "insert into product (obrand, oname, psize, ocnt, pcolor, pprice, pfile) ";
//			String query2 = " values(?,?,?,?,?,?,?)";
//			
//			ps = conn.prepareStatement(query1 + query2);
//			
//			ps.setString(1, obrand);
//			ps.setString(2, oname);
//			ps.setInt(3, psize);
//			ps.setInt(4, ocnt);
//			ps.setString(5, pcolor);
//			ps.setInt(6, pprice);
//			ps.setBinaryStream(7, pfile);
//			
//			ps.executeUpdate();
//			
//			conn.close();
//			
//		} catch (SQLException se) {
//			se.printStackTrace();
//			return false;
//		} catch (NumberFormatException nfe) {
//			nfe.printStackTrace();
//			return false;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return true; 
//	}
	
	//수정했을 때 
//	public boolean updateAction() {
//		PreparedStatement ps = null;
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn = DriverManager.getConnection(url, id, pw);
//			
//			String query1 = "updaet product set obrand=?, oname=?, psize=?, ocnt=?, pcolor=?, pprice=?, pfile=?) ";
//			String query2 = "where pseq = "+pseq;
//			
//			ps = conn.prepareStatement(query1 + query2);
//			
//			ps.setString(1, obrand);
//			ps.setString(2, oname);
//			ps.setInt(3, psize);
//			ps.setInt(4, ocnt);
//			ps.setString(5, pcolor);
//			ps.setInt(6, pprice);
//			ps.setBinaryStream(7, pfile);
//			
//			ps.executeUpdate();
//			
//			conn.close();
//			
//		} catch (SQLException se) {
//			se.printStackTrace();
//			return false;
//		} catch (NumberFormatException nfe) {
//			nfe.printStackTrace();
//			return false;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return true; 
//	}
	
}
