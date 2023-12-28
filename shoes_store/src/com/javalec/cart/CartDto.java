package com.javalec.cart;

public class CartDto {

	// Field
	int seqno, size, count, price;
	String brand, name, color;
	
	//Constructor
	
	public CartDto() {
	}



	public CartDto(int size, int count, int price, String brand, String name) {
		super();
		this.size = size;
		this.count = count;
		this.price = price;
		this.brand = brand;
		this.name = name;
	}//



	public CartDto(int seqno, int size, int count, int price, String brand, String name, String color) {
		super();
		this.seqno = seqno;
		this.size = size;
		this.count = count;
		this.price = price;
		this.brand = brand;
		this.name = name;
		this.color = color;
	}

	//Method
	public int getSeqno() {
		return seqno;
	}

	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	} 
	

	
}
