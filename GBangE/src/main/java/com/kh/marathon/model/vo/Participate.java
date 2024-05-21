package com.kh.marathon.model.vo;

import java.util.Date;

public class Participate {
	private int participateNo;
	private int memberNo;
	private int marathonNo;
	private int regionId;
	private String name;
	private String password;
	private String registerationNo;
	private String gender;
	private String phone;
	private String address;
	private Date participateDate;
	private Date changeDate;
	private String status;
	
	private String marathonName;
	private String regionName;
	private String participateCourse;
	
	
	public int getParticipateNo() {
		return participateNo;
	}
	public void setParticipateNo(int participateNo) {
		this.participateNo = participateNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getMarathonNo() {
		return marathonNo;
	}
	public void setMarathonNo(int marathonNo) {
		this.marathonNo = marathonNo;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegisterationNo() {
		return registerationNo;
	}
	public void setRegisterationNo(String registerationNo) {
		this.registerationNo = registerationNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getParticipateDate() {
		return participateDate;
	}
	public void setParticipateDate(Date participateDate) {
		this.participateDate = participateDate;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMarathonName() {
		return marathonName;
	}
	public void setMarathonName(String marathonName) {
		this.marathonName = marathonName;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	public String getParticipateCourse() {
		return participateCourse;
	}
	public void setParticipateCourse(String participateCourse) {
		this.participateCourse = participateCourse;
	}
	public Participate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Participate(int participateNo, int memberNo, int marathonNo, int regionId, String name, String password,
			String registerationNo, String gender, String phone, String address, Date participateDate, Date changeDate,
			String status) {
		super();
		this.participateNo = participateNo;
		this.memberNo = memberNo;
		this.marathonNo = marathonNo;
		this.regionId = regionId;
		this.name = name;
		this.password = password;
		this.registerationNo = registerationNo;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.participateDate = participateDate;
		this.changeDate = changeDate;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Participate [participateNo=" + participateNo + ", memberNo=" + memberNo + ", marathonNo=" + marathonNo
				+ ", regionId=" + regionId + ", name=" + name + ", password=" + password + ", registerationNo="
				+ registerationNo + ", gender=" + gender + ", phone=" + phone + ", address=" + address
				+ ", participateDate=" + participateDate + ", changeDate=" + changeDate + ", status=" + status + "]";
	}
	public Participate(int participateNo, String name, String marathonName, String regionName, Date participateDate, String phone ) {
		super();
		this.participateNo = participateNo;
		this.name = name;
		this.marathonName = marathonName;
		this.regionName = regionName;
		this.participateDate = participateDate;
		this.phone = phone;
	}
	
	
}
