package org.sjhello.sjobject.chapter4.step1;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Screening {
	private Movie movie;
	private int sequence;
	private LocalDateTime whenScreened;
}
