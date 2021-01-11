package br.com.andre.exercicio4.business;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public final class Money {
    private final double value;

    public Money add(double amount) {
        return new Money(value + amount);
    }

    public Money subtract(double amount) {
        return new Money(value - amount);
    }

	public Money times(double factor) {
		return new Money(value * factor);
	}
}