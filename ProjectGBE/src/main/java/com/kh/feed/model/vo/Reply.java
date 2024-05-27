package com.kh.feed.model.vo;

import java.util.Date;

public class Reply {
	private int replyNo;
	private int refBno;
	private String replyContent;
	private String memberNo;
	private Date createDate;
	private String status;
	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reply(int replyNo, int refBno, String replyContent, String memberNo, Date createDate, String status) {
		super();
		this.replyNo = replyNo;
		this.refBno = refBno;
		this.replyContent = replyContent;
		this.memberNo = memberNo;
		this.createDate = createDate;
		this.status = status;
	}
	
	public Reply(int replyNo, String replyContent, String memberNo, Date createDate) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.memberNo = memberNo;
		this.createDate = createDate;
	}
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public int getRefBno() {
		return refBno;
	}
	public void setRefBno(int refBno) {
		this.refBno = refBno;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
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
		return "Reply [replyNo=" + replyNo + ", refBno=" + refBno + ", replyContent=" + replyContent + ", memberNo="
				+ memberNo + ", createDate=" + createDate + ", status=" + status + "]";
	}
	
}
