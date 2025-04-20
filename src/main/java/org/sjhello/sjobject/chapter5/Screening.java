package org.sjhello.sjobject.chapter5;

import java.time.LocalDateTime;

import org.sjhello.sjobject.chapter4.Customer;
import org.sjhello.sjobject.chapter5.money.Money;

import lombok.Getter;

@Getter
public class Screening {
	private Movie movie;
	private int sequence;
	private LocalDateTime whenScreened;

	public Reservation reserve(Customer customer, int audienceCount) {
		return new Reservation(customer, this, audienceCount);
	}

	private Money calculateFee(int audienceCount) {
		return movie.calculateMovieFee(this).times(audienceCount);
	}
}
