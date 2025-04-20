package org.sjhello.sjobject.chapter5;

public class SequenceCondition {
	private int sequence;

	public boolean isSatisfiedBy(Screening screening) {
		return sequence == screening.getSequence();
	}
}
