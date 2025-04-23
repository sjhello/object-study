package org.sjhello.sjobject.chapter5;

import java.time.Duration;

import org.sjhello.sjobject.chapter5.money.Money;

public class AmountDiscountMovie extends Movie {
	private Money discountAmount;

	public AmountDiscountMovie(String title, Duration runningTime, Money fee, Money discountAmount,
		DiscountCondition... discountConditions) {
		super(title, runningTime, fee, discountConditions);
		this.discountAmount = discountAmount;
	}

	@Override
	protected Money calculateDiscountAmount() {
		return discountAmount;
	}
}
