package org.sjhello.sjobject.chapter4.step2;

import org.sjhello.sjobject.chapter4.money.Money;

public class ReservationAgency {
	public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
		boolean discountable = checkDiscountable(screening);
		Money fee = calculateFee(discountable, screening, audienceCount);
		return new Reservation(customer, screening, fee, audienceCount);
	}

	private boolean checkDiscountable(Screening screening) {
		return screening.getMovie().getConditions().stream()
			.anyMatch(condition -> condition.isDiscountable(screening));
	}

	private Money calculateFee(boolean discountable, Screening screening, int audienceCount) {
		if (discountable) {
			return screening.getMovie().getFee()
				.minus(calculateDiscountFee(screening.getMovie()))
				.times(audienceCount);
		}
		return screening.getMovie().getFee().times(audienceCount);
	}

	private Money calculateDiscountFee(Movie movie) {
		switch (movie.getMovieType()) {
			case AMOUNT_DISCOUNT -> {
				return calculateAmountDiscountFee(movie);
			}
			case PERCENT_DISCOUNT -> {
				return calculatePercentDiscountFee(movie);
			}
			case NONE_DISCOUNT -> {
				return calculateNoneDiscountFee();
			}
		}
		throw new IllegalArgumentException();
	}

	private Money calculateNoneDiscountFee() {
		return Money.ZERO;
	}

	private Money calculatePercentDiscountFee(Movie movie) {
		return movie.getFee().times(movie.getDiscountPercent());
	}

	private Money calculateAmountDiscountFee(Movie movie) {
		return movie.getDiscountAmount();
	}
}
