package com.kh.marathon.model.service;

import java.util.ArrayList;

import com.kh.marathon.model.vo.Marathon;

public interface MarathonService {

	ArrayList<Marathon> selectMarathon();

	int deleteAllMarathon();

	int insertMarathon();

	int deleteMarathon(int marathonNo);

	Marathon marathonDetail(int marathonNo);

	ArrayList<Marathon> selectDeleteMarathon();

	int restoreMarathon(int marathonNo);

	int updateMarathon(Marathon m);

}
