package com.kh.springProject.board.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
	private int replyNo;
	private String replyContent;
	private int refBno;
	private String replyWriter;
	private Date createDate;
	private String status;
	private int rcount;
}
