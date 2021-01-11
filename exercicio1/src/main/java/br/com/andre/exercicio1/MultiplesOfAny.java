package br.com.andre.exercicio1;

import java.util.Set;

public class MultiplesOfAny implements MultiplesCalculationStrategy {
    @Override
    public boolean isMultiple(long n, Set<Long> baseOperands) {
        return baseOperands.stream().map(operand -> {
            return n % operand == 0;
        }).reduce((previousIsMultiple, result) -> {
            return previousIsMultiple || result;
        }).orElse(false);
    }
}