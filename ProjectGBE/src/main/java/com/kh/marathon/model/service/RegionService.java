package com.kh.marathon.model.service;

public interface RegionService {
	String selectRegion(int regionId);
	int selectRegionId(String regionName);
}
