package com.kh.marathon.model.vo;

public class Region {
	private int regionId;
	private String regionName;
	
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public Region(int regionId, String regionName) {
		super();
		this.regionId = regionId;
		this.regionName = regionName;
	}
	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "region [regionId=" + regionId + ", regionName=" + regionName + "]";
	}
	
}
