package com.kh.qna.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
	private int questionId;
	private int memberNo;
	private String questionTitle;
	private String questionContent;
	private Date createDate;
	private String status;
	private String memberName;
	
}	
