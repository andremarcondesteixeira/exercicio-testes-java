package br.com.andre.exercicio4.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class Money_Tests {
    public @Test void Sum() {
        assertEquals(10, new Money(5).add(5).getValue());
    }

    public @Test void Subtract() {
        assertEquals(30, new Money(100).subtract(70).getValue());
    }

    public @Test void Times() {
        assertEquals(20, new Money(10).times(2).getValue());
    }

    public @Test void Money_Is_Comparable() {
        assertEquals(new Money(100), new Money(100));
        assertNotEquals(new Money(99), new Money(100));
    }
}