package br.com.andre.exercicio1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.LongStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

class MultiplesOfAll_Tests {
    private Set<Long> baseOperands;
    private @Spy MultiplesOfAll calculationStrategy;
    private @Captor ArgumentCaptor<Long> numberCaptor;
    private @Captor ArgumentCaptor<Set<Long>> operandsCaptor;

    public @BeforeEach void setUp() {
        baseOperands = new HashSet<Long>(Arrays.asList(3l, 5l));
        MockitoAnnotations.openMocks(this);
    }

    public @Test void Get_Multiples() {
        var expected = new long[] { 15, 30, 45, 60, 75, 90 };
        var limit = 100;
        long[] oneTo100 = LongStream.rangeClosed(1, limit).toArray();

        long[] result = toArray(calculationStrategy.calculateMultiples(limit, baseOperands));

        assertArrayEquals(expected, result);
        verify(calculationStrategy, times(limit)).isMultiple(numberCaptor.capture(), operandsCaptor.capture());
        assertArrayEquals(oneTo100, toArray(numberCaptor.getAllValues()));
        for (Set<Long> set : operandsCaptor.getAllValues()) {
            assertEquals(2, set.size());
            assertTrue(set.contains(3l));
            assertTrue(set.contains(5l));
        }
    }

    private long[] toArray(List<Long> l) {
        return l.stream().mapToLong(x -> x).toArray();
    }

    public @Test void Check_If_Number_Is_Multiple() {
        boolean isMultiple = calculationStrategy.isMultiple(15, baseOperands);
        assertTrue(isMultiple);
    }

    public @Test void Negative_Limit_Positive_Operands() {
        var expected = new long[] { -15, -30, -45, -60, -75, -90 };
        List<Long> multiples = calculationStrategy.calculateMultiples(-100, baseOperands);
        assertArrayEquals(expected, toArray(multiples));
    }

    public @Test void Positive_Limit_Negative_Operands() {
        baseOperands = new HashSet<Long>(Arrays.asList(-3l, -5l));
        var expected = new long[] { 15, 30, 45, 60, 75, 90 };

        List<Long> multiples = calculationStrategy.calculateMultiples(100, baseOperands);
        assertArrayEquals(expected, toArray(multiples));
    }

    public @Test void Negative_Limit_Negative_Operands() {
        baseOperands = new HashSet<Long>(Arrays.asList(-3l, -5l));
        var expected = new long[] { -15, -30, -45, -60, -75, -90 };

        List<Long> multiples = calculationStrategy.calculateMultiples(-100, baseOperands);
        assertArrayEquals(expected, toArray(multiples));
    }
}