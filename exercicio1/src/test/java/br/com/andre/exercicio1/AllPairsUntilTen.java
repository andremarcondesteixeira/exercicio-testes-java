package br.com.andre.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class AllPairsUntilTen implements MultiplesCalculationStrategy {
    public @Override List<Long> calculateMultiples(long until, Set<Long> baseOperands) {
        var result = new ArrayList<Long>();
        result.add(2l);
        result.add(4l);
        result.add(6l);
        result.add(8l);
        result.add(10l);
        return result;
    }

    @Override
    public boolean isMultiple(long n, Set<Long> baseOperands) {
        return n % 2 == 0;
    }
}