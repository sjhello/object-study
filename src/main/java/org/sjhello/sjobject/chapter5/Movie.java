package org.sjhello.sjobject.chapter5;

import java.time.Duration;
import java.util.List;

import org.sjhello.sjobject.chapter5.money.Money;

public class Movie {
	private String title;
	private Duration runningTime;
	private Money fee;
	private List<PeriodCondition> periodConditions;
	private List<SequenceCondition> sequenceConditions;

	private MovieType movieType;
	private Money discountAmount;
	private double discountPercent;

	public Money calculateMovieFee(Screening screening) {
		if (isDiscountable(screening)) {
			return fee.minus(calculateDiscountAmount());
		}
		return fee;
	}

	private Money calculateDiscountAmount() {
		switch (movieType) {
			case AMOUNT_DISCOUNT -> {
				return calculateAmountDiscountAmount();
			}
			case PERCENT_DISCOUNT -> {
				return calculatePercentDiscountAmount();
			}
			case NONE_DISCOUNT -> {
				return calculateNoneDiscountAmount();
			}
		}

		return null;
	}

	private Money calculateNoneDiscountAmount() {
		return Money.ZERO;
	}

	private Money calculatePercentDiscountAmount() {
		return fee.times(discountPercent);
	}

	private Money calculateAmountDiscountAmount() {
		return discountAmount;
	}

	private boolean isDiscountable(Screening screening) {
		return checkPeriodConditions(screening) || checkSequenceConditions(screening);
	}

	private boolean checkPeriodConditions(Screening screening) {
		return periodConditions.stream()
			.anyMatch(conditions -> conditions.isSatisfiedBy(screening));
	}

	private boolean checkSequenceConditions(Screening screening) {
		return periodConditions.stream()
			.anyMatch(conditions -> conditions.isSatisfiedBy(screening));
	}
}
