package com.lb.utils.orm.hibernate;

public class Message {
	boolean preMessage_b = false;
	String preMessage_s = "";
	boolean postMessage_b = false;
	String postMessage_s = "";
	
	public boolean isPreMessage_b() {
		return preMessage_b;
	}
	public void setPreMessage_b(boolean preMessage_b) {
		this.preMessage_b = preMessage_b;
	}
	public String getPreMessage_s() {
		return preMessage_s;
	}
	public void setPreMessage_s(String preMessage_s) {
		this.preMessage_s = preMessage_s;
	}
	public boolean isPostMessage_b() {
		return postMessage_b;
	}
	public void setPostMessage_b(boolean postMessage_b) {
		this.postMessage_b = postMessage_b;
	}
	public String getPostMessage_s() {
		return postMessage_s;
	}
	public void setPostMessage_s(String postMessage_s) {
		this.postMessage_s = postMessage_s;
	}
	

}
