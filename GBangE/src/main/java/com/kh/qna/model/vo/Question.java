package com.kh.qna.model.vo;

import java.util.Date;

public class Question {
	private int questionId;
	private int memberNo;
	private String questionTitle;
	private String questionContent;
	private Date createDate;
	private String status;
	private String memberName;
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", memberNo=" + memberNo + ", questionTitle=" + questionTitle
				+ ", questionContent=" + questionContent + ", createDate=" + createDate + ", status=" + status + "]";
	}
	public Question(int questionId, int memberNo, String questionTitle, String questionContent, Date createDate,
			String status) {
		super();
		this.questionId = questionId;
		this.memberNo = memberNo;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.createDate = createDate;
		this.status = status;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(int questionId, String memberName, String questionTitle, String questionContent, Date createDate) {
		super();
		this.questionId = questionId;
		this.memberName = memberName;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.createDate = createDate;
		
	}
	
}	
