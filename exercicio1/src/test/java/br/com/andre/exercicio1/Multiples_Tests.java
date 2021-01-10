package br.com.andre.exercicio1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Multiples_Tests {
    private int[] baseOperands;

    @BeforeEach
    public void setUp() {
        baseOperands = new int[] { 1 };
    }

    @Test
    public void of_Uses_MultiplesOfAll() {
        OfRelationshipCalculator calculator = new Multiples().of(1);
        assertTrue(calculator.getCalculationStrategy() instanceof MultiplesOfAll);
        assertArrayEquals(baseOperands, calculator.getBaseOperands());
    }

    @Test
    public void ofAll_Uses_MultiplesOfAll() {
        OfRelationshipCalculator calculator = new Multiples().ofAll(baseOperands);
        assertTrue(calculator.getCalculationStrategy() instanceof MultiplesOfAll);
        assertArrayEquals(baseOperands, calculator.getBaseOperands());
    }

    @Test
    public void ofAny_Uses_MultiplesOfAny() {
        OfRelationshipCalculator calculator = new Multiples().ofAny(baseOperands);
        assertTrue(calculator.getCalculationStrategy() instanceof MultiplesOfAny);
        assertArrayEquals(baseOperands, calculator.getBaseOperands());
    }
}