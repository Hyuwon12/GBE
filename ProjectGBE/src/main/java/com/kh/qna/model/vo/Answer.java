package com.kh.qna.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
	private int answerId;
	private int memberNo;
	private int refQno;
	private String answerTitle;
	private String answerContent;
	private Date createDate;
	private String status;

}
