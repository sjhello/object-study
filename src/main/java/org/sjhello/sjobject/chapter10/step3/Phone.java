package org.sjhello.sjobject.chapter10.step3;

import org.sjhello.sjobject.chapter10.money.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.sjhello.sjobject.chapter10.step3.Phone.PhoneType.*;

public class Phone {
    private static final int LATE_NIGHT_HOUR = 22;
    private PhoneType type;


    enum PhoneType {
        REGULAR,
        NIGHTHLY
    }

    private Money amount;
    private Money regularAmount;
    private Money nightlyAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<Call>();

    public Phone(Money amount, Duration seconds) {
        this(REGULAR, amount, Money.ZERO, Money.ZERO, seconds);
    }

    public Phone(Money regularAmount, Money nightlyAmount, Duration seconds) {
        this(REGULAR, regularAmount, nightlyAmount, Money.ZERO, seconds);
    }

    public Phone(PhoneType type, Money amount, Money regularAmount, Money nightlyAmount, Duration seconds) {
        this.type = type;
        this.amount = amount;
        this.regularAmount = regularAmount;
        this.nightlyAmount = nightlyAmount;
        this.seconds = seconds;
        this.calls = calls;
    }
}
