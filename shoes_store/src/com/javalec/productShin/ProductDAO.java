package com.javalec.productShin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.sale.SaleDto;
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

	public ProductDAO(String brnad, String name) {
		super();
		this.brnad = brnad;
		this.name = name;
	}

	public ProductDAO(String brnad, String name, int count) {
		super();
		this.brnad = brnad;
		this.name = name;
		this.count = count;
	}
	
	public ProductDAO(String brand, String name, int price, int size, int cnt, String color) {
		super();
		this.brnad = brand;
		this.name = name;
		this.price = price;
		this.size = size;
		this.count = cnt;
		this.color = color;
	}

//	Method

//	검색 결과를 Table 로 보내자
	public ArrayList<ProductDTO> selecList() {
		ArrayList<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		String whereDefault = "select obrand ,oname, (select oprice from orderProd group by oprice ) from orderProd group by obrand, oname order by obrand";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereDefault);

			while (rs.next()) {

				String wkBrand = rs.getString(1);
				String wkName = rs.getString(2);
				int wkPrice = rs.getInt(3);

				ProductDTO dto = new ProductDTO(wkBrand, wkName, wkPrice);
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

		String query = "select obrand ,oname, (select oprice from orderProd group by oprice ), (select pfile from product p inner join purchase pur on p.pseq = pur.pseq inner join orderProd o on o.oseq = p.oseq where o.obrand='"
				+ brnad + "' and o.oname = '" + name + "' group by pfile) from orderProd oo where oo.obrand ='" + brnad
				+ "' and oo.oname ='" + name + "' group by obrand, oname order by obrand";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(query);

			if (rs.next()) {
				String wkBrand = rs.getString(1);
				String wkName = rs.getString(2);
				int wkPrice = rs.getInt(3);

				// file
				ShareVar.filename = ShareVar.filename + 1;
				File file = new File(Integer.toString(ShareVar.filename));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(4);

				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
				}

				dto = new ProductDTO(wkBrand, wkName, wkPrice);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	// 해당 브랜드와 제품에 대한 사이즈 가져오기
	public ArrayList<ProductDTO> getBrandSize(String brand, String name) {
		ArrayList<ProductDTO> dtoList = new ArrayList<ProductDTO>();

		String query = "select osize from orderProd where obrand = '" + brand + "' and oname = '" + name
				+ "' group by osize";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				int wkSize = rs.getInt(1);
				ProductDTO dto = new ProductDTO(wkSize);
				dtoList.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	// 해당 브랜드와 제품에 대한 색상 가져오기
	public ArrayList<ProductDTO> getBrandColor(String brand, String name) {
		ArrayList<ProductDTO> dtoList = new ArrayList<ProductDTO>();

		String query = "select ocolor from orderProd where obrand = '"+brand+"' and oname ='"+name+"' group by ocolor";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String wkColor = rs.getString(1);
				ProductDTO dto = new ProductDTO(wkColor);
				dtoList.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	//BuyPage에서 값 입력했을 때, seq부터 모든 정보 가지고 오기 
	
	public int getAllInfo() {

		int wkSeq = 0;
		String query = "select pseq from product where oseq = (select oseq from orderProd where obrand='"+brnad+"' and oname ='"+name+"' and oprice= '"+price+"' and osize = '"+size+"' and ocolor='"+color+"')";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, ps_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(query);
			if (rs.next()) {
				wkSeq = rs.getInt(1);
				System.out.println("ProductDAO[wkSeq] : "+ wkSeq);
				
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return wkSeq;
	}

}
