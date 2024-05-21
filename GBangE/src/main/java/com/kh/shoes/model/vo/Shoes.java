package com.kh.shoes.model.vo;

public class Shoes {
//	SHOES_NO
//	SHOES_NAME
	private int shoesNo;
	private String shoesName;
	
	public Shoes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shoes(int shoesNo, String shoesName) {
		super();
		this.shoesNo = shoesNo;
		this.shoesName = shoesName;
	}

	public int getShoesNo() {
		return shoesNo;
	}

	public void setShoesNo(int shoesNo) {
		this.shoesNo = shoesNo;
	}

	public String getShoesName() {
		return shoesName;
	}

	public void setShoesName(String shoesName) {
		this.shoesName = shoesName;
	}

	@Override
	public String toString() {
		return "Shoes [shoesNo=" + shoesNo + ", shoesName=" + shoesName + "]";
	}
	
}
