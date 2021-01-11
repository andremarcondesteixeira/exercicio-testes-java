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

class MultiplesOfAny_Tests {
    private Set<Long> baseOperands;
    private @Spy MultiplesOfAny calculationStrategy;
    private @Captor ArgumentCaptor<Long> numberCaptor;
    private @Captor ArgumentCaptor<Set<Long>> operandsCaptor;

    @BeforeEach
    void setUp() {
        baseOperands = new HashSet<Long>(Arrays.asList(3l, 5l));
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void Get_Multiples() {
        var expected = new long[] { 3, 5, 6, 9, 10, 12, 15, 18, 20 };
        var limit = 20;
        long[] oneTo100 = LongStream.rangeClosed(1, limit).toArray();

        long[] result = toArray(calculationStrategy.calculateMultiples(limit, baseOperands));

        assertArrayEquals(expected, result);
        verify(calculationStrategy, times(limit)).isMultiple(numberCaptor.capture(), operandsCaptor.capture());
        assertArrayEquals(oneTo100, toArray(numberCaptor.getAllValues()));
        for(Set<Long> set : operandsCaptor.getAllValues()) {
            assertEquals(2, set.size());
            assertTrue(set.contains(3l));
            assertTrue(set.contains(5l));
        }
    }

    private long[] toArray(List<Long> l) {
        return l.stream().mapToLong(x -> x).toArray();
    }

    @Test
    void Check_If_Number_Is_Multiple() {
        boolean isMultiple = calculationStrategy.isMultiple(15, baseOperands);
        assertTrue(isMultiple);
    }

    @Test
    void Negative_Limit_Positive_Operands() {
        var expected = new long[] { -3, -5, -6, -9, -10, -12, -15, -18, -20 };
        List<Long> multiples = calculationStrategy.calculateMultiples(-20, baseOperands);
        assertArrayEquals(expected, toArray(multiples));
    }

    @Test
    void Positive_Limit_Negative_Operands() {
        baseOperands = new HashSet<Long>(Arrays.asList(-3l, -5l));
        var expected = new long[] { 3, 5, 6, 9, 10, 12, 15, 18, 20 };

        List<Long> multiples = calculationStrategy.calculateMultiples(20, baseOperands);
        assertArrayEquals(expected, toArray(multiples));
    }

    @Test
    void Negative_Limit_Negative_Operands() {
        baseOperands = new HashSet<Long>(Arrays.asList(-3l, -5l));
        var expected = new long[] { -3, -5, -6, -9, -10, -12, -15, -18, -20 };

        List<Long> multiples = calculationStrategy.calculateMultiples(-20, baseOperands);
        assertArrayEquals(expected, toArray(multiples));
    }
}