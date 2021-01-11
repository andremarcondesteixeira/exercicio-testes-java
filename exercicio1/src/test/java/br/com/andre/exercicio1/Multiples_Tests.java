package br.com.andre.exercicio1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Multiples_Tests {
    private long[] baseOperands;

    @BeforeEach void setUp() {
        baseOperands = new long[] { 1 };
    }

    @Test void of_Uses_MultiplesOfAll() {
        OfRelationshipCalculator calculator = new Multiples().of(1);
        assertTrue(calculator.getCalculationStrategy() instanceof MultiplesOfAll);
        assertArrayEquals(baseOperands, calculator.getBaseOperands());
    }

    @Test void ofAll_Uses_MultiplesOfAll() {
        OfRelationshipCalculator calculator = new Multiples().ofAll(baseOperands);
        assertTrue(calculator.getCalculationStrategy() instanceof MultiplesOfAll);
        assertArrayEquals(baseOperands, calculator.getBaseOperands());
    }

    @Test void ofAny_Uses_MultiplesOfAny() {
        OfRelationshipCalculator calculator = new Multiples().ofAny(baseOperands);
        assertTrue(calculator.getCalculationStrategy() instanceof MultiplesOfAny);
        assertArrayEquals(baseOperands, calculator.getBaseOperands());
    }
}