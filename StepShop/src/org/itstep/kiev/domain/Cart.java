package org.itstep.kiev.domain;

public class Cart extends Cell{
	
	private String customer;
	private long actionTime;
	
	public long getActionTime() {
		return actionTime;
	}
	public void setActionTime(long actionTime) {
		this.actionTime = actionTime;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
}
