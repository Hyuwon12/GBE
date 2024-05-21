package com.kh.notice.model.vo;

import java.util.Date;

public class Notice {
	
	private int noticeId;
	private int memberNo;
	private String noticeTitle;
	private String memberName; // 임시
	private String noticeContent;
	private int boardId;
	private Date createDate;
	private int count;
	private String status;
	public Notice() {
		super();
			
	}
	public Notice(int noticeId, int memberNo, String noticeTitle, String memberName, String noticeContent, int boardId,
			Date createDate, int count, String status) {
		super();
		this.noticeId = noticeId;
		this.memberNo = memberNo;
		this.noticeTitle = noticeTitle;
		this.memberName = memberName;
		this.noticeContent = noticeContent;
		this.boardId = boardId;
		this.createDate = createDate;
		this.count = count;
		this.status = status;
	}
	
	
	
	public Notice(int noticeId, String noticeTitle, String memberName, Date createDate, int count) {
		super();
		this.noticeId = noticeId;
		this.noticeTitle = noticeTitle;
		this.memberName = memberName;
		this.createDate = createDate;
		this.count = count;
	}
	public Notice(int noticeId, String noticeTitle, String memberName, String noticeContent, Date createDate,
			int count) {
		super();
		this.noticeId = noticeId;
		this.noticeTitle = noticeTitle;
		this.memberName = memberName;
		this.noticeContent = noticeContent;
		this.createDate = createDate;
		this.count = count;
	}
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", memberNo=" + memberNo + ", noticeTitle=" + noticeTitle
				+ ", memberName=" + memberName + ", noticeContent=" + noticeContent + ", boardId=" + boardId
				+ ", createDate=" + createDate + ", count=" + count + ", status=" + status + "]";
	}
	
	
	
	
}
