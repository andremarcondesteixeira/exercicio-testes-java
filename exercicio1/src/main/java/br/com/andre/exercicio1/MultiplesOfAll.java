package br.com.andre.exercicio1;

import java.util.Set;

public class MultiplesOfAll implements MultiplesCalculationStrategy {
    @Override
    public boolean isMultiple(int n, Set<Integer> baseOperands) {
        var result = true;
        for (int operand : baseOperands) {
            result &= n % operand == 0;
        }
        return result;
    }
}