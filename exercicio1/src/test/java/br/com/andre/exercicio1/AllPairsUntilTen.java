package br.com.andre.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AllPairsUntilTen implements MultiplesCalculationStrategy {
    @Override
    public List<Integer> calculateMultiples(int until, Set<Integer> baseOperands) {
        var result = new ArrayList<Integer>();
        result.add(2);
        result.add(4);
        result.add(6);
        result.add(8);
        result.add(10);
        return result;
    }

    @Override
    public boolean isMultiple(int n, Set<Integer> baseOperands) {
        return n % 2 == 0;
    }
}