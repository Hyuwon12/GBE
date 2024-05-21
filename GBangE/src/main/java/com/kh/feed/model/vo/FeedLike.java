package com.kh.feed.model.vo;

import java.util.Date;

public class FeedLike {
	
	private int likeNo;
	private int memberNo;
	private int feedNo;
	private Date likeDate;
	public FeedLike() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FeedLike(int likeNo, int memberNo, int feedNo, Date likeDate) {
		super();
		this.likeNo = likeNo;
		this.memberNo = memberNo;
		this.feedNo = feedNo;
		this.likeDate = likeDate;
	}
	public int getLikeNo() {
		return likeNo;
	}
	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getFeedNo() {
		return feedNo;
	}
	public void setFeedNo(int feedNo) {
		this.feedNo = feedNo;
	}
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
	@Override
	public String toString() {
		return "FeedLike [likeNo=" + likeNo + ", memberNo=" + memberNo + ", feedNo=" + feedNo + ", likeDate=" + likeDate
				+ "]";
	}
	
}
