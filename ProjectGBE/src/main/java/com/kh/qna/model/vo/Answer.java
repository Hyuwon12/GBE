package com.kh.qna.model.vo;

import java.util.Date;

public class Answer {
	private int answerId;
	private int memberNo;
	private int refQno;
	private String answerTitle;
	private String answerContent;
	private Date createDate;
	private String status;
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getRefQno() {
		return refQno;
	}
	public void setRefQno(int refQno) {
		this.refQno = refQno;
	}
	public String getAnswerTitle() {
		return answerTitle;
	}
	public void setAnswerTitle(String answerTitle) {
		this.answerTitle = answerTitle;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
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
		return "Answer [answerId=" + answerId + ", memberNo=" + memberNo + ", refQno=" + refQno + ", answerTitle="
				+ answerTitle + ", answerContent=" + answerContent + ", createDate=" + createDate + ", status=" + status
				+ "]";
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer(int answerId, int memberNo, int refQno, String answerTitle, String answerContent, Date createDate,
			String status) {
		super();
		this.answerId = answerId;
		this.memberNo = memberNo;
		this.refQno = refQno;
		this.answerTitle = answerTitle;
		this.answerContent = answerContent;
		this.createDate = createDate;
		this.status = status;
	}
	
	
}
