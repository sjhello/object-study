package org.sjhello.sjobject.chapter4.step1;

import java.time.DayOfWeek;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscountCondition {
	private DiscountConditionType type;

	private int sequence;

	private DayOfWeek dayOfWeek;
	private LocalTime startTime;
	private LocalTime endTime;
}
