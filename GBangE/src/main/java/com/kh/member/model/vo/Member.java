package com.kh.member.model.vo;

import java.util.Date;

public class Member {

	private int memberNo;
	private String memberName;
	private String memberId;
	private String memberPwd;
	private String gender;
	private String address;
	private String memberPno;
	private double mileage;
	private String shoes;
	private double weight;
	private Date enrollDate;
	private String status;
	private String profileImage;
	private String filePath;
	private String changeName;
	

	public Member(int memberNo, String memberName, String memberId, String memberPwd, String gender, String address,
			String memberPno, double mileage, String shoes, double weight, Date enrollDate, String status, 
			String profileImage, String filePath, String changeName) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.gender = gender;
		this.address = address;
		this.memberPno = memberPno;
		this.mileage = mileage;
		this.shoes = shoes;
		this.weight = weight;
		this.enrollDate = enrollDate;
		this.status = status;
		this.profileImage = profileImage;
		this.filePath = filePath;
		this.changeName = changeName;
	}

	public Member(String memberName, String memberId, String memberPwd, String gender, String address, String memberPno,
			String shoes, double weight) {
		super();
		this.memberName = memberName;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.gender = gender;
		this.address = address;
		this.memberPno = memberPno;
		this.shoes = shoes;
		this.weight = weight;
	}
	
	

	public Member(String memberId, String memberName, String gender, String address, String shoes, double weight) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.gender = gender;
		this.address = address;
		this.shoes = shoes;
		this.weight = weight;
	}

	public Member(String memberId, String memberPno) {
		super();
		this.memberId = memberId;
		this.memberPno = memberPno;
	}

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMemberPno() {
		return memberPno;
	}

	public void setMemberPno(String memberPno) {
		this.memberPno = memberPno;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public String getShoes() {
		return shoes;
	}

	public void setShoes(String shoes) {
		this.shoes = shoes;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberName=" + memberName + ", memberId=" + memberId + ", memberPwd="
				+ memberPwd + ", gender=" + gender + ", address=" + address + ", memberPno=" + memberPno + ", mileage="
				+ mileage + ", shoes=" + shoes + ", weight=" + weight + ", enrollDate=" + enrollDate + ", status="
				+ status + ", profileImage=" + profileImage + ", filePath=" + filePath + ", changeName=" + changeName
				+ "]";
	}
	
	
}
