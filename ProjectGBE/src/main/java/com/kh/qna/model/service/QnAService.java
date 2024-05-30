package com.kh.qna.model.service;

import java.util.ArrayList;

import com.kh.qna.model.vo.Answer;
import com.kh.qna.model.vo.Question;

public interface QnAService {

	ArrayList<Question> selectQuestion();
	ArrayList<Answer> selectAllAnswer();
	int insertAnswer(Answer an);
	ArrayList<Answer> selectAnswer(int refQno);

}
