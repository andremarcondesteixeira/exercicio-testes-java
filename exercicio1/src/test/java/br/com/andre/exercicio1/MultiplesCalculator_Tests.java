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
    private Set<Integer> baseOperands;
    private MultiplesCalculationStrategy calculationStrategy;

    @BeforeEach
    void setUp() {
        baseOperands = new HashSet<Integer>(Arrays.asList(2));
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
        assertArrayEquals(new int[] { 2 }, multiplesCalculator.getBaseOperands());
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
            new MultiplesCalculator(new HashSet<Integer>(), calculationStrategy);
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
            var baseOperands = new HashSet<Integer>(Arrays.asList(0));
            new MultiplesCalculator(baseOperands, calculationStrategy);
        });

        Exception e2 = assertThrows(IllegalArgumentException.class, () -> {
            var baseOperands = new HashSet<Integer>(Arrays.asList(7, 5, 0, 9));
            new MultiplesCalculator(baseOperands, calculationStrategy);
        });

        var expectedMessage = "Zero is not allowed as operand";
        assertEquals(expectedMessage, e1.getMessage());
        assertEquals(expectedMessage, e2.getMessage());
    }
}