package com.kh.training.model.vo;

public class TrainingCategory {
//	TRAINING_KEY
	private int trainingKey;
//	TRAINING_NAME
	private String trainingName;
	
	public TrainingCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrainingCategory(int trainingKey, String trainingName) {
		super();
		this.trainingKey = trainingKey;
		this.trainingName = trainingName;
	}

	public int getTrainingKey() {
		return trainingKey;
	}

	public void setTrainingKey(int trainingKey) {
		this.trainingKey = trainingKey;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	@Override
	public String toString() {
		return "TrainingCategory [trainingKey=" + trainingKey + ", trainingName=" + trainingName + "]";
	}
}
