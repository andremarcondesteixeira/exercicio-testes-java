package br.com.andre.exercicio1;

import java.util.Set;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MultiplesOfAny implements MultiplesCalculationStrategy {
    public @Override boolean isMultiple(long n, Set<Long> baseOperands) {
        return baseOperands.stream().map(operand -> {
            return n % operand == 0;
        }).reduce((previousIsMultiple, result) -> {
            return previousIsMultiple || result;
        }).orElse(false);
    }
}