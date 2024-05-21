package com.kh.training.model.vo;

import java.sql.Date;

public class Reply {
//	reply_NO
	private int replyNo;
//	reply_CONTENT
	private String replyContent;
//	REF_TNO
	private int refTno;
//	reply_WRITER
	private String replyWriter;
//	CREATE_DATE
	private String createDate;
//	STATUS
	private String status;

	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reply(int replyNo, String replyContent, int refTno, String replyWriter, String createDate, String status) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.refTno = refTno;
		this.replyWriter = replyWriter;
		this.createDate = createDate;
		this.status = status;
	}

	
	
	public Reply(int replyNo,String replyContent, String replyWriter, String createDate) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.replyWriter = replyWriter;
		this.createDate = createDate;
	}

	public int getreplyNo() {
		return replyNo;
	}

	public void setreplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getreplyContent() {
		return replyContent;
	}

	public void setreplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public int getRefTno() {
		return refTno;
	}

	public void setRefTno(int refTno) {
		this.refTno = refTno;
	}

	public String getreplyWriter() {
		return replyWriter;
	}

	public void setreplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
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
		return "reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", refTno=" + refTno + ", replyWriter="
				+ replyWriter + ", createDate=" + createDate + ", status=" + status + "]";
	}

}
