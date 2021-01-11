package br.com.andre.exercicio4.business;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public final class Money {
    private final double value;

    public Money add(double value) {
        return add(new Money(value));
    }

    public Money add(Money money) {
		return new Money(value + money.getValue());
	}

    public Money subtract(double value) {
        return subtract(new Money(value));
    }

	private Money subtract(Money money) {
        return new Money(value - money.getValue());
    }

    public Money times(double factor) {
		return new Money(value * factor);
	}


}