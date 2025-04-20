package org.sjhello.sjobject.chapter4.step2;

import org.sjhello.sjobject.chapter4.money.Money;

/**
 * 영화 예매 절차 구현 클래스
 */
public class ReservationAgency {
	public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
		Movie movie = screening.getMovie();

		// 할인 가능 여부 확인
		boolean discountable = false;
		for (DiscountCondition condition: movie.getConditions()) {
			if (condition.getType() == DiscountConditionType.PERIOD) {
				discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek())
					&& condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0
					&& condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
			} else {
				discountable = condition.getSequence() == screening.getSequence();
			}

			if (discountable) break;
		}

		// 할인 가능 여부에 따라서 적절한 할인 정책을 계산
		Money fee;
		if (discountable) {
			Money discountAmount = Money.ZERO;
			switch (movie.getMovieType()) {
				case AMOUNT_DISCOUNT:
					discountAmount = movie.getDiscountAmount();
				break;
				case PERCENT_DISCOUNT:
					discountAmount = movie.getFee().times(movie.getDiscountPercent());
				break;
				case NONE_DISCOUNT:
					discountAmount = Money.ZERO;
				break;
			}
			fee = movie.getFee().minus(discountAmount);
		} else {
			fee = movie.getFee();
		}
		return new Reservation(customer, screening, fee, audienceCount);
	}
}
