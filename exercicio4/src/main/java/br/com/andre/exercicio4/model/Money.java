package br.com.andre.exercicio4.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public final class Money {
    private final double value;

    public Money add(double value) {
        return new Money(this.value + value);
    }

    public Money subtract(double value) {
        return new Money(this.value - value);
    }
}