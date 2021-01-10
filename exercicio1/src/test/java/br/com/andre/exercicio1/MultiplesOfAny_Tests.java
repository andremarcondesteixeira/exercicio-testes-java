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
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class MultiplesOfAny_Tests {
    private Set<Integer> baseOperands;
    private @Spy MultiplesOfAny calculationStrategy;
    private @Captor ArgumentCaptor<Integer> numberCaptor;
    private @Captor ArgumentCaptor<Set<Integer>> operandsCaptor;

    @BeforeEach
    public void setUp() {
        baseOperands = new HashSet<Integer>(Arrays.asList(3, 5));
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void Get_Multiples() {
        var expected = new int[] { 3, 5, 6, 9, 10, 12, 15, 18, 20 };
        var limit = 20;

        int[] result = toArray(calculationStrategy.calculateMultiples(limit, baseOperands));

        assertArrayEquals(expected, result);
        verify(calculationStrategy, times(limit)).isMultiple(numberCaptor.capture(), operandsCaptor.capture());
        int[] oneTo100 = IntStream.rangeClosed(1, limit).toArray();
        assertArrayEquals(oneTo100, toArray(numberCaptor.getAllValues()));
        for(Set<Integer> set : operandsCaptor.getAllValues()) {
            assertEquals(2, set.size());
            assertTrue(set.contains(3));
            assertTrue(set.contains(5));
        }
    }

    private int[] toArray(List<Integer> l) {
        return l.stream().mapToInt(x -> x).toArray();
    }

    @Test
    public void Check_If_Number_Is_Multiple() {
        boolean isMultiple = calculationStrategy.isMultiple(15, baseOperands);
        assertTrue(isMultiple);
    }

    @Test
    public void Negative_Limit_Positive_Operands() {
        var expected = new int[] { -3, -5, -6, -9, -10, -12, -15, -18, -20 };
        List<Integer> multiples = calculationStrategy.calculateMultiples(-20, baseOperands);
        assertArrayEquals(expected, toArray(multiples));
    }

    @Test
    public void Positive_Limit_Negative_Operands() {
        baseOperands = new HashSet<Integer>(Arrays.asList(-3, -5));
        var expected = new int[] { 3, 5, 6, 9, 10, 12, 15, 18, 20 };

        List<Integer> multiples = calculationStrategy.calculateMultiples(20, baseOperands);
        assertArrayEquals(expected, toArray(multiples));
    }

    @Test
    public void Negative_Limit_Negative_Operands() {
        baseOperands = new HashSet<Integer>(Arrays.asList(-3, -5));
        var expected = new int[] { -3, -5, -6, -9, -10, -12, -15, -18, -20 };

        List<Integer> multiples = calculationStrategy.calculateMultiples(-20, baseOperands);
        assertArrayEquals(expected, toArray(multiples));
    }
}