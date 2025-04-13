package org.sjhello.sjobject.chapter4;

public enum DiscountConditionType {
	SEQUENCE("순번 조건"),
	PERIOD("기간 조건");

	private String type;

	DiscountConditionType(String type) {
		this.type = type;
	}
}
