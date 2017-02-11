package com.lb.jwitter.util;

import java.util.List;

public class MasterDetail<MasterClass, DetailClass> {
	private MasterClass master;
	private List<DetailClass> details;
	
	public MasterClass getMaster() {
		return master;
	}
	public void setMaster(MasterClass master) {
		this.master = master;
	}
	public List<DetailClass> getDetails() {
		return details;
	}
	public void setDetails(List<DetailClass> details) {
		this.details = details;
	}
	

}
