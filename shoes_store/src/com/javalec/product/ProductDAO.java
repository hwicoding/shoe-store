package com.javalec.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import com.javalec.util.ShareVar;

public class ProductDAO {
	
//	Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String ps_mysql = ShareVar.dbPass;
	
	
	int seqno, size, count, price;
	String brnad, name, color;
	FileInputStream file;
	
	
//	constructor
	
	public ProductDAO() {
		// TODO Auto-generated constructor stub
	}


	public ProductDAO(int seqno) {
		super();
		this.seqno = seqno;
	}


	public ProductDAO(int seqno, String brnad, String name, int price) {
		super();
		this.seqno = seqno;
		this.brnad = brnad;
		this.name = name;
		this.price = price;
	}
	
//	Method
	
//	검색 결과를 Table 로 보내자
	
	public ArrayList<ProductDTO> selecList() {
		ArrayList<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		String whereDefault = "select oseq, obrand, oname, oprice from orderprod";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			
			while(rs.next()) {
				
				int wkSeq = rs.getInt(1);
				String wkBrand = rs.getString(2);
				String wkName = rs.getString(3);
				int wkPrice = rs.getInt(4);
				
				ProductDTO dto = new ProductDTO(wkSeq, wkBrand, wkName, wkPrice);
				dtoList.add(dto);
			}
			conn_mysql.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
//	Table 에서 Row 를 click 했을 경우
	public ProductDTO tableClick() {
		
		ProductDTO dto = null;
		
		String where1 = "select p.oseq, obrand, oname, oprice, osize, ocnt, ocolor, pfile " ;
		String where2 = "from orderprod o, product p " ;
		String where3 = "where o.oseq = p.oseq";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(where1 + where2 + where3);
			
			if(rs.next()) {
				int wkSeqno = rs.getInt(1);
				String wkBrand = rs.getString(2);
				String wkName = rs.getString(3);
				int wkPrice = rs.getInt(4);
				int wkSize = rs.getInt(5);
				int wkCount = rs.getInt(6);
				String wkColor = rs.getString(7);
				
//				file
				ShareVar.filename = ShareVar.filename + 1;
				File file = new File(Integer.toString(ShareVar.filename));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(8);
				byte[] buffer = new byte[1024];
				
				while(input.read(buffer)>0) {
					output.write(buffer);
				}
				
				dto = new ProductDTO(wkSeqno, wkSize, wkCount, wkPrice, wkBrand, wkName, wkColor);
			}
			
			conn_mysql.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
		
	}

}
