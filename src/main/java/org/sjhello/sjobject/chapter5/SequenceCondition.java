package org.sjhello.sjobject.chapter5;

public class SequenceCondition implements DiscountCondition{
	private int sequence;

	public boolean isSatisfiedBy(Screening screening) {
		return sequence == screening.getSequence();
	}
}
