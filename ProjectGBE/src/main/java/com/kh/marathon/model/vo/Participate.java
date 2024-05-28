package com.kh.marathon.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
