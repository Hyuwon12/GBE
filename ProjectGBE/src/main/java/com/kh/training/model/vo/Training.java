package com.kh.training.model.vo;

import java.sql.Date;

public class Training {
	private String trainingTitle;

	private int count;
//	TRAINING_NO
	private int trainingNo;
//	MEMBER_NO
	private String trainingWriter;
//	TRAINING_KEY
	private String trainingKey;
//	SHOES_NO
	private int shoesNo;
//	TRAINING_DATE
	private String trainingDate;
//	RECORD_DATE
	private Date recordDate;
//	TRAINING_PLACE
	private String trainingPlace;
//	TRAINING_TIME
	private double trainingTime;
//	TRAINING_GOAL
	private String trainingGoal;
//	TRAINING_DISTANCE
	private double trainingDistance;
//	WEIGHT
	private double weight;
//	TRAINING_CONTENT
	private String trainingContent;
//	BOARD_ID
	private int boardId;

	private String oCStatus;

	private String status;

	public Training() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Training(String trainingTitle, int count, int trainingNo, String trainingWriter, String trainingKey,
			int shoesNo, String trainingDate, Date recordDate, String trainingPlace, double trainingTime,
			String trainingGoal, double trainingDistance, double weight, String trainingContent, int boardId,
			String oCStatus, String status) {
		super();
		this.trainingTitle = trainingTitle;
		this.count = count;
		this.trainingNo = trainingNo;
		this.trainingWriter = trainingWriter;
		this.trainingKey = trainingKey;
		this.shoesNo = shoesNo;
		this.trainingDate = trainingDate;
		this.recordDate = recordDate;
		this.trainingPlace = trainingPlace;
		this.trainingTime = trainingTime;
		this.trainingGoal = trainingGoal;
		this.trainingDistance = trainingDistance;
		this.weight = weight;
		this.trainingContent = trainingContent;
		this.boardId = boardId;
		this.oCStatus = oCStatus;
		this.status = status;
	}

	public Training(int trainingNo, String trainingTitle, String trainingWriter, Date recordDate, int count, String oCStatus) {
		super();
		this.trainingTitle = trainingTitle;
		this.count = count;
		this.trainingNo = trainingNo;
		this.trainingWriter = trainingWriter;
		this.recordDate = recordDate;
		this.oCStatus = oCStatus;
	}

	public String getTrainingTitle() {
		return trainingTitle;
	}

	public void setTrainingTitle(String trainingTitle) {
		this.trainingTitle = trainingTitle;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTrainingNo() {
		return trainingNo;
	}

	public void setTrainingNo(int trainingNo) {
		this.trainingNo = trainingNo;
	}

	public String getTrainingWriter() {
		return trainingWriter;
	}

	public void setTrainingWriter(String trainingWriter) {
		this.trainingWriter = trainingWriter;
	}

	public String getTrainingKey() {
		return trainingKey;
	}

	public void setTrainingKey(String trainingKey) {
		this.trainingKey = trainingKey;
	}

	public int getShoesNo() {
		return shoesNo;
	}

	public void setShoesNo(int shoesNo) {
		this.shoesNo = shoesNo;
	}

	public String getTrainingDate() {
		return trainingDate;
	}

	public void setTrainingDate(String trainingDate) {
		this.trainingDate = trainingDate;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public String getTrainingPlace() {
		return trainingPlace;
	}

	public void setTrainingPlace(String trainingPlace) {
		this.trainingPlace = trainingPlace;
	}

	public double getTrainingTime() {
		return trainingTime;
	}

	public void setTrainingTime(double trainingTime) {
		this.trainingTime = trainingTime;
	}

	public String getTrainingGoal() {
		return trainingGoal;
	}

	public void setTrainingGoal(String trainingGoal) {
		this.trainingGoal = trainingGoal;
	}

	public double getTrainingDistance() {
		return trainingDistance;
	}

	public void setTrainingDistance(double trainingDistance) {
		this.trainingDistance = trainingDistance;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getTrainingContent() {
		return trainingContent;
	}

	public void setTrainingContent(String trainingContent) {
		this.trainingContent = trainingContent;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getoCStatus() {
		return oCStatus;
	}

	public void setoCStatus(String oCStatus) {
		this.oCStatus = oCStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Training [trainingTitle=" + trainingTitle + ", count=" + count + ", trainingNo=" + trainingNo
				+ ", trainingWriter=" + trainingWriter + ", trainingKey=" + trainingKey + ", shoesNo=" + shoesNo
				+ ", trainingDate=" + trainingDate + ", recordDate=" + recordDate + ", trainingPlace=" + trainingPlace
				+ ", trainingTime=" + trainingTime + ", trainingGoal=" + trainingGoal + ", trainingDistance="
				+ trainingDistance + ", weight=" + weight + ", trainingContent=" + trainingContent + ", boardId="
				+ boardId + ", oCStatus=" + oCStatus + ", status=" + status + "]";
	}

}