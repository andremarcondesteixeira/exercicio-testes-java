package br.com.andre.exercicio1;

import java.util.Set;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MultiplesOfAll implements MultiplesCalculationStrategy {
    public @Override boolean isMultiple(long n, Set<Long> baseOperands) {
        var result = true;
        for (long operand : baseOperands) {
            result &= n % operand == 0;
        }
        return result;
    }
}