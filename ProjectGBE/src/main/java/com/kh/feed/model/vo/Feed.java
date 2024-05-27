package com.kh.feed.model.vo;

import java.util.Date;

public class Feed {
	private int feedNo;
	private String memberNo;
	private String category;
	private String competition;
	private String feedTitle;
	private String feedContent;
	private int count;
	private Date createDate;
	private int boardId;
	private int likeCount;
	private String status;
	public Feed() {
		super();
	
	}
	public Feed(int feedNo, String memberNo, String category, String competition, String feedTitle, String feedContent,
			int count, Date createDate, int boardId, int likeCount ,String status) {
		super();
		this.feedNo = feedNo;
		this.memberNo = memberNo;
		this.category = category;
		this.competition = competition;
		this.feedTitle = feedTitle;
		this.feedContent = feedContent;
		this.count = count;
		this.createDate = createDate;
		this.boardId = boardId;
		this.likeCount = likeCount; 
		this.status = status;
	}
	
	
	
	
	public Feed(int feedNo, String memberNo, String category, String competition, String feedTitle, String feedContent,
			int count, Date createDate, int likeCount) {
		super();
		this.feedNo = feedNo;
		this.memberNo = memberNo;
		this.category = category;
		this.competition = competition;
		this.feedTitle = feedTitle;
		this.feedContent = feedContent;
		this.count = count;
		this.createDate = createDate;
		this.likeCount = likeCount;
	}
	public int getLikeCount() {
		return likeCount;
	}
	
	
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public Feed(int feedNo, String memberNo, String feedTitle, int count, Date createDate) {
		super();
		this.feedNo = feedNo;
		this.memberNo = memberNo;
		this.feedTitle = feedTitle;
		this.count = count;
		this.createDate = createDate;
	}

	public Feed(int feedNo, String feedTitle, String feedContent, String category, String memberNo, String competition,
			int count, Date createDate) {
		super();
		this.feedNo = feedNo;
		this.feedTitle = feedTitle;
		this.feedContent = feedContent;
		this.category = category;
		this.memberNo = memberNo;
		this.competition = competition;
		this.count = count;
		this.createDate = createDate;
	}
	public int getFeedNo() {
		return feedNo;
	}
	public void setFeedNo(int feedNo) {
		this.feedNo = feedNo;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategoryNo(String category) {
		this.category = category;
	}
	public String getCompetition() {
		return competition;
	}
	public void setCompetition(String competition) {
		this.competition = competition;
	}
	public String getFeedTitle() {
		return feedTitle;
	}
	public void setFeedTitle(String feedTitle) {
		this.feedTitle = feedTitle;
	}
	public String getFeedContent() {
		return feedContent;
	}
	public void setFeedContent(String feedContent) {
		this.feedContent = feedContent;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Feed [feedNo=" + feedNo + ", memberNo=" + memberNo + ", category=" + category + ", competition="
				+ competition + ", feedTitle=" + feedTitle + ", feedContent=" + feedContent + ", count=" + count
				+ ", createDate=" + createDate + ", boardId=" + boardId + ", likeCount=" + likeCount + ", status="
				+ status + "]";
	}
	
	
	
	
}