package org.sjhello.sjobject.chapter4.step2;

import java.time.DayOfWeek;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Setter
public class DiscountCondition {
	private DiscountConditionType type;
	private int sequence;
	private DayOfWeek dayOfWeek;
	private LocalTime startTime;
	private LocalTime endTime;

	public boolean isDiscountable(Screening screening) {
		if (type == DiscountConditionType.PERIOD) {
			return isSatisfiedByPeriod(screening);
		}
		return isSatisfiedBySequence(screening);
	}

	private boolean isSatisfiedBySequence(Screening screening) {
		return sequence == screening.getSequence();
	}

	private boolean isSatisfiedByPeriod(Screening screening) {
		return screening.getWhenScreened().getDayOfWeek().equals(dayOfWeek)
			&& startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0
			&& endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
	}
}
