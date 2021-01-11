package br.com.andre.exercicio1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultiplesCalculator_Tests {
    private MultiplesCalculator multiplesCalculator;
    private Set<Long> baseOperands;
    private MultiplesCalculationStrategy calculationStrategy;

    @BeforeEach
    void setUp() {
        baseOperands = new HashSet<Long>(Arrays.asList(2l));
        calculationStrategy = spy(new AllPairsUntilTen());
        multiplesCalculator = new MultiplesCalculator(baseOperands, calculationStrategy);
    }

    @Test
    void until_Returns_A_Calculation_Result_Object() {
        OfRelationshipCalculationResult multiples = multiplesCalculator.until(10);
        assertTrue(multiples instanceof MultiplesCalculationResult);
        verify(calculationStrategy).calculateMultiples(10, baseOperands);
    }

    @Test
    void Calling_getBaseOperands_Returns_An_Array() {
        assertArrayEquals(new long[] { 2 }, multiplesCalculator.getBaseOperands());
    }

    @Test
    void When_CalculationStrategy_Is_Null_Throws_Exception() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new MultiplesCalculator(baseOperands, null);
        });
        assertEquals("No calculation strategy provided", e.getMessage());
    }

    @Test
    void Instancing_MultiplesCalculator_Without_Operands_Throws_Exception() {
        Exception e1 = assertThrows(IllegalArgumentException.class, () -> {
            new MultiplesCalculator(new HashSet<Long>(), calculationStrategy);
        });

        Exception e2 = assertThrows(IllegalArgumentException.class, () -> {
            new MultiplesCalculator(null, calculationStrategy);
        });

        Exception e3 = assertThrows(IllegalArgumentException.class, () -> {
            new MultiplesCalculator(null, null);
        });

        var expectedMessage = "At least 1 operand must be provided";
        assertEquals(expectedMessage, e1.getMessage());
        assertEquals(expectedMessage, e2.getMessage());
        assertEquals(expectedMessage, e3.getMessage());
    }

    @Test
    void Passing_Zero_As_Operand_Throws_Exception() {
        Exception e1 = assertThrows(IllegalArgumentException.class, () -> {
            var baseOperands = new HashSet<Long>(Arrays.asList(0l));
            new MultiplesCalculator(baseOperands, calculationStrategy);
        });

        Exception e2 = assertThrows(IllegalArgumentException.class, () -> {
            var baseOperands = new HashSet<Long>(Arrays.asList(7l, 5l, 0l, 9l));
            new MultiplesCalculator(baseOperands, calculationStrategy);
        });

        var expectedMessage = "Zero is not allowed as operand";
        assertEquals(expectedMessage, e1.getMessage());
        assertEquals(expectedMessage, e2.getMessage());
    }
}