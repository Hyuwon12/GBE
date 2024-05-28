package com.kh.marathon.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
	public Marathon(String marathonName, String location, String region, String marathonDate, String applicationDate,
			String otherIntroduction, String organizer, String organizerHost, String organizerPhone,
			String marathonSite, int imageNo, String marathonCourse) {
		super();
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
		this.imageNo = imageNo;
		this.marathonCourse = marathonCourse;
	}
	
}