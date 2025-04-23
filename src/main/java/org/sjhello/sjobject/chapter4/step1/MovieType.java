package org.sjhello.sjobject.chapter4.step1;

public enum MovieType {
	AMOUNT_DISCOUNT("금액 할인 정책"),
	PERCENT_DISCOUNT("비율 할인 정책"),
	NONE_DISCOUNT("미적용");

	private String name;

	MovieType(String name) {
		this.name = name;
	}
}
