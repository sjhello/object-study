package org.sjhello.sjobject.chapter5;

import java.time.Duration;

import org.sjhello.sjobject.chapter5.money.Money;

public class NoneDiscountMovie extends Movie {
	public NoneDiscountMovie(String title, Duration runningTime, Money fee,
		DiscountCondition... discountConditions) {
		super(title, runningTime, fee, discountConditions);
	}

	@Override
	protected Money calculateDiscountAmount() {
		return Money.ZERO;
	}
}
