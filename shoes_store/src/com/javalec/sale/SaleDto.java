package com.javalec.sale;

import java.io.FileInputStream;

public class SaleDto {

	int pcnt;
	String pdate;
	int oprice;
	int pseq;
	int oseq;
	int totalSales;
	int totalCnt;
	String brand;

	public SaleDto() {
		// TODO Auto-generated constructor stub
	}


	public int getPcnt() {
		return pcnt;
	}

	public SaleDto(String pdate, int totalSales , int totalCnt) {
		super();
		this.pdate = pdate;
		this.totalSales = totalSales;
		this.totalCnt = totalCnt;
	}
	
	public SaleDto(String brand) {
		super();
		this.brand = brand;
	}

	
	
	public SaleDto(int totalCnt, String brand, int totalSales) {
		super();
		this.totalCnt = totalCnt;
		this.brand = brand;
		this.totalSales = totalSales;
		
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}

	public void setPcnt(int pcnt) {
		this.pcnt = pcnt;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public int getOprice() {
		return oprice;
	}

	public void setOprice(int oprice) {
		this.oprice = oprice;
	}

	public int getPseq() {
		return pseq;
	}

	public void setPseq(int pseq) {
		this.pseq = pseq;
	}

	public int getOseq() {
		return oseq;
	}

	public void setOseq(int oseq) {
		this.oseq = oseq;
	}

}
