package com.kh.marathon.model.service;

import java.util.ArrayList;

import com.kh.marathon.model.vo.Participate;

public interface ParticipateService {
	int insertParticipate(Participate p);
	ArrayList<Participate> listParticipate(int marathonNo);
	
}
