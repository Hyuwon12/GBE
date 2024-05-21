package com.kh.training.model.vo;

public class Shoes {
//	SHOES_NO
	private int shoesNo;
//	SHOES_NAME
	private String shoesName;
//	STATUS
	private String status;

	public Shoes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shoes(int shoesNo, String shoesName, String status) {
		super();
		this.shoesNo = shoesNo;
		this.shoesName = shoesName;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Shoes [shoesNo=" + shoesNo + ", shoesName=" + shoesName + ", status=" + status + "]";
	}

}
