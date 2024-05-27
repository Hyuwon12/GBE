package com.kh.springProject.common.template;

import com.kh.springProject.common.model.vo.PageInfo;

public class PageNation {
	public static PageInfo getPageInfo(int listCount,int currentPage,int pageLimit,int boardLimit) {
		int maxPage = (int)Math.ceil((double)listCount/boardLimit);
		int startPage = (currentPage-1)/pageLimit * pageLimit+1;
		int endPage = startPage+pageLimit-1;
		if(endPage>maxPage) {
			endPage = maxPage;
		}
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		return pi;
	}
}
