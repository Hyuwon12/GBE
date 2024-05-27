package com.kh.marathon.model.vo;

public class Marathon {
	private int marathonNo;
	private String marathonName;
	private String location;
	private String region;
	private String marathonDate;
	private String applicationDate;
	private String otherIntroduction;
	private String organizer;
	private String organizerHost;
	private String organizerPhone;
	private String marathonSite;
	private String status;
	private int imageNo;
	private String marathonCourse;
	
	public int getMarathonNo() {
		return marathonNo;
	}
	public void setMarathonNo(int marathonNo) {
		this.marathonNo = marathonNo;
	}
	public String getMarathonName() {
		return marathonName;
	}
	public void setMarathonName(String marathonName) {
		this.marathonName = marathonName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getMarathonDate() {
		return marathonDate;
	}
	public void setMarathonDate(String marathonDate) {
		this.marathonDate = marathonDate;
	}
	public String getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getOtherIntroduction() {
		return otherIntroduction;
	}
	public void setOtherIntroduction(String otherIntroduction) {
		this.otherIntroduction = otherIntroduction;
	}
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	public String getOrganizerHost() {
		return organizerHost;
	}
	public void setOrganizerHost(String organizerHost) {
		this.organizerHost = organizerHost;
	}
	public String getOrganizerPhone() {
		return organizerPhone;
	}
	public void setOrganizerPhone(String organizerPhone) {
		this.organizerPhone = organizerPhone;
	}
	public String getMarathonSite() {
		return marathonSite;
	}
	public void setMarathonSite(String marathonSite) {
		this.marathonSite = marathonSite;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getImageNo() {
		return imageNo;
	}
	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}
	
	public String getMarathonCourse() {
		return marathonCourse;
	}
	public void setMarathonCourse(String marathonCourse) {
		this.marathonCourse = marathonCourse;
	}
	@Override
	public String toString() {
		return "Marathon [marathonNo=" + marathonNo + ", marathonName=" + marathonName + ", location=" + location
				+ ", region=" + region + ", marathonDate=" + marathonDate + ", applicationDate=" + applicationDate
				+ ", otherIntroduction=" + otherIntroduction + ", organizer=" + organizer + ", organizerHost="
				+ organizerHost + ", organizerPhone=" + organizerPhone + ", marathonSite=" + marathonSite + ", status="
				+ status + ", imageNo=" + imageNo + ", marathonCourse=" + marathonCourse + "]";
	}
	public Marathon(int marathonNo, String marathonName, String location, String region, String marathonDate,
			String applicationDate, String otherIntroduction, String organizer, String organizerHost,
			String organizerPhone, String marathonSite, String status, int imageNo, String marathonCourse) {
		super();
		this.marathonNo = marathonNo;
		this.marathonName = marathonName;
		this.location = location;
		this.region = region;
		this.marathonDate = marathonDate;
		this.applicationDate = applicationDate;
		this.otherIntroduction = otherIntroduction;
		this.organizer = organizer;
		this.organizerHost = organizerHost;
		this.organizerPhone = organizerPhone;
		this.marathonSite = marathonSite;
		this.status = status;
		this.imageNo = imageNo;
		this.marathonCourse = marathonCourse;
	}
	public Marathon() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}