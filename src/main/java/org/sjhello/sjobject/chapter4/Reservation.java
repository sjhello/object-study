package org.sjhello.sjobject.chapter4;

import org.sjhello.sjobject.chapter4.money.Money;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Reservation {
	private Customer customer;
	private Screening screening;
	private Money fee;
	private int audienceCount;
}
