package com.lb.jwitter.util;

import java.util.List;
import java.util.Map;

public class Qresult {
	private List<Object> objs;
	private Map<String,Object> objAlias;
	
	


	public Map<String, Object> getObjAlias() {
		return objAlias;
	}

	public void setObjAlias(Map<String, Object> objAlias) {
		this.objAlias = objAlias;
	}

	public List<Object> getObjs() {
		return objs;
	}

	public void setObjs(List<Object> objs) {
		this.objs = objs;
	}
	
}
