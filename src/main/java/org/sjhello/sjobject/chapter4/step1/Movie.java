package org.sjhello.sjobject.chapter4.step1;

import java.time.Duration;
import java.util.List;

import org.sjhello.sjobject.chapter4.money.Money;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {
	private String title;
	private Duration runningTime;
	private Money fee;
	private List<DiscountCondition> conditions;

	private MovieType movieType;
	private Money discountAmount;
	private double discountPercent;
}
